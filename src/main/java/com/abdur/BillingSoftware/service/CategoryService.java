package com.abdur.BillingSoftware.service;

import com.abdur.BillingSoftware.io.CategoryRequest;
import com.abdur.BillingSoftware.io.CategoryResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request, MultipartFile file);
    List<CategoryResponse> read();
    void delete(String categoryId);
}
