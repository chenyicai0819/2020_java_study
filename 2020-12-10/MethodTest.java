public class Test{
    public static void main(String[] args){}
    boolean a = login("is","is123456");
    if(a==true){
        System.out.println("登陆成功");
    }
    else{
        System.out.println("登陆失败");
    }

    public static boolean login(String username,String passname){
        if(username=="is" && passname=="is123456"){
            return true;
        }
        else
        {
            return false;
        }
    }
}