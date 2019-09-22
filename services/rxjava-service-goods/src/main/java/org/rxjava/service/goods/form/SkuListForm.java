package org.rxjava.service.goods.form;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author happy 2019-03-29 15:10
 */
@Data
public class SkuListForm {
    @Min(value = 0, message = "页码从0开始，表示第一页")
    private int page = 0;
    @Max(value = 200, message = "页大小，最大为200")
    private int pageSize = 10;
}
