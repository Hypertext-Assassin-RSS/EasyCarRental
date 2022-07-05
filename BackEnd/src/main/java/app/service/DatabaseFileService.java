package app.service;

import app.entity.File;
import org.springframework.web.multipart.MultipartFile;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 05
 **/
public interface DatabaseFileService {
    public File storeFile(MultipartFile file);
    public File getFile(String fileId);
}
