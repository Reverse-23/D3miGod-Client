package demiclient.module.render;

import demiclient.mixins.InGameHud;
import demiclient.module.Mod;

public class NoPumpking extends Mod {
	
	public static boolean on;

	public NoPumpking() {
		super("NoPumpking", "Removes overlay", Category.RENDER);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEnable() {
		on = true;
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		on = false;
		super.onDisable();
	}

}
