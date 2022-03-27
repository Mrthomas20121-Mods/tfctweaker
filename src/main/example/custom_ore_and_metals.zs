#loader preinit

import mods.tfctweaker.Orebuilder;
import mods.tfctweaker.MetalBuilder;

var metal_test = MetalBuilder('something');
metal_test.setUsable(true).setColor(0xFFFFFF).setTier(1).setHeat(1.0).setMeltTemp(0.35).build();

var ore_test = Orebuilder();
ore_test.setName('test').setCanMelt(true).setChunkChance(0.1).setPanChance(0).build();