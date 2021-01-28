package com.pramod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramod.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
