package app.repo;

import app.entity.NicImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NicRepo extends JpaRepository<NicImage, String> {

}