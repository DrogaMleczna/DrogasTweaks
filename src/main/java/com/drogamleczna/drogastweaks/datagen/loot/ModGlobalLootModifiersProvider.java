package com.drogamleczna.drogastweaks.datagen.loot;

import com.drogamleczna.drogastweaks.DrogasTweaks;
import com.drogamleczna.drogastweaks.loot.AddSusGravelItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, DrogasTweaks.MOD_ID);
    }

    @Override
    protected void start() {
        add("prismarine_shard_from_suspicious_gravel_in_trail_ruins", new AddSusGravelItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/trail_ruins_common")).build()}, Items.PRISMARINE_SHARD));

        add("prismarine_shard_from_suspicious_gravel_in_cold_ocean_ruins", new AddSusGravelItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/ocean_ruin_cold")).build()}, Items.PRISMARINE_SHARD));
    }
}
