package codenamed.tides.registry;

import codenamed.tides.Tides;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TidesEntityTypeTags {
    public static final TagKey<EntityType<?>> IMMUNE_TO_URCHIN = of("immune_to_urchin");

    private static TagKey<EntityType<?>> of(String id) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Tides.MOD_ID, id));
    }

    public  static  void init() { }
}
