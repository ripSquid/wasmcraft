package rip.squid.wasmcraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rip.squid.wasmcraft.block.Turtle;
import rip.squid.wasmcraft.blockentity.TurtleBlockEntity;


public class Wasmcraft implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Wasmcraft");

	public static final Block TURTLE = new Turtle(FabricBlockSettings.of(Material.METAL).resistance(8f).hardness(5f));

	public static BlockEntityType<TurtleBlockEntity> TURTLE_BLOCK_ENTITY;

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("wasmcraft", "turtle_block"), TURTLE);
		Registry.register(Registry.ITEM, new Identifier("wasmcraft", "turtle"), new BlockItem(TURTLE, new FabricItemSettings().group(ItemGroup.REDSTONE)));
		TURTLE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("wasmcraft", "turtle"), FabricBlockEntityTypeBuilder.create(TurtleBlockEntity::new, TURTLE).build(null));
	}


}
