package cn.teach.common.file;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUtil {
    public static FileType getFileType(String fileName) {
        String ext = FilenameUtils.getExtension(fileName).toLowerCase();
        if (ext.equals("png") || ext.equals("jpg") || ext.equals("gif") || ext.equals("bmp") || ext.equals("jpeg")) {
            return FileType.IMAGE;
        } else if (ext.equals("mp4") || ext.equals("wma")) {
            return FileType.VIDEO;
        } else {
            return FileType.FILE;
        }
    }

    public static String nonReduce(MultipartFile file) throws Exception {
        String root = System.getProperty("user.dir");
        String path = "/upload/";
        String originalName = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString().replace("-", "") + originalName.substring(originalName.lastIndexOf(".")).toLowerCase();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
        String dataFloder = formatter1.format(new Date());
        path = path + dataFloder + "/";
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        path += (fileExt + "/");
        String filePath = path + fileName;
        String finalPath = root + filePath;
        File newFile = new File(finalPath);
        File localhost = new File(root + path);
        localhost.mkdirs();
        file.transferTo(newFile);
        return filePath;
    }

    public static String uploadFile(MultipartFile file) throws Exception {
        String root = System.getProperty("user.dir");
        String path = "/upload/";
        String originalName = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString().replace("-", "") + originalName.substring(originalName.lastIndexOf(".")).toLowerCase();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
        String dataFloder = formatter1.format(new Date());
        path = path + dataFloder + "/";
        String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        path += (fileExt + "/");
        String filePath = path + fileName;
        String finalPath = root + filePath;
        File newFile = new File(finalPath);
        File localhost = new File(root + path);
        localhost.mkdirs();
        file.transferTo(newFile);
        return filePath;
    }

    public static String saveToImgByInputStream(InputStream instreams) {
        String filePath = "";
        if (instreams != null) {
            try {
                String root = System.getProperty("user.dir");
                String path = "/qrcode/";
                String fileName = UUID.randomUUID().toString().replace("-", "") + ".png";
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
                String dataFloder = formatter1.format(new Date());
                path = path + dataFloder + "/";
                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                path += (fileExt + "/");
                filePath = path + fileName;
                File file = new File(root + path + fileName);
                File dir = new File(root + path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(file);
                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = instreams.read(b)) != -1) {
                    fos.write(b, 0, nRead);
                }
                fos.flush();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }
        return filePath;
    }
}