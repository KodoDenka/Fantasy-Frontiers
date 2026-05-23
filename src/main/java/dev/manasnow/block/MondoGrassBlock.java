package dev.manasnow.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MondoGrassBlock extends Block {

    public MondoGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canSurvive(level, pos)) {
            level.setBlockAndUpdate(pos, ModBlocks.LOAM.defaultBlockState());
        } else if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
            for (int i = 0; i < 4; i++) {
                BlockPos target = pos.offset(
                    random.nextInt(3) - 1,
                    random.nextInt(5) - 3,
                    random.nextInt(3) - 1
                );
                if (level.getBlockState(target).is(ModBlocks.LOAM) && canSurvive(level, target)) {
                    level.setBlockAndUpdate(target, ModBlocks.MONDO_GRASS_BLOCK.defaultBlockState());
                }
            }
        }
    }

    private static boolean canSurvive(LevelReader level, BlockPos pos) {
        BlockPos above = pos.above();
        BlockState aboveState = level.getBlockState(above);
        return aboveState.getLightBlock(level, above) < 15;
    }
}