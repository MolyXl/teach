package cn.teach.common.file.local;

import cn.teach.common.file.FileMeta;
import cn.teach.common.file.FileUtil;
import cn.teach.common.file.IFileStorageProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Component
public class LocalFileStorage implements IFileStorageProvider {

    @Override
    public FileMeta put(MultipartFile file, HttpServletRequest request) {
        try {
            String basePath = "https://www.wuyouhezhubao.com";
            //String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            String filePath = FileUtil.uploadFile(file);
            FileMeta fileMeta = new FileMeta();
            fileMeta.setPath(basePath + filePath);
            fileMeta.setName(file.getOriginalFilename());
            fileMeta.setMimeType(file.getContentType());
            fileMeta.setSize(file.getSize());
            return fileMeta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(String path) {
        return false;
    }

    @Override
    public String type() {
        return "alioss";
    }

}