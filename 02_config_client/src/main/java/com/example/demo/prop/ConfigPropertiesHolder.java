package com.example.demo.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class ConfigPropertiesHolder {
	
	@Value("${my.test.defaultprop}")
	private String defaultProp;
	
	@Value("${my.test.serviceprop}")
	private String serviceProp;
	
	@Value("${my.test.envprop:default env value}")
	private String envProp;

	public String getDefaultProp() {
		return defaultProp;
	}

	public void setDefaultProp(String defaultProp) {
		this.defaultProp = defaultProp;
	}

	public String getServiceProp() {
		return serviceProp;
	}

	public void setServiceProp(String serviceProp) {
		this.serviceProp = serviceProp;
	}

	public String getEnvProp() {
		return envProp;
	}

	public void setEnvProp(String envProp) {
		this.envProp = envProp;
	}

	@Override
	public String toString() {
		return "{\"defaultProp:\" " + defaultProp + ", "
				+ "\"serviceProp: \"" + serviceProp + ", "
						+ "\"envProp: \"" + envProp + "]";
	}

}
