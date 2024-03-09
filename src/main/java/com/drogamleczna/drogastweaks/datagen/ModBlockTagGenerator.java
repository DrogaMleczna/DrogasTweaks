package com.drogamleczna.drogastweaks.datagen;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DrogasTweaks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.FLINT_BLOCK.get())
                .add(ModBlocks.FLINT_ORE.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FLINT_BLOCK.get())
                .add(ModBlocks.FLINT_ORE.get());
        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.TWIGS.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.TWIGS.get());

    }
}
