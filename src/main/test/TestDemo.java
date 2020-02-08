
import com.itdr.pojo.Users;
import com.itdr2.controller.IndexController;
import com.youname.common.ResponseCode;
import com.youname.dao.UsersDao;
import com.youname.service.impl.UsersServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class TestDemo {
    @Test
    public void test(){
        //使用spring的内置连接池
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdt = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
        //插入数据
        String sql="insert into users values(null,'yuan','123',0)";
        int update = jdt.update(sql);
        System.out.println(update);
        System.out.println("========================");
        //修改数据
        String sql2="update users set uname=? where uid=?";
        int hh = jdt.update(sql2, "hh", 3);
        System.out.println(hh);
        System.out.println("=================");
        //查询数据
        String sql3="select * from users";
        List<Map<String, Object>> maps = jdt.queryForList(sql3);
        for (Map<String, Object> map : maps) {
            for (String s : map.keySet()) {
                System.out.println(map.get(s));
            }
        }
        //删除数据
        String sql4="delete from users where uid=?";
        int delete = jdt.update(sql4, 4);
        System.out.println(delete);
    }

    @Test
    public void test2(){
        //袁婕
        //使用C3P0连接池
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdt = ac.getBean("jdbcTemplate1",JdbcTemplate.class);
        //插入数据
        String sql="insert into users values(null,'yuan','123',0)";
        int update = jdt.update(sql);
        System.out.println(update);
        System.out.println("========================");
        //修改数据
        String sql2="update users set uname=? where uid=?";
        int hh = jdt.update(sql2, "hh", 3);
        System.out.println(hh);
        System.out.println("=================");
        //查询数据
        String sql3="select * from users";
        List<Map<String, Object>> maps = jdt.queryForList(sql3);
        for (Map<String, Object> map : maps) {
            for (String s : map.keySet()) {
                System.out.println(map.get(s));
            }
        }
        //删除数据
//        String sql4="delete from users where uid=?";
//        int delete = jdt.update(sql4, 4);
//        System.out.println(delete);
    }
    @Test
    public void test4(){
        IndexController indexController = new IndexController();
        indexController.tm("hh","yyyy",10);
    }
    @Test
    public void test5(){
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring2.xml");
        IndexController ic = applicationContext.getBean(IndexController.class);
        ic.tm("hh","yyyy",10);
    }
    @Test
    public void test6(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("youname.xml");
        UsersServiceImpl us = applicationContext.getBean(UsersServiceImpl.class);
        ResponseCode hh = us.register("kk","123");
        System.out.println(hh.toString());

    }
    @Test
    public void test7(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("youname.xml");
        UsersServiceImpl us = applicationContext.getBean(UsersServiceImpl.class);
        ResponseCode games = us.games("鸡", "3月", "白羊座");
        System.out.println(games.getData().toString());
    }
}
