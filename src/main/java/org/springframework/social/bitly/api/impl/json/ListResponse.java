package org.springframework.social.bitly.api.impl.json;

import java.util.List;

public interface ListResponse<T> {
	List<T> getData();
}
