package net.ndrei.teslacorelib.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.ndrei.teslacorelib.TeslaCoreLib;

import java.util.List;

/**
 * Created by CF on 2017-02-17.
 */
public class GearDiamondItem extends BaseGearItem {
    public GearDiamondItem() {
        super("diamond");
    }

    @Override
    protected List<IRecipe> getRecipes(){
        List<IRecipe> recipes = super.getRecipes();

        recipes.add(new ShapedOreRecipe(new ItemStack(this, 1),
                "iwi", "wsw", "iwi",
                'w', Items.DIAMOND,
                'i', Items.IRON_INGOT,
                's', TeslaCoreLib.gearStone));
        recipes.add(new ShapedOreRecipe(new ItemStack(this, 1),
                " w ", "wsw", " w ",
                'w', Items.DIAMOND,
                's', TeslaCoreLib.gearIron));

        return recipes;
    }
}
