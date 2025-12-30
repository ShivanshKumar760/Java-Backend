package com.blogjwt.Jwt_Blog.Mapper;

import com.blogjwt.Jwt_Blog.DTO.BlogRequestDTO;
import com.blogjwt.Jwt_Blog.DTO.BlogResponseDTO;
import com.blogjwt.Jwt_Blog.Entity.Blog;
import com.blogjwt.Jwt_Blog.Entity.User;

public class BlogMapper {
    public  static Blog toEntity(BlogRequestDTO dto , User user){
        Blog blog=new Blog();
        blog.setBlogTitle(dto.getBlogTitle());
        blog.setBlogDescription(dto.getBlogDescription());
        blog.setUser(user);

        return blog;
    }


    public static BlogResponseDTO toResponse(Blog blog){
        return  new BlogResponseDTO(
                blog.getId(),
                blog.getBlogTitle(),
                blog.getBlogDescription()
        );
    }
}
