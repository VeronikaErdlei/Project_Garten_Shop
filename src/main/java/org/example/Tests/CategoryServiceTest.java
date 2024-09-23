/*package org.example.Tests;

import org.example.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowiredff
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private CategoryMapper categoryMapper;

    @Test
    public void testGetAllCategories() {
        Category category = new Category(1L, "Products", null);
        CategoryDTO categoryDTO = new CategoryDTO(1L, "Products");

        Mockito.when(categoryRepository.findAll()).thenReturn(Collections.singletonList(category));
        Mockito.when(categoryMapper.toDTO(category)).thenReturn(categoryDTO);

        List<CategoryDTO> result = categoryService.getAllCategories();
        assertEquals(1, result.size());
        assertEquals("Electronics", result.get(0).getName());
    }

    @Test
    public void testCreateCategory() {
        CategoryDTO dto = new CategoryDTO(null, "Books");
        Category category = new Category(null, "Books", null);

        Mockito.when(categoryMapper.toEntity(dto)).thenReturn(category);
        Mockito.when(categoryRepository.save(category)).thenReturn(category);

        categoryService.createCategory(dto);
        Mockito.verify(categoryRepository).save(category);
    }

    @Test
    public void testGetCategoryById() {
        Category category = new Category(1L, "Electronics", null);
        CategoryDTO categoryDTO = new CategoryDTO(1L, "Electronics");

        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        Mockito.when(categoryMapper.toDTO(category)).thenReturn(categoryDTO);

        CategoryDTO result = categoryService.getCategoryById(1L);
        assertEquals("Electronics", result.getName());
    }

    @Test(expected = RuntimeException.class)
    public void testGetCategoryByIdNotFound() {
        Mockito.when(categoryRepository.findById(1L)).thenReturn(Optional.empty());
        categoryService.getCategoryById(1L);
    }

    @Test
    public void testDeleteCategory() {
        categoryService.deleteCategory(1L);
        Mockito.verify(categoryRepository).deleteById(1L);
    }
}

 */



