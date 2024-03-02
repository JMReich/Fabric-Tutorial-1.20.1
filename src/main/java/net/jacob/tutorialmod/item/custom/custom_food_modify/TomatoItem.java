package net.jacob.tutorialmod.item.custom.custom_food_modify;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TomatoItem extends Item {


    public TomatoItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("Tooltip.tutorialmod.tomato.tooltip").formatted(Formatting.GREEN));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
