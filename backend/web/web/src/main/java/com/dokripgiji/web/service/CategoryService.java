package com.dokripgiji.web.service;

import com.dokripgiji.web.controller.dto.CategoryDto;
import com.dokripgiji.web.domain.category.Category;
import com.dokripgiji.web.domain.category.CategoryRepository;
import com.dokripgiji.web.domain.user.User;
import com.dokripgiji.web.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    public final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    @Transactional
    public Category saveCategory(CategoryDto categoryDto){


        System.out.println("1 = " + 1);
        User user = userRepository.getByUserId(categoryDto.getUserId());
        String code= categoryDto.getCode();
        System.out.println("2 = " + 2);

        Category category=Category.builder()
                .user(user)
                .code(code)
                .build();
        System.out.println("3 = " + 3);

        categoryRepository.save(category);
        return category;
    }
}
