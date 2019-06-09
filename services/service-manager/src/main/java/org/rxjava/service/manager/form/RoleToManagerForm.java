package org.rxjava.service.manager.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author happy 2019-05-08 15:38
 * 分配角色给管理者
 */
@Data
public class RoleToManagerForm {
    @NotEmpty
    private String managerId;
    @NotEmpty
    private List<String> roleIds;
}
