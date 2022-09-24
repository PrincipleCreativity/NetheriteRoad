package com.groupzts.netheriteroad.event;

import com.groupzts.netheriteroad.NetheriteRoad;
import com.groupzts.netheriteroad.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldOreGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        NetheriteRoad.ORE_GEN.generateWorld(random, chunkX * 16, chunkZ * 16, world, world.provider.getDimension());
        NetheriteRoad.ORE_GEN.generateWorldSecond(random, chunkX * 16, chunkZ * 16, world, world.provider.getDimension());
    }
    public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID) {
        boolean dimensionCriteria = dimID == -1;
        if (!dimensionCriteria)
            return;
        for (int i = 0; i < 2; i++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(14) + 8;
            int z = chunkZ + random.nextInt(16);
            (new WorldGenMinable(ModBlocks.ANCIENT_DEBRIS.getDefaultState(), 3, blockAt -> blockAt.getBlock() == Blocks.NETHERRACK.getDefaultState().getBlock())).generate(world, random, new BlockPos(x, y, z));
        }
    }
    public void generateWorldSecond(Random random, int chunkX, int chunkZ, World world, int dimID) {
        boolean dimensionCriteria = dimID == -1;
        if (!dimensionCriteria)
            return;
        for (int i = 0; i < 2; i++) {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(111) + 8;
            int z = chunkZ + random.nextInt(16);
            (new WorldGenMinable(ModBlocks.ANCIENT_DEBRIS.getDefaultState(), 2, blockAt -> blockAt.getBlock() == Blocks.NETHERRACK.getDefaultState().getBlock())).generate(world, random, new BlockPos(x, y, z));
        }
    }
}
