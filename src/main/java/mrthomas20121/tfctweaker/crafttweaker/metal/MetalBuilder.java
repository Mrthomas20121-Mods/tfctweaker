package mrthomas20121.tfctweaker.crafttweaker.metal;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import mrthomas20121.tfctweaker.RegistryHandler;
import net.dries007.tfc.api.types.Metal;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.ZenClass;

@ModOnly("tfc")
@ZenClass("mods.tfctweaker.early.metal.MetalBuilder")
@ZenRegister
public class MetalBuilder {

    private final ResourceLocation name;
    private Metal.Tier tier = Metal.Tier.TIER_0;
    private boolean usable;
    private float specificHeat = 0.35f;
    private float meltTemp = 1000f;
    private int color = 0x0;

    public MetalBuilder(String name)  {
        this.name = new ResourceLocation("tfc", name);
        this.usable = true;
    }
    public MetalBuilder(String name, boolean usable)  {
        this.name = new ResourceLocation("tfc", name);
        this.usable = usable;
    }

    public MetalBuilder setColor(int color) {
        this.color = color;
        return this;
    }

    public MetalBuilder setTier(int tier) {
        this.tier = Metal.Tier.valueOf(tier);
        return this;
    }

    public MetalBuilder setHeat(float heat) {
        this.specificHeat = heat;
        return this;
    }

    public MetalBuilder setMeltTemp(float meltTemp) {
        this.meltTemp = meltTemp;
        return this;
    }

    public void Build() {
        Metal metal = new Metal(this.name, this.tier, this.usable, this.specificHeat, this.meltTemp, this.color, null, null);
        RegistryHandler.addMetalToBuild(metal);
    }
}
