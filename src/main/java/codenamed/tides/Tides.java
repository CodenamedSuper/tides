package codenamed.tides;

import codenamed.tides.registry.*;
import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tides implements ModInitializer {
	public  static  final  String MOD_ID = "tides";
    public static final Logger LOGGER = LoggerFactory.getLogger("tides");

	public static final RegistryKey<PlacedFeature> PATCH_URCHIN = registerKey("patch_urchin");


	public static RegistryKey<PlacedFeature> registerKey(String name) {
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Tides.MOD_ID, name));
	}


	@Override
	public void onInitialize() {

		LOGGER.info(MOD_ID);


		TidesBlocks.init();
		TidesItems.init();
		TidesBlockEntityType.init();
		TidesItemGroup.init();
		TidesFeature.init();
		TidesPlacedFeatures.init();
		TidesBiomeKeys.init();
		TidesEntityTypeTags.init();



		BiomePlacement.replaceOverworld(BiomeKeys.BEACH, TidesBiomeKeys.SHORE, 0.2d);

		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.RIVER),
				GenerationStep.Feature.TOP_LAYER_MODIFICATION, TidesPlacedFeatures.DISK_PEBBLESTONE);

		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.LUKEWARM_OCEAN),
				GenerationStep.Feature.VEGETAL_DECORATION, TidesPlacedFeatures.CLAM);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.WARM_OCEAN),
				GenerationStep.Feature.VEGETAL_DECORATION, TidesPlacedFeatures.CLAM);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OCEAN),
				GenerationStep.Feature.VEGETAL_DECORATION, TidesPlacedFeatures.CLAM);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DEEP_COLD_OCEAN),
				GenerationStep.Feature.VEGETAL_DECORATION, TidesPlacedFeatures.CLAM);
		BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.COLD_OCEAN),
				GenerationStep.Feature.VEGETAL_DECORATION, TidesPlacedFeatures.CLAM);

	}
}