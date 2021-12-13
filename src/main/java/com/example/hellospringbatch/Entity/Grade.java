package com.example.hellospringbatch.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Grade {

    @Id
    @Column(name = "user_id", nullable = false)
    private String user_id;

    private String grade;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
