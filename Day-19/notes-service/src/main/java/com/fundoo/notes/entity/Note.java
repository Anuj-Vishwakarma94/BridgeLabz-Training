package com.fundoo.notes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    private boolean pinned   = false;
    private boolean archived = false;
    private boolean trashed  = false;

    private LocalDateTime reminderAt;
    private boolean reminderSent = false;

    @Column(name = "user_id")
    private Long userId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "note_labels",
        joinColumns = @JoinColumn(name = "note_id"),
        inverseJoinColumns = @JoinColumn(name = "label_id")
    )
    private List<Label> labels = new ArrayList<>();
}
