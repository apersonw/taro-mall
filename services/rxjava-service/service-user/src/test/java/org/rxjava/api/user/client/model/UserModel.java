package org.rxjava.api.user.client.model;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;
import org.rxjava.api.user.client.entity.Resource;

@Getter
@Setter
public class UserModel {

	private Resource avatar;
	private String id;
	private String nickname;

	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {

		if (avatar != null) {
			avatar.encode($parent + "avatar.", $list);
		}

		if (id != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "id", id));
		}

		if (nickname != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "nickname", nickname));
		}
		return $list;
	}
}