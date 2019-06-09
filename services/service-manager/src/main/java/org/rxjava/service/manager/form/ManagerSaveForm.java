package org.rxjava.service.manager.form;

import lombok.Data;
import org.rxjava.common.core.entity.Resource;

/**
 * @author happy 2019-05-08 15:54
 * 新建/编辑管理者
 */
@Data
public class ManagerSaveForm {
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private Resource avatar;
}
