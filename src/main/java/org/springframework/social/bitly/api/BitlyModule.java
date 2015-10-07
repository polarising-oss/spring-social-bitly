package org.springframework.social.bitly.api;

import org.springframework.social.bitly.api.impl.json.LinkMixin;

import com.fasterxml.jackson.databind.module.SimpleModule;

@SuppressWarnings("serial")
public class BitlyModule extends SimpleModule{

	public BitlyModule() {
		super( "BitlyModule" );
	}
	
	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(Link.class, LinkMixin.class);
	}
}
