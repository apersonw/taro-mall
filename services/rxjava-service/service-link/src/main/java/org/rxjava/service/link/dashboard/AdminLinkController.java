package org.rxjava.service.link.dashboard;

import org.rxjava.common.core.annotation.Login;
import org.rxjava.service.link.form.LinkLocationSaveForm;
import org.rxjava.service.link.entity.LinkLocation;
import org.rxjava.service.link.form.LinkLocationPageForm;
import org.rxjava.service.link.repository.LinkLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-27 10:35
 */
@RestController
@RequestMapping("admin")
public class AdminLinkController {
    @Autowired
    private LinkLocationRepository linkLocationRepository;

    /**
     * 新建/编辑链接位置
     */
    @PostMapping("linkLocation")
    Mono<LinkLocation> saveLinkLocation(
            @Valid LinkLocationSaveForm form
    ) {
        return Mono.empty();
    }

    /**
     * 查询链接位置分页
     */
    @Login(false)
    @GetMapping("linkLocations")
    Mono<Page<LinkLocation>> getLinkLocationPage(
            @Valid LinkLocationPageForm form
    ) {
        return linkLocationRepository
                .findPage(form, PageRequest.of(form.getPage(), form.getPageSize()));
    }
}
