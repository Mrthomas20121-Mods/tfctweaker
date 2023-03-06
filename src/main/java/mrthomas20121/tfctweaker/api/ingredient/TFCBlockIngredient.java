package mrthomas20121.tfctweaker.api.ingredient;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.tag.type.KnownTag;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.common.recipes.ingredients.BlockIngredient;
import net.dries007.tfc.common.recipes.ingredients.BlockIngredients;
import net.minecraft.world.level.block.Block;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name(Constants.CLASS_BLOCK_INGREDIENT)
@Document("mods/TFCTweaker/api/BlockIngredient")
public class TFCBlockIngredient {

    private final BlockIngredient internal;

    public TFCBlockIngredient(BlockIngredient ingredient) {
        this.internal = ingredient;
    }

    @ZenCodeType.Method
    public static TFCBlockIngredient of(Block block) {
        return new TFCBlockIngredient(BlockIngredients.of(block));
    }

    @ZenCodeType.Method
    public static TFCBlockIngredient of(Block[] blocks) {
        return new TFCBlockIngredient(BlockIngredients.of(blocks));
    }

    @ZenCodeType.Method
    public static TFCBlockIngredient of(KnownTag<Block> tag) {
        return new TFCBlockIngredient(BlockIngredients.of(tag.getTagKey()));
    }

    public BlockIngredient getInternal() {
        return internal;
    }
}