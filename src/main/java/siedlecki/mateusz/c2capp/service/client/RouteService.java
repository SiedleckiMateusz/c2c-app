package siedlecki.mateusz.c2capp.service.client;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.client.Route;
import siedlecki.mateusz.c2capp.repository.client.RouteRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService implements SimpleService<Route,Long> {

    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Route> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Route> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public Optional<Route> findByName(String name){

        List<Route> allRoutes = repository.findAll();

        return allRoutes.stream().filter(route -> route.getName().toLowerCase().contains(name.toLowerCase())).findFirst();
    }

    @Override
    public Route save(Route route) {
        return repository.save(route);
    }

    @Override
    public void delete(Route obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
