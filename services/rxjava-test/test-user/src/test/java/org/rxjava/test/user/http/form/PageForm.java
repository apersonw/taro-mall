package org.rxjava.test.user.http.form;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

@Getter
@Setter
public class PageForm {

	private int page;
	private int pageSize;

	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {

		$list.add(new SimpleImmutableEntry<>($parent + "page", page));

		$list.add(new SimpleImmutableEntry<>($parent + "pageSize", pageSize));
		return $list;
	}
}