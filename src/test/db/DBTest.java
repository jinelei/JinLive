import cn.jinelei.live.dao.RoomMapper;
import cn.jinelei.live.dao.UserMapper;
import cn.jinelei.live.model.Room;
import cn.jinelei.live.model.RoomExample;
import cn.jinelei.live.model.User;
import cn.jinelei.live.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.sql.SQLException;

/**
 * Created by jinelei on 17-4-3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:live-servlet.xml", "classpath:spring-config.xml"})
@WebAppConfiguration
public class DBTest {
    private static final Logger logger = LoggerFactory.getLogger(DBTest.class);
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private UserService userService;

    @Test
    public void test() throws SQLException {
        assert sqlSessionFactory != null;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        logger.debug(sqlSession.getConnection().getCatalog());
        assert userMapper != null;
        User user = userMapper.selectByPrimaryKey(1);
        logger.debug(String.valueOf(user));

        assert roomMapper != null;
        RoomExample example = new RoomExample();
        example.createCriteria().andUserIdEqualTo(1);
        Room room = roomMapper.selectByExample(example).get(0);
        logger.debug(String.valueOf(room));


    }


    @Test
    public void testUserService() {
        assert userService != null;
    }

}
