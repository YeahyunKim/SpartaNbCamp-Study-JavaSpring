package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.ApiUseTime;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//ApiUserTime Entity를 생성한다음 해당 엔티티를 저장할 레포지토리를 생성
public interface ApiUserTimeRepository extends JpaRepository<ApiUseTime, Long> {
    Optional<ApiUseTime> findByUser(User user);
}