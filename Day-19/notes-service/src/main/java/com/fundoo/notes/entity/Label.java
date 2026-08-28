package com.fundoo.notes.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "labels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labelId;

    @Column(nullable = false)
    private String name;

    @Column(name = "user_id")
    private Long userId;

    public Label(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }
}
