package mrthomas20121.tfctweaker.api.bracket;

import com.blamejared.crafttweaker.api.annotation.BracketDumper;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.util.Metal;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Collection;

@ZenRegister
@ZenCodeType.Name(Constants.CLASS_BRACKET_DUMPER)
public class TFCBracketDumper {

    @BracketDumper(value = Constants.BRACKET_METAL, subCommandName = "tfcMetals")
    public static Collection<Metal> getMetalDump() {
        return Metal.MANAGER.getValues();
    }
}
