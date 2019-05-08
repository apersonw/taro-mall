package org.rxjava.service.manager.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author happy 2019-05-08 15:45
 * 分配权限给管理者
 */
@Data
public class PermissionToRoleForm {
    @NotEmpty
    private String roleId;
    @NotEmpty
    private List<String> permissionIds;
}
