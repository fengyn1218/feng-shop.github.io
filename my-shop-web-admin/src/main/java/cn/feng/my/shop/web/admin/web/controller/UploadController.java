package cn.feng.my.shop.web.admin.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description: 文件上传控制器
 * @author:冯雨南
 * @createDate: 2020/4/24
 * @version:1.0.0
 */
@Controller
public class UploadController {
    private static final String UPLOAD_PATH = "/static/upload/";

    /**
     * @description: 文件上传
     * @param: dropFile:Dropzone的接收参数
     * @param: editorFile：富文本编辑器的图片上传参数
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @author:冯雨南
     * @date: 2020/4/24 14:26
     * @version:1.0.0
     **/
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropFile, MultipartFile editorFile, HttpServletRequest request) {

        Map<String, Object> result = new HashMap<>();

        //判断是DropZone还是富文本编辑器
        MultipartFile myFile = dropFile == null ? editorFile : dropFile;

        //获取文件名后缀
        String fileName = myFile.getOriginalFilename();
        String fileSussix = fileName.substring(fileName.lastIndexOf("."));
        //上传图片文件存放路径
        String realPath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }

        //将文件写入目标
        file = new File(realPath, UUID.randomUUID() + fileSussix);
        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //完整服务器路径
        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

        //DropZone的返回参数
        if (dropFile != null) {
            result.put("fileName", serverPath + UPLOAD_PATH + file.getName());
        }
        //富文本编辑器的返回参数
        else {
            result.put("errno", 0);
            result.put("data", new String[]{serverPath + UPLOAD_PATH + file.getName()});
        }
        return result;
    }
}
