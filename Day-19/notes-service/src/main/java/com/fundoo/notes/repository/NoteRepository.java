package com.fundoo.notes.repository;

import com.fundoo.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUserId(Long userId);
    Optional<Note> findByNoteIdAndUserId(Long noteId, Long userId);

    List<Note> findByUserIdAndPinnedTrue(Long userId);
    List<Note> findByUserIdAndArchivedTrue(Long userId);
    List<Note> findByUserIdAndTrashedTrue(Long userId);

    @Query("SELECT n FROM Note n WHERE n.userId = :userId AND (LOWER(n.title) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(n.content) LIKE LOWER(CONCAT('%', :query, '%')))")
    List<Note> searchNotes(@Param("userId") Long userId, @Param("query") String query);

    @Query("SELECT n FROM Note n WHERE n.reminderAt <= :now AND n.reminderSent = false")
    List<Note> findDueReminders(@Param("now") LocalDateTime now);
}
