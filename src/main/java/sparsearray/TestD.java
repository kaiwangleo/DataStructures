package sparsearray;

/**
 * @author leo
 * @version 1.0
 * @date 2022/4/14 0:12
 */
public class TestD {
    public static void main(String[] args) {
        // 1.%s 字符串类型
        String string1 = String.format("你好呀，我是%s,请问你是%s吗？", "大笨象", "大灰狼");
        System.out.println("string1 = " + string1);

        // %c 字符类型
        String string2 = String.format("字母%c", 'a');
        System.out.println("string2 = " + string2);

        // %b 布尔类型
        String string3 = String.format("布尔型%b", false);
        System.out.println("string3 = " + string3);

        // %d 整数类型（十进制）
        String string4 = String.format("数字%d", 3);
        System.out.println("string4 = " + string4);

        // %f 浮点类型
        String string5 = String.format("数字%f", 3.0);
        System.out.println("string5 = " + string5);
    }


}
