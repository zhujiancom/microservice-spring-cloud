package com.zj.cloud.repository;

import com.zj.cloud.entiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuji on 4/24/2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
