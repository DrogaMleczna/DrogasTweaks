package com.drogamleczna.drogastweaks.datagen.loot;

import com.drogamleczna.drogastweaks.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.FLINT_BLOCK.get());
        dropSelf(ModBlocks.WILLOW_PLANKS.get());
        dropSelf(ModBlocks.WILLOW_LOG.get());
        dropSelf(ModBlocks.WILLOW_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_WILLOW_LOG.get());
        dropSelf(ModBlocks.STRIPPED_WILLOW_WOOD.get());
        dropOther(ModBlocks.TWIGS.get(), Items.STICK);
        add(ModBlocks.WILLOW_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.FLINT_BLOCK.get(), NORMAL_LEAVES_SAPLING_CHANCES)); //TODO: Change to sapling

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
