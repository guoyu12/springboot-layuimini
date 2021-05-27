import com.anshark.model.GyUserPerm;
import com.anshark.model.GyUsers;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
public class Test {

    public static void main(String[] args) {

        GyUsers gyUsers = new GyUsers();

        Object o = new GyUserPerm();

        GyUserPerm gyUserPerm = new GyUserPerm();

        System.out.println(o instanceof GyUserPerm);
    }
}
