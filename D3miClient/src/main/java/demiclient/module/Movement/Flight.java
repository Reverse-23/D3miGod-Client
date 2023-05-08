package demiclient.module.Movement;

import org.lwjgl.glfw.GLFW;

import demiclient.module.Mod;
import demiclient.module.settings.BooleanSetting;
import demiclient.module.settings.ModeSetting;
import demiclient.module.settings.NumberSetting;

public class Flight extends Mod {

	public NumberSetting speed = new NumberSetting("Speed", 0, 10, 1, 0.1 );
	public BooleanSetting testBool = new BooleanSetting("Check", true);
	public ModeSetting testMode = new ModeSetting("Mode", "Test", "Test", "Test2", "test 3");
	
	public Flight() {
		super("Creative addons", "Toggle fly", Category.MOVEMENT);
		this.setKey(GLFW.GLFW_KEY_G);
		addSettings(speed, testBool, testMode);
	}
	
	@Override
	public void onTick() {
		mc.player.getAbilities().flying = true;
		mc.player.getAbilities().setFlySpeed(speed.getValueFloat());
		
		super.onTick();
	}
	
	@Override
	public void onDisable() {
		mc.player.getAbilities().flying = true;
		super.onDisable();
	}

}
