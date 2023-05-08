package demiclient.module;

import java.util.ArrayList;

import java.util.List;

import demiclient.module.Mod.Category;
import demiclient.module.Movement.*;
import demiclient.module.combat.combat.*;
import demiclient.module.misc.AutoEat;
import demiclient.module.misc.OnList;
import demiclient.module.render.Fullbright;
import demiclient.module.render.NoPumpking;
import demiclient.module.world.AutoRespawn;
import demiclient.module.world.Freecam;

public class ModuleManager {
	
	public static final ModuleManager INSTANCE = new ModuleManager();
	private List<Mod> modules = new ArrayList<>();

	public ModuleManager() {
		addModules();
	}
	
	public List<Mod> getModules() {
		return modules;
	}

	public List<Mod> getEnabledModules() {
		List<Mod> enabled = new ArrayList<>();
		for (Mod module : modules) {
			if (module.isEnabled()) enabled.add(module);
		}
		
		return enabled;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Mod> T getModule(Class<T> clazz) { 
        return (T) modules.stream().filter(mod -> mod.getClass() == clazz).findFirst().orElse(null); 
    }
	
	
	public List<Mod> getModulesInCategory(Category category) {
		List<Mod> categoryModules = new ArrayList<>();
		
		for(Mod mod : modules) {
			if (mod.getCategory() == category) {
				categoryModules.add(mod);
			}
		}
		
		return categoryModules;
	}
	
	private void addModules() {
		//modules.add(new Flight());
		modules.add(new Sprint());
		//modules.add(new OnList());
		modules.add(new Sneak());
		modules.add(new AutoRespawn());
		modules.add(new Fullbright());
		modules.add(new Offhand());
		modules.add(new NoPumpking());
		modules.add(new Freecam());
		modules.add(new AutoArmor());
		modules.add(new AutoEat());
	}
	
	public Mod getModuleByName(String moduleName) {
		for(Mod mod : modules) {
			if ((mod.getName().trim().equalsIgnoreCase(moduleName)) || (mod.toString().trim().equalsIgnoreCase(moduleName.trim()))) {
				return mod;
			}
		}
		return null;
	}
	
	
	
}
