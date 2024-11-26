package codenamed.tides.registry;
import codenamed.tides.Tides;
import codenamed.tides.block.entity.ClamBlockEntity;
import com.mojang.datafixers.types.Type;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class TidesBlockEntityType {
    public static final BlockEntityType<ClamBlockEntity> CLAM;



    @Nullable
    public static Identifier getId(BlockEntityType<?> type) {
        return Registries.BLOCK_ENTITY_TYPE.getId(type);
    }

    private static <T extends BlockEntity> BlockEntityType create(String id, BlockEntityType.Builder<T> builder) {


        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);
        return (BlockEntityType) Registry.register(Registries.BLOCK_ENTITY_TYPE, id, builder.build(type));
    }

    static {
        CLAM = create("clam", BlockEntityType.Builder.create(ClamBlockEntity::new, TidesBlocks.CLAM));
    }

    public static final class Builder<T extends BlockEntity> implements FabricBlockEntityType.Builder<T> {
        private final BlockEntityType.BlockEntityFactory<? extends T> factory;
        final Set<Block> blocks;

        private Builder(BlockEntityType.BlockEntityFactory<? extends T> factory, Set<Block> blocks) {
            this.factory = factory;
            this.blocks = blocks;
        }



        public BlockEntityType<T> build(Type<?> type) {
            return new BlockEntityType(this.factory, this.blocks, type);
        }
    }

    @FunctionalInterface
    private interface BlockEntityFactory<T extends BlockEntity> {
        T create(BlockPos pos, BlockState state);
    }

    public  static  void init() { }
}
