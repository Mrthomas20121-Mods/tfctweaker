package mrthomas20121.tfctweaker.api;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.dries007.tfc.common.capabilities.food.FoodTrait;
import net.dries007.tfc.common.recipes.outputs.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.openzen.zencode.java.ZenCodeType;

@Document("mods/TFCTweaker/Api/TFCModifier")
@ZenRegister()
@ZenCodeType.Name("mods.tfc.api.ItemStackProvider")
public class TFCItemStackProvider {

    private final ItemStackProvider output;

    public ItemStackProvider get() {
        return this.output;
    }

    private static TFCItemStackProvider of(ItemStackProvider provider) {
        return new TFCItemStackProvider(provider);
    }

    public TFCItemStackProvider() {
        this(ItemStackProvider.empty());
    }

    public TFCItemStackProvider(ItemStackProvider provider) {
        this.output = provider;
    }

    /**
     * Empty Output
     * @return TFCModifier
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider empty() {
        return new TFCItemStackProvider();
    }

    /**
     * Create an ItemstackProvider with no Modifier.
     * @param output item output
     * @return TFCModifier
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
     * @return
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider copyOldestFood(IItemStack output) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{CopyOldestFoodModifier.INSTANCE}));
    }

    /**
     * Copy the input forging bonus.
     * @param output
     * @return
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider copyForgingBonus(IItemStack output) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{CopyForgingBonusModifier.INSTANCE}));
    }

    /**
     * Reset the input input food data.
     * @return
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider resetFood() {
        return TFCItemStackProvider.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{ResetFoodModifier.INSTANCE}));
    }

    /**
     * Reset the output Food data
     * @param output the output item
     * @return
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider resetFood(IItemStack output) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{ResetFoodModifier.INSTANCE}));
    }

    /**
     * Add heat to the output
     * @param output
     * @param heat
     * @return
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider addHeat(IItemStack output, float heat) {
        return TFCItemStackProvider.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{new AddHeatModifier(heat)}));
    }

    /**
     * Add Heat to the input
     * @param heat
     * @return
     */
    @ZenCodeType.Method
    public static TFCItemStackProvider addHeat(float heat) {
        return TFCItemStackProvider.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{new AddHeatModifier(heat)}));
    }
}
