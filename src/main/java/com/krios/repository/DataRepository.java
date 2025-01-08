package com.krios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krios.entity.UserData;

public interface DataRepository extends JpaRepository<UserData, Integer> {



}