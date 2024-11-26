package codenamed.tides.registry;

import codenamed.tides.Tides;
import codenamed.tides.worldgen.feature.AnemoneColonyFeature;
import codenamed.tides.worldgen.feature.ClamFeature;
import codenamed.tides.worldgen.feature.MarinalOrganFeature;
import codenamed.tides.worldgen.feature.UrchinColonyFeature;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;

public abstract class TidesFeature<FC extends FeatureConfig> {

    public static final Feature<SimpleBlockFeatureConfig> COLONY_URCHIN = registerFeature("colony_urchin",
            new UrchinColonyFeature(SimpleBlockFeatureConfig.CODEC));
    public static final Feature<SimpleBlockFeatureConfig> COLONY_ANEMONE = registerFeature("colony_anemone",
            new AnemoneColonyFeature(SimpleBlockFeatureConfig.CODEC));
    public static final Feature<SimpleBlockFeatureConfig> ANEMONE = registerFeature("anemone",
            new MarinalOrganFeature(SimpleBlockFeatureConfig.CODEC));
    public static final Feature<SimpleBlockFeatureConfig> URCHIN = registerFeature("urchin",
            new MarinalOrganFeature(SimpleBlockFeatureConfig.CODEC));
    public static final Feature<SimpleBlockFeatureConfig> SPONGE = registerFeature("sponge",
            new MarinalOrganFeature(SimpleBlockFeatureConfig.CODEC));
    public static final Feature<SimpleBlockFeatureConfig> CLAM = registerFeature("clam",
            new ClamFeature(SimpleBlockFeatureConfig.CODEC));


    private static <C extends FeatureConfig, F extends Feature<C>> F registerFeature(String name, F feature) {
        return Registry.register(Registries.FEATURE, Identifier.of(Tides.MOD_ID, name), feature);
    }

    public  static  void  init() { }
}
