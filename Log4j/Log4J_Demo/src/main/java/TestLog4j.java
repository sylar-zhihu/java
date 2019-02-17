import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/*
 * 作者:
 * 日期:2019年1月24日:上午10:51:50
 * 程序作用:根据配置查看输出哪些信息
**/
public class TestLog4j {
    
    // 给log起一个名字 
    private static Logger logger = Logger.getLogger(TestLog4j.class); // 获取logger实例

    public static void main(String[] args) {
        // 设置等级

        logger.debug("调试debug信息");
        logger.error("报错error信息");
        logger.fatal("严重错误fatal信息");
        logger.info("普通Info信息");
        logger.warn("警告warn信息");
    }

//    public static void main(){
//
//    }
//    @Test
//    public void testLog() {
//        // 设置等级
//        logger.setLevel(Level.DEBUG);
//        logger.debug("调试debug信息");
//        logger.error("报错error信息");
//        logger.fatal("严重错误fatal信息");
//        logger.info("普通Info信息");
//        logger.warn("警告warn信息");
//
//    }

}
