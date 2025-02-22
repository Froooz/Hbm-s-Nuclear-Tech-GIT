package com.hbm.config;

import net.minecraftforge.common.config.Configuration;

public class GeneralConfig {

	public static boolean enableDebugMode = true;
	public static boolean enableMycelium = false;
	public static boolean enablePlutoniumOre = false;
	public static boolean enableDungeons = true;
	public static boolean enableMDOres = true;
	public static boolean enableMines = true;
	public static boolean enableRad = true;
	public static boolean enableNITAN = true;
	public static boolean enableNukeClouds = true;
	public static boolean enableBomberShortMode = false;
	public static boolean enableVaults = true;
	public static boolean enableCataclysm = false;
	public static boolean enableExtendedLogging = false;
	public static boolean enableHardcoreTaint = false;
	public static boolean enableGuns = true;
	public static boolean enableVirus = true;
	public static boolean enableCrosshairs = true;
	public static boolean enableReflectorCompat = false;
	public static boolean enableRenderDistCheck = true;
	public static boolean enableCustomDashKeybind = false;
	public static boolean enableReEval = true;
	public static int hintPos = 0;

	public static boolean enable528 = false;
	public static boolean enable528ReasimBoilers = true;
	public static boolean enable528ColtanDeposit = true;
	public static boolean enable528ColtanSpawn = false;
	public static boolean enable528BedrockDeposit = true;
	public static boolean enable528BedrockSpawn = false;
	public static int coltanRate = 2;
	public static int bedrockRate = 50;

	public static boolean enableLBSM = false;
	public static boolean enableLBSMFullSchrab = true;
	public static boolean enableLBSMShorterDecay = true;
	public static boolean enableLBSMSimpleArmorRecipes = true;
	public static boolean enableLBSMSimpleToolRecipes = true;
	public static boolean enableLBSMSimpleAlloy = true;
	public static boolean enableLBSMSimpleChemsitry = true;
	public static boolean enableLBSMSimpleCentrifuge = true;
	public static boolean enableLBSMUnlockAnvil = true;
	public static boolean enableLBSMSimpleCrafting = true;
	public static boolean enableLBSMSimpleMedicineRecipes = true;
	public static boolean enableLBSMSafeMEDrives = true;
	public static int schrabRate = 20;
	
	public static void loadFromConfig(Configuration config) {

		final String CATEGORY_GENERAL = CommonConfig.CATEGORY_GENERAL;
		enableDebugMode = config.get(CATEGORY_GENERAL, "1.00_enableDebugMode", false).getBoolean(false);
		enableMycelium = config.get(CATEGORY_GENERAL, "1.01_enableMyceliumSpread", false).getBoolean(false);
		enablePlutoniumOre = config.get(CATEGORY_GENERAL, "1.02_enablePlutoniumNetherOre", false).getBoolean(false);
		enableDungeons = config.get(CATEGORY_GENERAL, "1.03_enableDungeonSpawn", true).getBoolean(true);
		enableMDOres = config.get(CATEGORY_GENERAL, "1.04_enableOresInModdedDimensions", true).getBoolean(true);
		enableMines = config.get(CATEGORY_GENERAL, "1.05_enableLandmineSpawn", true).getBoolean(true);
		enableRad = config.get(CATEGORY_GENERAL, "1.06_enableRadHotspotSpawn", true).getBoolean(true);
		enableNITAN = config.get(CATEGORY_GENERAL, "1.07_enableNITANChestSpawn", true).getBoolean(true);
		enableNukeClouds = config.get(CATEGORY_GENERAL, "1.08_enableMushroomClouds", true).getBoolean(true);
		enableBomberShortMode = config.get(CATEGORY_GENERAL, "1.14_enableBomberShortMode", false).getBoolean(false);
		enableVaults = config.get(CATEGORY_GENERAL, "1.15_enableVaultSpawn", true).getBoolean(true);
		enableCataclysm = config.get(CATEGORY_GENERAL, "1.17_enableCataclysm", false).getBoolean(false);
		enableExtendedLogging = config.get(CATEGORY_GENERAL, "1.18_enableExtendedLogging", false).getBoolean(false);
		enableHardcoreTaint = config.get(CATEGORY_GENERAL, "1.19_enableHardcoreTaint", false).getBoolean(false);
		enableGuns = config.get(CATEGORY_GENERAL, "1.20_enableGuns", true).getBoolean(true);
		enableVirus = config.get(CATEGORY_GENERAL, "1.21_enableVirus", false).getBoolean(false);
		enableCrosshairs = config.get(CATEGORY_GENERAL, "1.22_enableCrosshairs", true).getBoolean(true);
		enableReflectorCompat = config.get(CATEGORY_GENERAL, "1.24_enableReflectorCompat", false).getBoolean(false);
		enableRenderDistCheck = config.get(CATEGORY_GENERAL, "1.25_enableRenderDistCheck", true).getBoolean(true);
		enableCustomDashKeybind = config.get(CATEGORY_GENERAL, "1.26_enableCustomDashKeybind", false).getBoolean(false);
		enableReEval = config.get(CATEGORY_GENERAL, "1.27_enableReEval", true).getBoolean(true);
		
		hintPos = CommonConfig.createConfigInt(config, CATEGORY_GENERAL, "1.27_hudOverlayPosition", "0: Top left\n1: Top right\n2: Center right\n3: Center Left", 0);
		
		final String CATEGORY_528 = CommonConfig.CATEGORY_528;

		config.addCustomCategoryComment(CATEGORY_528, "CAUTION\n"
				+ "528 Mode: Please proceed with caution!\n"
				+ "528-Modus: Lassen Sie Vorsicht walten!\n"
				+ "способ-528: действовать с осторожностью!");
		
		enable528 = CommonConfig.createConfigBool(config, CATEGORY_528, "enable528Mode", "The central toggle for 528 mode.", false);
		enable528ReasimBoilers = CommonConfig.createConfigBool(config, CATEGORY_528, "X528_forceReasimBoilers", "Keeps the RBMK dial for ReaSim boilers on, preventing use of non-ReaSim boiler columns and forcing the use of steam in-/outlets", true);
		enable528ColtanDeposit = CommonConfig.createConfigBool(config, CATEGORY_528, "X528_enableColtanDepsoit", "Enables the coltan deposit. A large amount of coltan will spawn around a single random location in the world.", true);
		enable528ColtanSpawn = CommonConfig.createConfigBool(config, CATEGORY_528, "X528_enableColtanSpawning", "Enables coltan ore as a random spawn in the world. Unlike the deposit option, coltan will not just spawn in one central location.", false);
		enable528BedrockDeposit = CommonConfig.createConfigBool(config, CATEGORY_528, "X528_enableBedrockDepsoit", "Enables bedrock coltan ores in the coltan deposit. These ores can be drilled to extract infinite coltan, albeit slowly.", true);
		enable528BedrockSpawn = CommonConfig.createConfigBool(config, CATEGORY_528, "X528_enableBedrockSpawning", "Enables the bedrock coltan ores as a rare spawn. These will be rarely found anywhere in the world.", false);
		coltanRate = CommonConfig.createConfigInt(config, CATEGORY_528, "X528_oreColtanFrequency", "Determines how many coltan ore veins are to be expected in a chunk. These values do not affect the frequency in deposits, and only apply if random coltan spanwing is enabled.", 2);
		bedrockRate = CommonConfig.createConfigInt(config, CATEGORY_528, "X528_bedrockColtanFrequency", "Determines how often (1 in X) bedrock coltan ores spawn. Applies for both the bedrock ores in the coltan deposit (if applicable) and the random bedrock ores (if applicable)", 50);
		
		
		final String CATEGORY_LBSM = CommonConfig.CATEGORY_LBSM;

		config.addCustomCategoryComment(CATEGORY_LBSM,
				"Will most likely break standard progression!\n"
				+ "However, the game gets generally easier and more enjoyable for casual players.\n"
				+ "Progression-braking recipes are usually not too severe, so the mode is generally server-friendly!");
		
		enableLBSM = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "enableLessBullshitMode", "The central toggle for LBS mode. Forced OFF when 528 is enabled!", false);
		enableLBSMFullSchrab = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_fullSchrab", "When enabled, this will replace schraranium with full schrabidium ingots in the transmutator's output", true);
		enableLBSMShorterDecay = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_shortDecay", "When enabled, this will highly accelerate the speed at which nuclear waste disposal drums decay their contents. 60x faster than 528 mode and 5-12x faster than on normal mode.", true);
		enableLBSMSimpleArmorRecipes = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_recipeSimpleArmor", "When enabled, simplifies the recipe for armor sets like starmetal or schrabidium.", true);
		enableLBSMSimpleToolRecipes = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_recipeSimpleTool", "When enabled, simplifies the recipe for tool sets like starmetal or scrhabidium", true);
		enableLBSMSimpleAlloy = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_recipeSimpleAlloy", "When enabled, adds some blast furnace recipes to make certain things cheaper", true);
		enableLBSMSimpleChemsitry = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_recipeSimpleChemistry", "When enabled, simplifies some chemical plant recipes", true);
		enableLBSMSimpleCentrifuge = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_recipeSimpleCentrifuge", "When enabled, enhances centrifuge outputs to make rare materials more common", true);
		enableLBSMUnlockAnvil = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_recipeUnlockAnvil", "When enabled, all anvil recipes are available at tier 1", true);
		enableLBSMSimpleCrafting = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_recipeSimpleCrafting", "When enabled, some uncraftable or more expansive items get simple crafting recipes. Scorched uranium also becomes washable", true);
		enableLBSMSimpleMedicineRecipes = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_recipeSimpleMedicine", "When enabled, makes some medicine recipes (line ones that require bismuth) much more affordable", true);
		enableLBSMSafeMEDrives = CommonConfig.createConfigBool(config, CATEGORY_LBSM, "LBSM_safeMEDrives", "When enabled, prevents ME Drives and Portable Cells from becoming radioactive", true);
		schrabRate = CommonConfig.createConfigInt(config, CATEGORY_LBSM, "LBSM_schrabOreRate", "Changes the amount of uranium ore needed on average to create one schrabidium ore using nukes. Standard mode value is 100", 20);
		
		if(enable528) enableLBSM = false;
	}
}
