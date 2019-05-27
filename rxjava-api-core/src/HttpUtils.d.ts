import Request from './Request';
declare class HttpUtils {
    private static factory;
    static request<T>(serviceId:string, method: string, url: string, pathVars: any, formVars: any): Promise<T>;
    static setFactory(factory: () => Request): void;
}
export default HttpUtils;
