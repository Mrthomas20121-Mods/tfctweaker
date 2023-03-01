package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.api.TFCItemStackProvider;
import net.dries007.tfc.common.recipes.HeatingRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.outputs.ItemStackProvider;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.Metal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fluids.FluidStack;
import org.openzen.zencode.java.ZenCodeType;

/**
 * TFC Heating Recipes
 *
 * @docParam this <recipetype:tfc:heating>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.heating")
@Document("mods/TFCTweaker/HeatingManager")
public class HeatingManager implements IRecipeManager<HeatingRecipe> {

    @Override
    public RecipeType<HeatingRecipe> getRecipeType() {
        return TFCRecipeTypes.HEATING.get();
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, TFCItemStackProvider output, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        addRecipe(Helpers.identifier(name), input.asVanillaIngredient(), output.get(), FluidStack.EMPTY, temp, useDurability);
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, TFCItemStackProvider output, IFluidStack outputFluid, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        addRecipe(Helpers.identifier(name), input.asVanillaIngredient(), output.get(), outputFluid.getInternal(), temp, useDurability);
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, TFCItemStackProvider output, Metal outputMetal, int amount, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        addRecipe(Helpers.identifier(name), input.asVanillaIngredient(), output.get(), new FluidStack(outputMetal.getFluid(), amount), temp, useDurability);
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, IItemStack output, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        addRecipe(Helpers.identifier(name), input.asVanillaIngredient(), ItemStackProvider.of(output.getInternal()), FluidStack.EMPTY, temp, useDurability);
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, IFluidStack outputFluid, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        addRecipe(Helpers.identifier(name), input.asVanillaIngredient(), ItemStackProvider.empty(), outputFluid.getInternal(), temp, useDurability);
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, Metal output, int amount, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        addRecipe(Helpers.identifier(name), input.asVanillaIngredient(), ItemStackProvider.empty(), new FluidStack(output.getFluid(), amount), temp, useDurability);
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, IItemStack output, IFluidStack outputFluid, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        addRecipe(Helpers.identifier(name), input.asVanillaIngredient(), ItemStackProvider.of(output.getInternal()), outputFluid.getInternal(), temp, useDurability);
    }

    public void addRecipe(ResourceLocation name, Ingredient input, ItemStackProvider output, FluidStack outputFluid, float temp, boolean useDurability) {
        HeatingRecipe recipe = new HeatingRecipe(name, input, output, outputFluid, temp, useDurability);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }
}
