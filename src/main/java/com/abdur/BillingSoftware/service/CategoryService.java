package com.abdur.BillingSoftware.service;

import com.abdur.BillingSoftware.io.CategoryRequest;
import com.abdur.BillingSoftware.io.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request);
    List<CategoryResponse> read();
    void delete(String categoryId);
}
