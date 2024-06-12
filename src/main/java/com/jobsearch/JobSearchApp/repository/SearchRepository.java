package com.jobsearch.JobSearchApp.repository;

import com.jobsearch.JobSearchApp.model.Post;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface SearchRepository {
    List<Post> findByText(String text);
}
