package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.api.TFCItemStackProvider;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.WeldingRecipe;
import net.dries007.tfc.common.recipes.outputs.ItemStackProvider;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:welding>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.welding")
@Document("mods/TFCTweaker/WeldingRecipe")
public class WeldingManager implements IRecipeManager<WeldingRecipe> {

    @Override
    public RecipeType<WeldingRecipe> getRecipeType() {
        return TFCRecipeTypes.WELDING.get();
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input1, IIngredient input2, int tier, TFCItemStackProvider output) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new WeldingRecipe(Helpers.identifier(name), input1.asVanillaIngredient(), input2.asVanillaIngredient(), tier, output.get())));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input1, IIngredient input2, int tier, IItemStack output) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new WeldingRecipe(Helpers.identifier(name), input1.asVanillaIngredient(), input2.asVanillaIngredient(), tier, ItemStackProvider.of(output.getInternal()))));
    }
}
