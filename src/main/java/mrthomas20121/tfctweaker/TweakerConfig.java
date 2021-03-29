package mrthomas20121.tfctweaker;

import net.minecraftforge.common.config.Config;

public class TweakerConfig {

    @Config(modid = TFCTweaker.MODID, name = "TFCTweaker")
    public static class BaseConfig {

        @Config.Comment("Enable/Disable Sequoia sapling.")
        public static boolean sequoia_sapling = false;
    }
}
