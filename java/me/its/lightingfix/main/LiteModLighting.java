package me.its.lightingfix.main;

import java.io.File;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mumfrey.liteloader.Configurable;
import com.mumfrey.liteloader.Tickable;
import com.mumfrey.liteloader.core.LiteLoader;
import com.mumfrey.liteloader.modconfig.ConfigPanel;

public class LiteModLighting implements Tickable {
	
	@Expose
	@SerializedName("Enabled")
	public static boolean isEnabled = true;
	
	@Expose
	@SerializedName("Key")
	KeyBinding key_enable = new KeyBinding("itsits.mod.lightingfix.enable", Keyboard.KEY_L, "itsits.mods");
	
	public String getVersion() {
		return "1.1";
	}
	
	public String getName() {
		return "Lighting Fix";
	}
	
	public void init(File configPath) {
		LiteLoader.getInput().registerKeyBinding(key_enable);
	}
	
	public void upgradeSettings(String version, File configPath, File oldConfigPath) {
		
	}
	
	public void onTick(Minecraft minecraft, float partialTicks, boolean inGame, boolean clock) {
		if(inGame) {
			if(key_enable.isPressed()) {
				isEnabled = !(isEnabled);
				minecraft.thePlayer.addChatMessage(new ChatComponentTranslation("\u00A7bSky Lighting Updates are now " + (isEnabled ? "\u00A7aEnabled." : "\u00A7cDisabled."), new Object[0]));
				LiteLoader.getInstance().writeConfig(this);
			}
		}
	}
}