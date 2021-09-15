package mrthomas20121.tfctweaker;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class RecipeHelper {

    public static void removeRecipe(IForgeRegistry<IRecipe> r, ResourceLocation name) {
        IForgeRegistryModifiable<IRecipe> registry = (IForgeRegistryModifiable<IRecipe>)r;
        registry.remove(name);
    }

    public static void removeRecipe(IForgeRegistry<IRecipe> r, String name) {
        removeRecipe(r, new ResourceLocation(name));
    }
}
