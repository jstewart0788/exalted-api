package com.jstewart.exalted.model;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jstewart.exalted.enumerations.Types;
import com.jstewart.exalted.enumerations.Durations;


@Entity
@Table(name = "charms")
public class Charm extends AuditModel {

    /* Fields */

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
    private String name;

    @NotNull
    @ElementCollection
    private Map<String, Integer> mins = new HashMap<String, Integer>();

    @ElementCollection
    private Map<String, Integer> costs = new HashMap<String, Integer>();

    @NotNull
    @ElementCollection
    private List<String> elements = new ArrayList<String>();

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Types type;

    @ElementCollection
    private List<String> effects = new ArrayList<String>();

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Durations duration;

    @ElementCollection
    private Map<String, Integer> prerequisite = new HashMap<String, Integer>();

    @NotNull
    private short page;

    @NotBlank
    @Lob
    private String description;

    /*  Getters and Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getMins() {
        return this.mins;
    }

    public void setMins(String name, Integer value) {
        this.mins.put(name, value);
    }

    public Map<String, Integer> getCosts() {
        return this.costs;
    }

    public void setCosts(String name, Integer value) {
        this.costs.put(name, value);
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public List<String> getEffects() {
        return effects;
    }

    public void setEffects(List<String> effects) {
        this.effects = effects;
    }

    public Durations getDuration() {
        return duration;
    }

    public void setDuration(Durations duration) {
        this.duration = duration;
    }

    public Map<String, Integer> getPrerequisite() {
        return this.prerequisite;
    }

    public void setPrerequisite(String name, Integer value) {
        this.prerequisite.put(name, value);
    }

    public short getPage() {
        return page;
    }

    public void setPage(short page) {
        this.page = page;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
