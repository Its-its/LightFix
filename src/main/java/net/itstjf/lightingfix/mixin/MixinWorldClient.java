package net.itstjf.lightingfix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.itstjf.lightingfix.core.LiteModLightingFix;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

@Mixin(World.class)
public abstract class MixinWorldClient implements IBlockAccess {
	@Inject(at = @At("HEAD"), method = "checkLightFor", cancellable = true)
	protected void checkLightFor(EnumSkyBlock lightType, BlockPos pos, CallbackInfoReturnable<Boolean> ci) {
		if(LiteModLightingFix.isEnabled) ci.setReturnValue(false);
	}
}