package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredientWithAmount;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import mrthomas20121.tfctweaker.api.ingredient.TFCFluidIngredient;
import mrthomas20121.tfctweaker.api.ingredient.TFCItemStackProvider;
import net.dries007.tfc.common.recipes.BarrelRecipe;
import net.dries007.tfc.common.recipes.InstantBarrelRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.ingredients.FluidStackIngredient;
import net.dries007.tfc.common.recipes.ingredients.ItemStackIngredient;
import net.dries007.tfc.common.recipes.outputs.ItemStackProvider;
import net.dries007.tfc.util.Helpers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fluids.FluidStack;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:barrel_instant>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.instant_barrel")
@Document("mods/TFCTweaker/InstantBarrelRecipe")
public class InstantBarrelManager implements IRecipeManager<InstantBarrelRecipe> {

    @Override
    public RecipeType<InstantBarrelRecipe> getRecipeType() {
        return TFCRecipeTypes.BARREL_INSTANT.get();
    }

    /**
     * Add an instant barrel recipe
     * @param name name of the recipe
     * @param input item input
     * @param inputFluid fluid input, can be empty
     * @param output item output
     * @param outputFluid fluid ouput
     * @param event the sound to play when it is done, default to BREWING_STAND_BREW
     *
     * @docParam name "instant_test"
     * @docParam input <item:minecraft:dirt>*10
     * @docParam inputFluid FluidIngredient.of(<fluid:minecraft:water>)
     * @docParam output ItemStackProvider.empty()
     * @docParam outputFluid <fluid:tfc:olive_oil>
     */
    @ZenCodeType.Method
    public void addRecipe(String name, IIngredientWithAmount input, TFCFluidIngredient inputFluid, TFCItemStackProvider output, IFluidStack outputFluid, @ZenCodeType.Optional SoundEvent event) {
        ItemStackIngredient itemStackIngredient = new ItemStackIngredient(input.getIngredient().asVanillaIngredient(), input.getAmount());
        addRecipe(Constants.identifier(name), itemStackIngredient, inputFluid.getIngredient(), output.getInternal(), outputFluid.getInternal(), event == null ? SoundEvents.BREWING_STAND_BREW : event);
    }

    public void addRecipe(ResourceLocation id, ItemStackIngredient ingredient, FluidStackIngredient fluidIngredient, ItemStackProvider output, FluidStack outputFluid, SoundEvent event) {
        addRecipe(id, new BarrelRecipe.Builder(ingredient, fluidIngredient, output, outputFluid, event));
    }

    public void addRecipe(ResourceLocation id, BarrelRecipe.Builder builder) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new InstantBarrelRecipe(id, builder)));
    }
}
