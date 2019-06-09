package org.rxjava.service.manager.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author happy 2019-05-08 16:01
 * 新建/编辑权限
 */
@Data
public class PermissionSaveForm {
    /**
     * 权限名称
     */
    @NotEmpty
    private String name;
    /**
     * 权限路径
     */
    @NotEmpty
    private String path;
    /**
     * 请求方法
     */
    @NotEmpty
    private String method;
}
