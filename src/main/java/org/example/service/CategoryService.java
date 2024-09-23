package org.example.service;

import org.example.dto.CategoryDTO;
import org.example.entity.Category;
import org.example.mapper.CategoryMapper;
import org.example.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void createCategory(CategoryDTO dto) {
        Category category = categoryMapper.toEntity(dto);
        categoryRepository.save(category);
    }

    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryMapper.toDTO(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}