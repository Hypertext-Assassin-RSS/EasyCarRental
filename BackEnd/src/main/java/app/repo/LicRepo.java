package app.repo;

import app.entity.LicImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicRepo extends JpaRepository<LicImage, String> {

}