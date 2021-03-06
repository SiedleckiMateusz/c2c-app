package siedlecki.mateusz.c2capp.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.entity.client.RouteEntity;

import java.util.Optional;


public interface RouteRepository extends JpaRepository<RouteEntity,Long> {

    Optional<RouteEntity> findByNameContains(String name);

}
