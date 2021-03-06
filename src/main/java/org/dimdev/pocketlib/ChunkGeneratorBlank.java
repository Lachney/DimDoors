package org.dimdev.pocketlib;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

import javax.annotation.Nullable;
import java.util.List;

public class ChunkGeneratorBlank implements IChunkGenerator {

    private final World world;

    public ChunkGeneratorBlank(World world, long seed) {
        this.world = world;
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        Chunk chunk = new Chunk(world, new ChunkPrimer(), x, z);
        if(!chunk.isTerrainPopulated()) chunk.setTerrainPopulated(true);
        return chunk;
    }

    @Override
    public void populate(int x, int z) {}

    @Override
    public boolean generateStructures(Chunk chunk, int x, int z) {
        return false;
    }

    @Override @Nullable public BlockPos getNearestStructurePos(World world, String structureName, BlockPos position, boolean findUnexplored) { return null; }

    @Override public void recreateStructures(Chunk chunk, int x, int z) {}

    @Override public boolean isInsideStructure(World world, String structureName, BlockPos pos) { return false; } // TODO: make this return true for pockets?

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        return world.getBiome(pos).getSpawnableList(creatureType);
    }
}
