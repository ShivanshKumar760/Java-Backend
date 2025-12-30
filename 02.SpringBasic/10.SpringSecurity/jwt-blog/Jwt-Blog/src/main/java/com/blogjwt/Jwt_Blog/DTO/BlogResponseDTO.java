package com.blogjwt.Jwt_Blog.DTO;

public class BlogResponseDTO {
    private int id;
    private String blogTitle;
    private String blogDescription;

    public BlogResponseDTO(int id, String blogTitle, String blogDescription) {
        this.id = id;
        this.blogTitle = blogTitle;
        this.blogDescription = blogDescription;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }
}
