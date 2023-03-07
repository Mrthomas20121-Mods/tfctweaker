package mrthomas20121.tfctweaker.natives;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.item.MCItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.common.capabilities.food.FoodCapability;
import net.dries007.tfc.common.capabilities.food.FoodTrait;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Objects;

@ZenRegister
@Document("mods/TFCTweaker/Api/Expansion/IItemStackExpansion")
@ZenCodeType.Expansion(Constants.CT_ITEMSTACK_API)
public class ExpandIItemStack {

    /**
     * Apply a food trait to the stack
     * @param self this
     * @param trait the trait we are adding to it
     * @return
     *
     * @docParam trait "salted"
     */
    @ZenCodeType.StaticExpansionMethod
    public static IItemStack applyFoodTrait(IItemStack self, String trait) {
        return new MCItemStack(FoodCapability.applyTrait(self.getInternal(), Objects.requireNonNull(FoodTrait.getTrait(new ResourceLocation(trait)))));
    }
}
