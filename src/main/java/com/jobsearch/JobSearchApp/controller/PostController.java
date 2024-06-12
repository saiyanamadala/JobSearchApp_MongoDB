package com.jobsearch.JobSearchApp.controller;

import com.jobsearch.JobSearchApp.model.Post;
import com.jobsearch.JobSearchApp.repository.PostRepository;
import com.jobsearch.JobSearchApp.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;

    @GetMapping("/posts")
    public List<Post> getAll(){
        return repo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }

    @PostMapping("/post/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

}
