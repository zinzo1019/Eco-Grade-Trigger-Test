package com.example.hellospringbatch.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    private String user_id;

    private String name;

    private int point;

    public void changePoint(int point) {
        this.point = point;
    }

}

