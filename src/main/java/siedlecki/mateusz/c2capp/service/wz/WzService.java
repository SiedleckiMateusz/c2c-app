package siedlecki.mateusz.c2capp.service.wz;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.wz.WzEntity;
import siedlecki.mateusz.c2capp.repository.wz.WzRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class WzService implements SimpleService<WzEntity,Long> {

    private final WzRepository repository;

    public WzService(WzRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WzEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<WzEntity> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public WzEntity save(WzEntity wz) {
        return repository.save(wz);
    }

    @Override
    public void delete(WzEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
