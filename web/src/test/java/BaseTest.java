import com.alibaba.fastjson.JSONObject;
import com.anshark.GyadminApplication;
import com.anshark.dao.GyMenusDao;
import com.anshark.model.GyMenus;
import com.anshark.utils.Md5Utils;
import com.anshark.utils.SpringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GyMenusDao gyMenusDao;

    @Test
    public void test1(){
        System.out.println(Md5Utils.md5("test"));
    }

    @Test
    public void test2(){
        List<GyMenus> menuInfo = gyMenusDao.getMenusBy(4, 2, Arrays.asList(5,6,7));

        System.out.println(JSONObject.toJSONString(menuInfo));
    }
}
