package mrthomas20121.tfctweaker;

import net.dries007.tfc.Constants;
import net.dries007.tfc.api.registries.TFCRegistryEvent;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.blocks.wood.BlockLeavesTFC;
import net.dries007.tfc.objects.blocks.wood.BlockSaplingTFC;
import net.dries007.tfc.objects.items.ItemArmorTFC;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = TFCTweaker.MODID)
public class RegistryHandler {

    private static ArrayList<Metal> metals = new ArrayList<>();

    public static void addMetalToBuild(Metal metal) {
        if(!metals.contains(metal)) metals.add(metal);
    }

    @SubscribeEvent
    public static void onBlockHarvestDrop(BlockEvent.HarvestDropsEvent event) {
        final Block block = event.getState().getBlock();

        if(block instanceof BlockLeavesTFC) {
            BlockLeavesTFC leave = (BlockLeavesTFC)block;
            if(leave.wood.getRegistryName().getPath().equals("sequoia")) {
                Tree tree = leave.wood;
                if(TweakerConfig.BaseConfig.sequoia_sapling) {
                    event.getDrops().add(new ItemStack(BlockSaplingTFC.get(tree), Constants.RNG.nextFloat() > 0.7f ? 1: 0));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onRegisterRecipesEvent(RegistryEvent.Register<IRecipe> event) {

        RecipeHelper.removeRecipe(event.getRegistry(), "minecraft:tnt");
    }

    public static void onPreRegisterMetal(TFCRegistryEvent.RegisterPreBlock<Metal> event) {
        for(Metal metal: metals) {
            event.getRegistry().register(metal);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onTooltipEvent(ItemTooltipEvent event) {
        ItemStack itemstack = event.getItemStack();
        List<String> tooltip = event.getToolTip();
        Item item = itemstack.getItem();

        if(item instanceof ItemArmorTFC)
        {
            ItemArmorTFC itemArmorTFC = (ItemArmorTFC) item;
            float crushing = itemArmorTFC.getCrushingModifier();
            float slashing = itemArmorTFC.getSlashingModifier();
            float piercing = itemArmorTFC.getPiercingModifier();

            if(isShiftDown()) {
                tooltip.add(TextFormatting.AQUA+(new TextComponentTranslation("tfctweaker.resistance.crushing",crushing)).getUnformattedComponentText());
                tooltip.add(TextFormatting.AQUA+(new TextComponentTranslation("tfctweaker.resistance.slashing", slashing)).getUnformattedComponentText());
                tooltip.add(TextFormatting.AQUA+(new TextComponentTranslation("tfctweaker.resistance.piercing", piercing)).getUnformattedComponentText());
            }
            else {
                tooltip.add(I18n.format("tfctweaker.shift"));
            }
        }

    }
    public static boolean isShiftDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }
}
