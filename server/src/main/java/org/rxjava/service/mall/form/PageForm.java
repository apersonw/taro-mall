package org.rxjava.service.mall.form;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author happy 2019-03-21 23:20
 */
@Data
class PageForm {
    @Min(value = 0, message = "页码必须大于等于0")
    private int page;
    @Max(value = 200, message = "页大小必须大于等于200")
    private int pageSize;
}
