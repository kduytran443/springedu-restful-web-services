package com.duyb1906443.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.entity.ClassScheduleEntity;
import com.duyb1906443.entity.WeeklyClassScheduleEntity;
import com.duyb1906443.mail.MailService;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassScheduleRepository;
import com.duyb1906443.repository.WeeklyClassScheduleRepository;

@Component
public class ScheduledTasksController {

	private String[] daysOfWeek = new String[] { "sunday", "monday", "tuesday", "wednesday", "thursday", "friday",
			"saturday" };

	@Autowired
	private WeeklyClassScheduleRepository weeklyClassScheduleRepository;

	@Autowired
	private ClassScheduleRepository classScheduleRepository;
	
	@Autowired
	private ClassMemberRepository classMemberRepository;
	
	@Autowired
	private MailService mailService;
	
	@Scheduled(fixedRate = 300000)
	public void scheduleTaskWithFixedRate() {
		// call send email method here
		Long miliseconds = 300000L;
		
		Date date = new Date();
		String dayOfWeek = daysOfWeek[date.getDay()];
		
		WeeklyClassScheduleEntity weeklyClassScheduleEntity = weeklyClassScheduleRepository.findOneByCode(dayOfWeek);
		
		Date startTime = new Date(date.getTime() - miliseconds);
		Integer startTimeMinutes = startTime.getHours() * 60 + startTime.getMinutes();
		Integer endTimeMinutes = date.getHours() * 60 + date.getMinutes();
		
		List<ClassScheduleEntity> classScheduleEntities = classScheduleRepository.findByWeeklyClassSchedule(weeklyClassScheduleEntity);
		if (classScheduleEntities != null) {

			List<ClassScheduleEntity> filteredList = classScheduleEntities.stream().filter(item -> {
				Integer scheduleMinutes = item.getStartHours() * 60 + item.getStartMinutes();
				if (scheduleMinutes > startTimeMinutes && scheduleMinutes <= endTimeMinutes) {
					return true;
				}
				return false;
			}).collect(Collectors.toList());
			
			for (ClassScheduleEntity classScheduleEntity : filteredList) {
				ClassEntity classEntity = classScheduleEntity.getClassEntity();
				String subject = "Lớp "+classEntity.getName() + " sẽ bắt đầu buổi học";
				String content = "Đường dẫn đến lớp học: http://localhost:3000/class/"+classEntity.getId()+"/live";
				
				List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByClassEntity(classEntity);
				
				for (ClassMemberEntity member : classMemberEntities) {
					mailService.sendMail(null, member.getUser().getEmail(), subject, content);
				}
				
			}
		}

	}

}
