package mrthomas20121.tfctweaker.client;

import mrthomas20121.tfctweaker.TFCTweaker;
import mrthomas20121.tfctweaker.knapping.CustomKnapping;
import mrthomas20121.tfctweaker.knapping.KnappingData;
import net.dries007.tfc.objects.container.*;

import net.dries007.tfc.util.OreDictionaryHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;
import java.util.Optional;

public class TFCTweakerGuiHandler implements IGuiHandler {

    public static void openGui(World world, BlockPos pos, EntityPlayer player, KnappingData data)
    {
        player.openGui(TFCTweaker.instance, data.getID(), world, pos.getX(), pos.getY(), pos.getZ());
    }

    public static void openGui(World world, EntityPlayer player, KnappingData data)
    {
        player.openGui(TFCTweaker.instance, data.getID(), world, 0, 0, 0);
    }

    @Override
    @Nullable
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        ItemStack stack = player.getHeldItemMainhand();
        Optional<KnappingData> optional = CustomKnapping.table.values().stream().filter(data->data.getID()==ID).findFirst();
        if(optional.isPresent()) {
            KnappingData data = optional.get();
            return new ContainerKnapping(data.getType(), player.inventory,  data.itemsMatch(stack) ? stack : player.getHeldItemOffhand());
        }
        return null;
    }
    @Override
    @Nullable
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        Container container = getServerGuiElement(ID, player, world, x, y, z);
        Optional<KnappingData> optional = CustomKnapping.table.values().stream().filter(data->data.getID()==ID).findFirst();
        if(optional.isPresent()) {
            KnappingData data = optional.get();
            return new CustomKnappingGui(container, player, data.getType(), data.getTEXTURE());
        }
        return null;
    }
}