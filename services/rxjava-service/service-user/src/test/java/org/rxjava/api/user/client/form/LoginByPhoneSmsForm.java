package org.rxjava.api.user.client.form;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

@Getter
@Setter
public class LoginByPhoneSmsForm {

	private String phone;
	private String sms;

	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {

		if (phone != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "phone", phone));
		}

		if (sms != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "sms", sms));
		}
		return $list;
	}
}