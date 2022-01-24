package rip.squid.wasmcraft.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import rip.squid.wasmcraft.Wasmcraft;

public class TurtleBlockEntity extends BlockEntity {
    public TurtleBlockEntity(BlockPos pos, BlockState state) {
        super(Wasmcraft.TURTLE_BLOCK_ENTITY, pos, state);
    }
}

