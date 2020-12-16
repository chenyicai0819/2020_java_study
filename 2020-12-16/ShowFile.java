import java.io.File;

public class ShowFile {
    public static void main(String[] args) {
        File file=new File("F://resu");
        showFile(file);
    }
    /*
    递归显示目录下的文件（包含子目录）
     */
    static void showFile(File file){
        if(file.isDirectory()){//递归的出口
            File files[]=file.listFiles();
            for(File f:files){
                System.out.println(f.getName());
                showFile(f);
            }
        }
    }
}