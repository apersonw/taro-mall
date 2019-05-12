package org.rxjava.test.user.http.client;

import reactor.core.publisher.Mono;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Future;

import org.rxjava.apikit.client.*;

import org.rxjava.test.user.http.form.LoginByPhoneSmsForm;

public class UserApi {
	private ClientAdapter clientAdapter;

	public UserApi() {
	}

	public UserApi(ClientAdapter clientAdapter) {
		this.clientAdapter = clientAdapter;
	}

	public Mono<String> getCurrentUser() {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("currentUser", _uriVariables);

		return clientAdapter.request("GET", _url, null, _0Type);
	}

	public Mono<String> loginByPhoneSms(LoginByPhoneSmsForm form) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("loginByPhoneSms", _uriVariables);

		List<Entry<String, Object>> _form = form.encode("", new ArrayList<>());
		return clientAdapter.request("POST", _url, _form, _1Type);
	}

	public Mono<String> system() {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("", _uriVariables);

		return clientAdapter.request("GET", _url, null, _2Type);
	}

	public void setclientAdapter(ClientAdapter clientAdapter) {
		this.clientAdapter = clientAdapter;
	}

	public ClientAdapter getclientAdapter() {
		return clientAdapter;
	}

	private static final ApiType _0Type = ApiUtils.type(String.class);
	private static final ApiType _1Type = ApiUtils.type(String.class);
	private static final ApiType _2Type = ApiUtils.type(String.class);
}