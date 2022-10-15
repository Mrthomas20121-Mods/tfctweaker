package mrthomas20121.tfctweaker.handlers;

import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.fluid.MCFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.MCItemStack;
import com.blamejared.crafttweaker.api.recipe.handler.IRecipeHandler;
import com.blamejared.crafttweaker.api.recipe.handler.IReplacementRule;
import com.blamejared.crafttweaker.api.recipe.handler.helper.ReplacementHandlerHelper;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import net.dries007.tfc.common.recipes.BarrelRecipe;
import net.dries007.tfc.common.recipes.SealedBarrelRecipe;
import net.dries007.tfc.common.recipes.ingredients.ItemStackIngredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@IRecipeHandler.For(SealedBarrelRecipe.class)
public class SealedBarrelHandler implements IRecipeHandler<SealedBarrelRecipe> {

    @Override
    public String dumpToCommandString(IRecipeManager manager, SealedBarrelRecipe recipe) {
        return String.format("<recipetype:tfc:sealed_barrel>.addRecipe(\"%s\", %s, %s, %s, %s);",
                recipe.getId(),
                recipe.getDuration(),
                recipe.getIngredients()
                        .stream()
                        .map(IIngredient::fromIngredient)
                        .map(IIngredient::getCommandString).collect(Collectors.joining(", ")),
                recipe.getInputFluid().ingredient().getMatchingFluids().stream()
                        .map(fluid -> new FluidStack(fluid, 0))
                        .map(MCFluidStack::new).map(IFluidStack::getCommandString)
                        .collect(Collectors.joining(", ")),
                new MCItemStack(recipe.getOutputItem().getStack(ItemStack.EMPTY)).getCommandString()
        );
    }

    @Override
    public Optional<Function<ResourceLocation, SealedBarrelRecipe>> replaceIngredients(IRecipeManager manager, SealedBarrelRecipe recipe, List<IReplacementRule> rules) {
        return ReplacementHandlerHelper.replaceNonNullIngredientList(
                recipe.getIngredients(),
                Ingredient.class, recipe, rules, ingredients -> id -> {
                   BarrelRecipe.Builder builder = new BarrelRecipe.Builder(new ItemStackIngredient(Ingredient.merge(ingredients), ingredients.get(0).getStackingIds().getInt(0)), recipe.getInputFluid(), recipe.getOutputItem(), recipe.getOutputFluid(), recipe.getCompleteSound());
                   return new SealedBarrelRecipe(recipe.getId(), builder, recipe.getDuration(), recipe.getOnSeal(), recipe.getOnUnseal());
                });
    }
}
