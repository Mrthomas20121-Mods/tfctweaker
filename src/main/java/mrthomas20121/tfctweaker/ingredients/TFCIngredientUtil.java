package mrthomas20121.tfctweaker.ingredients;

import com.blamejared.crafttweaker.api.fluid.CTFluidIngredient;
import com.blamejared.crafttweaker.api.ingredient.IIngredientWithAmount;
import net.dries007.tfc.common.recipes.ingredients.FluidIngredient;
import net.dries007.tfc.common.recipes.ingredients.FluidStackIngredient;
import net.dries007.tfc.common.recipes.ingredients.ItemStackIngredient;
import net.minecraftforge.fluids.FluidStack;

public class TFCIngredientUtil {

    public static ItemStackIngredient toItemStackIngredient(IIngredientWithAmount ingredient) {
        return new ItemStackIngredient(ingredient.getIngredient().asVanillaIngredient(), ingredient.getAmount());
    }

    public static FluidStackIngredient toFluidStackIngredient(IFluidIngredientWithAmount ingre) {
        return new FluidStackIngredient(toFluidIngredient(ingre.getIngredient()), ingre.getAmount());
    }

    public static FluidIngredient toFluidIngredient(CTFluidIngredient ctFluidIngredient) {
        return ctFluidIngredient.mapTo(fluidStack -> FluidIngredient.of(fluidStack.getFluid()), (fluidTagKey, integer) -> FluidIngredient.of(fluidTagKey), stream -> FluidIngredient.of(FluidStack.EMPTY.getFluid()));
    }
}
