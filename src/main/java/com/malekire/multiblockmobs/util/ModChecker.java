package com.malekire.multiblockmobs.util;

import com.malekire.multiblockmobs.Main;

import net.minecraftforge.fml.common.Loader;

public class ModChecker {

    public static boolean isHarvesterLoaded;

    public static void checkMods() {
        isHarvesterLoaded = Loader.isModLoaded("harvestersnight");
    }

    public static void printSuccessMessage() {
        if (isHarvesterLoaded) {
            Main.logger.info("Harvesters of the night has been loaded");
        }
    }
}
