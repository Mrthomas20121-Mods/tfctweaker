package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import mrthomas20121.tfctweaker.api.ingredient.TFCItemStackProvider;
import net.dries007.tfc.common.recipes.QuernRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:quern>
 */
@ZenRegister
@ZenCodeType.Name(Constants.CLASS_QUERN)
@Document("mods/TFCTweaker/QuernRecipe")
public class QuernManager implements IRecipeManager<QuernRecipe> {

    @Override
    public RecipeType<QuernRecipe> getRecipeType() {
        return TFCRecipeTypes.QUERN.get();
    }

    /**
     * Add a quern recipe
     * @param name name of the recipe
     * @param input input ingredient
     * @param output output item
     *
     * @docParam name "quern_test"
     * @docParam input <item:tfc:metal/ingot/copper>
     * @docParam output ItemStackProvider.none(<item:tfc:metal/sheet/copper>)
     */
    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, TFCItemStackProvider output) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new QuernRecipe(Constants.identifier(name), input.asVanillaIngredient(), output.getInternal())));

    }
}
