package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import mrthomas20121.tfctweaker.api.ingredient.TFCItemStackProvider;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.WeldingRecipe;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:welding>
 */
@ZenRegister
@ZenCodeType.Name(Constants.CLASS_WELDING)
@Document("mods/TFCTweaker/WeldingRecipe")
public class WeldingManager implements IRecipeManager<WeldingRecipe> {

    @Override
    public RecipeType<WeldingRecipe> getRecipeType() {
        return TFCRecipeTypes.WELDING.get();
    }

    /**
     * Add a welding recipe
     * @param name name of the recipe
     * @param input1 first input
     * @param input2 second input
     * @param tier anvil tier required
     * @param output output item
     *
     * @docParam name "welding_test"
     * @docParam input1 <item:tfc:metal/ingot/copper>
     * @docParam input2 <item:tfc:metal/double_ingot/copper>
     * @docParam tier 1
     * @docParam output ItemStackProvider.none(<item:tfc:metal/double_sheet/copper>);
     * @docParam combineForgingBonus true
     */
    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input1, IIngredient input2, int tier, TFCItemStackProvider output, boolean combineForgingBonus) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new WeldingRecipe(Constants.identifier(name), input1.asVanillaIngredient(), input2.asVanillaIngredient(), tier, output.getInternal(), combineForgingBonus)));
    }
}
