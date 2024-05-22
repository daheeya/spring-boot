package com.example.bookmgr.repository;

import com.example.bookmgr.entity.UserEntity;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void crudTest() {
        // save : insert and update
        userRepository.save(
                UserEntity.builder()
                        .idx(1L)
                        .name("david")
                        .email("david@gmail.com")
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build()
        );
    }

    @Test
    void dummydataTest(){
        List<UserEntity> users= Arrays.asList(
                UserEntity.builder().name("dahee").email("ekgml@naver.com").createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build(),
                UserEntity.builder().name("mike").email("mike@naver.com").createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build(),
                UserEntity.builder().name("steve").email("steve@naver.com").createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build(),
                UserEntity.builder().name("jason").email("jason@naver.com").createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build()
        );
        userRepository.saveAll(users); // saveAll을 통해 uesrs List의 데이터를 하나씩 넣음
    }


/* jpaMethodTest() */
    @Test
    void jpaMethodTest(){
        //var users = userRepository.findAll();
        //users.forEach(System.out::println);

        //var users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        //users.forEach(System.out::println);

        //var user = userRepository.findById(3L);
        //user.ifPresent(u->System.out.println(u));
        //System.out.println(user.orElseThrow());
        /*if (user.isPresent()) {
            System.out.println(user.get());
        }*/

        userRepository.findAllById(Lists.list(1L,2L,5L)).forEach(System.out::println);
    }

    @Test
    void pageableTest(){
        Pageable pageable = PageRequest.of(0,2,Sort.by(Sort.Direction.DESC, "name"));
        Page<UserEntity> page = userRepository.findAll(pageable);
        System.out.println("total page = "+page.getTotalPages());
        System.out.println("total elements = "+page.getTotalElements());
        System.out.println("current page number = "+page.getNumber());
        System.out.println("get content = "+page.getContent());
        System.out.println("isFirst = "+page.isFirst());
        System.out.println("isLast = "+page.isLast());
    }

    @Test
    void idxDeleteTest(){
        /*
        var user = userRepository.findById(3L);
        userRepository.delete(user.get());

        var users = userRepository.findAll();
        users.forEach(System.out::println);
        */
        userRepository.findById(3L).ifPresent(e->userRepository.delete(e));
        userRepository.deleteById(3L);
    }

/*
이름이 pupu 인사람을 추가하고
추가된 사용자의 email을 다른 것으로 변경해서 저장해보자.
 */

    @Test
    void updateTest(){
        userRepository.save(UserEntity.builder().name("pupu").email("pupu@gmail.com")  // 생성
                .createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build());
        // userRepository.save(UserEntity.builder().idx(11L).email("change@gmail.com").build()); <- error!
        userRepository.save(UserEntity.builder().idx(11L).name("pupu").email("change@gmail.com").build());  // 변경
    }
    @Test
    void idxEntityUpdateTest(){

        var user = UserEntity.builder().idx(11L).name("korea").email("korea@gmail.com")
                .createdAt(LocalDateTime.now()).updatedAt(LocalDateTime.now()).build();
        System.out.println("===============================");
        user.setEmail("korea11@gmail.com");
        userRepository.save(user);
    }
    @Test
    void update2Test(){
        // version : 2.XX
        userRepository.findById(11L).ifPresent(e->{
            e.setEmail("korea99@gmail.com");
            System.out.println("==============================");
            userRepository.save(e);
        });
    }

    @Test
    void update3Test(){
        // version : 3.XX
        userRepository.save(UserEntity.builder().idx(11L)
                .name("idx")
                .email("idx88@gmail.com")
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build());
    }

    @Test
    void queryMethodTest(){
        userRepository.findByName("korea").ifPresent(e-> System.out.println(e));
    }
}