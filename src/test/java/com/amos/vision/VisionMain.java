package com.amos.vision;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * DESCRIPTION: opencv test main
 *
 * @author amos.wang
 * @date 2019/9/27
 */
public class VisionMain {

    // 配置JVM参数 -Djava.library.path=E:\app_res\opencv\build\java\x64
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("java.library.path", "E:\\app_res\\opencv\\build\\java\\x64");

        Mat mat = Imgcodecs.imread("C:\\Users\\User\\Desktop\\pika.jpg");
        System.out.println(mat);
        // 显示图片
        HighGui.imshow("image", mat);
        // delay等待毫秒数[0则无限等待]
        HighGui.waitKey(0);

        // 两秒后关闭所有窗口
        HighGui.destroyWindow("image");
        System.exit(0);
    }

}
