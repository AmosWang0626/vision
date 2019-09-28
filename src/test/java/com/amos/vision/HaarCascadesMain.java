package com.amos.vision;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DESCRIPTION: opencv haar cascades main
 *
 * @author amos.wang
 * @date 2019/9/27
 */
public class HaarCascadesMain {

    /*
     * 启动时需配置JVM参数 -Djava.library.path=E:\app_res\opencv\build\java\x64
     *
     * opencv 安装目录 E:\app_res\opencv
     * 当前项目目录 E:\develop\github\vision
     * System.getProperty("user.dir") E:\develop\github\vision
     * System.getProperty("java.library.path") E:\app_res\opencv\build\java\x64
     */
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // OpenCV-HAAR 级联检测xml存放目录
        String haarcascades = "E:\\app_res\\opencv\\build\\etc\\haarcascades\\";

        // dgddy3 dgoj93 731grv
        Mat mat = Imgcodecs.imread("C:\\Users\\amos\\Pictures\\wallhaven-dgddy3.jpg");
        // 检测出的坐标集合
        List<Rect> rectList = new ArrayList<>();
        MatOfRect faceDetections = new MatOfRect();
        // directory
        File directory = new File(haarcascades);
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File xml : files) {
            /// haarcascade_frontalface_alt2 正常人脸可检测出
            // 测试人脸识别
            // if (!xml.getName().contains("face")) {
            //     continue;
            // }
            try {
                CascadeClassifier faceDetector = new CascadeClassifier(xml.getPath());
                faceDetector.detectMultiScale(mat, faceDetections);
                Rect[] rects = faceDetections.toArray();
                rectList.addAll(Arrays.asList(rects));
                System.out.println(String.format("检测成功: %s, 检测到 %s 处数据", xml.getName(), rects.length));
            } catch (Exception e) {
                System.out.println(String.format("检测失败: %s, 失败原因: %s", xml.getName(), e.getMessage()));
            }
        }

        System.out.println(String.format("检测到 %s 处数据", rectList.size()));

        for (Rect rect : rectList) {
            Imgproc.rectangle(mat, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }

        // 显示图片
        HighGui.namedWindow("image", HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("image", mat);
        // delay等待毫秒数[0则无限等待]
        HighGui.waitKey(0);
        // 关闭所有窗口
        HighGui.destroyWindow("image");

        /// 下边代码可将识别后的文件输出到指定项目跟目录
        if (rectList.size() > 0) {
            String filename = "output.png";
            System.out.println(String.format("输出文件 %s 见项目根目录", filename));
            Imgcodecs.imwrite(filename, mat);
        }

        System.exit(0);
    }

    private static void simple() {
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
