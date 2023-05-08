package demiclient.module.misc;

import org.lwjgl.glfw.GLFW;

import demiclient.module.Mod;
import demiclient.module.Mod.Category;
import demiclient.ui.Hud;

public class OnList extends Mod {

	public OnList() {
		super("Logo", "Hack like client module list", Category.MISC);
		// this.setKey(GLFW.GLFW_KEY_G);
	}
	
	@Override
	public void onEnable() {
		Hud.on = true;
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		Hud.on = false;
		super.onDisable();
	}
}
