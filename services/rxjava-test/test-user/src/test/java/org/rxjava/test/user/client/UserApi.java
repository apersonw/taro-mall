package org.rxjava.test.user.client;

import reactor.core.publisher.Mono;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Future;

import org.rxjava.apikit.client.*;

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

	public Mono<String> loginByPhoneSms() {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("loginByPhoneSms", _uriVariables);

		return clientAdapter.request("POST", _url, null, _1Type);
	}

	public void setclientAdapter(ClientAdapter clientAdapter) {
		this.clientAdapter = clientAdapter;
	}

	public ClientAdapter getclientAdapter() {
		return clientAdapter;
	}

	private static final ApiType _0Type = ApiUtils.type(String.class);
	private static final ApiType _1Type = ApiUtils.type(String.class);
}