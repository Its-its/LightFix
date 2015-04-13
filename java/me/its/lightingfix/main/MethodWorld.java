package me.its.lightingfix.main;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;

import com.mumfrey.liteloader.transformers.event.ReturnEventInfo;

public class MethodWorld {
	public static void checkLightFor(ReturnEventInfo<WorldClient, ?> e, EnumSkyBlock blockOrSky, BlockPos blockPos) {
		if (!LiteModLighting.isEnabled) {
			if (blockOrSky == EnumSkyBlock.SKY) {
				e.cancel();
			}
		}
	}
}