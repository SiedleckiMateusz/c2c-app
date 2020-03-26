package siedlecki.mateusz.c2capp.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.model.client.Coordinates;

public interface CoordinatesRepository extends JpaRepository<Coordinates,Long> {
}
