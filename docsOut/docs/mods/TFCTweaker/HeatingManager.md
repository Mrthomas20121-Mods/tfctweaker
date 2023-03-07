# heating

TFC Heating Recipes

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.tfc.heating;
```


## Implemented Interfaces
heating implements the following interfaces. That means all methods defined in these interfaces are also available in heating

- [IRecipeManager](/vanilla/api/recipe/manager/IRecipeManager)

## Methods

:::group{name=addJsonRecipe}

```zenscript
heating.addJsonRecipe(name as string, mapData as MapData)
```

| Parameter |                 Type                 |
|-----------|--------------------------------------|
| name      | string                               |
| mapData   | [MapData](/vanilla/api/data/MapData) |


:::

:::group{name=addRecipe}

add a heating recipe

```zenscript
// heating.addRecipe(name as string, input as IIngredient, output as IItemStack, outputFluid as IFluidStack, temp as float, useDurability as boolean)

<recipetype:tfc:heating>.addRecipe("heating_test2", <item:tfc:metal/ingot/copper>, ItemStackProvider.empty(), <fluid:tfc:metal/copper>*100, 500, false);
```

|   Parameter   |                        Type                        |                                        Description                                        | Optional | Default Value |
|---------------|----------------------------------------------------|-------------------------------------------------------------------------------------------|----------|---------------|
| name          | string                                             | name of the recipe                                                                        | false    |               |
| input         | [IIngredient](/vanilla/api/ingredient/IIngredient) | input item                                                                                | false    |               |
| output        | [IItemStack](/vanilla/api/item/IItemStack)         | output item(can be null)                                                                  | false    |               |
| outputFluid   | [IFluidStack](/forge/api/fluid/IFluidStack)        | output fluid                                                                              | false    |               |
| temp          | float                                              | temp when the input become the output                                                     | false    |               |
| useDurability | boolean                                            | tell if the recipe should use the item durability(if it has durability, default to false) | true     | false         |


:::

:::group{name=addRecipe}

add a heating recipe

```zenscript
// heating.addRecipe(name as string, input as IIngredient, output as ItemStackProvider, outputFluid as IFluidStack, temp as float, useDurability as boolean)

<recipetype:tfc:heating>.addRecipe("heating_test", <item:tfc:metal/ingot/copper>, ItemStackProvider.empty(), <fluid:tfc:metal/copper>*100, 500, false);
```

|   Parameter   |                            Type                             |                                        Description                                        | Optional | Default Value |
|---------------|-------------------------------------------------------------|-------------------------------------------------------------------------------------------|----------|---------------|
| name          | string                                                      | name of the recipe                                                                        | false    |               |
| input         | [IIngredient](/vanilla/api/ingredient/IIngredient)          | input item                                                                                | false    |               |
| output        | [ItemStackProvider](/mods/TFCTweaker/Api/ItemStackProvider) | output item(can be null)                                                                  | false    |               |
| outputFluid   | [IFluidStack](/forge/api/fluid/IFluidStack)                 | output fluid                                                                              | false    |               |
| temp          | float                                                       | temp when the input become the output                                                     | false    |               |
| useDurability | boolean                                                     | tell if the recipe should use the item durability(if it has durability, default to false) | true     | false         |


:::

:::group{name=addRecipe}

add a heating recipe

```zenscript
// heating.addRecipe(name as string, input as IIngredient, output as ItemStackProvider, outputMetal as metal, amount as int, temp as float, useDurability as boolean)

<recipetype:tfc:heating>.addRecipe("heating_test", <item:tfc:metal/ingot/copper>, ItemStackProvider.empty(), <metal:tfc:copper>, 100, 500, false);
```

|   Parameter   |                            Type                             |                                        Description                                        | Optional | Default Value |
|---------------|-------------------------------------------------------------|-------------------------------------------------------------------------------------------|----------|---------------|
| name          | string                                                      | name of the recipe                                                                        | false    |               |
| input         | [IIngredient](/vanilla/api/ingredient/IIngredient)          | input item                                                                                | false    |               |
| output        | [ItemStackProvider](/mods/TFCTweaker/Api/ItemStackProvider) | output item(can be null)                                                                  | false    |               |
| outputMetal   | [metal](/mods/TFCTweaker/api/Metal)                         | output metal                                                                              | false    |               |
| amount        | int                                                         | amount of metal                                                                           | false    |               |
| temp          | float                                                       | temp when the input become the output                                                     | false    |               |
| useDurability | boolean                                                     | tell if the recipe should use the item durability(if it has durability, default to false) | true     | false         |


:::

:::group{name=getAllRecipes}

Return Type: stdlib.List&lt;T&gt;

```zenscript
// heating.getAllRecipes() as stdlib.List<T>

<recipetype:tfc:heating>.getAllRecipes();
```

:::

:::group{name=getRecipeByName}

Return Type: T

```zenscript
heating.getRecipeByName(name as string) as T
```

| Parameter |  Type  |
|-----------|--------|
| name      | string |


:::

:::group{name=getRecipeMap}

Return Type: T[[ResourceLocation](/vanilla/api/resource/ResourceLocation)]

```zenscript
// heating.getRecipeMap() as T[ResourceLocation]

<recipetype:tfc:heating>.getRecipeMap();
```

:::

:::group{name=getRecipesByOutput}

Return Type: stdlib.List&lt;T&gt;

```zenscript
heating.getRecipesByOutput(output as IIngredient) as stdlib.List<T>
```

| Parameter |                        Type                        |
|-----------|----------------------------------------------------|
| output    | [IIngredient](/vanilla/api/ingredient/IIngredient) |


:::

:::group{name=remove}

```zenscript
heating.remove(output as IIngredient)
```

| Parameter |                        Type                        |
|-----------|----------------------------------------------------|
| output    | [IIngredient](/vanilla/api/ingredient/IIngredient) |


:::

:::group{name=removeAll}

```zenscript
// heating.removeAll()

<recipetype:tfc:heating>.removeAll();
```

:::

:::group{name=removeByInput}

```zenscript
heating.removeByInput(input as IItemStack)
```

| Parameter |                    Type                    |
|-----------|--------------------------------------------|
| input     | [IItemStack](/vanilla/api/item/IItemStack) |


:::

:::group{name=removeByModid}

```zenscript
heating.removeByModid(modid as string, exclude as Predicate<string>)
```

| Parameter |          Type           | Optional |           Default Value           |
|-----------|-------------------------|----------|-----------------------------------|
| modid     | string                  | false    |                                   |
| exclude   | Predicate&lt;string&gt; | true     | (name as string) as bool => false |


:::

:::group{name=removeByName}

```zenscript
heating.removeByName(names as string[])
```

| Parameter |   Type   |
|-----------|----------|
| names     | string[] |


:::

:::group{name=removeByRegex}

```zenscript
heating.removeByRegex(regex as string, exclude as Predicate<string>)
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

