package com.example.hellospringbatch.Repository;

import com.example.hellospringbatch.Entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, String> {

}
