class HttpUtils {
  static factory;

  static request(serviceId, method, url, pathVars, formVars) {
    let request = HttpUtils.factory();
    request.init({ serviceId, method, url, pathVars, formVars });
    return request.start();
  }

  static setFactory(factory) {
    HttpUtils.factory = factory;
  }
}

export default HttpUtils;
