package com.kdevwans.ApiWithSql.repo;

import com.kdevwans.ApiWithSql.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customers" , path = "customers")
public interface CustomerRepo extends JpaRepository<Customers,Integer> {
}
