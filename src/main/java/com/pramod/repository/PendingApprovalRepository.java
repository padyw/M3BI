package com.pramod.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramod.entity.PendingApproval;

@Repository
public interface PendingApprovalRepository extends JpaRepository<PendingApproval, Integer>{

	Optional<PendingApproval> findByHotelId(int id);

	Optional<PendingApproval> findByUserId(int id);
}
