package com.duyb1906443.dto;

import java.util.Date;

public class DateDTO {
	private int year;
	private int month;
	private int day;
	private int hours;
	private int minutes;
	private int seconds;
	
	@SuppressWarnings("deprecation")
	public DateDTO(long l) {
		Date date = new Date(l);
		
		this.year = date.getYear();
		this.month = date.getMonth();
		this.day = date.getDay();
		this.hours = date.getHours();
		this.minutes = date.getMinutes();
		this.seconds = date.getSeconds();
		
	}
	@Override
	public String toString() {
		return "DateDTO [year=" + year + ", month=" + month + ", day=" + day + ", hours=" + hours + ", minutes="
				+ minutes + ", seconds=" + seconds + "]";
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
}
