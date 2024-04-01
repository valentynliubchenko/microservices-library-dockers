package com.valentyn;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "BOOK")
public class BookDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

 }