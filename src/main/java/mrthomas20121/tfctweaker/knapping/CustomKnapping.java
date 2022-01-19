package mrthomas20121.tfctweaker.knapping;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import mrthomas20121.tfctweaker.TFCTweaker;
import mrthomas20121.tfctweaker.client.TFCTweakerGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Map;

@Mod.EventBusSubscriber(modid = TFCTweaker.MODID)
public class CustomKnapping {

    public static Map<String, KnappingData> table = new Object2ObjectOpenHashMap<>();

    @SubscribeEvent
    public static void rightClick(PlayerInteractEvent.RightClickItem event) {
        World world = event.getWorld();
        EntityPlayer player = event.getEntityPlayer();
        table.values().forEach(data->{

            if(data.itemsMatch(event.getItemStack())) {
                if(!world.isRemote && !player.isSneaking() && event.getItemStack().getCount() > 0) {
                    TFCTweakerGuiHandler.openGui(world, player.getPosition(), player, data);
                }
            }
        });
    }
}
