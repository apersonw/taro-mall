package org.rxjava.service.manager.dashboard;

import org.apache.commons.lang3.RandomStringUtils;
import org.rxjava.common.core.annotation.Login;
import org.rxjava.common.core.exception.ErrorMessageException;
import org.rxjava.common.core.utils.KeyUtils;
import org.rxjava.service.manager.entity.*;
import org.rxjava.service.manager.form.*;
import org.rxjava.service.manager.repository.*;
import org.rxjava.service.manager.type.IdentityType;
import org.rxjava.service.starter.boot.LoginInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-27 00:03
 */
@RequestMapping("admin")
@RestController
public class ManagerController {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ManagerPermissionRepository managerPermissionRepository;
    @Autowired
    private ManagerAuthRepository managerAuthRepository;
    @Autowired
    private ManagerRoleRepository managerRoleRepository;
    @Autowired
    private RolePermissionRepository rolePermissionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    /**
     * 管理员账号密码登陆
     */
    @Login(false)
    @PostMapping("login/password")
    public Mono<String> login(
            @Valid ManagerLoginForm form
    ) {
        String token = newToken();
        return managerAuthRepository
                .findByIdentityTypeAndIdentifierAndCredential(
                        IdentityType.USERNAME.name(),
                        form.getUsername(),
                        form.getPassword()
                )
                .flatMap(managerAuth -> reactiveRedisTemplate
                        .opsForValue()
                        .set(KeyUtils.newCacheId(ManagerController.class, token), managerAuth.getManagerId())
                )
                .map(r -> token)
                .switchIfEmpty(ErrorMessageException.mono("用户不存在"));
    }

    /**
     * 查询管理员基本信息
     */
    @GetMapping("manager")
    public Mono<Manager> getManager(
            LoginInfo loginInfo
    ) {
        return managerRepository.findById(loginInfo.getUserId());
    }

    /**
     * 查询管理员分页
     */
    @GetMapping("managers")
    public Mono<Page<Manager>> getManagerPage(
            @Valid ManagerPageForm form
    ) {
        return managerRepository
                .findPage(PageRequest.of(form.getPage(), form.getPageSize()), form);
    }

    /**
     * 查询管理员拥有的权限
     */
    @GetMapping("manager/permissions")
    public Flux<ManagerPermission> getManagerPermissions(
            LoginInfo loginInfo
    ) {
        return managerPermissionRepository.findByManagerId(loginInfo.getUserId());
    }

    /**
     * 给用户分配角色
     */
    @PostMapping("manager/role")
    public Mono<Void> saveRoleToManager(
            @Valid RoleToManagerForm form
    ) {
        return Flux
                .fromIterable(form.getRoleIds())
                .flatMap(roleId -> {
                    ManagerRole managerRole = new ManagerRole();
                    managerRole.setRoleId(roleId);
                    managerRole.setManagerId(form.getManagerId());
                    return managerRoleRepository
                            .save(managerRole);
                })
                .then();
    }

    /**
     * 给角色分配权限
     */
    @PostMapping("manager/role/permissions")
    public Mono<Void> savePermissionToRole(
            @Valid PermissionToRoleForm form
    ) {
        return Flux
                .fromIterable(form.getPermissionIds())
                .flatMap(permissionId -> {
                    RolePermission rolePermission = new RolePermission();
                    rolePermission.setPermissionId(permissionId);
                    rolePermission.setRoleId(form.getRoleId());
                    return rolePermissionRepository
                            .save(rolePermission);
                })
                .then();
    }

    /**
     * 新建/编辑角色
     */
    @PostMapping("role")
    public Mono<Void> saveRole(
            @Valid RoleSaveForm form
    ) {
        Role role = new Role();
        BeanUtils.copyProperties(form, role);
        return roleRepository
                .save(role)
                .then();
    }

    /**
     * 新建/编辑管理者
     */
    @PostMapping("manager")
    public Mono<Void> saveManager(
            @Valid ManagerSaveForm form
    ) {
        Manager manager = new Manager();
        BeanUtils.copyProperties(form, manager);
        return managerRepository
                .save(manager)
                .then();
    }

    /**
     * 新建/编辑权限
     */
    @PostMapping("permission")
    public Mono<Void> savePermission(
            @Valid PermissionSaveForm form
    ) {
        Permission permission = new Permission();
        BeanUtils.copyProperties(form, permission);
        return permissionRepository
                .save(permission)
                .then();
    }

    private String newToken() {
        return RandomStringUtils.randomAlphabetic(32);
    }
}
