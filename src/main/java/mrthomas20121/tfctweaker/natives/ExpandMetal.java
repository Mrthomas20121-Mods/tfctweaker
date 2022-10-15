package mrthomas20121.tfctweaker.natives;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.dries007.tfc.common.capabilities.forge.ForgeRule;
import net.dries007.tfc.common.recipes.ChiselRecipe;
import net.dries007.tfc.util.Metal;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Locale;

@ZenRegister
@NativeTypeRegistration(value = Metal.class, zenCodeName = "mods.tfctweaker.api.metal")
@Document("mods/tfctweaker/api/Metal")
public class ExpandMetal {

    @ZenCodeType.Method
    @ZenCodeType.Getter("commandString")
    public static String getCommandString(Metal internal) {

        return "<metal:" + internal.getId().toString().toLowerCase(Locale.ROOT) + ">";
    }
}
