package demiclient.module.world;

import demiclient.module.Mod;
import net.minecraft.client.MinecraftClient;

public class AutoRespawn extends Mod {
	public static MinecraftClient mc = MinecraftClient.getInstance();

	public AutoRespawn() {
		super("AutoRespawn", "name says it", Category.QOL);
	}

	@Override
	public void onTick() {
		if (this.isEnabled()) {
			if(mc.player.isDead()) {
				mc.player.requestRespawn();
				mc.player.closeScreen();;
			}
		}
		super.onTick();
	}
		
	@Override
	public void onEnable() {
		
		super.onEnable();
	}
		
	@Override
	public void onDisable() {
			
		super.onDisable();
	}
}