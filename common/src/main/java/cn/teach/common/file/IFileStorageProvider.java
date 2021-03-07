package cn.teach.common.file;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface IFileStorageProvider {
    FileMeta put(MultipartFile file, HttpServletRequest request);

    boolean delete(String path);

    String type();
}