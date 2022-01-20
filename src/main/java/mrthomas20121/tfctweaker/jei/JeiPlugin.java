package mrthomas20121.tfctweaker.jei;

import mezz.jei.api.JEIPlugin;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mrthomas20121.tfctweaker.TFCTweaker;
import mrthomas20121.tfctweaker.client.CustomKnappingGui;
import mrthomas20121.tfctweaker.knapping.CustomKnapping;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.compat.jei.categories.KnappingCategory;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

@JEIPlugin
public class JeiPlugin implements IModPlugin {

    @Override
    public void registerCategories(@Nonnull IRecipeCategoryRegistration registry)
    {
        CustomKnapping.table.keySet().forEach(name-> {
            final String knap_uid = TFCTweaker.MODID+".knap."+name;
            registry.addRecipeCategories(new KnappingCategory(registry.getJeiHelpers().getGuiHelper(), knap_uid));
        });
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
            registry.addRecipeClickArea(CustomKnappingGui.class, 97, 44, 22, 15, knap_uid);
        });
    }
}