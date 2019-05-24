import Request, { RequestParamsType } from './Request';

const NAMES_PATTERN = /\{([^\}]+?)\}/g;
const SERVICE_PATTERN = /^rxjava-apis-person-(.+)/g;

class RequestImpl implements Request {
  params: { method: string; serviceId: string; formVars: any; url: string };

  init(params: RequestParamsType): any {
    let { serviceId, method, url, pathVars, formVars } = params;
    if (pathVars) {
      url = url.replace(NAMES_PATTERN, key => {
        return encodeURIComponent(pathVars[key]);
      });
    }
    this.params = { serviceId, method, url, formVars };
  }

  start<T>(): Promise<T> {
    console.log('hello');
    return undefined;
  }
}

export default RequestImpl;