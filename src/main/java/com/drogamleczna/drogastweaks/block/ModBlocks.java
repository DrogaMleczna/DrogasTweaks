package com.drogamleczna.drogastweaks.block;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.item.ModCreativeModTabs;
import com.drogamleczna.drogastweaks.item.ModItems;
import com.drogamleczna.drogastweaks.worldgen.tree.DeadTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.crafting.conditions.FalseCondition;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DrogasTweaks.MOD_ID);

    public static final RegistryObject<Block> TWIGS = registerBlock("twigs",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> FLINT_ORE = registerBlock("flint_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_ORE).destroyTime(1.5f).sound(SoundType.STONE)));

    public static final RegistryObject<Block> FLINT_BLOCK = registerBlock("flint_block", () -> new Block(BlockBehaviour.Properties
            .copy(Blocks.DIRT).destroyTime(1.5f).sound(SoundType.STONE)));


    public static final RegistryObject<Block> DEAD_TREE_SAPLING = registerBlock("dead_tree_sapling",
            () -> new SaplingBlock(new DeadTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
