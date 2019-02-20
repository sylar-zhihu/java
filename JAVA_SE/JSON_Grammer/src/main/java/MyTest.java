
import com.google.gson.Gson;
import org.junit.Test;

import java.util.Map;
public class MyTest {

    @Test
    // jsonString转换为json
    public void testjsonToClass(){

        //创建一个JSON字符串
        String json = "{\"name\":\"孙悟空\",\"age\":18,\"gender\":\"男\"}";

        //创建一个解析器的实例
        Gson gson = new Gson();

        //通过gson 将json转换为对象 需要制定是什么类型
        Map map = gson.fromJson(json, Map.class);
        System.out.println(map);
        // 转换成对象
        Student stu = gson.fromJson(json, Student.class);
        System.out.println(stu);


    }


    @Test
    // 对象变成json
    public void testObj(){

        //创建一个stu对象
        Student stu = new Student("猪八戒",28,"男");

        //创建解析器
        Gson gson = new Gson();
        // 对象变成json
        String json = gson.toJson(stu);
        System.out.println(json);


    }
}
