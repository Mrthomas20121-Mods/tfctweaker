package mrthomas20121.tfctweaker.expand;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.item.MCItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.dries007.tfc.common.capabilities.food.FoodCapability;
import net.dries007.tfc.common.capabilities.food.FoodTrait;
import net.dries007.tfc.common.capabilities.food.FoodTraits;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Objects;

@ZenRegister
@Document("mods/tfctweaker/IItemStack")
@ZenCodeType.Expansion("crafttweaker.api.item.IItemStack")
public class IItemStackExpansion {

    @ZenCodeType.Method
    public static IItemStack copyFoodValue(IItemStack self, IItemStack stack) {
        return new MCItemStack(FoodCapability.mergeItemStacks(stack.getInternal(), self.getInternal()));
    }

    @ZenCodeType.Method
    public static IItemStack applyFoodTrait(IItemStack self, String trait) {
        return new MCItemStack(FoodCapability.applyTrait(self.getInternal(), Objects.requireNonNull(FoodTrait.getTrait(new ResourceLocation(trait)))));
    }
}
