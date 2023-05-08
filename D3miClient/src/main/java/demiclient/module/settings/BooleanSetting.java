package demiclient.module.settings;

public class BooleanSetting extends Setting{
	
	private boolean enabled;
	
	public BooleanSetting(String name, boolean defaultValue) {
		super(name);
		this.enabled = defaultValue;
	}
	
	public void Toggle() {
		this.enabled = !this.enabled;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
