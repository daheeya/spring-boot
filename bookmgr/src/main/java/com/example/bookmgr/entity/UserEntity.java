package com.example.bookmgr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="user_t")  // table 이름이 UserEntity 가 아닌 user_t 의 이름으로 테이블을 생성해줌
@Entity
public class UserEntity {
    @Id  // pk key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    //@Column(name = "")  // 컬럼명을 지정해줄 수 있지만 보통의 경우 굳이 정해주지 않고 테이블의 이름과 변수이름을 통일 시키는게 맞다.
    @Column(length = 50, nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
