package com.jobsearch.JobSearchApp.repository;

import com.jobsearch.JobSearchApp.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {

}
