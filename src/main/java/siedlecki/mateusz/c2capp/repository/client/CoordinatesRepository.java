package siedlecki.mateusz.c2capp.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.client.CoordinatesEntity;


public interface CoordinatesRepository extends JpaRepository<CoordinatesEntity,Long> {

}
