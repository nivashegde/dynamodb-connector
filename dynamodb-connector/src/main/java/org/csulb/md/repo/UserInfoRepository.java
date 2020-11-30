package org.csulb.md.repo;

import org.csulb.md.pojo.UserInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface UserInfoRepository extends CrudRepository<UserInfo, String> {}
