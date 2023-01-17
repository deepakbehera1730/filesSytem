package com.pdf.excelrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdf.entity.Users;

@Repository
public interface ExcelRepository extends JpaRepository<Users, Integer> {

}
