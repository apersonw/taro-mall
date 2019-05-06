package org.rxjava.service.link.form;

import lombok.Data;
import org.rxjava.common.core.status.Status;

/**
 * @author happy 2019-04-27 10:43
 */
@Data
public class LinkLocationSaveForm {
    private String id;
    /**
     * 位置名称
     */
    private String name;
    /**
     * 备注
     */
    private String remark;
    /**
     * 位置状态
     */
    private String status = Status.NORMAL.name();
}
