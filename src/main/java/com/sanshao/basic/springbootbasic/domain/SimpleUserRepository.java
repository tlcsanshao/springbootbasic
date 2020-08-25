package com.sanshao.basic.springbootbasic.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, Long> {

    //分页
    Page<SimpleUser> findAll(Pageable pageable);

    Page<SimpleUser> findByNameLike(String name, Pageable pageable);

    Page<SimpleUser> findFirst5ByNameLike(String name, Pageable pageable);

    Page<SimpleUser> findTop5ByNameLike(String name, Pageable pageable);

    List<SimpleUser> findTop10ByNameLike(String name, Pageable pageable);

    //自定义query
    @Modifying
    @Transactional
    @Query("update SimpleUser u set u.name = ?1 where u.id = ?2")
    int modifyNameById(String name, Long id);

}
