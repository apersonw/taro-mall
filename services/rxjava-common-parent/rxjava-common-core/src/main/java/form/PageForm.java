package form;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author happy 2019-04-27 10:53
 */
@Data
public class PageForm {
    /**
     * 页码
     */
    @Min(value = 0, message = "页面最小为0")
    private int page = 0;
    /**
     * 页大小
     */
    @Min(value = 1, message = "页大小最小为1")
    @Max(value = 100, message = "页大小最大为100")
    private int pageSize = 10;
}
