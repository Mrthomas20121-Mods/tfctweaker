package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.dries007.tfc.common.recipes.BlastFurnaceRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.ingredients.FluidIngredient;
import net.dries007.tfc.common.recipes.ingredients.FluidStackIngredient;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.Metal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fluids.FluidStack;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:blast_furnace>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.blast_furnace")
@Document("mods/TFCTweaker/BlastFurnaceRecipe")
public class BlastFurnaceManager implements IRecipeManager<BlastFurnaceRecipe> {

    @Override
    public RecipeType<BlastFurnaceRecipe> getRecipeType() {
        return TFCRecipeTypes.BLAST_FURNACE.get();
    }

    @ZenCodeType.Method
    public void addRecipe(String name, Metal input, IIngredient catalyst, Metal output) {
        this.addRecipe(Helpers.identifier(name), new FluidStackIngredient(FluidIngredient.of(input.getFluid()), 100), catalyst.asVanillaIngredient(), new FluidStack(output.getFluid(), 100));
    }

    @ZenCodeType.Method
    public void addRecipe(String name, IFluidStack input, IIngredient catalyst, IFluidStack output) {
        this.addRecipe(Helpers.identifier(name), new FluidStackIngredient(FluidIngredient.of(input.getFluid()), input.getAmount()), catalyst.asVanillaIngredient(), output.getInternal());
    }

    public void addRecipe(ResourceLocation id, FluidStackIngredient inputFluid, Ingredient catalyst, FluidStack outputFluid) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new BlastFurnaceRecipe(id, inputFluid, catalyst, outputFluid)));
    }
}
