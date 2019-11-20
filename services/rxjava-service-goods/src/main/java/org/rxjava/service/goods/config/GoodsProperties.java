package org.rxjava.service.goods.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author happy 2019/9/22 00:53
 */
@Data
@ConfigurationProperties(prefix = "goods")
public class GoodsProperties {
}
