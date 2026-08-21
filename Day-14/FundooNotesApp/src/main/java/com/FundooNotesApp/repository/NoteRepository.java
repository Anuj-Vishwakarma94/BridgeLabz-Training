package com.FundooNotesApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FundooNotesApp.entity.Note;
import com.FundooNotesApp.entity.User;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByOwner(User owner);

    Optional<Note> findByNoteIdAndOwner(Long noteId, User owner);
}
