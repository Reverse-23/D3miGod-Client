package demiclient.ui;

import demiclient.module.Mod;
import demiclient.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class Hud {

	public static boolean on = false;
	
	private static MinecraftClient mc = MinecraftClient.getInstance();
	
	public static void render(MatrixStack matrices, float tickDelta) {
		
		// mc.textRenderer.drawWithShadow(matrices, "D3miGod", 10, 10, Color.PINK.getRGB());
		renderArrayList(matrices);
		
	}
	
	public static void renderArrayList(MatrixStack matrices) {
		if (on) {
			int index = 0;
			int sWidth = mc.getWindow().getScaledWidth();
			int sHeight = mc.getWindow().getScaledHeight();
			
			for (Mod mod : ModuleManager.INSTANCE.getEnabledModules()) {
				mc.textRenderer.drawWithShadow(matrices, mod.getDisplayName(), (sWidth - 4) - mc.textRenderer.getWidth(mod.getDisplayName()), 10 + (index * mc.textRenderer.fontHeight), -1);
				index++;
			}
		}
	}
	
	
	
	
	
}


