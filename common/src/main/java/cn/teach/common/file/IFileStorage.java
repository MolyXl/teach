package cn.teach.common.file;

import org.springframework.web.multipart.MultipartFile;

public interface IFileStorage {
    FileMeta put(MultipartFile file);
    boolean delete(String path);
}