package mrthomas20121.tfctweaker.ingredients;

import com.blamejared.crafttweaker.api.fluid.CTFluidIngredient;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredientWithAmount;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.item.MCItemStack;
import net.dries007.tfc.common.capabilities.food.FoodCapability;
import net.dries007.tfc.common.recipes.ingredients.FluidIngredient;
import net.dries007.tfc.common.recipes.ingredients.FluidStackIngredient;
import net.dries007.tfc.common.recipes.ingredients.ItemStackIngredient;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;

import java.util.Arrays;

public class TFCIngredientUtil {

    public static ItemStackIngredient toItemStackIngredient(IIngredientWithAmount ingredient) {
        return new ItemStackIngredient(ingredient.getIngredient().asVanillaIngredient(), ingredient.getAmount());
    }

    public static FluidStackIngredient toFluidStackIngredient(IFluidStack ingre) {
        return new FluidStackIngredient(mapFluidIngredients(ingre.asFluidIngredient()), ingre.getAmount());
    }

    public static FluidIngredient mapFluidIngredients(CTFluidIngredient ingredient) {

        return ingredient
                .mapTo(fluid -> FluidIngredient.of(fluid.getFluid()), (tag, i) -> FluidIngredient.of(tag), stream -> {
                    throw new IllegalArgumentException("Unable to use a compound ingredient for TFC!");
                });
    }
}
