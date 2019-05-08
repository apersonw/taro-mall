package org.rxjava.service.manager.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author happy 2019-05-08 15:51
 * 新建/编辑角色
 */
@Data
public class RoleSaveForm {
    /**
     * 上级角色Id
     */
    private String parentId;
    @NotEmpty
    private String name;
}
