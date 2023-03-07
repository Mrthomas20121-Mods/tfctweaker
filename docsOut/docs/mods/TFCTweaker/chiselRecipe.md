# chisel

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.tfc.chisel;
```


## Implemented Interfaces
chisel implements the following interfaces. That means all methods defined in these interfaces are also available in chisel

- [IRecipeManager](/vanilla/api/recipe/manager/IRecipeManager)

## Methods

:::group{name=addJsonRecipe}

```zenscript
chisel.addJsonRecipe(name as string, mapData as MapData)
```

| Parameter |                 Type                 |
|-----------|--------------------------------------|
| name      | string                               |
| mapData   | [MapData](/vanilla/api/data/MapData) |


:::

:::group{name=addRecipe}

Add a chisel recipe to convert a block to another when using a chisel and hammer in the offhand

```zenscript
chisel.addRecipe(name as string, input as BlockIngredient, output as Block, mode as ChiselMode, extraDrop as ItemStackProvider, itemIngredient as IIngredient)
```

|   Parameter    |                            Type                             |                          Description                          | Optional |
|----------------|-------------------------------------------------------------|---------------------------------------------------------------|----------|
| name           | string                                                      | the name of the recipe                                        | false    |
| input          | [BlockIngredient](/mods/TFCTweaker/api/BlockIngredient)     | block/tag of blocks                                           | false    |
| output         | [Block](/vanilla/api/block/Block)                           | the output item                                               | false    |
| mode           | [ChiselMode](/mods/TFCTweaker/recipe/ChiselMode)            | the mode used for the recipe(smooth/stair/slab)               | false    |
| extraDrop      | [ItemStackProvider](/mods/TFCTweaker/Api/ItemStackProvider) | extra blocks/items dropped from the block after the operation | false    |
| itemIngredient | [IIngredient](/vanilla/api/ingredient/IIngredient)          | ingredient                                                    | true     |


:::

:::group{name=getAllRecipes}

Return Type: stdlib.List&lt;T&gt;

```zenscript
// chisel.getAllRecipes() as stdlib.List<T>

<recipetype:tfc:chisel>.getAllRecipes();
```

:::

:::group{name=getRecipeByName}

Return Type: T

```zenscript
chisel.getRecipeByName(name as string) as T
```

| Parameter |  Type  |
|-----------|--------|
| name      | string |


:::

:::group{name=getRecipeMap}

Return Type: T[[ResourceLocation](/vanilla/api/resource/ResourceLocation)]

```zenscript
// chisel.getRecipeMap() as T[ResourceLocation]

<recipetype:tfc:chisel>.getRecipeMap();
```

:::

:::group{name=getRecipesByOutput}

Return Type: stdlib.List&lt;T&gt;

```zenscript
chisel.getRecipesByOutput(output as IIngredient) as stdlib.List<T>
```

| Parameter |                        Type                        |
|-----------|----------------------------------------------------|
| output    | [IIngredient](/vanilla/api/ingredient/IIngredient) |


:::

:::group{name=remove}

```zenscript
chisel.remove(output as IIngredient)
```

| Parameter |                        Type                        |
|-----------|----------------------------------------------------|
| output    | [IIngredient](/vanilla/api/ingredient/IIngredient) |


:::

:::group{name=removeAll}

```zenscript
// chisel.removeAll()

<recipetype:tfc:chisel>.removeAll();
```

:::

:::group{name=removeByInput}

```zenscript
chisel.removeByInput(input as IItemStack)
```

| Parameter |                    Type                    |
|-----------|--------------------------------------------|
| input     | [IItemStack](/vanilla/api/item/IItemStack) |


:::

:::group{name=removeByModid}

```zenscript
chisel.removeByModid(modid as string, exclude as Predicate<string>)
```

| Parameter |          Type           | Optional |           Default Value           |
|-----------|-------------------------|----------|-----------------------------------|
| modid     | string                  | false    |                                   |
| exclude   | Predicate&lt;string&gt; | true     | (name as string) as bool => false |


:::

:::group{name=removeByName}

```zenscript
chisel.removeByName(names as string[])
```

| Parameter |   Type   |
|-----------|----------|
| names     | string[] |


:::

:::group{name=removeByRegex}

```zenscript
chisel.removeByRegex(regex as string, exclude as Predicate<string>)
```

| Parameter |          Type           | Optional |           Default Value           |
|-----------|-------------------------|----------|-----------------------------------|
| regex     | string                  | false    |                                   |
| exclude   | Predicate&lt;string&gt; | true     | (name as string) as bool => false |


:::


## Properties

|    Name    |                             Type                              | Has Getter | Has Setter |
|------------|---------------------------------------------------------------|------------|------------|
| allRecipes | stdlib.List&lt;T&gt;                                          | true       | false      |
| recipeMap  | T[[ResourceLocation](/vanilla/api/resource/ResourceLocation)] | true       | false      |

