package com.example.demo.repositorys;

import com.example.demo.entitys.DrugDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugDetailsRepo extends JpaRepository<DrugDetails, String> {
}
