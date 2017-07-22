package net.ndrei.teslacorelib.gui

import net.minecraft.client.renderer.GlStateManager
import net.minecraft.item.EnumDyeColor
import net.ndrei.teslacorelib.inventory.BoundingRectangle
import net.ndrei.teslacorelib.tileentities.SidedTileEntity

/**
 * Created by CF on 2017-07-03.
 */
class LockedInventoryTogglePiece(left: Int, top: Int, val entity: SidedTileEntity, val color: EnumDyeColor) : ToggleButtonPiece(left, top, 14, 14) {
    override val currentState: Int
        get() = if (this.entity.getInventoryLockState(this.color) ?: false) 0 else 1

    override fun drawBackgroundLayer(container: BasicTeslaGuiContainer<*>, guiX: Int, guiY: Int, partialTicks: Float, mouseX: Int, mouseY: Int) {
        container.bindDefaultTexture()
        container.drawTexturedRect(this.left, this.top,
                110, 210, 14, 14)

        if (super.isInside(container, mouseX, mouseY)) {
            container.drawFilledRect(container.guiLeft + this.left + 1, container.guiTop + this.top + 1, this.width - 2, this.height - 2, 0x42FFFFFF)
        }
    }

    override fun renderState(container: BasicTeslaGuiContainer<*>, state: Int, box: BoundingRectangle) {
        container.bindDefaultTexture()
        GlStateManager.enableBlend()
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA)
        container.drawTexturedModalRect(box.left, box.top,
                199 + (state % 2) * 18, 227, 14, 14)
        GlStateManager.disableBlend()
    }

    override fun getStateToolTip(state: Int)
            = listOf(when (state) {
        0 -> "Unlock Inventory"
        1 -> "Lock Inventory"
        else -> "???"
    }, *super.getStateToolTip(state).toTypedArray())

    override fun clicked() {
        this.entity.toggleInventoryLock(this.color)
    }
}