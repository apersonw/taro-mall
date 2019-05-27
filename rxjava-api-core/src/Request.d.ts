export interface RequestParamsType {
    serviceId: string;
    method: string;
    url: string;
    pathVars: any;
    formVars: any;
}
/**
 * 请求接口,由客户端实现
 */
interface Request {
    init(params: RequestParamsType): any;
    start<T>(): Promise<T>;
}
export default Request;
