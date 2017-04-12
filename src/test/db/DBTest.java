import cn.jinelei.live.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jinelei on 17-4-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/live-servlet.xml", "classpath:spring-config.xml"})
public class DBTest {

    @Autowired
    UserService userService;

    @Test
    public void userService() {
        assert userService != null;
    }
}
