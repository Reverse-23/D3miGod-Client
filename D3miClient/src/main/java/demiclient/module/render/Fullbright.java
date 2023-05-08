package demiclient.module.render;

import demiclient.module.Mod;
import demiclient.module.setting.ISimpleOption;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Fullbright extends Mod {

    public Fullbright() {
        super("Fullbright", "night vision", Category.RENDER);
    }
    
    @SuppressWarnings("unchecked")
    
	@Override
    public void onTick() {
        if (this.isEnabled()) {
        	mc.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 500, 255)); //((ISimpleOption<Double>) (Object) mc.options.getGamma()).setValueUnrestricted(100.0d);
            
            


    }

}
    @Override
    public void onDisable() {
    	
    	mc.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
    	super.onDisable();
    }
}
