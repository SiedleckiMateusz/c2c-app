package siedlecki.mateusz.c2capp.service.client;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.client.Coordinates;
import siedlecki.mateusz.c2capp.repository.client.CoordinatesRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinatesService implements SimpleService<Coordinates,Long> {

    private final CoordinatesRepository coordinatesRepository;

    public CoordinatesService(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    @Override
    public List<Coordinates> findAll() {
        return coordinatesRepository.findAll();
    }

    @Override
    public Optional<Coordinates> findById(Long aLong) {
        return coordinatesRepository.findById(aLong);
    }

    @Override
    public Coordinates save(Coordinates coordinates) {
        return coordinatesRepository.save(coordinates);
    }

    @Override
    public void delete(Coordinates obj) {
        coordinatesRepository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        coordinatesRepository.deleteById(aLong);
    }
}
