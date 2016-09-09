package com.flemby.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "index")
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "index_seq_gen")
    @SequenceGenerator(initialValue = 1000,
            allocationSize = 1, name = "index_seq_gen", sequenceName = "index_id_seq")
    private Integer id;

    @Column(length = 1000)
    private String text;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "index", cascade = CascadeType.ALL)
    private List<Item> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
