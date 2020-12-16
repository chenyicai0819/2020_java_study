public class StringTest {
    public static void main(String[] args) {
        String name="hello world,today is so cold";
        char [] c={
                name.charAt(0)
        };
        String firstCharacter=new String(c);//这个字符串只有1个字符（h)
        String newString=firstCharacter.toUpperCase().concat(name.substring(1));

        System.out.println("首字母变大写后："+newString);
    }
}