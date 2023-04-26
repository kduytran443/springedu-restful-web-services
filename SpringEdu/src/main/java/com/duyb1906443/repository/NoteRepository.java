package com.duyb1906443.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.NoteEntity;

public interface NoteRepository extends JpaRepository<NoteEntity, Long>{

}