import { AbstractApi } from 'rxjava-api-core';

class TestApi extends AbstractApi {
  testRequest() {
    return super._request();
  };
}

export { TestApi };
const testApi = new TestApi();
export default testApi;
