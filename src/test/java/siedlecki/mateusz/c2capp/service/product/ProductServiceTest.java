package siedlecki.mateusz.c2capp.service.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import siedlecki.mateusz.c2capp.entity.product.ProductEntity;
import siedlecki.mateusz.c2capp.repository.product.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    ProductEntity someProduct;

    @BeforeEach
    void setUp() {
        someProduct = ProductEntity.builder()
                .name("Widelec plastikowy a'100")
                .description("Widelec plastikowy czarny, pakowany po 100 szt.")
                .barcode("12412624342")
                .pictureUrl("http://google.pl")
                .id(1L)
                .build();
    }

    @Test
    void findAll() {
//        given
        List<ProductEntity> products = new ArrayList<>();
        products.add(someProduct);
        when(productRepository.findAll()).thenReturn(products);
//        when
        List<ProductEntity> allProducts = productService.findAll();

//        then
        Assertions.assertEquals(1,allProducts.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void findById() {
//        given
        when(productRepository.findById(any())).thenReturn(Optional.of(someProduct));
//        when
        ProductEntity byIdProduct = productService.findById(1L).orElse(null);

//        then
        assertNotNull(byIdProduct);
        verify(productRepository, times(1)).findById(any());

    }


    @Test
    void findByIdNotFound() {
//        given
        when(productRepository.findById(any())).thenReturn(Optional.empty());
//        when
        ProductEntity byIdProduct = productService.findById(1L).orElse(null);

//        then
        assertNull(byIdProduct);
        verify(productRepository, times(1)).findById(any());

    }

    @Test
    void save() {
    }
}
