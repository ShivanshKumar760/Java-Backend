package com.blogjwt.Jwt_Blog.Service;

import com.blogjwt.Jwt_Blog.DTO.BlogRequestDTO;
import com.blogjwt.Jwt_Blog.DTO.BlogResponseDTO;
import com.blogjwt.Jwt_Blog.Entity.Blog;
import com.blogjwt.Jwt_Blog.Entity.User;
import com.blogjwt.Jwt_Blog.Mapper.BlogMapper;
import com.blogjwt.Jwt_Blog.Repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {
//    private final Blog blog;
    private final BlogRepository blogRepo;

//    public BlogService(Blog blog, BlogRepository blogRepo) {
//        this.blog = blog;
//        this.blogRepo = blogRepo;
//    }

    public BlogService(BlogRepository blogRepo) {
        this.blogRepo = blogRepo;
    }

    public BlogResponseDTO createBlog(BlogRequestDTO dto, User user){
            Blog blog = BlogMapper.toEntity(dto, user);
            blogRepo.save(blog);
            return BlogMapper.toResponse(blog);
    }

    public List<BlogResponseDTO> getBlogs(User user){
        return blogRepo.findByUserUsername(user.getUsername())
                .stream().map(BlogMapper::toResponse).collect(Collectors.toList());
    }

    public BlogResponseDTO getBlogById(Long id){
        Blog blog = blogRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        return BlogMapper.toResponse(blog);
    }
}
