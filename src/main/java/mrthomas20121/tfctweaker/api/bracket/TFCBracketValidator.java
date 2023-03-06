package mrthomas20121.tfctweaker.api.bracket;

import com.blamejared.crafttweaker.api.annotation.BracketValidator;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.util.Metal;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name(Constants.CLASS_BRACKET_VALIDATOR)
public class TFCBracketValidator {

    @BracketValidator(Constants.BRACKET_METAL)
    public static boolean validateMetal(String tokens) {
        return Metal.MANAGER.get(new ResourceLocation(tokens)) != null;
    }
}
