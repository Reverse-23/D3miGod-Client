package demiclient.module.Movement;

import org.lwjgl.glfw.GLFW;

import demiclient.module.Mod;
import demiclient.module.Mod.Category;
import demiclient.module.settings.NumberSetting;

public class Sneak extends Mod {

	
	
	public Sneak() {
		super("Sneak", "Toggle Sneak [Z]", Category.MOVEMENT);
		this.setKey(GLFW.GLFW_KEY_Z);
		
	}
	
	@Override
	public void onTick() {
		
		mc.player.input.sneaking = true;
		
		
		
		super.onTick();
	}
	
	@Override
	public void onDisable() {
		mc.player.input.sneaking = false;
		super.onDisable();
	}

}