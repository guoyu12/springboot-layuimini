import com.anshark.GyadminApplication;
import com.anshark.dao.GyMenusDao;
import com.anshark.model.GyMenus;
import com.anshark.utils.SpringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GyadminApplication.class)
public class BaseTest {

    @Test
    public void test1(){
        GyMenusDao bean = SpringUtils.getBean(GyMenusDao.class);
        List<GyMenus> menusBy = bean.getMenusBy(0, 0, Arrays.asList(1, 2));
        System.out.println(menusBy);
    }
}
