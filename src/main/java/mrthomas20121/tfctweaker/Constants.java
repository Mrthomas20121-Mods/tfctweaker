package mrthomas20121.tfctweaker;

import net.minecraft.resources.ResourceLocation;

public class Constants {

    // names for the CrT classes
    public static final String CLASS_BRACKET_DUMPER = "tfc.api.bracket.dumper";
    public static final String CLASS_BRACKET_HANDLER = "tfc.api.bracket.handler";
    public static final String CLASS_BRACKET_VALIDATOR = "tfc.api.bracket.validator";
    public static final String CLASS_FLUID_INGREDIENT = "tfc.api.ingredient.FluidIngredient";
    public static final String CLASS_BLOCK_INGREDIENT = "tfc.api.ingredient.BlockIngredient";
    public static final String CLASS_ITEMSTACK_PROVIDER = "tfc.api.ingredient.ItemStackProvider";
    public static final String CLASS_EXPAND_METAL = "tfc.api.metal";
    public static final String CLASS_EXPAND_CHISEL_MODE = "tfc.api.ChiselMode";
    public static final String CLASS_EXPAND_FORGE_RULES = "tfc.api.ForgeRule";

    // recipes class
    public static final String CLASS_ROCK_KNAPPING = "mods.tfc.rock_knapping";
    public static final String CLASS_SEALED_BARREL = "mods.tfc.sealed_barrel";
    public static final String CLASS_WELDING = "mods.tfc.welding";

    public static final String BRACKET_METAL = "metal";
    public static final String BRACKET_ENUM_CHISEL = "tfc:chisel_mode";
    public static final String BRACKET_ENUM_FORGE_RULES = "tfc:forge_rule";

    public static ResourceLocation identifier(String name) {
        return new ResourceLocation(TFCTweaker.mod_id, name);
    }
}
