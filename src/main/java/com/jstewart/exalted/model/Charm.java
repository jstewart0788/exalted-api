package com.jstewart.exalted.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.jstewart.exalted.enumerations.Types;
import com.jstewart.exalted.enumerations.Durations;

@Entity
@Table(name = "charms")
public class Charm extends AuditModel {
    @Id
    @GeneratedValue(generator = "charm_generator")
    @SequenceGenerator(
            name = "charm_generator",
            sequenceName = "charm_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @NotBlank
    @Size(min = 3, max = 100)
    private Types type;

    @NotBlank
    @Size(min = 3, max = 100)
    private Durations duration;

    @Column(columnDefinition = "text")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
