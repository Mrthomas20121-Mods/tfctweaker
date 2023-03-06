package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import mrthomas20121.tfctweaker.api.ingredient.TFCItemStackProvider;
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

    /**
     * add a heating recipe
     * @param name name of the recipe
     * @param input input item
     * @param output output item(can be null)
     * @param outputFluid output fluid
     * @param temp temp when the input become the output
     * @param useDurability tell if the recipe should use the item durability(if it has durability, default to false)
     *
     * @docParam name "heating_test"
     * @docParam input <item:tfc:metal/ingot/copper>
     * @docParam output ItemStackProvider.empty()
     * @docParam outputFluid <fluid:tfc:metal/copper>*100
     * @docParam temp 500
     * @docParam useDurability false
     */
    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, TFCItemStackProvider output, IFluidStack outputFluid, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        addRecipe(Helpers.identifier(name), input.asVanillaIngredient(), output.getInternal(), outputFluid == null ? FluidStack.EMPTY : outputFluid.getInternal(), temp, useDurability);
    }

    /**
     * add a heating recipe
     * @param name name of the recipe
     * @param input input item
     * @param output output item(can be null)
     * @param outputMetal output metal
     * @param amount amount of metal
     * @param temp temp when the input become the output
     * @param useDurability tell if the recipe should use the item durability(if it has durability, default to false)
     *
     * @docParam name "heating_test"
     * @docParam input <item:tfc:metal/ingot/copper>
     * @docParam output ItemStackProvider.empty()
     * @docParam outputMetal <metal:tfc:copper>
     * @docParam amount 100
     * @docParam temp 500
     * @docParam useDurability false
     */
    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, TFCItemStackProvider output, Metal outputMetal, int amount, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        addRecipe(Constants.identifier(name), input.asVanillaIngredient(), output.getInternal(), new FluidStack(outputMetal.getFluid(), amount), temp, useDurability);
    }

    /**
     * add a heating recipe
     * @param name name of the recipe
     * @param input input item
     * @param output output item(can be null)
     * @param outputFluid output fluid
     * @param temp temp when the input become the output
     * @param useDurability tell if the recipe should use the item durability(if it has durability, default to false)
     *
     * @docParam name "heating_test2"
     * @docParam input <item:tfc:metal/ingot/copper>
     * @docParam output ItemStackProvider.empty()
     * @docParam outputFluid <fluid:tfc:metal/copper>*100
     * @docParam temp 500
     * @docParam useDurability false
     */
    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, IItemStack output, IFluidStack outputFluid, float temp, @ZenCodeType.OptionalBoolean boolean useDurability) {
        addRecipe(Helpers.identifier(name), input.asVanillaIngredient(), ItemStackProvider.of(output.getInternal()), outputFluid.getInternal(), temp, useDurability);
    }

    public void addRecipe(ResourceLocation name, Ingredient input, ItemStackProvider output, FluidStack outputFluid, float temp, boolean useDurability) {
        HeatingRecipe recipe = new HeatingRecipe(name, input, output, outputFluid, temp, useDurability);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe, ""));
    }
}
