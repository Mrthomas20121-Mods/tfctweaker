package mrthomas20121.tfctweaker.natives;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.fluid.IFluidStack;
import com.blamejared.crafttweaker.api.fluid.MCFluidStack;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.item.MCItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.common.capabilities.forge.ForgeRule;
import net.dries007.tfc.common.recipes.ChiselRecipe;
import net.dries007.tfc.util.Metal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.openzen.zencode.java.ZenCodeType;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Locale;

@ZenRegister
@NativeTypeRegistration(value = Metal.class, zenCodeName = Constants.CLASS_EXPAND_METAL)
@Document("mods/TFCTweaker/api/Metal")
public class ExpandMetal {
    @ZenCodeType.Method
    public static Metal[] getAllMetals() {
        return Metal.MANAGER.getValues().toArray(new Metal[] {});
    }

    /**
     * get the metal from ingot
     * @param stack ingot
     * @return metal found
     *
     * @docParam stack <item:tfc:metal/ingot/copper>
     */
    @ZenCodeType.Method
    public static Metal getMetalFromIngot(IItemStack stack) {
        return Metal.getFromIngot(stack.getInternal());
    }

    @ZenCodeType.Method
    @ZenCodeType.Getter("commandString")
    public static String getCommandString(Metal internal) {
        return "<metal:" + internal.getId().toString().toLowerCase(Locale.ROOT) + ">";
    }

    @ZenCodeType.Method
    public static IFluidStack getFluidStack(Metal internal, int amount) {
        return new MCFluidStack(new FluidStack(internal.getFluid(), amount));
    }

    @ZenCodeType.Method
    public static IItemStack getMetalPart(Metal internal, String partName) {
        String finalName = "%s:metal/%s/%s".formatted(internal.getId().getNamespace(), partName, internal.getId().getPath());
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(finalName));
        if(item == null) {
            throw new IllegalArgumentException("Part name is wrong! Please use a valid part name");
        }
        return new MCItemStack(new ItemStack(item));
    }
}
