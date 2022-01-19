package mrthomas20121.tfctweaker.knapping;

import mrthomas20121.tfctweaker.TFCTweaker;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class KnappingData {

    private final String location;

    private final KnappingType type;
    private final ResourceLocation TEXTURE;
    private final ResourceLocation TEXTURE_DISABLED;
    private final List<ItemStack> items;
    private final int ID;

    public KnappingData(int amountToConsume, boolean consumeAfterComplete, String location, List<ItemStack> list, int id) {
        this.location = location;
        this.type = new KnappingType(amountToConsume, consumeAfterComplete);
        this.TEXTURE = new ResourceLocation(TFCTweaker.MODID, String.format("textures/gui/%s_button.png", location));
        this.TEXTURE_DISABLED = new ResourceLocation(TFCTweaker.MODID, String.format("textures/gui/%s_button_disabled.png", location));
        this.items = list;
        this.ID = id;
    }

    public String getLocation() {
        return location;
    }

    public ResourceLocation getTEXTURE() {
        return TEXTURE;
    }

    public ResourceLocation getTEXTURE_DISABLED() {
        return TEXTURE_DISABLED;
    }

    public List<ItemStack> getItems() {
        return this.items;
    }

    public int getID() {
        return ID;
    }

    public KnappingType getType() {
        return type;
    }

    public boolean itemsMatch(ItemStack stack) {
        return this.items.stream().anyMatch(itemStack->itemStack.getItem().getRegistryName().equals(stack.getItem().getRegistryName()));
    }
}
