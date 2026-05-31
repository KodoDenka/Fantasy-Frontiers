package dev.manasnow.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class MondoGrass extends PlantBlock implements Fertilizable {

    public static final MapCodec<MondoGrass> CODEC = createCodec(MondoGrass::new);

    private static final VoxelShape SHAPE = createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    @Override
    public MapCodec<MondoGrass> getCodec() {
        return CODEC;
    }

    public MondoGrass(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d offset = state.getModelOffset(world, pos);
        return SHAPE.offset(offset.x, offset.y, offset.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND)
            || floor.isOf(ModBlocks.LOAM) || floor.isOf(ModBlocks.MONDO_GRASS_BLOCK);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        for (int i = 0; i < 8; i++) {
            BlockPos target = pos.add(
                random.nextInt(7) - 3,
                random.nextInt(5) - 2,
                random.nextInt(7) - 3
            );
            if (world.getBlockState(target).isAir() && this.getDefaultState().canPlaceAt(world, target)) {
                world.setBlockState(target, this.getDefaultState());
            }
        }
    }
}