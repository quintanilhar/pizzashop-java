package me.quintanilha.pizzashop.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Pizza {
    private long id;

    @Length(max = 60)
    private String name;

    public Pizza() {
    }

    public Pizza(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty
    public long id() {
        return id;
    }

    @JsonProperty
    public String name() {
        return name;
    }
}
