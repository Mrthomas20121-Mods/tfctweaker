package mrthomas20121.tfctweaker.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.dries007.tfc.common.recipes.AlloyRecipe;
import net.dries007.tfc.common.recipes.TFCRecipeTypes;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.Metal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @docParam this <recipetype:tfc:alloy>
 */
@ZenRegister
@ZenCodeType.Name("mods.tfc.alloy")
@Document("mods/TFCTweaker/AlloyManager")
public class AlloyManager implements IRecipeManager<AlloyRecipe> {

    @Override
    public RecipeType<AlloyRecipe> getRecipeType() {
        return TFCRecipeTypes.ALLOY.get();
    }

    /**
     * Add an alloy recipe
     * @param name recipe name
     * @param consumer builder
     *
     * @docParam name "alloy_test"
     * @docParam consumer (alloy) => {
     *    alloy.add("tfc:tin", 0.08, 0.12);
     *    alloy.add("tfc:copper", 0.88, 0.92);
     *    alloy.output("tfc:bronze");
     *    // can also do it this way
     *    // alloy.add(<metal:tfc:tin>, 0.08, 0.12);
     *    // alloy.add(<metal:tfc:copper>, 0.88, 0.92);
     *    // alloy.output(<metal:tfc:bronze>);
     * }
     */
    @ZenCodeType.Method
    public void addRecipe(String name, Consumer<Builder> consumer) {
        Builder builder = new Builder();
        consumer.accept(builder);
        addRecipe(Helpers.identifier(name), builder.getMetals(), builder.getOutput());
    }

    public void addRecipe(ResourceLocation name, Supplier<Map<Metal, AlloyRecipe.Range>> metals, Supplier<Metal> outputMetal) {
        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, new AlloyRecipe(name, metals, outputMetal)));
    }

    @ZenRegister
    @ZenCodeType.Name("mods.tfc.alloy_builder")
    @Document("mods/TFCTweaker/AlloyBuilder")
    public static class Builder {
        private final Map<Metal, AlloyRecipe.Range> metals = new HashMap<>();

        private Supplier<Metal> output;

        /**
         * add a metal to the alloy
         * @param metalName name of the metal
         * @param min min amount
         * @param max max amount
         *
         * @docParam metalName "tfc:copper"
         * @docParam min 0.88
         * @docParam max 0.92
         */
        @ZenCodeType.Method
        public void add(String metalName, double min, double max) {
            Metal metal = Metal.MANAGER.get(new ResourceLocation(metalName));
            AlloyRecipe.Range range = new AlloyRecipe.Range(min, max);
            metals.put(metal, range);
        }

        /**
         * add a metal to the alloy
         * @param metal metal
         * @param min min amount
         * @param max max amount
         *
         * @docParam metal <metal:tfc:copper>
         * @docParam min 0.88
         * @docParam max 0.92
         */
        @ZenCodeType.Method
        public void add(Metal metal, double min, double max) {
            AlloyRecipe.Range range = new AlloyRecipe.Range(min, max);
            metals.put(metal, range);
        }

        /**
         * Add a metal as output
         * @param name name of the metal
         *
         * @docParam name "bronze"
         */
        @ZenCodeType.Method
        public void output(String name) {
            this.output = () -> Metal.MANAGER.get(new ResourceLocation(name));
        }

        /**
         * Add a metal as output
         * @param metal metal
         *
         * @docParam metal <metal:tfc:bronze>
         */
        @ZenCodeType.Method
        public void output(Metal metal) {
            this.output = () -> metal;
        }


        public Supplier<Map<Metal, AlloyRecipe.Range>> getMetals() {
            return () -> metals;
        }

        public Supplier<Metal> getOutput() {
            return output;
        }
    }
}
