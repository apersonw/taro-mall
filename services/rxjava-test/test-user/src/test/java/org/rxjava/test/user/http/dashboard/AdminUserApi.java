package org.rxjava.test.user.http.dashboard;

import reactor.core.publisher.Mono;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Future;

import org.rxjava.apikit.client.*;

import org.rxjava.test.user.http.entity.User;
import org.rxjava.test.user.http.form.UserPageForm;
import org.rxjava.test.user.http.domain.Page;

public class AdminUserApi {
	private ClientAdapter clientAdapter;

	public AdminUserApi() {
	}

	public AdminUserApi(ClientAdapter clientAdapter) {
		this.clientAdapter = clientAdapter;
	}

	public Mono<Page<User>> getPage(UserPageForm form) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("admin/userPage", _uriVariables);

		List<Entry<String, Object>> _form = form.encode("", new ArrayList<>());
		return clientAdapter.request("GET", _url, _form, _0Type);
	}

	public void setclientAdapter(ClientAdapter clientAdapter) {
		this.clientAdapter = clientAdapter;
	}

	public ClientAdapter getclientAdapter() {
		return clientAdapter;
	}

	private static final ApiType _0Type = ApiUtils.type(Page.class, ApiUtils.type(User.class));
}