package com.valentyn;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Book {

    private Long id;

    private String title;

    private String author;

 }