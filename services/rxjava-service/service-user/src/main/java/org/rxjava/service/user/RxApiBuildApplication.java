package org.rxjava.service.user;

import org.rxjava.apikit.tool.ApiGenerateManager;
import org.rxjava.apikit.tool.generator.impl.JavaClientApiGenerator;
import org.rxjava.apikit.tool.generator.impl.JavaScriptApiGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.File;

/**
 * @author happy
 */
@SpringBootApplication
public class RxApiBuildApplication implements CommandLineRunner {
    /**
     * 构建api
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxApiBuildApplication.class).web(WebApplicationType.NONE).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        //模块绝对路径
        String moduleAbsolutePath = getModuleAbsolutePath("service-user");
        //java源码文件夹
        String javaSourceDir = new File(moduleAbsolutePath, "src/main/java/").getAbsolutePath();
        //设置Java生成后的文件夹路径
        String javaOutPath = new File(moduleAbsolutePath, "../../rxjava-test/test-user/src/test/java/").getAbsolutePath();
        //设置Js生成后的文件夹路径
        String jsOutPath = new File(moduleAbsolutePath, "src/test/js/").getAbsolutePath();

        //配置java客户端生成器
        JavaClientApiGenerator javaClientApiGenerator = new JavaClientApiGenerator();
        javaClientApiGenerator.setOutPath(javaOutPath);
        javaClientApiGenerator.setRootPackage("org.rxjava.test.user.http");

        //配置js客户端生成器
        JavaScriptApiGenerator javaScriptApiGenerator = new JavaScriptApiGenerator();
        javaScriptApiGenerator.setOutPath(jsOutPath);

        //初始化api生成管理器
        ApiGenerateManager apiGenerateManager = new ApiGenerateManager(javaSourceDir, "org.rxjava.service.user");

        //开始生成java客户端Api
        apiGenerateManager.generateJavaApi(javaClientApiGenerator);

        //开始生成java script客户端Api
//        apiGenerateManager.generateJavaScriptApi(javaScriptApiGenerator);
    }

    /**
     * 获取指定模块绝对路径
     */
    private String getModuleAbsolutePath(String module) {
        File root = new File(module);
        if (!root.exists()) {
            root = new File("services/rxjava-service/", module);
        }
        if (!root.exists()) {
            root = new File("rxjava-service/", module);
        }
        if (!root.exists()) {
            root = new File(".");
        }
        return root.getAbsolutePath();
    }

}
