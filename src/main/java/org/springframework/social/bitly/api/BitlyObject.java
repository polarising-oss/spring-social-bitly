package org.springframework.social.bitly.api;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author bramos
 *
 */
public abstract class BitlyObject{

	private Map<String, Object> extraData;
	
	public BitlyObject() {
		extraData = new HashMap<>();
	}
	
	public Map<String, Object> getExtraData() {
		return extraData;
	}
	
	public void add(String key, Object value){
		extraData.put(key, value);
	}
}
