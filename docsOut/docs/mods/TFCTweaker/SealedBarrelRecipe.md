# barrel_sealed

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.tfc.barrel_sealed;
```


## Implemented Interfaces
barrel_sealed implements the following interfaces. That means all methods defined in these interfaces are also available in barrel_sealed

- [IRecipeManager](/vanilla/api/recipe/manager/IRecipeManager)

## Methods

:::group{name=addJsonRecipe}

```zenscript
barrel_sealed.addJsonRecipe(name as string, mapData as MapData)
```

| Parameter |                 Type                 |
|-----------|--------------------------------------|
| name      | string                               |
| mapData   | [MapData](/vanilla/api/data/MapData) |


:::

:::group{name=addRecipe}

Add an instant barrel recipe

```zenscript
barrel_sealed.addRecipe(name as string, duration as int, input as invalid, fluidIngredient as invalid, output as invalid, outputFluid as IFluidStack, event as SoundEvent, onSeal as invalid, onUnseal as invalid)
```

|    Parameter    |                    Type                     |                           Description                            |
|-----------------|---------------------------------------------|------------------------------------------------------------------|
| name            | string                                      | name of the recipe                                               |
| duration        | int                                         | how long until the recipe is done(in hours)                      |
| input           | **invalid**                                 | item input                                                       |
| fluidIngredient | **invalid**                                 | fluid input, can be empty                                        |
| output          | **invalid**                                 | item output                                                      |
| outputFluid     | [IFluidStack](/forge/api/fluid/IFluidStack) | fluid ouput                                                      |
| event           | [SoundEvent](/vanilla/api/sound/SoundEvent) | the sound to play when it is done, default to BREWING_STAND_BREW |
| onSeal          | **invalid**                                 | Call this on seal                                                |
| onUnseal        | **invalid**                                 | Call this on unseal                                              |


:::

:::group{name=getAllRecipes}

Return Type: stdlib.List&lt;T&gt;

```zenscript
// barrel_sealed.getAllRecipes() as stdlib.List<T>

<recipetype:tfc:barrel_sealed>.getAllRecipes();
```

:::

:::group{name=getRecipeByName}

Return Type: T

```zenscript
barrel_sealed.getRecipeByName(name as string) as T
```

| Parameter |  Type  |
|-----------|--------|
| name      | string |


:::

:::group{name=getRecipeMap}

Return Type: T[[ResourceLocation](/vanilla/api/resource/ResourceLocation)]

```zenscript
// barrel_sealed.getRecipeMap() as T[ResourceLocation]

<recipetype:tfc:barrel_sealed>.getRecipeMap();
```

:::

:::group{name=getRecipesByOutput}

Return Type: stdlib.List&lt;T&gt;

```zenscript
barrel_sealed.getRecipesByOutput(output as IIngredient) as stdlib.List<T>
```

| Parameter |                        Type                        |
|-----------|----------------------------------------------------|
| output    | [IIngredient](/vanilla/api/ingredient/IIngredient) |


:::

:::group{name=remove}

```zenscript
barrel_sealed.remove(output as IIngredient)
```

| Parameter |                        Type                        |
|-----------|----------------------------------------------------|
| output    | [IIngredient](/vanilla/api/ingredient/IIngredient) |


:::

:::group{name=removeAll}

```zenscript
// barrel_sealed.removeAll()

<recipetype:tfc:barrel_sealed>.removeAll();
```

:::

:::group{name=removeByInput}

```zenscript
barrel_sealed.removeByInput(input as IItemStack)
```

| Parameter |                    Type                    |
|-----------|--------------------------------------------|
| input     | [IItemStack](/vanilla/api/item/IItemStack) |


:::

:::group{name=removeByModid}

```zenscript
barrel_sealed.removeByModid(modid as string, exclude as Predicate<string>)
```

| Parameter |          Type           | Optional |           Default Value           |
|-----------|-------------------------|----------|-----------------------------------|
| modid     | string                  | false    |                                   |
| exclude   | Predicate&lt;string&gt; | true     | (name as string) as bool => false |


:::

:::group{name=removeByName}

```zenscript
barrel_sealed.removeByName(names as string[])
```

| Parameter |   Type   |
|-----------|----------|
| names     | string[] |


:::

:::group{name=removeByRegex}

```zenscript
barrel_sealed.removeByRegex(regex as string, exclude as Predicate<string>)
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

