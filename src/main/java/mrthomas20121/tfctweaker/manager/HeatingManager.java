package mrthomas20121.tfctweaker.manager;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.dries007.tfc.common.recipes.HeatingRecipe;
import net.dries007.tfc.common.recipes.SealedBarrelRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.outputs.ItemStackProvider;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fluids.FluidStack;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:heating>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.heating")
@Document("mods/tfctweaker/HeatingManager")
public class HeatingManager implements IRecipeManager<HeatingRecipe> {

    @Override
    public RecipeType<HeatingRecipe> getRecipeType() {
        return TFCRecipeTypes.HEATING.get();
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, IItemStack output, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        HeatingRecipe recipe = new HeatingRecipe(Helpers.identifier(name), input.asVanillaIngredient(), ItemStackProvider.of(output.getInternal()), FluidStack.EMPTY, temp, useDurability);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, IFluidStack outputFluid, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        HeatingRecipe recipe = new HeatingRecipe(Helpers.identifier(name), input.asVanillaIngredient(), ItemStackProvider.empty(), outputFluid.getInternal(), temp, useDurability);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, IItemStack output, IFluidStack outputFluid, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        HeatingRecipe recipe = new HeatingRecipe(Helpers.identifier(name), input.asVanillaIngredient(), ItemStackProvider.of(output.getInternal()), outputFluid.getInternal(), temp, useDurability);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }
}
