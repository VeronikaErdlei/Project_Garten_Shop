/*package org.example.Tests;

import org.example.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductMapper productMapper;

    @Test
    public void testGetAllProducts() {
        Product product = new Product(1L, "Laptop", "A high-end laptop", 1200.0, 1000.0, null, 5);
        ProductDTO productDTO = new ProductDTO(1L, "Laptop", "A high-end laptop", 1200.0, 1000.0, null);

        Mockito.when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
        Mockito.when(productMapper.toDTO(product)).thenReturn(productDTO);

        List<ProductDTO> result = productService.filterAndSortProducts(null, null, null, null, "name");
        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).getName());
    }

    @Test
    public void testFindByCategory() {
        Product product = new Product(1L, "Laptop", "A high-end laptop", 1200.0, 1000.0, null, 5);

        Mockito.when(productRepository.findByCategoryId(1L)).thenReturn(Collections.singletonList(product));

        List<Product> result = productService.findByCategory(1L);
        assertEquals(1, result.size());
        assertEquals("Laptop", result.get(0).getName());
    }

    @Test
    public void testSaveProduct() {
        Product product = new Product(1L, "Laptop", "A high-end laptop", 1200.0, 1000.0, null, 5);

        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product result = productService.save(product);
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product(1L, "Laptop", "A high-end laptop", 1200.0, 1000.0, null, 5);

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(1L);
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }

    @Test(expected = RuntimeException.class)
    public void testGetProductByIdNotFound() {
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.empty());
        productService.getProductById(1L);
    }

    @Test
    public void testDeleteProduct() {
        productService.delete(1L);
        Mockito.verify(productRepository).deleteById(1L);
    }
}

 */