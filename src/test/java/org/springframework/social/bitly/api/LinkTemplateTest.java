package org.springframework.social.bitly.api;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.social.bitly.api.impl.BitlyTemplate;
import org.springframework.social.bitly.api.impl.LinkTemplate;
import org.springframework.social.bitly.api.impl.json.LinkInfoResponse;
import org.springframework.util.Assert;

@RunWith( BlockJUnit4ClassRunner.class )
public class LinkTemplateTest {

	private static final String BIT_LINK = "http://bit.ly/1L9ZgQ9";

	private static final String ACCESS_TOKEN = "ecf511940ebbaae77aaf611a26b33f0a5a152d82";

	private BitlyTemplate bitlyTemplate;
	
	private LinkTemplate linkTemplate;
	
	@Before
	public void setUp(){
		bitlyTemplate = new BitlyTemplate( ACCESS_TOKEN );

		linkTemplate = new LinkTemplate( bitlyTemplate.getRestTemplate() );
	}
	
	@Test
	public void expand(){
		List<Link> links = linkTemplate.expand( Arrays.asList( BIT_LINK ), Arrays.asList( "sQRdoJ" ) );
		for (Link link : links) {
			Assert.notNull( link.getGlobalHash() );
		}
		Assert.notEmpty( links, "Links could not be empty!" );
	}
	
	@Test
	public void info(){
		List<Link> links = linkTemplate.info( Arrays.asList( BIT_LINK ), Arrays.asList( "sQRdoJ" ) );
		for (Link link : links) {
			Assert.notNull( link.getCreatedAt() );
			Assert.notNull( link.getCreatedBy() );
		}
		Assert.notEmpty( links, "Links could not be empty!" );
	}
	
	@Test
	public void expand2(){
		LinkInfoResponse links = linkTemplate.expand2( Arrays.asList( BIT_LINK ), Arrays.asList( "sQRdoJ" ) );
		List<Link> data = links.getData();
		for (Link link : data) {
			Assert.notNull( link.getGlobalHash() );
		}
		Assert.notEmpty( data, "Links could not be empty!" );
	}
}
