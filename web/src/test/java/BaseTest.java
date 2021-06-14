import com.alibaba.fastjson.JSONObject;
import com.anshark.GyadminApplication;
import com.anshark.dao.GyMenusDao;
import com.anshark.mapper.GyDataStatisticsMapper;
import com.anshark.model.GyDataStatistics;
import com.anshark.model.GyMenus;
import com.anshark.utils.Md5Utils;
import com.anshark.utils.SpringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    @Autowired
    private GyDataStatisticsMapper gyDataStatisticsMapper;

    @Test
    public void test1(){
        System.out.println(Md5Utils.md5("test"));
    }

    @Test
    public void test2(){
        String date = "2021-06-14";
        QueryWrapper<GyDataStatistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_at,'%Y-%m-%d') = '"+date+"'");
        System.out.println(gyDataStatisticsMapper.selectOne(queryWrapper));
    }
}
