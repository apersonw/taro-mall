package org.rxjava.api.user.form;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

@Getter
@Setter
public class UserPageForm extends PageForm {

	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {
		return $list;
	}
}