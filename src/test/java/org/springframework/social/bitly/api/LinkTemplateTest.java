package org.springframework.social.bitly.api;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.social.bitly.api.impl.BitlyTemplate;
import org.springframework.social.bitly.api.impl.LinkTemplate;
import org.springframework.util.Assert;

@RunWith( BlockJUnit4ClassRunner.class )
public class LinkTemplateTest {

	private static final String ACCESS_TOKEN = "4a3d07c72b77b1bd640f4f442ce021ac18a4978d";

	private BitlyTemplate bitlyTemplate;
	
	private LinkTemplate linkTemplate;
	
	@Before
	public void setUp(){
		bitlyTemplate = new BitlyTemplate( ACCESS_TOKEN );

		linkTemplate = new LinkTemplate( bitlyTemplate.getRestTemplate() );
	}
	
	@Test
	public void expand(){
		List<Link> links = linkTemplate.expand( Arrays.asList( "http://bit.ly/vfK6Km" ), Arrays.asList( "asQRdoJ" ) );
		for (Link link : links) {
			Assert.notNull( link.getGlobalHash() );
		}
		Assert.notEmpty( links, "Links could not be empty!" );
	}
}
