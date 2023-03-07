package mrthomas20121.tfctweaker;

import net.minecraft.resources.ResourceLocation;

public class Constants {

    // names for the CrT classes
    public static final String CLASS_BRACKET_DUMPER = "mods.tfc.api.bracket.BracketDumper";
    public static final String CLASS_BRACKET_HANDLER = "mods.tfc.api.bracket.BracketHandler";
    public static final String CLASS_BRACKET_VALIDATOR = "mods.tfc.api.bracket.BracketValidator";
    public static final String CLASS_FLUID_INGREDIENT = "mods.tfc.api.ingredient.FluidIngredient";
    public static final String CLASS_BLOCK_INGREDIENT = "mods.tfc.api.ingredient.BlockIngredient";
    public static final String CLASS_ITEMSTACK_PROVIDER = "mods.tfc.api.ingredient.ItemStackProvider";
    public static final String CLASS_EXPAND_METAL = "mods.tfc.api.Metal";
    public static final String CLASS_EXPAND_CHISEL_MODE = "mods.tfc.api.ChiselMode";
    public static final String CLASS_EXPAND_FORGE_RULES = "mods.tfc.api.ForgeRule";

    // recipes class
    public static final String CLASS_ALLOY = "mods.tfc.AlloyRecipe";
    public static final String CLASS_ALLOY_BUILDER = "mods.tfc.AlloyBuilder";
    public static final String CLASS_ANVIL = "mods.tfc.AnvilRecipe";
    public static final String CLASS_BLAST_FURNACE = "mods.tfc.BlastFurnaceRecipe";
    public static final String CLASS_CHISEL = "mods.tfc.ChiselRecipe";
    public static final String CLASS_CLAY_KNAPPING = "mods.tfc.ClayKnappingRecipe";
    public static final String CLASS_FIRE_CLAY_KNAPPING = "mods.tfc.FireClayKnappingRecipe";
    public static final String CLASS_HEATING = "mods.tfc.HeatingRecipe";
    public static final String CLASS_INSTANT_BARREL = "mods.tfc.InstantBarrelRecipe";
    public static final String CLASS_LEATHER_KNAPPING = "mods.tfc.LeatherKnappingRecipe";
    public static final String CLASS_LOOM = "mods.tfc.LoomRecipe";
    public static final String CLASS_POT = "mods.tfc.PotRecipe";
    public static final String CLASS_QUERN = "mods.tfc.QuernRecipe";
    public static final String CLASS_ROCK_KNAPPING = "mods.tfc.RockKnappingRecipe";
    public static final String CLASS_SEALED_BARREL = "mods.tfc.SealedBarrelRecipe";
    public static final String CLASS_WELDING = "mods.tfc.WeldingRecipe";

    public static final String BRACKET_METAL = "metal";
    public static final String BRACKET_ENUM_CHISEL = "tfc:chisel_mode";
    public static final String BRACKET_ENUM_FORGE_RULES = "tfc:forge_rule";

    public static final String CT_ITEMSTACK_API = "crafttweaker.api.item.IItemStack";

    public static ResourceLocation identifier(String name) {
        return new ResourceLocation(TFCTweaker.mod_id, name);
    }
}
