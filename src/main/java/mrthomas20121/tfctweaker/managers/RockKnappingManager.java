package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.dries007.tfc.common.recipes.KnappingRecipe;
import net.dries007.tfc.common.recipes.RockKnappingRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeSerializers;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.KnappingPattern;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:leather_knapping>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.leather_knapping")
@Document("mods/tfctweaker/LeatherKnappingRecipe")
public class RockKnappingManager implements IRecipeManager<RockKnappingRecipe> {

    @Override
    public RecipeType<RockKnappingRecipe> getRecipeType() {
        return TFCRecipeTypes.ROCK_KNAPPING.get();
    }

    @ZenCodeType.Method
    public void addRecipe(String name, boolean outside_slot_required, String[] pattern, IItemStack output, IIngredient ingredient) {
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
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new RockKnappingRecipe(Helpers.identifier(name), knappingPattern, output.getInternal(), ingredient.asVanillaIngredient())));
    }
}
