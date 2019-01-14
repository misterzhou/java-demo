import org.guojing.test.spring.model.Group;
import org.guojing.test.spring.model.User;
import org.guojing.test.spring.service.IGroupUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created at: 2018-11-18 11:56
 *
 * @author guojing
 */
public class SpringBeanTest {

    public static void main(String[] args) {
        User user1 = new User().setUserId(1000).setUsername("zhangsan").setPhone("18510921234");
        User user2 = new User().setUserId(1500).setUsername("lisi").setPhone("18510001111");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IGroupUserService groupUserService = (IGroupUserService) context.getBean("groupUserService");
        Group tempGroup = groupUserService.createTempGroup(Arrays.asList(user1, user2));
    }

}
