import request from '@/utils/request';

export async function query() {
  return request('/server/aliapi/users');
}

export async function queryCurrent() {
  return request('/server/aliapi/currentUser');
}
