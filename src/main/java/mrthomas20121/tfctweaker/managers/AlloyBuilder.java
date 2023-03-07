package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import mrthomas20121.tfctweaker.Constants;
import net.dries007.tfc.common.recipes.AlloyRecipe;
import net.dries007.tfc.util.Metal;
import net.minecraft.resources.ResourceLocation;
import org.openzen.zencode.java.ZenCodeType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@ZenRegister
@ZenCodeType.Name(Constants.CLASS_ALLOY_BUILDER)
@Document("mods/TFCTweaker/AlloyBuilder")
class AlloyBuilder {
    private final Map<Metal, AlloyRecipe.Range> metals = new HashMap<Metal, AlloyRecipe.Range>();

    private Supplier<Metal> output;

    /**
     * add a metal to the alloy
     *
     * @param metalName name of the metal
     * @param min       min amount
     * @param max       max amount
     * @docParam metalName "tfc:copper"
     * @docParam min 0.88
     * @docParam max 0.92
     */
    @ZenCodeType.Method
    public void Add(String metalName, double min, double max) {
        Metal metal = Metal.MANAGER.get(new ResourceLocation(metalName));
        AlloyRecipe.Range range = new AlloyRecipe.Range(min, max);
        metals.put(metal, range);
    }

    /**
     * add a metal to the alloy
     *
     * @param metal metal
     * @param min   min amount
     * @param max   max amount
     * @docParam metal <metal:tfc:copper>
     * @docParam min 0.88
     * @docParam max 0.92
     */
    @ZenCodeType.Method
    public void Add(Metal metal, double min, double max) {
        AlloyRecipe.Range range = new AlloyRecipe.Range(min, max);
        metals.put(metal, range);
    }

    /**
     * Add a metal as output
     *
     * @param name name of the metal
     * @docParam name "bronze"
     */
    @ZenCodeType.Method
    public void Output(String name) {
        this.output = () -> Metal.MANAGER.get(new ResourceLocation(name));
    }

    /**
     * Add a metal as output
     *
     * @param metal metal
     * @docParam metal <metal:tfc:bronze>
     */
    @ZenCodeType.Method
    public void Output(Metal metal) {
        this.output = () -> metal;
    }


    public Supplier<Map<Metal, AlloyRecipe.Range>> getMetals() {
        return () -> metals;
    }

    public Supplier<Metal> getOutput() {
        return output;
    }
}
