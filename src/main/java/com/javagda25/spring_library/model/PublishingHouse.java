package com.javagda25.spring_library.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PublishingHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "publishingHouse", fetch = FetchType.EAGER)
    private Set<Book> books;

    public PublishingHouse(String name) {
        this.name = name;
    }
}
