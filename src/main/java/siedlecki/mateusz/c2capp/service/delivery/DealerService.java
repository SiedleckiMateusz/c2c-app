package siedlecki.mateusz.c2capp.service.delivery;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.delivery.DealerEntity;
import siedlecki.mateusz.c2capp.repository.delivery.DealerRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class DealerService implements SimpleService<DealerEntity,Long> {

    private final DealerRepository repository;

    public DealerService(DealerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DealerEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<DealerEntity> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public DealerEntity save(DealerEntity dealerEntity) {
        return repository.save(dealerEntity);
    }

    public List<DealerEntity> saveAll(List<DealerEntity> dealerEntities){
        return repository.saveAll(dealerEntities);
    }

    @Override
    public void delete(DealerEntity obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
