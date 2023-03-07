package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.google.gson.JsonSyntaxException;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.common.recipes.ChiselRecipe;
import net.dries007.tfc.common.recipes.KnappingRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeSerializers;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.KnappingPattern;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:clay_knapping>
 */
@ZenRegister
@ZenCodeType.Name(Constants.CLASS_CLAY_KNAPPING)
@Document("mods/TFCTweaker/ClayKnappingRecipe")
public class ClayKnappingManager implements IRecipeManager<KnappingRecipe> {

    @Override
    public RecipeType<KnappingRecipe> getRecipeType() {
        return TFCRecipeTypes.CLAY_KNAPPING.get();
    }

    /**
     * Add a clay knapping recipe
     * @param name name of the recipe
     * @param outside_slot_required should the outside slot be required?
     * @param pattern the pattern
     * @param output the output item
     *
     * @docParam name "knapping_test"
     * @docParam outside_slot_required false
     * @docParam pattern ["XXXXX", " XXX ", " XXX ", " XXX ", "XXXXX"]
     * @docParam output <item:tfc:ceramic/unfired_brick>
     */
    @ZenCodeType.Method
    public void addRecipe(String name, boolean outside_slot_required, String[] pattern, IItemStack output) {
        int width = pattern[0].length();
        int height = pattern.length;
        KnappingPattern knappingPattern = new KnappingPattern(width, height, outside_slot_required);

        for(int r = 0; r < height; ++r) {
            String row = pattern[r];
            if (r > 0 && width != row.length()) {
                CraftTweakerAPI.LOGGER.warn("Invalid pattern: each row must be the same width");
            }

            for(int c = 0; c < width; ++c) {
                knappingPattern.set(r * width + c, row.charAt(c) != ' ');
            }
        }
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new KnappingRecipe(Helpers.identifier(name), knappingPattern, output.getInternal(), TFCRecipeSerializers.CLAY_KNAPPING.get())));
    }
}
