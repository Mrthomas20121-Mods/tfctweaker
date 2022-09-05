package mrthomas20121.tfctweaker.manager;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.dries007.tfc.common.recipes.BarrelRecipe;
import net.dries007.tfc.common.recipes.SealedBarrelRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.common.recipes.ingredients.FluidIngredient;
import net.dries007.tfc.common.recipes.ingredients.FluidStackIngredient;
import net.dries007.tfc.common.recipes.ingredients.ItemStackIngredient;
import net.dries007.tfc.common.recipes.outputs.ItemStackProvider;
import net.dries007.tfc.util.Helpers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fluids.FluidStack;
import org.openzen.zencode.java.ZenCodeType;

/**
 * @docParam this <recipetype:tfc:barrel_sealed>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.barrel")
@Document("mods/tfctweaker/BarrelManager")
public class BarrelManager implements IRecipeManager<SealedBarrelRecipe> {

    @Override
    public RecipeType<SealedBarrelRecipe> getRecipeType() {
        return TFCRecipeTypes.BARREL_SEALED.get();
    }

    @ZenCodeType.Method
    public void addRecipe(String name, int duration, IIngredient input, int inputCount, IFluidStack inputFluid, int inputFluidCount,  IItemStack output, IFluidStack outputFluid, SoundEvent event) {
        ResourceLocation registryName = Helpers.identifier(name);
        ItemStackIngredient itemStackIngredient = new ItemStackIngredient(input.asVanillaIngredient(), inputCount);
        FluidStackIngredient fluidStackIngredient = new FluidStackIngredient(FluidIngredient.of(inputFluid.getFluid()), inputFluidCount);
        ItemStack stack = output.getInternal();
        FluidStack fluidStack = outputFluid.getInternal();
        BarrelRecipe.Builder builder = new BarrelRecipe.Builder(itemStackIngredient, fluidStackIngredient, ItemStackProvider.of(stack), fluidStack, event);
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new SealedBarrelRecipe(registryName, builder, duration,null, null), ""));
    }
}
