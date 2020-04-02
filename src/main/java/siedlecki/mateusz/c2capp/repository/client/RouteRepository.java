package siedlecki.mateusz.c2capp.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.model.client.Route;

import java.util.Optional;


public interface RouteRepository extends JpaRepository<Route,Long> {

    Optional<Route> findByNameContains(String name);

}
