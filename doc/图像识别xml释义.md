# opencv图像识别
- opencv version 4.1.1
- opencv中的人脸检测使用基于Harr的级联分类和基于LBP的级联分类

## HARR & LBP
> - Harr是在2001年，由Viola和Jones等人提出的，它的脸部检测的基本思想是：对于面部正面的大部分区域而言，会有眼睛所在的区域比前额和脸颊更暗，嘴巴应该比脸颊更暗等情况。和这样类似的比较大约有20个，通过这样的比较决定该区域是否为人脸。
> - LBP是在2006年由Ahonen等人提出的，相比于Harr，LBP有更快的速度。通过比较想读亮度直方图来确定是否为人脸。但是对于稳定性，LBP要弱于前者。

### Opencv自带训练好的人脸检测模型
- HARR 模型目录 E:\app_res\opencv\build\etc\haarcascades
- LBP 模型目录 E:\app_res\opencv\build\etc\lbpcascades

- HARR 检测器(人脸眼睛)：haarcascade_eye.xml
- HARR 检测器(人脸戴眼镜)：haarcascade_eye_tree_eyeglasses.xml
- HARR 检测器(猫脸)：haarcascade_frontalcatface.xml
- HARR 检测器(猫脸拓展)：haarcascade_frontalcatface_extended.xml
- HARR 检测器(人脸得分4(满分10))：haarcascade_frontalface_alt.xml
- HARR 检测器(人脸得分7(满分10))：haarcascade_frontalface_alt2.xml
- HARR 检测器(人脸得分9(满分10))：haarcascade_frontalface_alt_tree.xml
- HARR 检测器(人脸得分2(满分10))：haarcascade_frontalface_default.xml
- HARR 检测器(侧脸)：haarcascade_profileface.xml
- HARR 检测器(全身)：haarcascade_fullbody.xml
- HARR 检测器(上半身)：haarcascade_upperbody.xml
- HARR 检测器(下半身)：haarcascade_lowerbody.xml
- HARR 检测器(左眼)：haarcascade_lefteye_2splits.xml
- HARR 检测器(右眼)：haarcascade_righteye_2splits.xml
- HARR 检测器(未知)：haarcascade_licence_plate_rus_16stages.xml
- HARR 检测器(未知 或俄罗斯车牌号)：haarcascade_russian_plate_number.xml
- HARR 检测器(笑脸)：haarcascade_smile.xml

- LBP 检测器(猫脸)：lbpcascade_frontalcatface.xml
- LBP 检测器(人脸)：lbpcascade_frontalface.xml
- LBP 检测器(人脸优化版小脸)：lbpcascade_frontalface_improved.xml
- LBP 检测器(侧脸)：lbpcascade_profileface.xml
- LBP 检测器(未知 或银器)：lbpcascade_silverware.xml
