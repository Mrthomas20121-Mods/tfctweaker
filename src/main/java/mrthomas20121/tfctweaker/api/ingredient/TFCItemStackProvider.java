package mrthomas20121.tfctweaker.api.ingredient;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.common.capabilities.food.FoodTrait;
import net.dries007.tfc.common.recipes.outputs.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.openzen.zencode.java.ZenCodeType;

@Document("mods/TFCTweaker/Api/ItemStackProvider")
@ZenRegister()
@ZenCodeType.Name(Constants.CLASS_ITEMSTACK_PROVIDER)
public class TFCItemStackProvider {

    private final ItemStackProvider output;

    public ItemStackProvider getInternal() {
        return this.output;
    }

    private static TFCItemStackProvider of(ItemStackProvider provider) {
        return new TFCItemStackProvider(provider);
    }

    @ZenCodeType.Constructor
    public TFCItemStackProvider() {
        this(ItemStackProvider.empty());
    }

    public TFCItemStackProvider(ItemStackProvider provider) {
        this.output = provider;
    }

    /**
     * Empty Output
     * @return TFCItemStackProvider
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider empty() {
        return new TFCItemStackProvider();
    }

    /**
     * Create an ItemStackProvider with no Modifier.
     * @param output item output
     * @return TFCItemStackProvider
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider none(IItemStack output) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[0]));
    }

    @ZenCodeType.Method
    public static TFCItemStackProvider addRemoveTrait(String trait, boolean add) {
        return TFCItemStackProvider.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{CopyInputModifier.INSTANCE, new AddRemoveTraitModifier(add, FoodTrait.getTrait(new ResourceLocation(trait)))}));
    }

    @ZenCodeType.Method
    public static TFCItemStackProvider copyFood(IItemStack output) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{CopyFoodModifier.INSTANCE}));
    }

    @ZenCodeType.Method
    public static TFCItemStackProvider copyHeat(IItemStack output) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{CopyHeatModifier.INSTANCE}));
    }

    @ZenCodeType.Method
    public static TFCItemStackProvider copyHeat() {
        return TFCItemStackProvider.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{CopyHeatModifier.INSTANCE}));
    }

    @ZenCodeType.Method
    public static TFCItemStackProvider copyInput() {
        return TFCItemStackProvider.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{CopyInputModifier.INSTANCE}));
    }

    /**
     * Copy the oldest food from the input and add it to the output item
     * @param output
     * @return TFCItemStackProvider
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider copyOldestFood(IItemStack output) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{CopyOldestFoodModifier.INSTANCE}));
    }

    /**
     * Copy the input forging bonus.
     * @param output
     * @return TFCItemStackProvider
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider copyForgingBonus(IItemStack output) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{CopyForgingBonusModifier.INSTANCE}));
    }

    /**
     * Reset the input food data.
     * @return TFCItemStackProvider
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider resetFood() {
        return TFCItemStackProvider.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{ResetFoodModifier.INSTANCE}));
    }

    /**
     * Reset the output Food data
     * @param output the output item
     * @return TFCItemStackProvider
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider resetFood(IItemStack output) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{ResetFoodModifier.INSTANCE}));
    }

    /**
     * Add heat to the output
     * @param output heat item
     * @param heat
     * @return TFCItemStackProvider
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider addOutputHeat(IItemStack output, float heat) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{new AddHeatModifier(heat)}));
    }

    /**
     * Add Heat to the input
     * @param heat
     * @return TFCItemStackProvider
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider addInputHeat(float heat) {
        return TFCItemStackProvider.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{new AddHeatModifier(heat)}));
    }
}
