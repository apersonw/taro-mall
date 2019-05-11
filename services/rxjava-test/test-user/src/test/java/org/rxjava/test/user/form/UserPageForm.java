package org.rxjava.test.user.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map.Entry;

@Getter
@Setter
public class UserPageForm {

	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {
		return $list;
	}
}