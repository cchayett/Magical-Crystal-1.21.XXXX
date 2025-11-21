package com.chayet.magicalcrystal.util;

import com.chayet.magicalcrystal.items.custom.MiningHammerItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class MiningHammerUsageEvent implements PlayerBlockBreakEvents.Before{
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity) {
        ItemStack mainHandItem = player.getMainHandStack();

        if (mainHandItem.getItem() instanceof MiningHammerItem hammer && player instanceof ServerPlayerEntity serverPlayer){
            if (HARVESTED_BLOCKS.contains(blockPos)){
                return true;
            }

            for (BlockPos pos : MiningHammerItem.getBlocksInRange(1, blockPos, serverPlayer)){
                if (blockPos == pos || !hammer.isCorrectForDrops(mainHandItem, world.getBlockState(pos))){
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.interactionManager.tryBreakBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }

        return true;
    }
}
