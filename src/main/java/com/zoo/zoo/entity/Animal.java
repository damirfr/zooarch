package com.zoo.zoo.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "age")
    private int age;

}
