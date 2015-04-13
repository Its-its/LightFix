package me.its.lightingfix.main;

import com.mumfrey.liteloader.core.runtime.Obf;

public class ObfuscationTable extends Obf {
	public static ObfuscationTable EnumSkyBlock = new ObfuscationTable("net.minecraft.world.EnumSkyBlock", "ahn");
	public static ObfuscationTable updateLightByType = new ObfuscationTable("func_147463_c", "c", "updateLightByType");

	public static ObfuscationTable World = new ObfuscationTable("net.minecraft.world.World", "ahb");

	protected ObfuscationTable(String seargeName, String obfName) {
		super(seargeName, obfName, seargeName);
	}

	protected ObfuscationTable(String seargeName, String obfName, String mcpName) {
		super(seargeName, obfName, mcpName);
	}
}