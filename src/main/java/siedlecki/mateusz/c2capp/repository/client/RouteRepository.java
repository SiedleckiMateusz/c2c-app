package siedlecki.mateusz.c2capp.repository.client;

import javafx.scene.effect.SepiaTone;
import org.springframework.data.jpa.repository.JpaRepository;
import siedlecki.mateusz.c2capp.model.client.Route;

import java.util.Set;

public interface RouteRepository extends JpaRepository<Route,Long> {

}
