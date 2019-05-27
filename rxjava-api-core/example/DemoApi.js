import { AbstractApi } from 'rxjava-api-core';

class DemoApi extends AbstractApi {
  test = () => {
    return super._request('test', 'GET', 'testFlux/instant');
  };

}

export { DemoApi };
const demoApi = new DemoApi();
export default demoApi;

