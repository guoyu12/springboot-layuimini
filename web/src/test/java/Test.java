import com.anshark.utils.DateUtils;
import java.util.Date;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
public class Test {

    public static void main(String[] args) {
        for (int i = 0; i <= 6; i++) {
            Date date = DateUtils.day(0 - i);
            String dateStr = DateUtils.getDateStr(date,DateUtils.DATE);
            System.out.println(dateStr);
        }
    }
}
