package siedlecki.mateusz.c2capp.service.delivery;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.delivery.Dealer;
import siedlecki.mateusz.c2capp.repository.delivery.DealerRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class DealerService implements SimpleService<Dealer,Long> {

    private final DealerRepository repository;

    public DealerService(DealerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dealer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Dealer> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public Dealer save(Dealer dealer) {
        return repository.save(dealer);
    }

    public List<Dealer> saveAll(List<Dealer> dealers){
        return repository.saveAll(dealers);
    }

    @Override
    public void delete(Dealer obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
