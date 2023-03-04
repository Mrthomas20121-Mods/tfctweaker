package mrthomas20121.tfctweaker.api;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.tag.type.KnownTag;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.dries007.tfc.common.recipes.ingredients.FluidIngredient;
import net.dries007.tfc.common.recipes.ingredients.FluidStackIngredient;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;
import java.util.List;

@ZenRegister
@ZenCodeType.Name("mods.tfc.api.FluidStackIngredient")
@Document("mods/TFCTweaker/api/FluidStackIngredient")
public class TFCFluidIngredient {

    private final FluidStackIngredient ingredient;

    public TFCFluidIngredient(FluidStackIngredient ingredient) {
        this.ingredient = ingredient;
    }

    public FluidStackIngredient getIngredient() {
        return ingredient;
    }

    /**
     * Empty Fluid Ingredient
     * @return
     */
    @ZenCodeType.Method
    @ZenCodeType.Getter("empty")
    public static TFCFluidIngredient empty() {
        return new TFCFluidIngredient(FluidStackIngredient.EMPTY);
    }

    /**
     * Fluid Ingredient from a tag
     * @param fluids
     * @param amount
     * @return
     */
    @ZenCodeType.Method
    public static TFCFluidIngredient of(KnownTag<Fluid> fluids, int amount) {
        return new TFCFluidIngredient(new FluidStackIngredient(FluidIngredient.of(fluids.getTagKey()), amount));
    }

    /**
     * Fluid Ingredient from a fluidstack
     * @param fluid
     * @return
     */
    @ZenCodeType.Method
    public static TFCFluidIngredient of(IFluidStack fluid) {
        return new TFCFluidIngredient(new FluidStackIngredient(FluidIngredient.of(fluid.getFluid()), fluid.getAmount()));
    }

    @ZenCodeType.Method
    public static TFCFluidIngredient of(IFluidStack[] stack, int amount) {
        FluidIngredient[] fluidIngredients = Arrays.stream(stack).map(IFluidStack::getFluid).map(FluidIngredient::of).toList().toArray(new FluidIngredient[] {});
        return new TFCFluidIngredient(new FluidStackIngredient(FluidIngredient.of(fluidIngredients), amount));
    }
}
