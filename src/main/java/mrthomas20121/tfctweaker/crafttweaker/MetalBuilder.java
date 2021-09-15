package mrthomas20121.tfctweaker.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenConstructor;
import stanhebben.zenscript.annotations.ZenMethod;

import java.nio.charset.StandardCharsets;

@ZenClass("mods.tfctweaker.MetalBuilder")
@ZenRegister
public class MetalBuilder {

    private ResourceLocation name;
    private Metal.Tier tier = Metal.Tier.TIER_0;
    private boolean usable;
    private float specificHeat = 0.35f;
    private float meltTemp = 1000f;
    private int color = 0x0;

    @ZenConstructor
    public MetalBuilder() {
        this.usable = true;
    }

    @ZenConstructor
    public MetalBuilder(String metal) {
        this();
        this.name = new ResourceLocation("tfc", metal);
    }

    @ZenMethod
    public MetalBuilder setName(String name) {
        if(this.name == null) this.name = new ResourceLocation("tfc", name);
        return this;
    }

    @ZenMethod
    public MetalBuilder setUsable(boolean usable) {
        this.usable = usable;
        return this;
    }

    @ZenMethod
    public MetalBuilder setColor(int color) {
        this.color = color;
        return this;
    }

    @ZenMethod
    public MetalBuilder setColor(String color) {
        this.color = Integer.getInteger("0x"+color);
        return this;
    }

    @ZenMethod
    public MetalBuilder setTier(int tier) {
        this.tier = Metal.Tier.valueOf(tier);
        return this;
    }

    @ZenMethod
    public MetalBuilder setHeat(float heat) {
        this.specificHeat = heat;
        return this;
    }

    @ZenMethod
    public MetalBuilder setMeltTemp(float meltTemp) {
        this.meltTemp = meltTemp;
        return this;
    }

    @ZenMethod
    public void build() {
        Metal metal = new Metal(this.name, this.tier, this.usable, this.specificHeat, this.meltTemp, this.color, null, null);
        TFCRegistries.METALS.register(metal);
        CraftTweakerAPI.logInfo("Registered metal with name"+ StringUtils.capitalize(this.name.getPath()));
    }
}
