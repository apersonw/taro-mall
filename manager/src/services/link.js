import request from '@/utils/request';
import { stringify } from 'qs';

export async function queryLocations(params = {}) {
  return request(`/api/link/admin/linkLocations?${stringify(params)}`);
}
