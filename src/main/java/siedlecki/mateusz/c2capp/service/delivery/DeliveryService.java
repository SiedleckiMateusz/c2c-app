package siedlecki.mateusz.c2capp.service.delivery;

import org.springframework.stereotype.Service;
import siedlecki.mateusz.c2capp.entity.delivery.DeliveryEntity;
import siedlecki.mateusz.c2capp.repository.delivery.DeliveryRepository;
import siedlecki.mateusz.c2capp.service.SimpleService;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService implements SimpleService<DeliveryEntity,Long> {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }


    @Override
    public List<DeliveryEntity> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Optional<DeliveryEntity> findById(Long aLong) {
        return deliveryRepository.findById(aLong);
    }

    @Override
    public DeliveryEntity save(DeliveryEntity delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public void delete(DeliveryEntity obj) {
        deliveryRepository.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        deliveryRepository.deleteById(aLong);
    }
}
