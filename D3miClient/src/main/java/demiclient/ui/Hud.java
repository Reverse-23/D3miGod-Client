package demiclient.ui;

import java.awt.Color;

import demiclient.module.Mod;
import demiclient.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class Hud {

	public static boolean on = false;
	
	private static MinecraftClient mc = MinecraftClient.getInstance();
	
	public static void render(MatrixStack matrices, float tickDelta) {
		
		mc.textRenderer.drawWithShadow(matrices, "D3miGod", 10, 10, Color.PINK.getRGB());
		renderArrayList(matrices);
		
	}
	
	public static void renderArrayList(MatrixStack matrices) {
		if (on) {
			 mc.textRenderer.drawWithShadow(matrices, "D3miGod", 10, 10, Color.PINK.getRGB());
		}
	}
	
	
	
	
	
}


