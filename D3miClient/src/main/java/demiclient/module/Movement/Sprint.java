package demiclient.module.Movement;

import org.lwjgl.glfw.GLFW;

import demiclient.module.Mod;
import demiclient.module.Mod.Category;

public class Sprint extends Mod {

	public Sprint() {
		super("Sprint", "ToggleSprint", Category.MOVEMENT);
		this.setKey(GLFW.GLFW_KEY_V);
	}
	
	@Override
	public void onTick() {
		if (mc.player.forwardSpeed>0) mc.player.setSprinting(true);
		super.onTick();
	}
	
	@Override
    public void onDisable() {
        super.onDisable();
    }

}
