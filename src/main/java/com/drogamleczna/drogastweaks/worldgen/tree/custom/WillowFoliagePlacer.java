package com.drogamleczna.drogastweaks.worldgen.tree.custom;

import com.drogamleczna.drogastweaks.worldgen.tree.ModFoliagePlacers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class WillowFoliagePlacer extends FoliagePlacer {
    public static final Codec<WillowFoliagePlacer> CODEC = RecordCodecBuilder.create(willowFoliagePlacerInstance
            -> foliagePlacerParts(willowFoliagePlacerInstance).and(Codec.intRange(0,16).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(willowFoliagePlacerInstance, WillowFoliagePlacer::new));

    private final int height;
    public WillowFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.WILLOW_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        boolean flag = pAttachment.doubleTrunk();
        BlockPos blockpos = pAttachment.pos().above(pOffset);
        int i = pFoliageRadius -2 + pAttachment.radiusOffset() - 1;
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i - 2, pFoliageHeight - 3, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i - 1, pFoliageHeight - 4, flag);

        for(int j = pFoliageHeight - 5; j >= 0; --j) {
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i, j, flag);
        }

        this.placeLeavesRowWithHangingLeavesBelow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i, -1, flag, 0.1F, 0.1F);
        this.placeLeavesRowWithHangingLeavesBelow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i - 1, -2, flag, 0.1F, 0.1F);


    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
}
