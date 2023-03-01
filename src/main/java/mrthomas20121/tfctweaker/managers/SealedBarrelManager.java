package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredientWithAmount;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.api.TFCFluidIngredient;
import mrthomas20121.tfctweaker.api.TFCItemStackProvider;
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
@ZenCodeType.Name("mods.tfc.barrel_sealed")
@Document("mods/TFCTweaker/SealedBarrelRecipe")
public class SealedBarrelManager implements IRecipeManager<SealedBarrelRecipe> {

    @Override
    public RecipeType<SealedBarrelRecipe> getRecipeType() {
        return TFCRecipeTypes.BARREL_SEALED.get();
    }

    @ZenCodeType.Method
    public void addRecipe(String name, int duration, IIngredientWithAmount input, TFCFluidIngredient fluidStackIngredient, IItemStack output, IFluidStack outputFluid, @ZenCodeType.Optional SoundEvent event, @ZenCodeType.Optional TFCItemStackProvider onSeal, @ZenCodeType.Optional TFCItemStackProvider onUnseal) {
        ItemStackIngredient itemStackIngredient = new ItemStackIngredient(input.getIngredient().asVanillaIngredient(), input.getAmount());
        addRecipe(Helpers.identifier(name), duration, itemStackIngredient, fluidStackIngredient.getIngredient(), TFCItemStackProvider.none(output).get(), outputFluid.getInternal(), event == null ? SoundEvents.BREWING_STAND_BREW : event, toProvider(onSeal), toProvider(onUnseal));
    }

    public void addRecipe(ResourceLocation id, int duration, ItemStackIngredient ingredient, FluidStackIngredient fluidIngredient, ItemStackProvider output, FluidStack outputFluid, SoundEvent event, @Nullable ItemStackProvider onSeal, @Nullable ItemStackProvider onUnseal) {
        addRecipe(id, new BarrelRecipe.Builder(ingredient, fluidIngredient, output, outputFluid, event), duration, onSeal, onUnseal);
    }

    public void addRecipe(ResourceLocation id, BarrelRecipe.Builder builder, int duration, @Nullable ItemStackProvider onSeal, @Nullable ItemStackProvider onUnseal) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new SealedBarrelRecipe(id, builder, duration,onSeal, onUnseal)));
    }

    private ItemStackProvider toProvider(TFCItemStackProvider modifier) {
        if(modifier == null) {
            return null;
        }
        return modifier.get();
    }
}
