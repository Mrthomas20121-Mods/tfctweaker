package mrthomas20121.tfctweaker.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.potions.IPotion;
import crafttweaker.api.potions.IPotionEffect;
import net.dries007.tfc.api.capability.food.FoodStatsTFC;
import net.dries007.tfc.objects.fluids.FluidsTFC;
import net.dries007.tfc.objects.fluids.properties.DrinkableProperty;
import net.dries007.tfc.objects.fluids.properties.FluidWrapper;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.tfctweaker.fluids")
public class Fluids {

    @ZenMethod
    public static void makeDrinkable(ILiquidStack liquidStack, float thirst)
    {
        FluidWrapper fluidWrapper = FluidsTFC.getWrapper(CraftTweakerMC.getFluid(liquidStack.getDefinition())).with(DrinkableProperty.DRINKABLE, (player) -> {
            if (player.getFoodStats() instanceof FoodStatsTFC) {
                ((FoodStatsTFC)player.getFoodStats()).addThirst(thirst);
            }
        });
    }

    @ZenMethod
    public static void makeDrinkable(ILiquidStack liquidStack, float thirst, IPotionEffect potion)
    {
        FluidsTFC.getWrapper(CraftTweakerMC.getFluid(liquidStack.getDefinition())).with(DrinkableProperty.DRINKABLE, (player) -> {
            if (player.getFoodStats() instanceof FoodStatsTFC) {
                ((FoodStatsTFC)player.getFoodStats()).addThirst(thirst);
                player.addPotionEffect(new PotionEffect(getPotion(potion.getPotion().name().toLowerCase()), potion.getDuration(), potion.getAmplifier()));
            }
        });
    }

    @ZenMethod
    public static void makeDrinkable(ILiquidStack liquidStack, float thirst, String potion, int duration, int level)
    {
        FluidsTFC.getWrapper(CraftTweakerMC.getFluid(liquidStack.getDefinition())).with(DrinkableProperty.DRINKABLE, (player) -> {
            if (player.getFoodStats() instanceof FoodStatsTFC) {
                ((FoodStatsTFC)player.getFoodStats()).addThirst(thirst);
                player.addPotionEffect(new PotionEffect(getPotion(potion), duration, level));
            }
        });
    }

    private static Potion getPotion(String potion)
    {
        return Potion.REGISTRY.getObject(new ResourceLocation(potion));
    }
}
