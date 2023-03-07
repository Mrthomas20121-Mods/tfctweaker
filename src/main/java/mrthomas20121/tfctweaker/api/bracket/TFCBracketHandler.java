package mrthomas20121.tfctweaker.api.bracket;


import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotation.BracketResolver;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.util.Metal;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.Locale;

@ZenRegister
@ZenCodeType.Name(Constants.CLASS_BRACKET_HANDLER)
@Document("mods/TFCTweaker/api/BracketHandlers")
public class TFCBracketHandler {

    /**
     * Gets a {@link net.dries007.tfc.util.Metal} instance. Throws an Exception if not found
     *
     * @param tokens What you would write in the BEP call.
     *
     * @return The found {@link net.dries007.tfc.util.Metal}
     *
     * @docParam tokens "tfc:copper"
     */
    @ZenCodeType.Method
    @BracketResolver(Constants.BRACKET_METAL)
    public static Metal getMetal(String tokens) {

        if(!tokens.toLowerCase(Locale.ENGLISH).equals(tokens)) {
            CraftTweakerAPI.LOGGER.warn("Metal BEP <metal:{}> does not seem to be lower-cased!", tokens);
        }

        final String[] split = tokens.split(":");
        if(split.length != 2) {
            throw new IllegalArgumentException("Could not get metal with name: <metal:" + tokens + ">! Syntax is <metal:modid:metalname>");
        }
        ResourceLocation key = new ResourceLocation(split[0], split[1]);
        return Metal.MANAGER.get(key);
    }
}
