package org.springframework.social.bitly.api.impl.json;

import java.util.List;

import org.springframework.social.bitly.api.Link;
import org.springframework.social.bitly.api.impl.json.deserializers.LinkInfoDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize( using=LinkInfoDeserializer.class)
public class LinkInfoResponse extends BitlyResponse<List<Link>> {
}