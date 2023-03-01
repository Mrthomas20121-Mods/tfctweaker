package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.api.TFCItemStackProvider;
import net.dries007.tfc.common.recipes.ChiselRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.ingredients.BlockIngredient;
import net.dries007.tfc.common.recipes.ingredients.BlockIngredients;
import net.dries007.tfc.common.recipes.outputs.ItemStackProvider;
import net.dries007.tfc.util.Helpers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.openzen.zencode.java.ZenCodeType;

import javax.annotation.Nullable;

/**
 * @docParam this <recipetype:tfc:chisel>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.chisel")
@Document("mods/TFCTweaker/chiselRecipe")
public class ChiselManager implements IRecipeManager<ChiselRecipe> {

    @Override
    public RecipeType<ChiselRecipe> getRecipeType() {
        return TFCRecipeTypes.CHISEL.get();
    }

    @ZenCodeType.Method
    public void addRecipe(String name, Block[] input, Block output, ChiselRecipe.Mode mode, IItemStack extraDrop, @ZenCodeType.Optional IIngredient itemIngredient) {
        addRecipe(Helpers.identifier(name), BlockIngredients.of(input), output.defaultBlockState(), mode, ItemStackProvider.of(extraDrop.getInternal()), itemIngredient.asVanillaIngredient());
    }

    @ZenCodeType.Method
    public void addRecipe(String name, Block[] input, Block output, ChiselRecipe.Mode mode, TFCItemStackProvider extraDrop, @ZenCodeType.Optional IIngredient itemIngredient) {
        addRecipe(Helpers.identifier(name), BlockIngredients.of(input), output.defaultBlockState(), mode, extraDrop.get(), itemIngredient.asVanillaIngredient());
    }

    public void addRecipe(ResourceLocation name, BlockIngredient ingredient, BlockState output, ChiselRecipe.Mode mode, ItemStackProvider extraDrop, @Nullable Ingredient itemIngredient) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new ChiselRecipe(name, ingredient, output, mode, itemIngredient, extraDrop)));
    }
}
