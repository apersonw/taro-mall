declare class AbstractApi {
  name: string;

  constructor(name: string);

  request<T>(serviceId: string, method: string, url: string, pathVars: object, formVars: object): Promise<T>;
}

export default AbstractApi;
