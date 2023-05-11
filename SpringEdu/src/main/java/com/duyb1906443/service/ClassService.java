package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassDTO;

public interface ClassService {
	
	ClassDTO save(ClassDTO classDTO);
	List<Integer> getClassChart();
	
	boolean checkFavorited(Long classId, Long userId);
	void favorite(Long classId, Long userId);
	
}
