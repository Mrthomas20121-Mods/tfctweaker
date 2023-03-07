# welding

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.tfc.welding;
```


## Implemented Interfaces
welding implements the following interfaces. That means all methods defined in these interfaces are also available in welding

- [IRecipeManager](/vanilla/api/recipe/manager/IRecipeManager)

## Methods

:::group{name=addJsonRecipe}

```zenscript
welding.addJsonRecipe(name as string, mapData as MapData)
```

| Parameter |                 Type                 |
|-----------|--------------------------------------|
| name      | string                               |
| mapData   | [MapData](/vanilla/api/data/MapData) |


:::

:::group{name=addRecipe}

Add a welding recipe

```zenscript
// welding.addRecipe(name as string, input1 as IIngredient, input2 as IIngredient, tier as int, output as ItemStackProvider)

<recipetype:tfc:welding>.addRecipe("welding_test", <item:tfc:metal/ingot/copper>, <item:tfc:metal/double_ingot/copper>, 1, <item:tfc:metal/double_sheet/copper>);
```

| Parameter |                            Type                             |     Description     |
|-----------|-------------------------------------------------------------|---------------------|
| name      | string                                                      | name of the recipe  |
| input1    | [IIngredient](/vanilla/api/ingredient/IIngredient)          | first input         |
| input2    | [IIngredient](/vanilla/api/ingredient/IIngredient)          | second input        |
| tier      | int                                                         | anvil tier required |
| output    | [ItemStackProvider](/mods/TFCTweaker/Api/ItemStackProvider) | output item         |


:::

:::group{name=getAllRecipes}

Return Type: stdlib.List&lt;T&gt;

```zenscript
// welding.getAllRecipes() as stdlib.List<T>

<recipetype:tfc:welding>.getAllRecipes();
```

:::

:::group{name=getRecipeByName}

Return Type: T

```zenscript
welding.getRecipeByName(name as string) as T
```

| Parameter |  Type  |
|-----------|--------|
| name      | string |


:::

:::group{name=getRecipeMap}

Return Type: T[[ResourceLocation](/vanilla/api/resource/ResourceLocation)]

```zenscript
// welding.getRecipeMap() as T[ResourceLocation]

<recipetype:tfc:welding>.getRecipeMap();
```

:::

:::group{name=getRecipesByOutput}

Return Type: stdlib.List&lt;T&gt;

```zenscript
welding.getRecipesByOutput(output as IIngredient) as stdlib.List<T>
```

| Parameter |                        Type                        |
|-----------|----------------------------------------------------|
| output    | [IIngredient](/vanilla/api/ingredient/IIngredient) |


:::

:::group{name=remove}

```zenscript
welding.remove(output as IIngredient)
```

| Parameter |                        Type                        |
|-----------|----------------------------------------------------|
| output    | [IIngredient](/vanilla/api/ingredient/IIngredient) |


:::

:::group{name=removeAll}

```zenscript
// welding.removeAll()

<recipetype:tfc:welding>.removeAll();
```

:::

:::group{name=removeByInput}

```zenscript
welding.removeByInput(input as IItemStack)
```

| Parameter |                    Type                    |
|-----------|--------------------------------------------|
| input     | [IItemStack](/vanilla/api/item/IItemStack) |


:::

:::group{name=removeByModid}

```zenscript
welding.removeByModid(modid as string, exclude as Predicate<string>)
```

| Parameter |          Type           | Optional |           Default Value           |
|-----------|-------------------------|----------|-----------------------------------|
| modid     | string                  | false    |                                   |
| exclude   | Predicate&lt;string&gt; | true     | (name as string) as bool => false |


:::

:::group{name=removeByName}

```zenscript
welding.removeByName(names as string[])
```

| Parameter |   Type   |
|-----------|----------|
| names     | string[] |


:::

:::group{name=removeByRegex}

```zenscript
welding.removeByRegex(regex as string, exclude as Predicate<string>)
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

