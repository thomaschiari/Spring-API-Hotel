package com.example.demo.hotel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Hotel {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column
    @NotNull
    @NonNull
    protected String hotel;

    @Column
    @NotNull
    @NonNull
    protected String identifier;

    @Column
    @NotNull
    @NonNull
    protected Integer stars;

    @Column
    @NotNull
    @NonNull
    protected Double dailyRate;
}
