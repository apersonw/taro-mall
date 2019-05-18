package org.rxjava.api.user.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

@Getter
@Setter
public class LoginInfo {

	private String identityType;
	private String userAuthId;
	private String userId;

	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {

		if (identityType != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "identityType", identityType));
		}

		if (userAuthId != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "userAuthId", userAuthId));
		}

		if (userId != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "userId", userId));
		}
		return $list;
	}
}