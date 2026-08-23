package com.FundooNotesApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FundooNotesApp.entity.Label;
import com.FundooNotesApp.entity.User;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

    List<Label> findByOwner(User owner);

    Optional<Label> findByLabelIdAndOwner(Long labelId, User owner);

    boolean existsByNameAndOwner(String name, User owner);
}
