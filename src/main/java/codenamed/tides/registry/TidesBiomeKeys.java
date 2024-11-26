package codenamed.tides.registry;

import codenamed.tides.Tides;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.PlacedFeature;

public class TidesBiomeKeys {

    public static final RegistryKey<Biome> SHORE = registerKey("shore");


    public static RegistryKey<Biome> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Tides.MOD_ID, name));
    }

    public  static  void  registerBiomeKeys() {

    }
}
