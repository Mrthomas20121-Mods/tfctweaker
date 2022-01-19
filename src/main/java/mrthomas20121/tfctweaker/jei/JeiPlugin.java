package mrthomas20121.tfctweaker.jei;

import mezz.jei.api.JEIPlugin;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mrthomas20121.tfctweaker.TFCTweaker;
import mrthomas20121.tfctweaker.knapping.CustomKnapping;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.compat.jei.categories.KnappingCategory;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

@JEIPlugin
public class JeiPlugin implements IModPlugin {
    public static final String KNAP_GROUT_UID = TFCTweaker.MODID + ".knap.grout";

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry)
    {
        registry.addRecipeCategories(new KnappingCategory(registry.getJeiHelpers().getGuiHelper(), KNAP_GROUT_UID));
    }

    @Override
    public void register(@Nonnull IModRegistry registry)
    {
        CustomKnapping.table.forEach((name, data)-> {
            final String knap_uid = TFCTweaker.MODID+".knap."+name;
            List<CustomKnappingRecipeWrapper> recipeList = TFCRegistries.KNAPPING.getValuesCollection().stream()
                    .filter(recipe -> recipe.getType() == data.getType())
                    .map(recipe -> new CustomKnappingRecipeWrapper(recipe, registry.getJeiHelpers().getGuiHelper(), data))
                    .collect(Collectors.toList());
            registry.addRecipes(recipeList, knap_uid);
            for(ItemStack stack: data.getItems()) {
                registry.addRecipeCatalyst(stack, knap_uid);
            }
            //registry.addRecipeClickArea(TFCTinkerKnappingGui.class, 97, 44, 22, 15, knap_uid);
        });
    }
}