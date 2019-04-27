import request from '@/utils/request';

export async function queryProvince() {
  return request('/server/aliapi/geographic/province');
}

export async function queryCity(province) {
  return request(`/server/aliapi/geographic/city/${province}`);
}
