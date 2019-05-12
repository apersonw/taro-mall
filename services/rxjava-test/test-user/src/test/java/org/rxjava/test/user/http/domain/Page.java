package org.rxjava.test.user.http.domain;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

@Getter
@Setter
public class Page<T> {

	private long totalElements;
	private int totalPages;

	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {
		throw new RuntimeException("不支持泛型");
	}
}