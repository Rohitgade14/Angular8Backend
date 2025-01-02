package com.krios.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.krios.entity.UserData;

public interface DataRepository extends JpaRepository<UserData, Integer> {

//	Page<UserData> findAll(Pageable pageable);

}