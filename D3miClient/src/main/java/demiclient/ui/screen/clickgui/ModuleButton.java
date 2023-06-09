package demiclient.ui.screen.clickgui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import demiclient.Client;
import demiclient.module.Mod;
import demiclient.module.settings.BooleanSetting;
import demiclient.module.settings.ModeSetting;
import demiclient.module.settings.NumberSetting;
import demiclient.module.settings.Setting;
import demiclient.ui.screen.clickgui.setting.CheckBox;
import demiclient.ui.screen.clickgui.setting.Component;
import demiclient.ui.screen.clickgui.setting.ModeBox;
import demiclient.ui.screen.clickgui.setting.Slider;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

public class ModuleButton {
	
	public Mod module;
	public Frame parent;
	public int offset;
	public List<Component> components;
	public boolean extended = false;

	public ModuleButton(Mod module, Frame parent, int offset ) {
		this.module = module;
		this.parent = parent;
		this.offset = offset;
		this.extended = false;
		this.components = new ArrayList<>();
		
		
		
		int setOffset = offset;
		for (Setting setting : module.getSettings()) {
			if (setting instanceof BooleanSetting) {
				components.add(new CheckBox(setting, this, setOffset));
			} else if (setting instanceof ModeSetting) {
				components.add(new ModeBox(setting, this, setOffset));
			} else if (setting instanceof NumberSetting) {
				components.add(new Slider(setting, this, setOffset));
			}
			setOffset += parent.height;
		}
	}
	
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		DrawableHelper.fill(matrices, parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, new Color(30, 30, 30, 160).getRGB());
		if (isHovered(mouseX, mouseY)) DrawableHelper.fill(matrices, parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, new Color(30, 30, 30, 160).getRGB());
		
		int toffset = ((parent.height/2) - parent.mc.textRenderer.fontHeight / 2);
		parent.mc.textRenderer.drawWithShadow(matrices, module.getName(), parent.x + toffset, parent.y + toffset + offset + 1, module.isEnabled() ? Color.GREEN.getRGB() : -1); 
	
		if (extended) {
			for (Component component : components)  {
				component.render(matrices, mouseX, mouseY, delta);
			}
		}
	}
	
	
	public void mouseClicked(double mouseX, double mouseY, int button) {
		if (isHovered(mouseX, mouseY)) {
			if (button == 0) {
				module.toggle();
			} else if (button == 1){
				extended = !extended;
				parent.updateButtons();
				Client.INSTANCE.logger.info(extended);
			}
		}
		
		for (Component component : components)  {
			component.mouseClicked(mouseX, mouseY, button);
		}
	}
	
	public void mouseReleased(double mouseX, double mouseY, int button) {
		for (Component component : components)  {
			component.mouseReleased(mouseX, mouseY, button);
		}
	}

	public boolean isHovered(double mouseX, double mouseY) {
		return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + offset && mouseY < parent.y + offset + parent.height;
	}
}
