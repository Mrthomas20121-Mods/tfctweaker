package mrthomas20121.tfctweaker.natives;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.item.MCItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.dries007.tfc.common.capabilities.forge.ForgeRule;
import net.dries007.tfc.common.recipes.ChiselRecipe;
import net.dries007.tfc.util.Metal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Locale;

@ZenRegister
@NativeTypeRegistration(value = Metal.class, zenCodeName = "mods.tfctweaker.api.metal")
@Document("mods/TFCTweaker/api/Metal")
public class ExpandMetal {

    @ZenCodeType.Method
    @ZenCodeType.Getter("commandString")
    public static String getCommandString(Metal internal) {

        return "<metal:" + internal.getId().toString().toLowerCase(Locale.ROOT) + ">";
    }

    @ZenCodeType.Method
    public static IItemStack getMetalPart(Metal internal, String partName) {
        String finalName = "%s:metal/%s/%s".formatted(internal.getId().getNamespace(), partName, internal.getId().getPath());
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(finalName));
        if(item == null) {
            throw new IllegalArgumentException("Part name is wrong! Please fix");
        }
        return new MCItemStack(new ItemStack(item));
    }
}
