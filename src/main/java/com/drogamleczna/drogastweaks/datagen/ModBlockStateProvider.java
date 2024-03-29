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



public class ModBlockStateProvider extends BlockStateProvider {

    private static final String CUBE_COLUMN = "minecraft:block/cube_column";

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DrogasTweaks.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FLINT_BLOCK);
        blockWithItem(ModBlocks.FLINT_ORE);

        leavesBlock(ModBlocks.TWIGS);

        saplingBlock(ModBlocks.DEAD_TREE_SAPLING);



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
    public void logBlockWithItem(RegistryObject<Block> block) {
        logBlock((RotatedPillarBlock) block.get());
        simpleBlockItem(block.get(), models().withExistingParent(DrogasTweaks.MOD_ID + ":" + blockName(block), CUBE_COLUMN));
    }


    public void axisBlockWithItem(RegistryObject<Block> block, RegistryObject<Block> blockSide) {
        axisBlock((RotatedPillarBlock) block.get(), blockTexture(blockSide.get()), blockTexture(blockSide.get()));
        simpleBlockItem(block.get(), models().withExistingParent(DrogasTweaks.MOD_ID + ":" + blockName(block), CUBE_COLUMN));
    }

    private String blockName(RegistryObject<Block> block) {
        return blockKey(block).getPath();
    }
    private ResourceLocation blockKey(RegistryObject<Block> block) {
        return ForgeRegistries.BLOCKS.getKey(block.get());
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject){
        simpleBlock(blockRegistryObject.get(), models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

}
