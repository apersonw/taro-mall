package org.rxjava.service.goods.form;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.rxjava.common.core.form.PageForm;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author happy 2019-03-23 00:21
 */
@Data()
public class GoodsListForm {
    /**
     * 类目Id
     */
    private String categoryId;
    /**
     * 品牌Id
     */
    private String brandId;
    /**
     * 商品Ids
     */
    @Size(max = 100, message = "最多查询指定id的100个商品")
    private List<String> goodsIds;
}
