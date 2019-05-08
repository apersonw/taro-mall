package org.rxjava.service.goods;

import org.rxjava.apikit.tool.Manager;
import org.rxjava.apikit.tool.ObjectFactory;
import org.rxjava.apikit.tool.analyse.Analyse;
import org.rxjava.apikit.tool.analyse.MessageAnalyse;
import org.rxjava.apikit.tool.analyse.impl.ClassPathAnalyse;
import org.rxjava.apikit.tool.analyse.impl.ClassPathMessageAnalyse;
import org.rxjava.apikit.tool.generator.Context;
import org.rxjava.apikit.tool.generator.impl.JavaClientApiGenerator;
import org.rxjava.apikit.tool.generator.impl.PatternNameMaper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.File;

/**
 * @author happy 2019-05-08 23:17
 */
@SpringBootApplication
public class RxGoodsBuilder implements CommandLineRunner {
    /**
     * 构建api
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxGoodsBuilder.class).web(WebApplicationType.NONE).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        //模块绝对路径
        String moduleAbsolutePath = getModuleAbsolutePath("service-goods");
        //java源码文件夹
        String javaSourceDir = new File(moduleAbsolutePath, "src/main/java/").getAbsolutePath();

        //生成后的JavaApi文件夹
        String javaClientDir = new File(moduleAbsolutePath, "src/test/java/").getAbsolutePath();

        Manager manager = new Manager();

        //开始分析
        manager.setJavaSourceDir(javaSourceDir);
        manager.setRootPackage("org.rxjava.service.goods");
        manager.setObjectFactory(objectFactory);
        manager.analyse();

        //JavaApi生成
        {
            //开始生成api
            JavaClientApiGenerator generator = new JavaClientApiGenerator();
            generator.setOutPath(javaClientDir);
            generator.setApiNameMaper(new PatternNameMaper(
                    "(?<name>.*)Controller", "${name}Api"
            ));
            generator.setRootPackage("org.rxjava.service.goods.client");
            manager.generate(generator);
        }
    }

    /**
     * 获取指定模块绝对路径
     */
    private String getModuleAbsolutePath(String module) {
        File root = new File(module);
        if (!root.exists()) {
            root = new File("rxjava-service/", module);
        }
        if (!root.exists()) {
            root = new File(".");
        }
        return root.getAbsolutePath();
    }

    /**
     * Manager需要的对象创建工厂
     */
    private static ObjectFactory objectFactory = new ObjectFactory() {
        @Override
        public Context createContext() {
            return new Context();
        }

        @Override
        public Analyse createAnalyse() {
            return new ClassPathAnalyse();
        }

        @Override
        public MessageAnalyse createMessageAnalyse() {
            return new ClassPathMessageAnalyse();
        }
    };

}