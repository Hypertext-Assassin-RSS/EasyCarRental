package app.repo;

import app.entity.CarImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @PROJECT EasyCarRental
 * @Author Rajith Sanjaya
 * @Date 2022 Jul 11
 **/

@Repository
public interface CarImagesRepo extends JpaRepository<CarImages,String> {
}
