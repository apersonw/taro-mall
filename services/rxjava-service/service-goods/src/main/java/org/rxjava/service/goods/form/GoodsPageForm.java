package org.rxjava.service.goods.form;

import lombok.Data;

/**
 * @author happy 2019-03-28 21:32
 */
@Data
public class GoodsPageForm {
    private int page = 0;
    private int pageSize = 10;
}
