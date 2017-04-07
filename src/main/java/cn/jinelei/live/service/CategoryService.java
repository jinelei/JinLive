package cn.jinelei.live.service;

import cn.jinelei.live.exception.CategoryException;
import cn.jinelei.live.model.data.Category;

import java.util.List;

/**
 * Created by jinelei on 17-4-7.
 */
public interface CategoryService {

    Category insertCategory(Category category) throws CategoryException;

    Category insertCategory(String categoryName, String categoryIntroduce) throws CategoryException;

    boolean deleteCategory(Category category) throws CategoryException;

    boolean deleteCategory(Integer categoryId) throws CategoryException;

    Category updateCategory(Category category) throws CategoryException;

    Category updateCategory(Integer categoryId, String categoryName, String categoryIntroduce) throws CategoryException;

    Category getCategory(Integer categoryId) throws CategoryException;

    List<Category> getCategoryFuzzyName(String categoryName);

    List<Category> getCategoryFuzzyIntroduce(String categoryIntroduce);

    List<Category> getCategoryAll();

}
