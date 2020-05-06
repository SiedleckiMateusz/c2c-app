package siedlecki.mateusz.c2capp.service.client;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.client.CoordinatesEntity;
import siedlecki.mateusz.c2capp.repository.client.CoordinatesRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinatesService implements SimpleService<CoordinatesEntity,Long> {

    private final CoordinatesRepository coordinatesRepository;

    public CoordinatesService(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    @Override
    public List<CoordinatesEntity> findAll() {
        return coordinatesRepository.findAll();
    }

    @Override
    public Optional<CoordinatesEntity> findById(Long aLong) {
        return coordinatesRepository.findById(aLong);
    }

    @Override
    public CoordinatesEntity save(CoordinatesEntity coordinates) {
        return coordinatesRepository.save(coordinates);
    }

    @Override
    public void delete(CoordinatesEntity obj) {
        coordinatesRepository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        coordinatesRepository.deleteById(aLong);
    }
}
