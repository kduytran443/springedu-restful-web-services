package com.duyb1906443.dto;

import java.util.Date;
import java.util.List;

public class ClassExcerciseDTO {
	private Long id;
	private String name;
	private Date createdTime;
	private Date startTime;
	private Date endTime;
	private float mark;
	private int effective;
	private Long classEntity;
	private List<Long> files;
	private List<Long> submittedExercises;
	private List<Long> ChoiceQuestionOfClassExcercises;

}
