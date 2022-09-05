package mrthomas20121.tfctweaker.helpers;


import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import net.dries007.tfc.common.recipes.ingredients.ItemStackIngredient;

public class IngredientHelper {

    ItemStackIngredient getIngredient(IIngredient ingredient, int count) {
        return new ItemStackIngredient(ingredient.asVanillaIngredient(), count);
    }
}
