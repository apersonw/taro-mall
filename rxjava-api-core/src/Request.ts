export interface RequestParamsType {
    /**
     * 微服务Id
     */
    serviceId: string;
    /**
     * 方法：Get，Post等
     */
    method: string;
    /**
     * 请求路径
     */
    url: string;
    /**
     * 路径参数
     */
    pathVars: any;
    /**
     * 表单参数
     */
    formVars: any;
}

interface Request {
    /**
     * 初始化
     */
    init(params: RequestParamsType): any;

    /**
     * 开始
     */
    start<T>(): Promise<T>;
}

export default Request;
