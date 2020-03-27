package siedlecki.mateusz.c2capp.service.client;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.client.Route;
import siedlecki.mateusz.c2capp.repository.client.RouteRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService implements SimpleService<Route,Long> {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public Optional<Route> findById(Long aLong) {
        return routeRepository.findById(aLong);
    }

    @Override
    public Route save(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public void delete(Route obj) {
        routeRepository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        routeRepository.deleteById(aLong);
    }
}
