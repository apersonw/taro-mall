package org.rxjava.api.user.client.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

@Getter
@Setter
public class Resource {

	private int height;
	private String key;
	private int width;

	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<>($parent + "height", height));

		if (key != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "key", key));
		}

		$list.add(new SimpleImmutableEntry<>($parent + "width", width));
		return $list;
	}
}