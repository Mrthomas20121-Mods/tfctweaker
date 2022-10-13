package mrthomas20121.tfctweaker.api;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.dries007.tfc.common.capabilities.food.FoodTrait;
import net.dries007.tfc.common.recipes.outputs.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.openzen.zencode.java.ZenCodeType;

@Document("mods/tfctweaker/api/TFCModifier")
@ZenRegister()
@ZenCodeType.Name("mods.tfc.api.TFCModifier")
public class TFCModifier {

    private ItemStackProvider output = ItemStackProvider.empty();

    public TFCModifier setOutput(ItemStackProvider output) {
        this.output = output;
        return this;
    }

    public ItemStackProvider get() {
        return this.output;
    }

    private static TFCModifier of(ItemStackProvider provider) {
        return new TFCModifier().setOutput(provider);
    }

    /**
     * Empty Output
     * @return TFCModifier
     */
    @ZenCodeType.Method
    public static TFCModifier empty() {
        return new TFCModifier();
    }

    /**
     * Create an ItemstackProvider with no Modifier.
     * @param output item output
     * @return TFCModifier
     */
    @ZenCodeType.Method
    public static TFCModifier none(IItemStack output) {
        return TFCModifier.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[0]));
    }

    @ZenCodeType.Method
    public static TFCModifier addRemoveTrait(String trait, boolean add) {
        return TFCModifier.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{CopyInputModifier.INSTANCE, new AddRemoveTraitModifier(add, FoodTrait.getTrait(new ResourceLocation(trait)))}));
    }

    @ZenCodeType.Method
    public static TFCModifier copyFood(IItemStack output) {
        return TFCModifier.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{CopyFoodModifier.INSTANCE}));
    }

    @ZenCodeType.Method
    public static TFCModifier copyHeat(IItemStack output) {
        return TFCModifier.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{CopyFoodModifier.INSTANCE}));
    }

    @ZenCodeType.Method
    public static TFCModifier copyHeat() {
        return TFCModifier.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{CopyFoodModifier.INSTANCE}));
    }

    @ZenCodeType.Method
    public static TFCModifier copyInput() {
        return TFCModifier.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{CopyInputModifier.INSTANCE}));
    }

    @ZenCodeType.Method
    public static TFCModifier copyOldestFood(IItemStack output) {
        return TFCModifier.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{CopyOldestFoodModifier.INSTANCE}));
    }

    @ZenCodeType.Method
    public static TFCModifier copyForgingBonus(IItemStack output) {
        return TFCModifier.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{CopyForgingBonusModifier.INSTANCE}));
    }

    /**
     * Reset the input input food data.
     * @return
     */
    @ZenCodeType.Method
    public static TFCModifier resetFood() {
        return TFCModifier.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{ResetFoodModifier.INSTANCE}));
    }

    /**
     * Reset the output Food data
     * @param output the output item
     * @return
     */
    @ZenCodeType.Method
    public static TFCModifier resetFood(IItemStack output) {
        return TFCModifier.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{ResetFoodModifier.INSTANCE}));
    }

    /**
     * Add heat to the output
     * @param output
     * @param heat
     * @return
     */
    @ZenCodeType.Method
    public static TFCModifier addHeat(IItemStack output, float heat) {
        return TFCModifier.of(new ItemStackProvider(output.getInternal(), new ItemStackModifier[]{new AddHeatModifier(heat)}));
    }

    /**
     * Add Heat to the input
     * @param heat
     * @return
     */
    @ZenCodeType.Method
    public static TFCModifier addHeat(float heat) {
        return TFCModifier.of(new ItemStackProvider(ItemStack.EMPTY, new ItemStackModifier[]{new AddHeatModifier(heat)}));
    }
}
