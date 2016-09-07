package com.flemby.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Paul on 25/06/2016.
 */

@Entity
@Table(name = "calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_seq_gen")
    @SequenceGenerator(initialValue = 1000,
            allocationSize = 1, name = "calendar_seq_gen", sequenceName = "calendar_id_seq")
    private Integer id;

    private String month;

    @ElementCollection
    @JsonIgnore
    private List<String> title;

    @ElementCollection
    @JsonIgnore
    private List<String> description;

    private int days;

    @ElementCollection
    @JsonIgnore
    private List<String> dates;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<String> getDates() {
        return dates;
    }

    public void setDates(List<String> dates) {
        this.dates = dates;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
