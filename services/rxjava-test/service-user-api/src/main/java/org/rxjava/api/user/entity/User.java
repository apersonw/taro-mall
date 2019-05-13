package org.rxjava.api.user.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

@Getter
@Setter
public class User {

	private Resource avatar;
	private Date createDate;
	private String id;
	private String nickname;
	private Date updateDate;

	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {

		if (avatar != null) {
			avatar.encode($parent + "avatar.", $list);
		}

		if (createDate != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "createDate", createDate));
		}

		if (id != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "id", id));
		}

		if (nickname != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "nickname", nickname));
		}

		if (updateDate != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "updateDate", updateDate));
		}
		return $list;
	}
}