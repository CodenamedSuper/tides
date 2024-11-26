package codenamed.tides.worldgen.feature;

import codenamed.tides.block.custom.MarinalOrganBlock;
import codenamed.tides.registry.TidesBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class AnemoneColonyFeature extends Feature<SimpleBlockFeatureConfig> {
    public AnemoneColonyFeature(Codec<SimpleBlockFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<SimpleBlockFeatureConfig> context) {
        SimpleBlockFeatureConfig simpleBlockFeatureConfig = (SimpleBlockFeatureConfig)context.getConfig();
        StructureWorldAccess world = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        BlockState blockState = simpleBlockFeatureConfig.toPlace().get(context.getRandom(), blockPos);
        BlockPos testPos = blockPos.up();
        Random random = context.getRandom();
        if (blockState.canPlaceAt(world, blockPos) && world.getBlockState(blockPos) == Blocks.WATER.getDefaultState()) {

            if (world.getBlockState(testPos).isOf(Blocks.WATER)) {
                world.setBlockState(testPos, TidesBlocks.ANEMONE_TENTACLES.getDefaultState().with(MarinalOrganBlock.WATERLOGGED, true),1);
            }
            for (int i = 0; i < 5; i++) {
                if (random.nextInt(2) == 0) {
                    if (i == 0) {
                        world.setBlockState(blockPos.north(), TidesBlocks.ANEMONE_TENTACLES.getDefaultState().with(MarinalOrganBlock.WATERLOGGED, true)
                                .with(MarinalOrganBlock.FACING, Direction.NORTH), 1);
                    } else if (i == 1) {
                        world.setBlockState(blockPos.east(), TidesBlocks.ANEMONE_TENTACLES.getDefaultState().with(MarinalOrganBlock.WATERLOGGED, true)
                                .with(MarinalOrganBlock.FACING, Direction.EAST), 1);
                    } else if (i == 2) {
                        world.setBlockState(blockPos.south(), TidesBlocks.ANEMONE_TENTACLES.getDefaultState().with(MarinalOrganBlock.WATERLOGGED, true)
                                .with(MarinalOrganBlock.FACING, Direction.SOUTH), 1);
                    } else if (i == 3) {
                        world.setBlockState(blockPos.west(), TidesBlocks.ANEMONE_TENTACLES.getDefaultState().with(MarinalOrganBlock.WATERLOGGED, true)
                                .with(MarinalOrganBlock.FACING, Direction.WEST), 1);
                    }
                }
            }


            if (blockState.getBlock() instanceof TallPlantBlock) {
                if (!world.isAir(blockPos.up())) {
                    return false;
                }

                TallPlantBlock.placeAt(world, blockState, blockPos, 2);
            } else {
                world.setBlockState(blockPos, blockState, 2);
            }


            return true;
        } else {
            return false;
        }
    }
}