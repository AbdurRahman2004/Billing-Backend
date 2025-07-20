package com.abdur.BillingSoftware.service.impl;

import com.abdur.BillingSoftware.entity.CategoryEntity;
import com.abdur.BillingSoftware.io.CategoryRequest;
import com.abdur.BillingSoftware.io.CategoryResponse;
import com.abdur.BillingSoftware.io.ItemResponse;
import com.abdur.BillingSoftware.repository.CategoryRepository;
import com.abdur.BillingSoftware.repository.ItemRepository;
import com.abdur.BillingSoftware.service.CategoryService;
import com.abdur.BillingSoftware.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final FileUploadService fileUploadService;
    private final ItemRepository itemRepository;
    
    @Override
    public CategoryResponse add (CategoryRequest request , MultipartFile file){
      String imgUrl = fileUploadService.uploadFile(file);
      CategoryEntity newCategory =  convertToEntity(request);
      newCategory.setImgUrl(imgUrl);
      newCategory = categoryRepository.save(newCategory);
      return convertToResponse(newCategory);
    }


    @Override
    public List<CategoryResponse> read(){
       return  categoryRepository.findAll()
                 .stream()
                 .map(this::convertToResponse)
                 .collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId){
      CategoryEntity existingCategory = categoryRepository.findByCategoryId(categoryId)
              .orElseThrow(()-> new RuntimeException("Category not Found: "+ categoryId));
      fileUploadService.deleteFile(existingCategory.getImgUrl());
      categoryRepository.delete(existingCategory);
    }

    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
        Integer itemCounts = itemRepository.countByCategoryId(newCategory.getId());
        return CategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgColour(newCategory.getBgColour())
                .imgUrl(newCategory.getImgUrl())
                .createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt())
                .items(itemCounts)
                .build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
      return  CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description((request.getDescription()))
                .bgColour(request.getBgColour())
                .build();
    }
}
