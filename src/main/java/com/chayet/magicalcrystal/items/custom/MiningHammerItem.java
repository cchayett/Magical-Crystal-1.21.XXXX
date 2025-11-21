package com.chayet.magicalcrystal.items.custom;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class MiningHammerItem extends MiningToolItem {
    public MiningHammerItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, BlockTags.PICKAXE_MINEABLE, attackDamage, attackSpeed, settings);
    }

    public static List<BlockPos> getBlocksInRange(int range, BlockPos iniBlockPos, ServerPlayerEntity player){
        List<BlockPos> positions = new ArrayList<>();//all the blocks to be destroyed
        HitResult hit = player.raycast(20,0, false);//the place that player looks
        if (hit.getType() == HitResult.Type.BLOCK){
            BlockHitResult blockHit = (BlockHitResult) hit;
            //jugde the side to extend the range
            if (blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP){
                for (int i = -range; i <= range; i++){
                    for (int j = -range; j <= range; j++){
                        positions.add(new BlockPos(iniBlockPos.getX() + i, iniBlockPos.getY(), iniBlockPos.getZ() + j));
                    }
                }
            }

            if (blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH){
                for (int i = -range; i <= range; i++){
                    for (int j = -range; j <= range; j++){
                        positions.add(new BlockPos(iniBlockPos.getX() + i, iniBlockPos.getY() + j, iniBlockPos.getZ()));
                    }
                }
            }

            if (blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST){
                for (int i = -range; i <= range; i++){
                    for (int j = -range; j <= range; j++){
                        positions.add(new BlockPos(iniBlockPos.getX(), iniBlockPos.getY() + i, iniBlockPos.getZ() + j));
                    }
                }
            }
        }
        return positions;
    }
}
