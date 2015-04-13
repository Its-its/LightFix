package me.its.lightingfix.main;

import static com.mumfrey.liteloader.core.runtime.Obf.EntityClientPlayerMP;
import static me.its.lightingfix.main.ObfuscationTable.*;

import com.mumfrey.liteloader.transformers.event.Event;
import com.mumfrey.liteloader.transformers.event.EventInjectionTransformer;
import com.mumfrey.liteloader.transformers.event.MethodInfo;
import com.mumfrey.liteloader.transformers.event.inject.BeforeReturn;
import com.mumfrey.liteloader.transformers.event.inject.MethodHead;

public class Transformer extends EventInjectionTransformer {

	protected void addEvents() {
		Event preUpdateLightByType = Event.getOrCreate("preUpdateLightByType", true);
		
		MethodInfo preUpdateLightByTypeMethodInfo = new MethodInfo(World, updateLightByType, Boolean.TYPE, new Object[]{ EnumSkyBlock, Integer.TYPE, Integer.TYPE, Integer.TYPE });
		
		MethodHead preUpdateLightByTypeInjectionPoint = new MethodHead();
		
		addEvent(preUpdateLightByType, preUpdateLightByTypeMethodInfo, preUpdateLightByTypeInjectionPoint);
		
		preUpdateLightByType.addListener(new MethodInfo("me.its.lightingfix.main.MethodWorld", "preUpdateLightByType"));
	}
}