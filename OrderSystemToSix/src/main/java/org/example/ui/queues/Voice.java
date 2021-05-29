package org.example.ui.queues;
/**
 * 一个用java代码实现 语音播报示例
 *
 */

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.*;

public class Voice {

    public static void voice() throws IOException {
        // 拿到音响
        System.out.println(System.getProperty("java.library.path"));
        ActiveXComponent sap = new ActiveXComponent("sapi.SpVoice");
        // 找到本地要朗读的文件
        try {
            File srcFile = new File("F:\\a蓝桥\\点餐系统\\语音播报\\叫号.txt");
            // 获取文本文档的内容
            FileReader flie = new FileReader(srcFile);
            BufferedReader bf = new BufferedReader(flie);
            String content = bf.readLine();
            System.out.println("播报："+content);
            // 调节语速 音量大小
            sap.setProperty("Volume", new Variant(100));
            sap.setProperty("Rate", new Variant(0));

            Dispatch xj = sap.getObject();
            // 执行朗读
            int no=0;
            while (content != null) {
                Dispatch.call(xj, "Speak", new Variant(content));
                no++;
                if(no==2){//朗读次数
                    break;
                }
            }
            xj.safeRelease();
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            sap.safeRelease();
        }

    }

}