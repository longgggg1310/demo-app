package com.example.demo.repository;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.domain.EmployeeDocument;

import java.util.List;
public interface EmployeeRepositoryElasticsearch extends ElasticsearchRepository<EmployeeDocument, Long> {
    @Query("{\"bool\": {\"must\": {\"match\": {\"address\": \"?0\"}}}}")
    List<EmployeeDocument> findByAddress(String fieldValue);

    @Query("{\"fuzzy\": {\"address\": {\"value\": \"?0\", \"fuzziness\": \"auto\"}}}")
    List<EmployeeDocument> findByAddressFuzzy(String address);
}
