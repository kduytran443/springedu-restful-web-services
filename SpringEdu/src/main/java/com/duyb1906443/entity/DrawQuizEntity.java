package com.duyb1906443.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`draw_quiz`")
public class DrawQuizEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private QuizEntity quiz;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "draw_quiz_choice_answer", joinColumns = @JoinColumn(name = "draw_quiz_id"), inverseJoinColumns = @JoinColumn(name = "choice_answer_id"))
	private List<ChoiceAnswerEntity> choiceAnswers;

	@ManyToOne
	@JoinColumn(name = "choice_question_id")
	private ChoiceQuestionEntity choiceQuestion;

	@ManyToOne
	@JoinColumn(name = "submitted_exercise_id")
	private SubmittedExerciseEntity submittedExercise;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QuizEntity getQuiz() {
		return quiz;
	}

	public void setQuiz(QuizEntity quiz) {
		this.quiz = quiz;
	}

	public List<ChoiceAnswerEntity> getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(List<ChoiceAnswerEntity> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

	public ChoiceQuestionEntity getChoiceQuestion() {
		return choiceQuestion;
	}

	public void setChoiceQuestion(ChoiceQuestionEntity choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}

	public SubmittedExerciseEntity getSubmittedExercise() {
		return submittedExercise;
	}

	public void setSubmittedExercise(SubmittedExerciseEntity submittedExercise) {
		this.submittedExercise = submittedExercise;
	}

}
