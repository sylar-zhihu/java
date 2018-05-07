package reflex_demo;

import java.lang.reflect.Field;

/*
 * 作者:
 * 日期:2016年12月5日:下午3:30:50
 * 程序作用:把Fan_She_3_Example类里面所有的成员变量为String的
 *  字符串里面的b改成a
**/
public class Fan_She_4_Field_Example {
    /*
     * 把Fan_She_3_Example类里面所有的成员变量为String的 字符串里面的b改成a
     */
    public String string = "hall";

    public String string2 = "basketball";

    public String string3 = "itcast";

    public static void main(String[] args) throws Exception {
        // 得到所有成员变量的Field
        Fan_She_4_Field_Example f = new Fan_She_4_Field_Example();
        Field[] fields = Fan_She_4_Field_Example.class.getFields();
        // 显示改变以前的结果
        System.out.println(f);
        System.out.println(fields.length);
        for (Field field : fields) {
            // 字节码的比较用== 因为字节码只有一份
            if (field.getType() == (String.class)) {
                String string = (String) field.get(f);
                String newStr = string.replace("b", "a");
                // 改变对象的成员变量
                field.set(f, newStr);
            }
        }
        // 显示改变后的结果
        System.out.println(f);

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return string + string2 + string3;
    }
}
