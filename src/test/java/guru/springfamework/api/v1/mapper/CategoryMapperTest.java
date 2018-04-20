package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rubatsirochiripa on 2/4/2018.
 */
public class CategoryMapperTest {

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;


    @Test
    public void categoryToCategoryDTO() throws Exception {

        //given
        Category category = new Category();
        category.setName("Joe");
        category.setId(1l);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(1l), categoryDTO.getId());
        assertEquals("Joe", categoryDTO.getName());
    }

}