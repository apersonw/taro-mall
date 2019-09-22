package org.rxjava.service.goods;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

/**
 * @author happy 2019-05-06 13:57
 */
public class RxServiceGoodsMain {
    public static void main(String[] args) {
        try {
            URLClassLoader cl = (URLClassLoader) ClassLoader.getSystemClassLoader();
            Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addURL.setAccessible(true);
            String[] strPaths = new String[]{"base-lib", "lib"};
            for (String strPath : strPaths) {
                Path path = Paths.get(strPath);
                if (Files.isDirectory(path)) {
                    Consumer<Path> pathConsumer = p -> {
                        try {
                            addURL.invoke(cl, p.toUri().toURL());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    };
                    Files.newDirectoryStream(path).forEach(pathConsumer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        RxServiceGoodsApplication.main(args);
    }
}
