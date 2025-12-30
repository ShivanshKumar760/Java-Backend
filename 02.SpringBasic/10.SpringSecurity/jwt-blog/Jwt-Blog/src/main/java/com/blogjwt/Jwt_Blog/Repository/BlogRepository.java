package com.blogjwt.Jwt_Blog.Repository;

import com.blogjwt.Jwt_Blog.Entity.Blog;
//import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Long> {

    List<Blog> findByUserUsername(String username);
}
