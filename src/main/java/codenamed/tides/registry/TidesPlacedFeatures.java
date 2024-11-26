package codenamed.tides.registry;

import codenamed.tides.Tides;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

public class TidesPlacedFeatures {

    public static final RegistryKey<PlacedFeature> COLONY_URCHIN = registerKey("colony_urchin");
    public static final RegistryKey<PlacedFeature> COLONY_ANEMONE = registerKey("colony_anemone");
    public static final RegistryKey<PlacedFeature> ANEMONE = registerKey("anemone");
    public static final RegistryKey<PlacedFeature> URCHIN = registerKey("urchin");
    public static final RegistryKey<PlacedFeature> SPONGE = registerKey("sponge");
    public static final RegistryKey<PlacedFeature> CLAM = registerKey("clam");

    public static final RegistryKey<PlacedFeature> DISK_LIMESTONE = registerKey("disk_shorestone");
    public static final RegistryKey<PlacedFeature> DISK_PEBBLESTONE = registerKey("disk_pebblestone");

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Tides.MOD_ID, name));
    }

    public  static  void  registerPlacedFeatures() {

    }
}
