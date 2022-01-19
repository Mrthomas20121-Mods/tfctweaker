package mrthomas20121.tfctweaker;

import mrthomas20121.tfctweaker.client.TFCTweakerGuiHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = TFCTweaker.MODID, name = TFCTweaker.NAME, version = TFCTweaker.VERSION,
        dependencies = "required-after:forge@[14.23.5.2847,);")
public class TFCTweaker {
    public static final String MODID = "tfctweaker";
    public static final String NAME = "TFC Tweaker";
    public static final String VERSION = "1.0.7";

    public static Logger logger;

    @Mod.Instance()
    public static TFCTweaker instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        logger = event.getModLog();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new TFCTweakerGuiHandler());
		OredictTweak.registerOredicts();
	}
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
