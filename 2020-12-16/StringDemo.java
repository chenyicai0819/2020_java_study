public class StringDemo {
    public static void main(String[] args) {
        String str=" shi yan lou ";
        System.out.println(str.length());
        System.out.println(str.trim().length());
        //trim只能去掉字符串中的前面和后面的空格
        System.out.println(str.replaceAll("\\s", ""));
        /*
        正则表达式：独立于编程语言的一门技术
        作用：按照某种规则匹配字符串
         */
    }
}