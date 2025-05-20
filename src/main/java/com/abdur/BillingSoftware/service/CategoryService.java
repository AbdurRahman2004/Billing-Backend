package com.abdur.BillingSoftware.service;

import com.abdur.BillingSoftware.io.CategoryRequest;
import com.abdur.BillingSoftware.io.CategoryResponse;

public interface CategoryService {

    CategoryResponse add(CategoryRequest request);
}
