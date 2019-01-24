package net.itstjf.lightingfix.core;

import java.io.File;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TextComponentTranslation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mumfrey.liteloader.Tickable;
import com.mumfrey.liteloader.core.LiteLoader;

public class LiteModLightingFix implements Tickable {
	@Expose @SerializedName("Enabled")
	public static boolean isEnabled = true;
	
	@Expose @SerializedName("Key")
	KeyBinding key_enable = new KeyBinding("Toggle Lighting", Keyboard.KEY_L, "Lighting Edit");
	
	@Override
	public String getVersion() {
		return "1.0";
	}
	
	@Override
	public void init(File configPath) {
		LiteLoader.getInput().registerKeyBinding(this.key_enable);
	}
	
	@Override public void upgradeSettings(String version, File configPath, File oldConfigPath) {}
	
	@Override
	public String getName() {
		return "Lighting Edit";
	}
	
	@Override
	public void onTick(Minecraft mc, float partialTicks, boolean inGame, boolean clock) {
		if(!inGame) return;
		
		if(key_enable.isPressed()) {
			LiteModLightingFix.isEnabled = !LiteModLightingFix.isEnabled;
			String lightingText = (!isEnabled ? "\u00A7aEnabled." : "\u00A7cDisabled.");
			String modText = (isEnabled ? "\u00A7aEnabled." : "\u00A7cDisabled.");
			
			String str = "\u00A7bSky Lighting Updates are now " + lightingText + "\u00A7b | Mod " + modText;
			
			mc.player.sendMessage(new TextComponentTranslation(str));
			LiteLoader.getInstance().writeConfig(this);
		}
	}
}