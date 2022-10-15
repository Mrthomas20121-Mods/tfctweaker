package mrthomas20121.tfctweaker.handlers;

import com.blamejared.crafttweaker.api.fluid.MCFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.MCItemStack;
import com.blamejared.crafttweaker.api.recipe.handler.IRecipeHandler;
import com.blamejared.crafttweaker.api.recipe.handler.IReplacementRule;
import com.blamejared.crafttweaker.api.recipe.handler.helper.ReplacementHandlerHelper;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import net.dries007.tfc.common.recipes.HeatingRecipe;
import net.dries007.tfc.common.recipes.outputs.ItemStackProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@IRecipeHandler.For(HeatingRecipe.class)
public class HeatingHandler implements IRecipeHandler<HeatingRecipe> {

    @Override
    public String dumpToCommandString(IRecipeManager manager, HeatingRecipe recipe) {
        return String.format("<recipetype:tfc:heating>.addRecipe(\"%s\", %s, %s, %s);",
                recipe.getId(),
                recipe.getIngredients()
                        .stream()
                        .map(IIngredient::fromIngredient)
                        .map(IIngredient::getCommandString).collect(Collectors.joining(", ")),
                new MCFluidStack(recipe.getDisplayOutputFluid()).getCommandString(),
                new MCItemStack(recipe.getResultItem()).getCommandString()
        );
    }

    @Override
    public Optional<Function<ResourceLocation, HeatingRecipe>> replaceIngredients(IRecipeManager manager, HeatingRecipe recipe, List<IReplacementRule> rules) {
        return ReplacementHandlerHelper.replaceNonNullIngredientList(
                recipe.getIngredients(),
                Ingredient.class, recipe, rules, ingredients -> id -> new HeatingRecipe(recipe.getId(), Ingredient.merge(ingredients), ItemStackProvider.of(recipe.getResultItem()), recipe.getDisplayOutputFluid(), recipe.getTemperature(), false));
    }
}
