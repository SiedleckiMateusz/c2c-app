package siedlecki.mateusz.c2capp.service.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import siedlecki.mateusz.c2capp.model.client.Client;
import siedlecki.mateusz.c2capp.repository.client.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @InjectMocks
    ClientService clientService;

    @Mock
    ClientRepository clientRepository;

    Client someClient;

    @BeforeEach
    void setUp() {
        someClient = Client.builder()
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
        List<Client> returnClients = new ArrayList<>();
        returnClients.add(Client.builder().id(11L).build());
        returnClients.add(Client.builder().id(22L).build());

        when(clientRepository.findAll()).thenReturn(returnClients);

//        when
        List<Client> clients = clientService.findAll();

//        then
        assertEquals(2,clients.size());
    }

    @Test
    void findById() {

        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(someClient));

//        when
        Client c1 = clientService.findById(1L).orElse(null);
//        then
        assertNotNull(c1);
    }

    @Test
    void findByIdNotExist() {

        when(clientRepository.findById(anyLong())).thenReturn(Optional.empty());

//        when
        Client c1 = clientService.findById(1L).orElse(null);
//        then
        assertNull(c1);
    }

    @Test
    void save() {
//        given
        when(clientRepository.save(any())).thenReturn(someClient);
        Client c1 = Client.builder().id(5L).build();

//        when
        Client returnedClient = clientService.save(c1);

//        then
        assertNotNull(returnedClient);
        verify(clientRepository,times(1)).save(any());
    }
}