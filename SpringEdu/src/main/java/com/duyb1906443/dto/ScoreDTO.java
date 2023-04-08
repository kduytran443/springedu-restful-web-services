package com.duyb1906443.dto;

public class ScoreDTO {
	private Long submittedExerciseId;
	private Float mark;
	private String teacherComment;

	public Long getSubmittedExerciseId() {
		return submittedExerciseId;
	}

	public void setSubmittedExerciseId(Long submittedExerciseId) {
		this.submittedExerciseId = submittedExerciseId;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	public String getTeacherComment() {
		return teacherComment;
	}

	public void setTeacherComment(String teacherComment) {
		this.teacherComment = teacherComment;
	}

}
