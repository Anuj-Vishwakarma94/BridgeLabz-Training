package com.FundooNotesApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.FundooNotesApp.entity.Note;
import com.FundooNotesApp.entity.User;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByOwner(User owner);

    Optional<Note> findByNoteIdAndOwner(Long noteId, User owner);

    // --- State-based filters ---
    List<Note> findByOwnerAndPinnedTrueAndTrashedFalse(User owner);

    List<Note> findByOwnerAndArchivedTrueAndTrashedFalse(User owner);

    List<Note> findByOwnerAndTrashedTrue(User owner);

    List<Note> findByOwnerAndTrashedFalse(User owner);

    // --- Search (title or content, case-insensitive, excluding trashed) ---
    @Query("SELECT n FROM Note n WHERE n.owner = :owner AND n.trashed = false " +
           "AND (LOWER(n.title) LIKE LOWER(CONCAT('%', :q, '%')) " +
           "OR LOWER(n.content) LIKE LOWER(CONCAT('%', :q, '%')))")
    List<Note> searchByOwnerAndKeyword(@Param("owner") User owner, @Param("q") String q);
}

