package demiclient.module.combat.combat;
import java.util.List;

import demiclient.module.Mod;
import demiclient.utils.player.FindItemResult;
import demiclient.utils.player.InventoryUtils;
import net.minecraft.entity.Entity;
import net.minecraft.item.Items;

public class Offhand extends Mod {

	List<Entity> entities;

	
	public Offhand() {
		super("Offhand", "Puts the shit in your offhand", Category.COMBAT);
	}
	@Override
	public void onTick() {
		nullCheck();
		if (mc.player.getOffHandStack().getItem() != Items.TOTEM_OF_UNDYING) {
            FindItemResult iTotem = InventoryUtils.find(itemStack -> itemStack.getItem() == Items.TOTEM_OF_UNDYING, 0, 35);
            if (iTotem.found()) {
            	InventoryUtils.move().from(iTotem.getSlot()).toOffhand();
            } else return;
		}
		super.onTick();
	}
}