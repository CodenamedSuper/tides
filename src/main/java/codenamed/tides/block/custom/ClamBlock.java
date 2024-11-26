package codenamed.tides.block.custom;

import codenamed.tides.block.entity.ClamBlockEntity;
import codenamed.tides.registry.TidesItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class ClamBlock extends BlockWithEntity implements Waterloggable {

    public  static  final BooleanProperty OPEN = BooleanProperty.of("open");
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED;


    public ClamBlock(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(OPEN, false).with(WATERLOGGED, false));


    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(OPEN)) {
            return Block.createCuboidShape(0, 0, 0, 16, 4, 16);
        }
        else {
            return VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 0, 0, 16, 4, 16), Block.createCuboidShape(0, 4, 0, 16, 8, 16), BooleanBiFunction.OR);

        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        WorldAccess worldAccess = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).with(WATERLOGGED, worldAccess.getFluidState(blockPos).getFluid() == Fluids.WATER);
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }


    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if ((Boolean)state.get(WATERLOGGED)) {
            double d = (double)pos.getX() + 0.5;
            double e = (double)pos.getY();
            double f = (double)pos.getZ() + 0.5;
            if (random.nextDouble() < 0.1) {
            }

            Direction direction = (Direction)state.get(FACING);
            Direction.Axis axis = direction.getAxis();
            double g = 0.52;
            double h = random.nextDouble() * 0.6 - 0.3;
            double i = axis == Direction.Axis.X ? (double)direction.getOffsetX() * 0.52 : h;
            double j = random.nextDouble() * 6.0 / 16.0;
            double k = axis == Direction.Axis.Z ? (double)direction.getOffsetZ() * 0.52 : h;
            world.addParticle(ParticleTypes.BUBBLE, d + i, e + j, f + k, 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {


        cycleOpenedState(state, world, pos, player);
        return ActionResult.SUCCESS;
    }

    public  void  cycleOpenedState(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (!state.get(OPEN)) {
            world.setBlockState(pos, state.with(OPEN, true));
            if (player.getBlockPos().getX() == pos.getX() && player.getBlockPos().getZ() == pos.getZ() && player.getBlockPos().getY() == pos.getY() && !state.get(WATERLOGGED)) {
                launchEntity(player, pos, world, state);

            }

        }
        else {
            world.setBlockState(pos, state.with(OPEN, false));
        }
    }




    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity.getBlockPos().getX() == pos.getX() && entity.getBlockPos().getZ() == pos.getZ() && entity.getBlockPos().getY() == pos.getY()) {
        }
    }

    public  void  launchEntity(Entity entity, BlockPos blockPos, World world, BlockState state) {
        Vec3d velocity = entity.getVelocity();
        float speed = 1.0f;
        if (state.get(FACING) == Direction.SOUTH) {
            entity.setVelocity(velocity.x, speed, -speed);
        }
        else if (state.get(FACING) == Direction.WEST) {
            entity.setVelocity(speed, speed, velocity.z);
        }
        else if (state.get(FACING) == Direction.NORTH) {
            entity.setVelocity(velocity.x, speed, speed);
        }
        else if (state.get(FACING) == Direction.EAST) {
            entity.setVelocity(-speed, speed, velocity.z);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{OPEN, FACING, WATERLOGGED});

    }

    static {
        WATERLOGGED = Properties.WATERLOGGED;

    }

    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ClamBlockEntity(pos, state);
    }
}
