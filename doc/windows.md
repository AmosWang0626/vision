# windows install soft

## opencv

- 下载 opencv-x.x.x-xxx.exe
  - [download url](https://opencv.org/releases/)
- 安装 opencv-x.x.x-xxx.exe

- 配置环境变量（JAVA_HOME下边步骤会用到）
  - PATH E:\app_res\opencv\build\x64\vc15\bin
  - JAVA_HOME E:\app_res\Java\jdk1.8.0_201

- 将jar放到本地maven仓库
  - mvn install:install-file -Dfile=E:\app_res\opencv\build\java\opencv-411.jar -DgroupId=com.opencv -DartifactId=opencv -Dversion=4.1.1 -Dpackaging=jar

- 运行测试
  - 运行VisionMain，配置JVM参数-Djava.library.path=E:\app_res\opencv\build\java\x64