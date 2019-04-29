import { stringify } from 'qs';
import request from '@/utils/request';

export async function queryProjectNotice() {
  return request('/server/aliapi/project/notice');
}

export async function queryActivities() {
  return request('/server/aliapi/activities');
}

export async function queryOrder(params) {
  return request(`/api/order/admin/orderPage?${stringify(params)}`);
}

export async function queryUser(params) {
  return request(`/api/user/admin/userPage?${stringify(params)}`);
}

export async function queryBrand(params) {
  return request(`/api/goods/admin/brandPage?${stringify(params)}`);
}

export async function queryCategory(params) {
  return request(`/api/goods/admin/categoryPage?${stringify(params)}`);
}

export async function queryGoods(params) {
  return request(`/api/goods/admin/goodsPage?${stringify(params)}`);
}

export async function queryRule(params) {
  return request(`/server/aliapi/rule?${stringify(params)}`);
}

export async function removeRule(params) {
  return request('/server/aliapi/rule', {
    method: 'POST',
    body: {
      ...params,
      method: 'delete',
    },
  });
}

export async function addRule(params) {
  return request('/server/aliapi/rule', {
    method: 'POST',
    body: {
      ...params,
      method: 'post',
    },
  });
}

export async function updateRule(params = {}) {
  return request(`/server/aliapi/rule?${stringify(params.query)}`, {
    method: 'POST',
    body: {
      ...params.body,
      method: 'update',
    },
  });
}

export async function fakeSubmitForm(params) {
  return request('/server/aliapi/forms', {
    method: 'POST',
    body: params,
  });
}

export async function fakeChartData() {
  return request('/server/aliapi/fake_chart_data');
}

export async function queryTags() {
  return request('/server/aliapi/tags');
}

export async function queryBasicProfile(id) {
  return request(`/server/aliapi/profile/basic?id=${id}`);
}

export async function queryAdvancedProfile() {
  return request('/server/aliapi/profile/advanced');
}

export async function queryFakeList(params) {
  return request(`/server/aliapi/fake_list?${stringify(params)}`);
}

export async function removeFakeList(params) {
  const { count = 5, ...restParams } = params;
  return request(`/server/aliapi/fake_list?count=${count}`, {
    method: 'POST',
    body: {
      ...restParams,
      method: 'delete',
    },
  });
}

export async function addFakeList(params) {
  const { count = 5, ...restParams } = params;
  return request(`/server/aliapi/fake_list?count=${count}`, {
    method: 'POST',
    body: {
      ...restParams,
      method: 'post',
    },
  });
}

export async function updateFakeList(params) {
  const { count = 5, ...restParams } = params;
  return request(`/server/aliapi/fake_list?count=${count}`, {
    method: 'POST',
    body: {
      ...restParams,
      method: 'update',
    },
  });
}

export async function fakeAccountLogin(params) {
  return request('/server/aliapi/login/account', {
    method: 'POST',
    body: params,
  });
}

export async function fakeRegister(params) {
  return request('/server/aliapi/register', {
    method: 'POST',
    body: params,
  });
}

export async function queryNotices(params = {}) {
  return request(`/server/aliapi/notices?${stringify(params)}`);
}

export async function getFakeCaptcha(mobile) {
  return request(`/server/aliapi/captcha?mobile=${mobile}`);
}
