package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.api.TFCModifier;
import net.dries007.tfc.common.capabilities.forge.ForgeRule;
import net.dries007.tfc.common.recipes.AnvilRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.outputs.ItemStackProvider;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:anvil>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.anvil")
@Document("mods/tfctweaker/AnvilRecipe")
public class AnvilManager implements IRecipeManager<AnvilRecipe> {

    @Override
    public RecipeType<AnvilRecipe> getRecipeType() {
        return TFCRecipeTypes.ANVIL.get();
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, int minTier, ForgeRule[] rules, boolean applyForgingBonus, TFCModifier modifier) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new AnvilRecipe(Helpers.identifier(name), input.asVanillaIngredient(), minTier, rules, applyForgingBonus, modifier.get())));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IIngredient input, int minTier, ForgeRule[] rules, boolean applyForgingBonus, IItemStack output) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new AnvilRecipe(Helpers.identifier(name), input.asVanillaIngredient(), minTier, rules, applyForgingBonus, ItemStackProvider.of(output.getInternal()))));
    }
}
