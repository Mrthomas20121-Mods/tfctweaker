package mrthomas20121.tfctweaker.natives;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.BracketEnum;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.dries007.tfc.common.capabilities.forge.ForgeRule;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Locale;

@ZenRegister
@NativeTypeRegistration(value = ForgeRule.class, zenCodeName = "mods.tfctweaker.ForgeRule")
@Document("mods/tfctweaker/recipe/ForgeRule")
@BracketEnum("tfc:forge_rule")
public class ExpandForgeRule {

    @ZenCodeType.Method
    @ZenCodeType.Getter("commandString")
    public static String getCommandString(ForgeRule internal) {

        return "<constant:tfc:forge_rule:" + internal.name().toLowerCase(Locale.ROOT) + ">";
    }
}
