package org.rxjava.service.goods.model;

import lombok.Data;
import org.rxjava.common.core.entity.KeyValue;

import java.util.List;

@Data
public class SkuAndGroupModel {
    private List<SkuModel> skuList;
    private List<KeyValue<String, List<String>>> skuGroupList;
}
