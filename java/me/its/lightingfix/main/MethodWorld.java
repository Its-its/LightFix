package me.its.lightingfix.main;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.EnumSkyBlock;

import com.mumfrey.liteloader.transformers.event.ReturnEventInfo;

public class MethodWorld {
	public static void preUpdateLightByType(ReturnEventInfo<WorldClient, ?> e, EnumSkyBlock blockOrSky, int arg2, int arg3, int arg4) {
		if (!LiteModLighting.isEnabled) {
			if (blockOrSky == EnumSkyBlock.Sky) {
				e.cancel();
			}
		}
	}
}