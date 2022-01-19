package mrthomas20121.tfctweaker.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import mrthomas20121.tfctweaker.knapping.CustomKnapping;
import mrthomas20121.tfctweaker.knapping.KnappingData;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipeSimple;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ZenRegister
@ZenClass("mods.tfctweaker.knapping")
public class Knapping {

    @ZenMethod
    public static void registerType(String knappingName, int amountToConsume, boolean consumeAfterComplete, String location, IItemStack... items) {
        List<ItemStack> list = Arrays.stream(items).map(item->(ItemStack)item.getInternal()).collect(Collectors.toList());
        CustomKnapping.table.put(knappingName, new KnappingData(amountToConsume, consumeAfterComplete, location, list, CustomKnapping.table.size()+1));
    }

    @ZenMethod
    public static void addRecipe(String registryName, String knappingName, IItemStack output, boolean outputSlotRequired, String... pattern) {
        KnappingData data = CustomKnapping.table.get(knappingName);
        ItemStack outputStack = (ItemStack) output.getInternal();
        KnappingRecipe recipe = new KnappingRecipeSimple(data.getType(), outputSlotRequired, outputStack, pattern).setRegistryName(registryName);
        CraftTweakerAPI.apply(new IAction()
        {
            @Override
            public void apply()
            {
                TFCRegistries.KNAPPING.register(recipe);
            }

            @Override
            public String describe()
            {
                //noinspection ConstantConditions
                return String.format("Adding %s knapping recipe %s", knappingName, recipe.getRegistryName().toString());
            }
        });
    }
}
