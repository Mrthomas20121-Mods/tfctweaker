package mrthomas20121.tfctweaker.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mrthomas20121.tfctweaker.TFCTweaker;
import mrthomas20121.tfctweaker.knapping.KnappingData;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.compat.jei.wrappers.KnappingRecipeWrapper;
import net.dries007.tfc.util.Helpers;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class CustomKnappingRecipeWrapper extends KnappingRecipeWrapper {

    private final KnappingData data;

    public CustomKnappingRecipeWrapper(KnappingRecipe recipe, IGuiHelper helper, KnappingData data)
    {
        super(recipe, helper, data.getTEXTURE(), data.getTEXTURE_DISABLED());
        this.data = data;
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ingredients.setOutputLists(VanillaTypes.ITEM, Helpers.listOf(data.getItems()));
    }
}