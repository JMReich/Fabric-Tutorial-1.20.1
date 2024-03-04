package net.jacob.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jacob.tutorialmod.block.ModBlocks;
import net.jacob.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;


public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RAW_RUBY_BLOCK);
        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);

        addDrop(ModBlocks.RUBY_ORE, oreDropGenerator(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY, 2.0f, 5.0f));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, oreDropGenerator(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY, 2.0f, 5.0f));
        addDrop(ModBlocks.NETHER_RUBY_ORE, oreDropGenerator(ModBlocks.NETHER_RUBY_ORE, ModItems.RAW_RUBY, 2.0f, 5.0f));
        addDrop(ModBlocks.ENDSTONE_RUBY_ORE, oreDropGenerator(ModBlocks.ENDSTONE_RUBY_ORE, ModItems.RAW_RUBY, 2.0f, 5.0f));

        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR));
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);
        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_WALL);
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB));
    }



    public LootTable.Builder oreDropGenerator(Block drop, Item item, Float min, Float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder) ItemEntry.builder(item)
                        .apply(SetCountLootFunction
                                .builder(UniformLootNumberProvider
                                        .create(min, max))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
