package siedlecki.mateusz.c2capp.service.wz;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.wz.Wz;
import siedlecki.mateusz.c2capp.repository.wz.WzRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class WzService implements SimpleService<Wz,Long> {

    private final WzRepository repository;

    public WzService(WzRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Wz> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Wz> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Wz save(Wz wz) {
        return repository.save(wz);
    }

    @Override
    public void delete(Wz obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
