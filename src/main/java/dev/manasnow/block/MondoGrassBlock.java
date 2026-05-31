package dev.manasnow.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;

public class MondoGrassBlock extends Block {

    public MondoGrassBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(world, pos)) {
            world.setBlockState(pos, ModBlocks.LOAM.getDefaultState());
        } else if (world.getLightLevel(pos.up()) >= 9) {
            for (int i = 0; i < 4; i++) {
                BlockPos target = pos.add(
                    random.nextInt(3) - 1,
                    random.nextInt(5) - 3,
                    random.nextInt(3) - 1
                );
                if (world.getBlockState(target).isOf(ModBlocks.LOAM) && canSurvive(world, target)) {
                    world.setBlockState(target, ModBlocks.MONDO_GRASS_BLOCK.getDefaultState());
                }
            }
        }
    }

    private static boolean canSurvive(WorldView world, BlockPos pos) {
        BlockPos above = pos.up();
        BlockState aboveState = world.getBlockState(above);
        return aboveState.getOpacity(world, above) < 15;
    }
}