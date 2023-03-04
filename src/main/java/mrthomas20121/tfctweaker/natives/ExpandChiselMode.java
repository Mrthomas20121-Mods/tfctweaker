package mrthomas20121.tfctweaker.natives;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.BracketEnum;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.dries007.tfc.common.recipes.ChiselRecipe;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Locale;

@ZenRegister
@NativeTypeRegistration(value = ChiselRecipe.Mode.class, zenCodeName = "mods.tfctweaker.ChiselMode")
@Document("mods/TFCTweaker/recipe/ChiselMode")
@BracketEnum("tfc:chisel_mode")
public class ExpandChiselMode {

    @ZenCodeType.Method
    @ZenCodeType.Getter("commandString")
    public static String getCommandString(ChiselRecipe.Mode internal) {

        return "<constant:tfc:chisel_mode:" + internal.name().toLowerCase(Locale.ROOT) + ">";
    }
}