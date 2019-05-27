import {AbstractApi} from 'rxjava-api-core'

/**
 * Demo
*/
declare class DemoApi extends AbstractApi {
    test():Promise<String>;
}
export { DemoApi };
declare const demoApi: DemoApi;
export default demoApi;