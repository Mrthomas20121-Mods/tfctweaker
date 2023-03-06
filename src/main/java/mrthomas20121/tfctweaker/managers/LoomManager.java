package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import mrthomas20121.tfctweaker.api.ingredient.TFCItemStackProvider;
import net.dries007.tfc.common.recipes.LoomRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.util.Helpers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:loom>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.loom")
@Document("mods/TFCTweaker/LoomRecipe")
public class LoomManager implements IRecipeManager<LoomRecipe> {

    @Override
    public RecipeType<LoomRecipe> getRecipeType() {
        return TFCRecipeTypes.LOOM.get();
    }

    /**
     * Add a loom recipe
     * @param name name of the recipe
     * @param input input ingredient
     * @param output output item
     * @param inputCount how many items are needed
     * @param stepsRequired the number of steps
     * @param inProgressTexture in progress texture
     *
     * @docParam name "loom_test"
     * @docParam input <item:minecraft:string>
     * @docParam output ItemStackProvider.none(<item:tfc:burlap_cloth>)
     * @docParam inputCount 10
     * @docParam stepsRequired 10
     * @docParam inProgressTexture "tfc:block/burlap"
     */
    public void addRecipe(String name, IIngredient input, TFCItemStackProvider output, int inputCount, int stepsRequired, String inProgressTexture) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new LoomRecipe(Constants.identifier(name), input.asVanillaIngredient(), output.getInternal(), inputCount, stepsRequired, new ResourceLocation(inProgressTexture))));

    }
}
