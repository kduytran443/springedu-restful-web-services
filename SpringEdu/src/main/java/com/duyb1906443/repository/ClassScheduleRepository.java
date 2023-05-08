package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.ClassScheduleEntity;
import com.duyb1906443.entity.WeeklyClassScheduleEntity;

public interface ClassScheduleRepository extends JpaRepository<ClassScheduleEntity, Long> {
	
	List<ClassScheduleEntity> findByWeeklyClassSchedule(WeeklyClassScheduleEntity weeklyClassSchedule);
	
}
