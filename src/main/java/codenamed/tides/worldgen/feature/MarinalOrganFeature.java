package codenamed.tides.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class MarinalOrganFeature extends Feature<SimpleBlockFeatureConfig> {
    public MarinalOrganFeature(Codec<SimpleBlockFeatureConfig> configCodec) {
        super(configCodec);
    }


    public boolean generate(FeatureContext<SimpleBlockFeatureConfig> context) {
        SimpleBlockFeatureConfig simpleBlockFeatureConfig = (SimpleBlockFeatureConfig)context.getConfig();
        StructureWorldAccess world = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        BlockState blockState = simpleBlockFeatureConfig.toPlace().get(context.getRandom(), blockPos);
        BlockPos testPos = blockPos.up();
        Random random = context.getRandom();
        if (blockState.canPlaceAt(world, blockPos) && world.getBlockState(blockPos) == Blocks.WATER.getDefaultState()) {


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

