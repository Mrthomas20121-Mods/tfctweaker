package mrthomas20121.tfctweaker.ingredients;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.bracket.CommandStringDisplayable;
import com.blamejared.crafttweaker.api.fluid.CTFluidIngredient;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;

/**
 * Consists of a fluid ingredient and an amount.
 */
@ZenRegister
@Document("tfc/api/ingredient/IFluidIngredientWithAmount")
@ZenCodeType.Name("tfc.api.ingredient.IFluidIngredientWithAmount")
public interface IFluidIngredientWithAmount extends CommandStringDisplayable {

    /**
     * The backing ingredient
     */
    @ZenCodeType.Getter("ingredient")
    CTFluidIngredient.CompoundFluidIngredient getIngredient();

    /**
     * Gets the amount of Fluids in the ItemStack
     *
     * @return ItemStack's amount
     */
    @ZenCodeType.Getter("amount")
    int getAmount();

}
