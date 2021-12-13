package com.example.hellospringbatch;

import com.example.hellospringbatch.Entity.Grade;
import com.example.hellospringbatch.Entity.User;
import com.example.hellospringbatch.Repository.GradeRepository;
import com.example.hellospringbatch.Repository.UserRepository;
import com.example.hellospringbatch.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private UserService userService;

    /*
    user 테이블에 데이터 삽입
     */
    @Test
    public void insertDummiesInUser() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            User user = User.builder()
                    .user_id("email" + i + "@naver.com")
                    .name("user" + i)
                    .point((int) (Math.random() * 300 + 1))
                    .build();
            userRepository.save(user);
        });
    }

    /*
    grade 테이블에 데이터 삽입 (grade 속성엔 null 데이터 삽입)
     */
    @Test
    public void insertDummiesInGrede() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Grade grade = Grade.builder()
                    .user_id("email" + i + "@naver.com")
                    .build();
            gradeRepository.save(grade);
        });
    }

    /*
    user 테이블의 point 데이터 업데이트 -> grade 테이블의 grade 데이터가 자동 업데이트 됨
     */
    @Test
    public void updatePoint() {

        IntStream.rangeClosed(1, 10).forEach(i -> {
            User user = User.builder()
                    .user_id("email" + i + "@naver.com")
                    .point((int) (Math.random() * 300 + 1))
                    .build();
            userService.updatePoint(user);
        });
    }

}
