package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredientWithAmount;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import mrthomas20121.tfctweaker.api.ingredient.TFCFluidIngredient;
import mrthomas20121.tfctweaker.api.ingredient.TFCItemStackProvider;
import net.dries007.tfc.common.recipes.BarrelRecipe;
import net.dries007.tfc.common.recipes.SealedBarrelRecipe;
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
import org.jetbrains.annotations.Nullable;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:barrel_sealed>
 */
@ZenRegister
@ZenCodeType.Name(Constants.CLASS_SEALED_BARREL)
@Document("mods/TFCTweaker/SealedBarrelRecipe")
public class SealedBarrelManager implements IRecipeManager<SealedBarrelRecipe> {

    @Override
    public RecipeType<SealedBarrelRecipe> getRecipeType() {
        return TFCRecipeTypes.BARREL_SEALED.get();
    }

    /**
     * Add an instant barrel recipe
     * @param name name of the recipe
     * @param duration how long until the recipe is done(in hours)
     * @param input item input
     * @param fluidIngredient fluid input, can be empty
     * @param output item output
     * @param outputFluid fluid ouput
     * @param event the sound to play when it is done, default to BREWING_STAND_BREW
     * @param onSeal Call this on seal
     * @param onUnseal Call this on unseal
     *
     * @docParam name "instant_test"
     * @docParam duration 2
     * @docParam input <item:minecraft:dirt>*10
     * @docParam fluidStackIngredient FluidIngredient.of(<fluid:minecraft:water>)
     * @docParam output ItemStackProvider.empty()
     * @docParam outputFluid <fluid:tfc:olive_oil>
     * @docParam event null
     */
    @ZenCodeType.Method
    public void addRecipe(String name, int duration, ItemStackIngredient input, FluidStackIngredient fluidIngredient, ItemStackProvider output, IFluidStack outputFluid, SoundEvent event, @Nullable ItemStackProvider onSeal, @Nullable ItemStackProvider onUnseal) {
        addRecipe(Constants.identifier(name), new BarrelRecipe.Builder(input, fluidIngredient, output, outputFluid.getInternal(), event), duration, onSeal, onUnseal);
    }

    private void addRecipe(ResourceLocation id, BarrelRecipe.Builder builder, int duration, @Nullable ItemStackProvider onSeal, @Nullable ItemStackProvider onUnseal) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new SealedBarrelRecipe(id, builder, duration,onSeal, onUnseal)));
    }

    @Nullable
    private ItemStackProvider toProvider(TFCItemStackProvider modifier) {
        if(modifier == null) {
            return null;
        }
        return modifier.getInternal();
    }
}
