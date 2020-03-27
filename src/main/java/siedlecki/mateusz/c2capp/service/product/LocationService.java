package siedlecki.mateusz.c2capp.service.product;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.product.Location;
import siedlecki.mateusz.c2capp.repository.product.LocationRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService implements SimpleService<Location,Long> {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Location> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Location> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Location save(Location location) {
        return repository.save(location);
    }

    @Override
    public void delete(Location obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
