package rip.squid.wasmcraft.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import rip.squid.wasmcraft.blockentity.TurtleBlockEntity;

public class Turtle extends Block implements BlockEntityProvider {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public Turtle(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                VoxelShape shape_north = VoxelShapes.empty();
                shape_north = VoxelShapes.union(shape_north, VoxelShapes.cuboid(0.125,  0, 0.125, 0.875, 0.75, 0.875));
                shape_north = VoxelShapes.union(shape_north, VoxelShapes.cuboid(0.1875, 0.25, 0.875, 0.8125, 0.6875, 1));
                return shape_north;
            case SOUTH:
                VoxelShape shape_south = VoxelShapes.empty();
                shape_south = VoxelShapes.union(shape_south, VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.75, 0.875));
                shape_south = VoxelShapes.union(shape_south, VoxelShapes.cuboid(0.1875, 0.25, 0, 0.8125, 0.6875, 0.125));
                return shape_south;
            case EAST:
                VoxelShape shape_east = VoxelShapes.empty();
                shape_east = VoxelShapes.union(shape_east, VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.75, 0.875));
                shape_east = VoxelShapes.union(shape_east, VoxelShapes.cuboid(0, 0.25, 0.1875, 0.125, 0.6875, 0.8125));
                return shape_east;
            case WEST:
                VoxelShape shape_west = VoxelShapes.empty();
                shape_west = VoxelShapes.union(shape_west, VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.75, 0.875));
                shape_west = VoxelShapes.union(shape_west, VoxelShapes.cuboid(0.875, 0.25, 0.1875, 1, 0.6875, 0.8125));
                return shape_west;
            default:
                return VoxelShapes.fullCube();
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TurtleBlockEntity(pos, state);
    }
}
