package mrthomas20121.tfctweaker.client;

import mrthomas20121.tfctweaker.knapping.CustomKnapping;
import mrthomas20121.tfctweaker.knapping.KnappingData;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.dries007.tfc.client.gui.GuiKnapping;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import java.util.Optional;

public class CustomKnappingGui extends GuiKnapping {

    private KnappingType type = null;

    public CustomKnappingGui(Container container, EntityPlayer player, KnappingType type, ResourceLocation buttonTexture)
    {
        super(container, player, type, buttonTexture);
        this.type = type;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        super.func_146976_a(partialTicks, mouseX, mouseY);
        Optional<KnappingData> optionalData = CustomKnapping.table.values().stream().filter(data->data.getType().equals(this.type)).findFirst();

        if(optionalData.isPresent()) {
            KnappingData data = optionalData.get();
            GlStateManager.color(1, 1, 1, 1);
            mc.getTextureManager().bindTexture(data.getTEXTURE_DISABLED());
            for (GuiButton button : buttonList)
            {
                if (!button.visible)
                {
                    Gui.drawModalRectWithCustomSizedTexture(button.x, button.y, 0, 0, 16, 16, 16, 16);
                }
            }
        }
    }
}