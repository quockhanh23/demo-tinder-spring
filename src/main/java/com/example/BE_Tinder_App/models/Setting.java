package com.example.BE_Tinder_App.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int startAge;
    private int endAge;
    @Column(length = 50)
    private String educationLevel;
    @Column(length = 20)
    private String smoke;
    @Column(length = 20)
    private String drinkAlcohol;
    @NotNull
    private Long idUser;
    private boolean defaultSetting;
}
