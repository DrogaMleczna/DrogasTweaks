package com.drogamleczna.drogastweaks.datagen;


import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.data.models.model.ModelTemplates.CUBE_COLUMN;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DrogasTweaks.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FLINT_BLOCK);
        leavesBlock(ModBlocks.TWIGS);
        blockWithItem(ModBlocks.WILLOW_PLANKS);
        leavesBlock(ModBlocks.WILLOW_LEAVES);

        logBlock((RotatedPillarBlock) ModBlocks.WILLOW_LOG.get());
        axisBlock(((RotatedPillarBlock) ModBlocks.WILLOW_WOOD.get()), blockTexture(ModBlocks.WILLOW_LOG.get()), blockTexture(ModBlocks.WILLOW_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_WILLOW_WOOD.get()), blockTexture(ModBlocks.STRIPPED_WILLOW_LOG.get()),
                new ResourceLocation(DrogasTweaks.MOD_ID, "block/stripped_willow_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_WILLOW_WOOD.get()), blockTexture(ModBlocks.STRIPPED_WILLOW_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_WILLOW_LOG.get()));

        //blockItem(ModBlocks.WILLOW_LOG);
        //blockItem(ModBlocks.WILLOW_WOOD);
        //blockItem(ModBlocks.STRIPPED_WILLOW_LOG);
        //blockItem(ModBlocks.STRIPPED_WILLOW_WOOD);


    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(DrogasTweaks.MOD_ID + ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    //public void logBlockWithItem(RegistryObject<Block> block) {
    //    logBlock((RotatedPillarBlock) block.get());
    //    simpleBlockItem(block.get(), models().withExistingParent(DrogasTweaks.MOD_ID + ":" + blockName(block), CUBE_COLUMN));
    //}
//
    //public void axisBlockWithItem(RegistryObject<Block> block, RegistryObject<Block> blockSide) {
    //    axisBlock((RotatedPillarBlock) block.get(), blockTexture(blockSide.get()), blockTexture(blockSide.get()));
    //    simpleBlockItem(block.get(), models().withExistingParent(DrogasTweaks.MOD_ID + ":" + blockName(block), CUBE_COLUMN));
    //}

}
