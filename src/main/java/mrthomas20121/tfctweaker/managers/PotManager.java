package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import mrthomas20121.tfctweaker.api.ingredient.TFCFluidIngredient;
import net.dries007.tfc.common.recipes.PotRecipe;
import net.dries007.tfc.common.recipes.SimplePotRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @docParam this <recipetype:tfc:pot>
 */
@ZenRegister
@ZenCodeType.Name(Constants.CLASS_POT)
@Document("mods/TFCTweaker/PotRecipe")
public class PotManager implements IRecipeManager<PotRecipe> {
    @Override
    public RecipeType<PotRecipe> getRecipeType() {
        return TFCRecipeTypes.POT.get();
    }

    /**
     * Add a pot recipe
     * @param name name of the recipe
     * @param ingredients array of input ingredient
     * @param fluid input fluid
     * @param duration time the recipe take
     * @param minTemp temp min required by the recipe
     * @param outputFluid output fluid
     *
     * @docParam name "pot_test"
     * @docParam ingredients [<tag:items:minecraft:sand>]
     * @docParam fluid FluidIngredient.of(<fluid:tfc:salt_water>)
     * @docParam duration 4
     * @docParam minTemp 200
     * @docParam outputFluid FluidIngredient.of(<fluid:minecraft:water>)
     */
    @ZenCodeType.Method
    public void addPotRecipe(String name, IIngredient[] ingredients, TFCFluidIngredient fluid, int duration, float minTemp, IFluidStack outputFluid) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new SimplePotRecipe(Helpers.identifier(name), Arrays.stream(ingredients).map(IIngredient::asVanillaIngredient).toList(), fluid.getIngredient(), duration, minTemp, outputFluid.getInternal(), new ArrayList<>(5))));
    }

    /**
     * Add a pot recipe
     * @param name name of the recipe
     * @param ingredients ingredients
     * @param fluid input fluid
     * @param duration duration
     * @param minTemp temp min required by the recipe
     * @param outputFluid output fluid
     * @param output output items
     *
     * @docParam name "pot_test"
     * @docParam ingredients [<tag:items:minecraft:sand>]
     * @docParam fluid FluidIngredient.of(<fluid:tfc:salt_water>)
     * @docParam duration 4
     * @docParam minTemp 200
     * @docParam outputFluid FluidIngredient.of(<fluid:minecraft:water>)
     * @docParam output [<item:minecraft:dirt>]
     */
    @ZenCodeType.Method
    public void addPotRecipe(String name, IIngredient[] ingredients, TFCFluidIngredient fluid, int duration, float minTemp, IFluidStack outputFluid, IItemStack[] output) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new SimplePotRecipe(Constants.identifier(name), Arrays.stream(ingredients).map(IIngredient::asVanillaIngredient).toList(), fluid.getIngredient(), duration, minTemp, outputFluid.getInternal(), Arrays.stream(output).map(IItemStack::getInternal).toList())));
    }
}
