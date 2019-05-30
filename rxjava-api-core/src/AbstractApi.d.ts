declare class AbstractApi {
    _request<T>(serviceId: string, method: string, url: string, pathVars: any, formVars: any): Promise<T>;
}
export default AbstractApi;
