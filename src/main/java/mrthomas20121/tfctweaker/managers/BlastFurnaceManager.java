package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import mrthomas20121.tfctweaker.api.ingredient.TFCFluidIngredient;
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
@ZenCodeType.Name(Constants.CLASS_BLAST_FURNACE)
@Document("mods/TFCTweaker/BlastFurnaceRecipe")
public class BlastFurnaceManager implements IRecipeManager<BlastFurnaceRecipe> {

    @Override
    public RecipeType<BlastFurnaceRecipe> getRecipeType() {
        return TFCRecipeTypes.BLAST_FURNACE.get();
    }

    /**
     * Add a Blast furnace recipe
     * @param name name of the recipe
     * @param input metal
     * @param amount amount of metal used
     * @param catalyst catalyst used for the recipe
     * @param output metal
     * @param outputAmount amount of metal received
     *
     * @docParam name "blast_test"
     * @docParam input <metal:tfc:copper>
     * @docParam amount 100
     * @docParam catalyst <tag:items:forge:gems/coal>
     * @docParam output <metal:tfc:bronze>
     * @docParam outputAmount 50
     */
    @ZenCodeType.Method
    public void addRecipe(String name, Metal input, int amount, IIngredient catalyst, Metal output, int outputAmount) {
        this.addRecipe(Helpers.identifier(name), new FluidStackIngredient(FluidIngredient.of(input.getFluid()), amount), catalyst.asVanillaIngredient(), new FluidStack(output.getFluid(), outputAmount));
    }

    /**
     * Add a Blast furnace recipe, default to 100mb of metal used
     * @param name name of the recipe
     * @param input metal
     * @param catalyst catalyst used for the recipe
     * @param output metal
     *
     * @docParam name "blast_test"
     * @docParam input <metal:tfc:copper>
     * @docParam catalyst <tag:items:forge:gems/coal>
     * @docParam output <metal:tfc:bronze>
     */
    @ZenCodeType.Method
    public void addRecipe(String name, Metal input, IIngredient catalyst, Metal output) {
        this.addRecipe(Helpers.identifier(name), new FluidStackIngredient(FluidIngredient.of(input.getFluid()), 100), catalyst.asVanillaIngredient(), new FluidStack(output.getFluid(), 100));
    }

    /**
     * Add a Blast furnace recipe
     * @param name name of the recipe
     * @param input fluid input
     * @param catalyst catalyst used for the recipe
     * @param output fluid output
     *
     * @docParam name "blast_test"
     * @docParam input FluidStackIngredient.of(<fluid:tfc:metal/copper>*100);
     * @docParam catalyst <tag:items:forge:gems/coal>
     * @docParam output <fluid:tfc:metal/bronze>*100
     */
    @ZenCodeType.Method
    public void addRecipe(String name, TFCFluidIngredient input, IIngredient catalyst, IFluidStack output) {
        this.addRecipe(Helpers.identifier(name), input.getIngredient(), catalyst.asVanillaIngredient(), output.getInternal());
    }

    public void addRecipe(ResourceLocation id, FluidStackIngredient inputFluid, Ingredient catalyst, FluidStack outputFluid) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new BlastFurnaceRecipe(id, inputFluid, catalyst, outputFluid)));
    }
}
