package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.dries007.tfc.common.recipes.PotRecipe;
import net.dries007.tfc.common.recipes.SimplePotRecipe;
import net.dries007.tfc.common.recipes.SoupPotRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.ingredients.FluidIngredient;
import net.dries007.tfc.common.recipes.ingredients.FluidStackIngredient;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;

/**
 * @docParam this <recipetype:tfc:pot>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.pot")
@Document("mods/tfctweaker/PotRecipe")
public class PotManager implements IRecipeManager<PotRecipe> {
    @Override
    public RecipeType<PotRecipe> getRecipeType() {
        return TFCRecipeTypes.POT.get();
    }

    @ZenCodeType.Method
    public void addSimplePotRecipe(String name, IIngredient[] ingredients, IFluidStack fluid, int duration, float minTemp, IFluidStack outputFluid, IItemStack[] output) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new SoupPotRecipe(Helpers.identifier(name), Arrays.stream(ingredients).map(IIngredient::asVanillaIngredient).toList(), new FluidStackIngredient(FluidIngredient.of(fluid.getFluid()), fluid.getAmount()), duration, minTemp, outputFluid.getInternal(), Arrays.stream(output).map(IItemStack::getInternal).toList())));
    }

    @ZenCodeType.Method
    public void addSoupPotRecipe(String name, IIngredient[] ingredients, IFluidStack fluid, int duration, float minTemp) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new SoupPotRecipe(Helpers.identifier(name), Arrays.stream(ingredients).map(IIngredient::asVanillaIngredient).toList(), new FluidStackIngredient(FluidIngredient.of(fluid.getFluid()), fluid.getAmount()), duration, minTemp)));
    }
}
