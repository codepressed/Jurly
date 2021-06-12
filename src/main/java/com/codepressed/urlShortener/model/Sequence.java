package com.codepressed.urlShortener.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "sequences")
public class Sequence {

    @Id
    private String id;
    private Long value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sequence sequence = (Sequence) o;
        return Objects.equals(id, sequence.id) && Objects.equals(value, sequence.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
