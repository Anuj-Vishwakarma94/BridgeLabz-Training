package com.fundoo.notes.repository;

import com.fundoo.notes.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
    List<Label> findByUserId(Long userId);
    Optional<Label> findByLabelIdAndUserId(Long labelId, Long userId);
}
