package guru.springfamework.services;

import guru.springfamework.api.v1.model.CategoryDTO;

import java.util.List;

/**
 * Created by rubatsirochiripa on 2/4/2018.
 */
public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String catName);
}
