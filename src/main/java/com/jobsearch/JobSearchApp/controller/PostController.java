package com.jobsearch.JobSearchApp.controller;

import com.jobsearch.JobSearchApp.model.Post;
import com.jobsearch.JobSearchApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @GetMapping("/post")
    public List<Post> getAll(){
        return repo.findAll();
    }

}
