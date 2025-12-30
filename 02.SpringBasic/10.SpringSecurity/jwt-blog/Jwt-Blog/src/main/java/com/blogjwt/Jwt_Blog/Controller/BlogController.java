package com.blogjwt.Jwt_Blog.Controller;

import com.blogjwt.Jwt_Blog.DTO.BlogRequestDTO;
import com.blogjwt.Jwt_Blog.DTO.BlogResponseDTO;
import com.blogjwt.Jwt_Blog.Entity.User;
import com.blogjwt.Jwt_Blog.Service.BlogService;
import com.blogjwt.Jwt_Blog.Service.UserService;
//import org.springframework.security.core.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
//blog service and user service
    private final BlogService blogService;
    private final UserService userService;

    public BlogController(BlogService blogService, UserService userService) {
        this.blogService = blogService;
        this.userService = userService;
    }

//    @PostMapping
//    public BlogResponseDTO createTodo(@RequestBody BlogRequestDTO dto, @RequestParam String username) {
//        User user = userService.getUserEntity(username);
//        return blogService.createBlog(dto, user);
//    }
//
//    @GetMapping
//    public List<BlogResponseDTO> getTodos(@RequestParam String username) {
//        User user = userService.getUserEntity(username);
//        return blogService.getBlogs(user);
//    }



    @PostMapping
    public BlogResponseDTO createBlog(@RequestBody BlogRequestDTO dto, Authentication auth) {
        User user = userService.getUserEntity(auth.getName());
        return blogService.createBlog(dto, user);
    }

    @GetMapping
    public List<BlogResponseDTO> getBlogs(Authentication auth) {
        User user = userService.getUserEntity(auth.getName());
        return blogService.getBlogs(user);
    }

    @GetMapping("/{id}")
    public BlogResponseDTO getBlogById(@PathVariable Long id,Authentication auth){
        if(!auth.isAuthenticated()){
            throw new RuntimeException("Not Authenticated");
        }
        return blogService.getBlogById(id);
    }
}
