package com.jobsearch.JobSearchApp.repository;

import com.jobsearch.JobSearchApp.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImplementation implements SearchRepository{

    @Autowired
    MongoClient mClient;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {
        List<Post> posts= new ArrayList<>();
        MongoDatabase database = mClient.getDatabase("Job");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", text)
                                                .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));

        result.forEach(doc->posts.add(converter.read(Post.class,doc)));


        return posts;
    }
}
