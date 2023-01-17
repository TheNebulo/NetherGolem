package thenebulo.nether.golem;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.registry.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherGolem implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");
	public static final Item SUMMONING_STONE = new SummoningStone(new FabricItemSettings().fireproof().rarity(Rarity.EPIC));

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier("nethergolem", "summoning_stone"), SUMMONING_STONE);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
			content.add(SUMMONING_STONE);
		});
	}
}
