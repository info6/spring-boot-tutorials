package com.zhangbo.elasticsearch.dao;

import com.zhangbo.elasticsearch.document.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends ElasticsearchCrudRepository<User, Long> {

	User findByUserNameLike(String userName);

}
