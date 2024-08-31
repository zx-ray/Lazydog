package org.suibian.lazydog.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LazyDogItem extends Item {
    public LazyDogItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        BlockState state = world.getBlockState(pos);
        Block hitBlock = state.getBlock();
        if (!world.isClient()) {
            if (hitBlock.equals(Blocks.BEDROCK)) { //检测到基岩就直接破环掉
                world.breakBlock(pos, false);
                PlayerEntity player = context.getPlayer();
                assert player != null;
                if (!player.isCreative()) {
                    ItemStack stack = player.getStackInHand(context.getHand());
                    stack.setCount(stack.getCount() - 1);
                }
            }
        }
        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.lazydog.tooltip"));
    }
}
