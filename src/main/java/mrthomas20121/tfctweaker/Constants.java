package mrthomas20121.tfctweaker;

import net.minecraft.resources.ResourceLocation;

public class Constants {

    // names for the CrT classes
    public static final String CLASS_BRACKET_DUMPER = "tfc.api.bracket.Dumper";
    public static final String CLASS_BRACKET_HANDLER = "tfc.api.bracket.Handler";
    public static final String CLASS_BRACKET_VALIDATOR = "tfc.api.bracket.Validator";
    public static final String CLASS_FLUID_INGREDIENT = "tfc.api.ingredient.FluidIngredient";
    public static final String CLASS_BLOCK_INGREDIENT = "tfc.api.ingredient.BlockIngredient";
    public static final String CLASS_ITEMSTACK_PROVIDER = "tfc.api.ingredient.ItemStackProvider";
    public static final String CLASS_EXPAND_METAL = "tfc.api.Metal";
    public static final String CLASS_EXPAND_CHISEL_MODE = "tfc.api.ChiselMode";
    public static final String CLASS_EXPAND_FORGE_RULES = "tfc.api.ForgeRule";

    // recipes class
    public static final String CLASS_ALLOY = "mods.tfc.Alloy";
    public static final String CLASS_ALLOY_BUILDER = "mods.tfc.AlloyBuilder";
    public static final String CLASS_ANVIL = "mods.tfc.Anvil";
    public static final String CLASS_BLAST_FURNACE = "mods.tfc.BlastFurnace";
    public static final String CLASS_CHISEL = "mods.tfc.Chisel";
    public static final String CLASS_CLAY_KNAPPING = "mods.tfc.ClayKnapping";
    public static final String CLASS_FIRE_CLAY_KNAPPING = "mods.tfc.FireClayKnapping";
    public static final String CLASS_HEATING = "mods.tfc.Heating";
    public static final String CLASS_INSTANT_BARREL = "mods.tfc.InstantBarrel";
    public static final String CLASS_LEATHER_KNAPPING = "mods.tfc.LeatherKnapping";
    public static final String CLASS_LOOM = "mods.tfc.Loom";
    public static final String CLASS_POT = "mods.tfc.Pot";
    public static final String CLASS_QUERN = "mods.tfc.Quern";
    public static final String CLASS_ROCK_KNAPPING = "mods.tfc.RockKnapping";
    public static final String CLASS_SEALED_BARREL = "mods.tfc.SealedBarrel";
    public static final String CLASS_WELDING = "mods.tfc.Welding";

    public static final String BRACKET_METAL = "metal";
    public static final String BRACKET_ENUM_CHISEL = "tfc:chisel_mode";
    public static final String BRACKET_ENUM_FORGE_RULES = "tfc:forge_rule";

    public static final String CT_ITEMSTACK_API = "crafttweaker.api.item.IItemStack";

    public static ResourceLocation identifier(String name) {
        return new ResourceLocation(TFCTweaker.mod_id, name);
    }
}
