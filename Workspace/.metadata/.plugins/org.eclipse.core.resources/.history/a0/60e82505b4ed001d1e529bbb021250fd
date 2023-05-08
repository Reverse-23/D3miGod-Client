package demiclient.module.misc;

import org.lwjgl.glfw.GLFW;

import demiclient.module.Mod;
import demiclient.module.Mod.Category;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class AutoEat extends Mod{

	private int hunger = 3;
	
	public AutoEat() {
		super("AutoEat", "AutoEat", Category.QOL);
		
	}
	
	@Override
	public void onTick() {
		if(mc.player.getHungerManager().getFoodLevel() <= hunger) {
			int foodSlot= -1;
			FoodComponent bestFood = null;
			for(int i = 0; i< 9; i++) {
				Item item = mc.player.getInventory().getStack(i).getItem();
				
				if(!item.isFood()) {
					continue;
				}
				FoodComponent food = item.getFoodComponent();
				if(bestFood != null) {
					if(food.getHunger() > bestFood.getHunger()) {
						bestFood = food;
						foodSlot = i;
					}
				}else {
					bestFood = food;
					foodSlot = i;
				}
				
			}
			
		    if(bestFood != null) {
		    	mc.player.getInventory().selectedSlot = foodSlot;
		    	mc.options.useKey.setPressed(true);
		    }
		}
		super.onTick();
	}
}
