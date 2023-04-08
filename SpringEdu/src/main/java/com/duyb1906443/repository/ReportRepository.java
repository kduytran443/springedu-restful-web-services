package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.ReportEntity;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
	List<ReportEntity> findAllByOrderByIdDesc();
}
