package app.service;

import app.entity.LicImage;
import app.entity.NicImage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 05
 **/
public interface DatabaseFileService {
    public NicImage saveNic(MultipartFile file);
    public NicImage getNic(String fileId);

    public LicImage saveLic(MultipartFile file);
    public LicImage getLic(String fileId);
}
