package org.suibian.lazydog;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.suibian.lazydog.item.LazyDogItem;

public class LazyDog implements ModInitializer {
	public static final String MOD_ID = "lazydog";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final LazyDogItem LAZY_DOG_ITEM = new LazyDogItem(new FabricItemSettings().maxCount(64));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Lazydog!");
		Registry.register(Registries.ITEM,new Identifier(MOD_ID,"lazydog"),LAZY_DOG_ITEM);

	}
}