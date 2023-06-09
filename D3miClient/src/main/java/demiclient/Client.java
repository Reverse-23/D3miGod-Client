package demiclient;

import java.util.Timer;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import demiclient.module.Mod;
import demiclient.module.ModuleManager;
import demiclient.ui.screen.clickgui.ClickGUI;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import com.google.common.eventbus.EventBus;


public class Client implements ModInitializer {

	
	public static final Client INSTANCE  = new Client();
	public Logger logger = LogManager.getLogger(Client.class);
	
	private MinecraftClient mc = MinecraftClient.getInstance();
	
	public static final EventBus EventBus = new EventBus();
	
	
	
	
	
	
	
	DiscordRPC lib = DiscordRPC.INSTANCE;
	String applicationId = "1104180952151892039";
	String steamId = "";
	DiscordEventHandlers handlers = new DiscordEventHandlers();
	Long start_time = System.currentTimeMillis() / 1000;

	

	Integer times = 0;
	Timer t = new Timer();

	
	
	@Override
	public void onInitialize() {
		 
		
		logger.info("---_---_---_D3miGod-Client _---_---_---");
		
		handlers.ready = (user) -> logger.info("Discord on! " + user);
		lib.Discord_Initialize(applicationId, handlers, true, steamId);

		basicPresence();
		new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				lib.Discord_RunCallbacks();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ignored) {
				}
			}
		}, "RPC-Callback-Handler").start();
	}
		
		
	private void basicPresence() {

		DiscordRichPresence presence = new DiscordRichPresence();
		presence.startTimestamp = start_time; // each second
		presence.details = "Playing Minecraft";
		presence.largeImageKey = "spartan";
		presence.largeImageText = "D3miGod Client 0.2";
		presence.instance = 1;
		lib.Discord_UpdatePresence(presence);

	}
	
	public void onKeyPress(int key, int action) {
		if (action == GLFW.GLFW_PRESS) {
			for (Mod module : ModuleManager.INSTANCE.getModules()) {
				if (key == module.getKey()) module.toggle();
			}
			
			if (key == GLFW.GLFW_KEY_RIGHT_SHIFT) mc.setScreen(ClickGUI.INSTANCE);
		}
	}
	
	public void onTick() {
		if(mc.player !=  null) {
			for (Mod module : ModuleManager.INSTANCE.getEnabledModules()){
				module.onTick();
			}
	}
	}

}
