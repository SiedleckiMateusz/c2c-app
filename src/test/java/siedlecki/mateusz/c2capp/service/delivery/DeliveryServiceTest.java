package siedlecki.mateusz.c2capp.service.delivery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import siedlecki.mateusz.c2capp.model.delivery.Dealer;
import siedlecki.mateusz.c2capp.model.delivery.Delivery;
import siedlecki.mateusz.c2capp.model.delivery.Supplier;
import siedlecki.mateusz.c2capp.repository.delivery.DeliveryRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeliveryServiceTest {

    @InjectMocks
    DeliveryService deliveryService;

    @Mock
    DeliveryRepository deliveryRepository;

    Delivery someDelivery;

    @BeforeEach
    void setUp() {
        someDelivery = Delivery.builder()
                .id(1L)
                .creationTime(LocalDateTime.now())
                .dealer(new Dealer("Ulex","52443211"))
                .supplier(new Supplier("Pekaes"))
                .info("Wszystko było ok")
                .build();
    }

    @Test
    void findAll() {
//        given
        List<Delivery> deliveries = new ArrayList<>();
        deliveries.add(someDelivery);
        when(deliveryRepository.findAll()).thenReturn(deliveries);

//        when
        List<Delivery> all = deliveryService.findAll();

//        then
        assertEquals(1,all.size());
        verify(deliveryRepository,times(1)).findAll();

    }

    @Test
    void findById() {
//        given
        when(deliveryRepository.findById(any())).thenReturn(Optional.of(someDelivery));

//        when
        Optional<Delivery> optionalDelivery = deliveryService.findById(1L);

//        then
        assertNotNull(optionalDelivery.orElse(null));
        verify(deliveryRepository,times(1)).findById(any());
    }

    @Test
    void findByIdNotFound() {
//        given
        when(deliveryRepository.findById(any())).thenReturn(Optional.empty());

//        when
        Optional<Delivery> optionalDelivery = deliveryService.findById(1L);

//        then
        assertNull(optionalDelivery.orElse(null));
        verify(deliveryRepository,times(1)).findById(any());
    }

    @Test
    void save() {
//        given
        when(deliveryRepository.save(any())).thenReturn(someDelivery);

//        when
        Delivery saved = deliveryService.save(someDelivery);

//        then
        assertNotNull(saved);
        verify(deliveryRepository,times(1)).save(any());
    }
}