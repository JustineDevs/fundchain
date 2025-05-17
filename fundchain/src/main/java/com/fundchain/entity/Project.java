package com.fundchain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String shortDescription;
    private double fundingGoal;
    private String ethereumAddress;
    private String imageUrl;
    private String category;
    private String tags;
    @ManyToOne
    private User creator;
    private java.sql.Timestamp createdAt;
}