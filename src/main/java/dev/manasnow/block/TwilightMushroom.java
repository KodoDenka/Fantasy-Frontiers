package dev.manasnow.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TwilightMushroom extends PlantBlock implements Fertilizable {

    public static final MapCodec<TwilightMushroom> CODEC = createCodec(TwilightMushroom::new);

    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 9.0, 11.0);

    public TwilightMushroom(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<TwilightMushroom> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos below = pos.down();
        BlockState belowState = world.getBlockState(below);
        //Redo this with a proper tag later.
        if (belowState.isOf(ModBlocks.LOAM) || belowState.isOf(ModBlocks.MONDO_GRASS_BLOCK)) {
            return true;
        }
        return world.getLightLevel(pos) < 13 && this.canPlantOnTop(belowState, world, below);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(25) == 0) {
            int count = 0;
            for (BlockPos nearby : BlockPos.iterate(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
                if (world.getBlockState(nearby).isOf(this)) {
                    count++;
                }
            }
            if (count < 5) {
                BlockPos target = pos.add(
                    random.nextInt(3) - 1,
                    random.nextInt(2) - random.nextInt(2),
                    random.nextInt(3) - 1
                );
                if (world.isAir(target) && state.canPlaceAt(world, target)) {
                    world.setBlockState(target, state);
                }
            }
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double) random.nextFloat() < 0.4;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        // Wire up a TreeGrower here once a huge Twilight Mushroom configured feature is registered.
    }
}