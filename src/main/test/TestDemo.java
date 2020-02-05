import com.itdr.pojo.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Users u = (Users) ac.getBean("users");
        System.out.println(u);
//        Users u2 = (Users) ac.getBean("users");
//        System.out.println(u2);
        Users a = (Users) ac.getBean("a");
        System.out.println(a);
    }
}
