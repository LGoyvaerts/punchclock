package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    // Constructor for Injection
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Get all Categories
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getAllEntries() {
        return categoryService.findAll();
    }

    // Create Category
    public Category createCategory(@Valid @RequestBody Category category){
        return categoryService.createCategory(category);
    }

    //Delete Category
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void deleteCategoryById(@Valid @PathVariable(value = "id") Long id){
        categoryService.deleteCategoryById(id);
    }
}
