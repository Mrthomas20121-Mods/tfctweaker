package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.common.recipes.KnappingRecipe;
import net.dries007.tfc.common.recipes.RockKnappingRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeSerializers;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.KnappingPattern;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:rock_knapping>
 */
@ZenRegister
@ZenCodeType.Name(Constants.CLASS_ROCK_KNAPPING)
@Document("mods/TFCTweaker/RockKnappingRecipe")
public class RockKnappingManager implements IRecipeManager<RockKnappingRecipe> {

    @Override
    public RecipeType<RockKnappingRecipe> getRecipeType() {
        return TFCRecipeTypes.ROCK_KNAPPING.get();
    }

    /**
     * Add a Rock Knapping recipe
     * @param name name of the recipe
     * @param outside_slot_required should the output slot be required
     * @param pattern pattern
     * @param rocks Rock(s) that be used to knapp the recipe
     * @param output the output item
     *
     * @docParam name "rock_test"
     * @docParam outside_slot_required false
     * @docParam pattern ["XX   ", " XX  ", "  XX ", "   XX", ""]
     * @docParam rocks <tag:items:tfc:igneous_extrusive_rock>
     * @docParam output <item:tfc:stone/axe_head/igneous_extrusive>
     */
    @ZenCodeType.Method
    public void addRecipe(String name, boolean outside_slot_required, String[] pattern, IIngredient rocks, IItemStack output) {
        int width = pattern[0].length();
        int height = pattern.length;
        KnappingPattern knappingPattern = new KnappingPattern(width,height, outside_slot_required);

        for(int r = 0; r < height; ++r) {
            String row = pattern[r];
            if (r > 0 && width != row.length()) {
                CraftTweakerAPI.LOGGER.warn("Invalid pattern: each row must be the same width");
            }

            for(int c = 0; c < width; ++c) {
                knappingPattern.set(r * width + c, row.charAt(c) != ' ');
            }
        }
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new RockKnappingRecipe(Constants.identifier(name), knappingPattern, output.getInternal(), rocks.asVanillaIngredient())));
    }
}
