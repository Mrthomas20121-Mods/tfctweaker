package mrthomas20121.tfctweaker.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import mrthomas20121.tfctweaker.RegistryHandler;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Ore;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.StringUtils;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenConstructor;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.tfctweaker.Orebuilder")
@ZenRegister
public class OreBuilder {

    private ResourceLocation name;
    private ResourceLocation metal_name;
    private boolean canMelt;
    private double chunkChance = 00D;
    private double panChance = 00D;

    @ZenConstructor
    public OreBuilder() {}

    @ZenMethod
    public OreBuilder setName(String name) {
        this.name = new ResourceLocation("tfc", name);
        return this;
    }

    @ZenMethod
    public OreBuilder setMetal(String name) {
        this.metal_name = new ResourceLocation("tfc", name);
        return this;
    }

    @ZenMethod
    public OreBuilder setCanMelt(boolean canMelt) {
        this.canMelt = canMelt;
        return this;
    }

    @ZenMethod
    public OreBuilder setChunkChance(double chunkChance) {
        this.chunkChance = chunkChance;
        return this;
    }

    @ZenMethod
    public OreBuilder setPanChance(double panChance) {
        this.panChance = panChance;
        return this;
    }

    @ZenMethod
    public void build() {
        TFCRegistries.ORES.register(new Ore(this.name, this.metal_name, this.canMelt, this.chunkChance, this.panChance));
        CraftTweakerAPI.logInfo("Registered ore with name"+ StringUtils.capitalize(this.name.getPath()));
    }
}
