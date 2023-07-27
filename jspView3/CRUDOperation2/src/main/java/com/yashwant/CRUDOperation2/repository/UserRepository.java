package com.yashwant.CRUDOperation2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yashwant.CRUDOperation2.entity.Users;
@Repository

public interface UserRepository extends CrudRepository<Users, Integer> {

}
