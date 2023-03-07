package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import mrthomas20121.tfctweaker.api.ingredient.TFCItemStackProvider;
import net.dries007.tfc.common.capabilities.forge.ForgeRule;
import net.dries007.tfc.common.recipes.AnvilRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:anvil>
 */
@ZenRegister
@ZenCodeType.Name(Constants.CLASS_ANVIL)
@Document("mods/TFCTweaker/AnvilRecipe")
public class AnvilManager implements IRecipeManager<AnvilRecipe> {

    @Override
    public RecipeType<AnvilRecipe> getRecipeType() {
        return TFCRecipeTypes.ANVIL.get();
    }

    /**
     * Add an anvil recipe
     * @param name recipe name
     * @param input input ingredient
     * @param minTier min anvil tier required for the recipe
     * @param rules rules used to forge the item
     * @param applyForgingBonus should forging bonus be applied
     * @param output the output item
     *
     * @docParam name "anvil_test"
     * @docParam input <tfc:metal/ingot/copper>
     * @docParam minTier 1
     * @docParam rules [<constant:tfc:forge_rule:hit_any>, <constant:tfc:forge_rule:draw_not_last>, <constant:tfc:forge_rule:hit_any>]
     * @docParam applyForgingBonus true
     * @docParam output ItemStackProvider.none(<tfc:metal/chisel_head/copper>)
     */
    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, int minTier, ForgeRule[] rules, boolean applyForgingBonus, TFCItemStackProvider output) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new AnvilRecipe(Helpers.identifier(name), input.asVanillaIngredient(), minTier, rules, applyForgingBonus, output.getInternal())));
    }
}
