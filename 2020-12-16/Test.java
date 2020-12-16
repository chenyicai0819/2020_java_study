import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file=new File("F:\\resu");
        File files[]=file.listFiles();
        for(File f:files){
            if(f.isDirectory()){
                File files01[]=f.listFiles();
                for(File f2:files01){
                    if(f2.isDirectory()){
                        File []files02=f2.listFiles();
                        for(File f3:files02){
                            System.out.println("第3层目录："+f3.getName());
                        }
                    }
                    System.out.println("第2层目录："+f2.getName());
                }
            }
            System.out.println("第1层目录："+f.getName());
        }

    }
}
/*
目录也会被当作文件来处理
Linux中所有的硬件设备也都是文件
例如，一个网卡（其实是以文件的形式存在）
 */