package codenamed.tides.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UrchinSpinesBlock extends MarinalOrganBlock {
    public UrchinSpinesBlock(float height, float xzOffset, Settings settings) {
        super(height, xzOffset, settings);

    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 120, 0));
            livingEntity.damage(world.getDamageSources().sweetBerryBush(), 1.0f);
        }
        super.onEntityCollision(state, world, pos, entity);
    }
}
