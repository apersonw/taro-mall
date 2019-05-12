package org.rxjava.test.user;

import org.junit.Test;
import org.rxjava.test.user.http.client.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-05-10 17:26
 */
public class TestApplication extends TestBase {

    @Autowired
    private UserApi userApi;

    @Test
    public void testSystem() {
        Mono<String> stringMono = userApi.system();
        String block = stringMono.block();
        System.out.println(block);
    }
}
