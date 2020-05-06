package siedlecki.mateusz.c2capp.service.client;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.client.RouteEntity;
import siedlecki.mateusz.c2capp.repository.client.RouteRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService implements SimpleService<RouteEntity,Long> {

    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RouteEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<RouteEntity> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public Optional<RouteEntity> findByName(String name){

        List<RouteEntity> allRoutes = repository.findAll();

        return allRoutes.stream().filter(route -> route.getName().toLowerCase().contains(name.toLowerCase())).findFirst();
    }

    @Override
    public RouteEntity save(RouteEntity route) {
        return repository.save(route);
    }

    @Override
    public void delete(RouteEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
