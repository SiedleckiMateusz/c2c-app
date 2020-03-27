package siedlecki.mateusz.c2capp.service.delivery;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.model.delivery.Dealer;
import siedlecki.mateusz.c2capp.repository.delivery.DealerRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class DealerService implements SimpleService<Dealer,Long> {

    private final DealerRepository dealerRepository;

    public DealerService(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }

    @Override
    public List<Dealer> findAll() {
        return dealerRepository.findAll();
    }

    @Override
    public Optional<Dealer> findById(Long aLong) {
        return dealerRepository.findById(aLong);
    }

    @Override
    public Dealer save(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    @Override
    public void delete(Dealer obj) {
        dealerRepository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        dealerRepository.deleteById(aLong);
    }
}
