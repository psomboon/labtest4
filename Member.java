package com.example.demo.entity;

import io.micrometer.core.lang.NonNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Table(name="Member")
public class Member {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="Member_seq",sequenceName="Member_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Member_seq")
    @Column(name="Member_ID",unique = true, nullable = false)
    private @NonNull Long id;
    private @NonNull String name;

    public Long getId() { return id; }

    public void setId(Long id){ this.id=id; }

    public String getName(){ return name; }

    public void setName(String name) { this.name = name; }

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "member",
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Photocollection> photocollection ;

    public Member(){}

    public Member(String name){
        this.name=name;
    }

}

