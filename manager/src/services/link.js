import request from '@/utils/request';

export async function queryLocations() {
  return request('/api/link/admin/linkLocations');
}
