package cn.glutnn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class DemoApplicationTests {
    @Test
    void contextLoads() {

        String password=DigestUtils.md5DigestAsHex("123456".getBytes());


        System.out.println(password);
    }

}
