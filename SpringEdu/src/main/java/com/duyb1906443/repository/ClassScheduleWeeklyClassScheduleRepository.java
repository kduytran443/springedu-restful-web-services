package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassScheduleEntity;
import com.duyb1906443.entity.ClassScheduleWeeklyClassScheduleEntity;

public interface ClassScheduleWeeklyClassScheduleRepository extends JpaRepository<ClassScheduleWeeklyClassScheduleEntity, Long> {
	
	List<ClassScheduleWeeklyClassScheduleEntity> findAllByClassSchedule(ClassScheduleEntity classSchedule);
	
}
