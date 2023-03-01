package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.api.TFCItemStackProvider;
import net.dries007.tfc.common.recipes.LoomRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.outputs.ItemStackProvider;
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

    public void addRecipe(String name, IIngredient input, IItemStack output, int inputCount, int stepsRequired, String inProgressTexture) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new LoomRecipe(Helpers.identifier(name), input.asVanillaIngredient(), ItemStackProvider.of(output.getInternal()), inputCount, stepsRequired, new ResourceLocation(inProgressTexture))));

    }

    public void addRecipe(String name, IIngredient input, TFCItemStackProvider output, int inputCount, int stepsRequired, String inProgressTexture) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new LoomRecipe(Helpers.identifier(name), input.asVanillaIngredient(), output.get(), inputCount, stepsRequired, new ResourceLocation(inProgressTexture))));
    }
}
