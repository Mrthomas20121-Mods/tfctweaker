package mrthomas20121.tfctweaker.api.ingredient;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.tag.type.KnownTag;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.common.recipes.ingredients.FluidIngredient;
import net.dries007.tfc.common.recipes.ingredients.FluidStackIngredient;
import net.minecraft.world.level.material.Fluid;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Arrays;

@ZenRegister
@ZenCodeType.Name(Constants.CLASS_FLUID_INGREDIENT)
@Document("mods/TFCTweaker/Api/FluidStackIngredient")
public class TFCFluidIngredient {

    private final FluidStackIngredient ingredient;

    public TFCFluidIngredient(FluidStackIngredient ingredient) {
        this.ingredient = ingredient;
    }

    public FluidStackIngredient getIngredient() {
        return ingredient;
    }

    /**
     * Create an empty fluid ingredient
     * @return
     */
    @ZenCodeType.Method
    public static TFCFluidIngredient empty() {
        return new TFCFluidIngredient(FluidStackIngredient.EMPTY);
    }

    /**
     * Create a fluid ingredient from a fluid tag
     * @param fluids tag of fluids
     * @param amount amount of fluid
     * @return
     *
     * @docParam fluids <tag:fluids:minecraft:water>
     * @docParam amount 100
     */
    @ZenCodeType.Method
    public static TFCFluidIngredient of(KnownTag<Fluid> fluids, int amount) {
        return new TFCFluidIngredient(new FluidStackIngredient(FluidIngredient.of(fluids.getTagKey()), amount));
    }

    /**
     * Create a fluid ingredient from a fluidstack
     * @param fluid Fluidstack
     * @return
     *
     * @docParam fluid <fluid:tfc:olive_oil>*100
     */
    @ZenCodeType.Method
    public static TFCFluidIngredient of(IFluidStack fluid) {
        return new TFCFluidIngredient(new FluidStackIngredient(FluidIngredient.of(fluid.getFluid()), fluid.getAmount()));
    }

    /**
     * Create a fluid ingredient from a list of fluids
     * @param fluidStacks array of fluids
     * @param amount amount of fluid
     * @return
     *
     * @docParam fluidStacks [<fluid:minecraft:water>, <fluid:minecraft:lava>]
     * @docParam amount 1000
     */
    @ZenCodeType.Method
    public static TFCFluidIngredient of(IFluidStack[] fluidStacks, int amount) {
        FluidIngredient[] fluidIngredients = Arrays.stream(fluidStacks).map(IFluidStack::getFluid).map(FluidIngredient::of).toList().toArray(new FluidIngredient[] {});
        return new TFCFluidIngredient(new FluidStackIngredient(FluidIngredient.of(fluidIngredients), amount));
    }
}
