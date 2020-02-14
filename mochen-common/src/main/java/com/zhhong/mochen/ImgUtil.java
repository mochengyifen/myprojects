package com.zhhong.mochen;


import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author 董仁亮
 * @date 2019-07-14 16:44
 * @Description:
 */
@Slf4j
public class ImgUtil {

    /**
     * @date:2019-07-14 16:46
     * @description:判断图片的类型
     */
    public static String imgType(String base64File) {
        String strExtraFile = ".jpg";
        if (base64File.indexOf("data:image/jpeg;base64") == 0) {
            strExtraFile = ".jpg";
        } else if (base64File.indexOf("data:image/png;base64") == 0) {
            strExtraFile = ".png";
        } else if (base64File.indexOf("data:image/bmp;base64") == 0) {
            strExtraFile = ".bmp";
        }
        return strExtraFile;
    }


    public static void uploadImg(BASE64Decoder decoder, String base64File, File fileDir) {
        try {
            log.debug("write file base64data:" + base64File);
            //Base64解码
            byte[] b = decoder.decodeBuffer(base64File);
            //生成jpeg图片
            OutputStream out = new FileOutputStream(fileDir);
            out.write(b);
            out.flush();
            out.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
