package me.its.lightingfix.main;

import com.mumfrey.liteloader.core.runtime.Obf;

public class ObfuscationTable extends Obf {
	public static ObfuscationTable EnumSkyBlock = new ObfuscationTable("net.minecraft.world.EnumSkyBlock", "arf");
	public static ObfuscationTable updateLightByType = new ObfuscationTable("func_180500_c", "c", "checkLightFor");

	public static ObfuscationTable World = new ObfuscationTable("net.minecraft.world.World", "aqu");
	
	public static ObfuscationTable blockPos = new ObfuscationTable("net.minecraft.util.BlockPos", "dt");

	protected ObfuscationTable(String seargeName, String obfName) {
		super(seargeName, obfName, seargeName);
	}

	protected ObfuscationTable(String seargeName, String obfName, String mcpName) {
		super(seargeName, obfName, mcpName);
	}
}