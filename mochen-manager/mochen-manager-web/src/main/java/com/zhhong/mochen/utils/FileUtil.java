package com.zhhong.mochen.utils;

import com.alibaba.fastjson.JSONObject;
import com.zhhong.mochen.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 董仁亮
 * @date 2020-01-13 12:34
 * @Description:
 */

@Slf4j
public class FileUtil {
    /**
     * 富文本图片上传
     *
     * @param file
     * @param request
     * @param response
     * @throws IllegalStateException
     * @throws IOException
     */
    public static void umeditorUpload(MultipartFile file, HttpServletRequest request,
                                      HttpServletResponse response, String imgPath) throws IllegalStateException, IOException {
        JSONObject json = new JSONObject();
        String type = "." + file.getOriginalFilename().split("\\.")[1];
        String name = "hold\\StaticResources\\img\\" + DateUtil.getTodayMonth() + "\\" + UUIDUtils.getUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String realPath = request.getSession().getServletContext().getRealPath("");
        String newRealPath = realPath.substring(0, request.getSession().getServletContext().getRealPath("").indexOf("webapps") + 8);
        File dir = new File(newRealPath, name);
        String src = imgPath + name.replace("\\", "/");
        if (!dir.exists()) {
            dir.mkdirs();
            json.put("state", "SUCCESS");
            json.put("original", file.getOriginalFilename());
            json.put("size", file.getSize());
            json.put("url", src);
            json.put("title", name);
            json.put("type", type);
        } else {
            json.put("state", "FALSE");
        }
        file.transferTo(dir);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(json.toString());
        writer.close();
    }

    /**
     * spring图片上传，从request中获取
     *
     * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static List<String> springUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        List<String> fileNames = new ArrayList<String>();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 记录上传过程起始时的时间，用来计算上传时间
                // int pre = (int) System.currentTimeMillis();
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        String suffixName = myFileName.substring(myFileName.lastIndexOf(".")); // 获取文件后缀名
                        // 取文件名
                        String fileName = UUIDUtils.getUUID() + suffixName; // 设置图片名 当前时间+文件后缀
                        String realPath = request.getSession().getServletContext().getRealPath("");
                        String newRealPath = realPath.substring(0, request.getSession().getServletContext().getRealPath("").indexOf("webapps") + 8);
                        if (suffixName.toLowerCase().equals(".jpg") || suffixName.toLowerCase().equals(".png") || suffixName.toLowerCase().equals(".gif")) { // 分文件夹存储不同文件
                            fileName = "hold/StaticResources/img/" + DateUtil.getTodayMonth() + "/" + fileName;
                        } else {
                            fileName = "hold/StaticResources/file/" + DateUtil.getTodayMonth() + "/" + fileName;
                        }
                        log.debug("write file, path :" + fileName);
                        File fileDir = new File(newRealPath, fileName);
                        if (!fileDir.exists()) { // 如果目录不存在 则创建目录
                            fileDir.mkdirs();
                        }
                        file.transferTo(fileDir); // 把文件写入磁盘
                        fileNames.add(fileName);
                    }
                } else {
                    log.info("未检测到文件");
                }
            }
            return fileNames;
        } else {
            log.info("在request中未检测到文件");
        }

        fileNames.add("");
        return fileNames;
    }

    /**
     * base64位图片上传
     *
     * @param request
     * @param strPicBase64Data
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static List<String> base64Upload(HttpServletRequest request, String strPicBase64Data) throws IllegalStateException, IOException {
        List<String> fileNames = new ArrayList<String>();
        //判断图片的类型
        String strExtraFile = ImgUtil.imgType(strPicBase64Data);
        String[] arrBase64File = strPicBase64Data.split(",");
        if (arrBase64File.length == 2) {
            strPicBase64Data = arrBase64File[1];
        }
        String fileName = UUIDUtils.getUUID() + strExtraFile; // 设置图片名 当前时间+文件后缀
        String realPath = request.getSession().getServletContext().getRealPath("");
        String newRealPath = realPath.substring(0, request.getSession().getServletContext().getRealPath("").indexOf("webapps") + 8);
        if (strExtraFile.toLowerCase().equals(".jpg") || strExtraFile.toLowerCase().equals(".png") || strExtraFile.toLowerCase().equals(".gif")) { // 分文件夹存储不同文件
            fileName = "hold/StaticResources/img/" + DateUtil.getTodayMonth() + "/" + fileName;
        } else {
            fileName = "hold/StaticResources/file/" + DateUtil.getTodayMonth() + "/" + fileName;
        }
        log.debug("write file, newRealPath :" + newRealPath + ", fileName" + fileName);
        File fileDir = new File(newRealPath, fileName);
        if (!fileDir.getParentFile().exists()) { // 如果目录不存在 则创建目录
            fileDir.getParentFile().mkdirs();
        }
        BASE64Decoder decoder = new BASE64Decoder();
        //上传图片
        ImgUtil.uploadImg(decoder, strPicBase64Data, fileDir);
        fileNames.add(fileName);
        return fileNames;
    }


    /**
     * Multipart方式图片上传
     *
     * @param file
     * @param request
     * @param imgPath
     * @return
     */
    public static MochenResult MultipartUpload(MultipartFile file, HttpServletRequest request, String imgPath) {
        try {
            String myFileName = file.getOriginalFilename();// 文件原名称
            String suffixName = myFileName.substring(myFileName.lastIndexOf(".")); // 获取文件后缀名
            // 取文件名
            String fileName = myFileName;
            //String fileName = UUIDUtils.getUUID() + suffixName; // 设置图片名 当前时间+文件后缀
            String realPath = request.getSession().getServletContext().getRealPath("");
            String newRealPath = realPath.substring(0, request.getSession().getServletContext().getRealPath("").indexOf("webapps") + 8);
            fileName = "hold/StaticResources/App/20199" + "/" + fileName;
            if (suffixName.toLowerCase().equals(".jpg") || suffixName.toLowerCase().equals(".png") || suffixName.toLowerCase().equals(".gif")
                    || suffixName.toLowerCase().equals(".jpeg") || suffixName.toLowerCase().equals(".bmp")) {

                return MochenResult.build(StatusCode.CODE_ERROR_FILE, "文件格式不支持");
            } else {
                File fileDir = new File(newRealPath, fileName);
                if (!fileDir.exists()) { // 如果目录不存在 则创建目录
                    fileDir.mkdirs();
                }
                file.transferTo(fileDir); // 把文件写入磁盘

                return MochenResult.build(StatusCode.CODE_SUCCESS, "上传成功", imgPath + fileName);
            }
        } catch (Exception e) {
            log.debug("上传失败", e.getMessage());
            return MochenResult.build(StatusCode.CODE_ERROR, "上传失败" + e.getMessage());
        }
    }
}
