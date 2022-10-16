package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.api.TFCModifier;
import net.dries007.tfc.common.recipes.AlloyRecipe;
import net.dries007.tfc.common.recipes.QuernRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.outputs.ItemStackProvider;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:quern>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.quern")
@Document("mods/tfctweaker/QuernManager")
public class QuernManager implements IRecipeManager<QuernRecipe> {

    @Override
    public RecipeType<QuernRecipe> getRecipeType() {
        return TFCRecipeTypes.QUERN.get();
    }

    public void addRecipe(String name, IIngredient input, IItemStack output) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new QuernRecipe(Helpers.identifier(name), input.asVanillaIngredient(), ItemStackProvider.of(output.getInternal()))));
    }

    public void addRecipe(String name, IIngredient input, TFCModifier output) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new QuernRecipe(Helpers.identifier(name), input.asVanillaIngredient(), output.get())));

    }
}
