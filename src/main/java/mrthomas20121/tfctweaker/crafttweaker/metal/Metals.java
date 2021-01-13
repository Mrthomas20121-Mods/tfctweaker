package mrthomas20121.tfctweaker.crafttweaker.metal;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.tfctweaker.early.metal.Metals")
@ModOnly("tfc")
public class Metals {

    @ZenMethod
    public static MetalBuilder addMetal(String name) {
        return new MetalBuilder(name);
    }
}
