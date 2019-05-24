declare class AbstractApi {
  constructor();

  request<T>(serviceId: string, method: string, url: string, pathVars: object, formVars: object): Promise<T>;
}

export default AbstractApi;