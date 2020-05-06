package siedlecki.mateusz.c2capp.service.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import siedlecki.mateusz.c2capp.entity.client.ClientEntity;
import siedlecki.mateusz.c2capp.repository.client.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientEntityServiceTest {

    @InjectMocks
    ClientService clientService;

    @Mock
    ClientRepository clientRepository;

    ClientEntity someClient;

    @BeforeEach
    void setUp() {
        someClient = ClientEntity.builder()
                .id(1L)
                .warehouseName("Warehouse name")
                .realName("Real name")
                .address("My address")
                .nip("nip-nip-nip")
                .info("Info")
                .build();
    }

    @Test
    void findAll() {
//        given
        List<ClientEntity> returnClients = new ArrayList<>();
        returnClients.add(ClientEntity.builder().id(11L).build());
        returnClients.add(ClientEntity.builder().id(22L).build());

        when(clientRepository.findAll()).thenReturn(returnClients);

//        when
        List<ClientEntity> clients = clientService.findAll();

//        then
        assertEquals(2,clients.size());
    }

    @Test
    void findById() {

        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(someClient));

//        when
        ClientEntity c1 = clientService.findById(1L).orElse(null);
//        then
        assertNotNull(c1);
    }

    @Test
    void findByIdNotExist() {

        when(clientRepository.findById(anyLong())).thenReturn(Optional.empty());

//        when
        ClientEntity c1 = clientService.findById(1L).orElse(null);
//        then
        assertNull(c1);
    }

    @Test
    void save() {
//        given
        when(clientRepository.save(any())).thenReturn(someClient);
        ClientEntity c1 = ClientEntity.builder().id(5L).build();

//        when
        ClientEntity returnedClient = clientService.save(c1);

//        then
        assertNotNull(returnedClient);
        verify(clientRepository,times(1)).save(any());
    }
}