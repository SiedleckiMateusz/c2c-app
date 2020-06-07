package siedlecki.mateusz.c2capp.service.product;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.product.LocationEntity;
import siedlecki.mateusz.c2capp.repository.product.LocationRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService implements SimpleService<LocationEntity,Long> {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LocationEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<LocationEntity> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public LocationEntity save(LocationEntity location) {
        return repository.save(location);
    }

    public List<LocationEntity> saveAll(List<LocationEntity> locations){
        return repository.saveAll(locations);
    }

    @Override
    public void delete(LocationEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
