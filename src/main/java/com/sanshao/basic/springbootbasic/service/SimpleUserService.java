package com.sanshao.basic.springbootbasic.service;


import com.sanshao.basic.springbootbasic.domain.SimpleUser;
import com.sanshao.basic.springbootbasic.domain.SimpleUserRepository;
import com.sanshao.basic.springbootbasic.logs.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class SimpleUserService {
    @Autowired
    private SimpleUserRepository simpleUserRepository;


    @LogAnnotation("Add User")
    public SimpleUser addUser(SimpleUser simpleUser) {
        log.info("Add a User");
        return simpleUserRepository.save(simpleUser);
    }


    @LogAnnotation("Delete User")
    public boolean deleteUser(Long id) {
        try {
            simpleUserRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @LogAnnotation("Update User")
    public boolean updateUser(SimpleUser simpleUser) {
        long id = simpleUser.getId();
        SimpleUser simpleUser1 = simpleUserRepository.findById(id).get();
        if (simpleUser1 == null) {
            return false;
        }
        simpleUser1.setAge(simpleUser.getAge());
        simpleUser1.setName(simpleUser.getName());
        simpleUser1.setScore(simpleUser.getScore());
        try {
            simpleUserRepository.save(simpleUser1);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @LogAnnotation("Get User")
    public SimpleUser getSimpleUser(Long id) {
        return simpleUserRepository.findById(id).get();
    }

    @LogAnnotation("Get Users")
    public List<SimpleUser> getSimpleUsers(String name, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");

        //返回Page对象。所有
//        Page<SimpleUser> simpleUsers = simpleUserRepository.findAll(pageable);
        //返回Page对象。name查询
        Page<SimpleUser> simpleUsers = simpleUserRepository.findByNameLike("%" + name + "%", pageable);
//        //返回Page对象。name查询，前五个
//        Page<SimpleUser> simpleUsers = simpleUserRepository.findFirst5ByNameLike("%" + name + "%", pageable);
//        //返回Page对象。name查询，前五个
//        Page<SimpleUser> simpleUsers = simpleUserRepository.findTop5ByNameLike("%" + name + "%", pageable);

        return simpleUsers.getContent();

    }
}
