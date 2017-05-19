package com.github.solairerove.woodstock.hipster.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Unit.
 */
@Entity
@Table(name = "unit")
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jhi_label")
    private String label;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "description")
    private String description;

    @Column(name = "featured")
    private Boolean featured;

    @OneToMany(mappedBy = "unit")
    @JsonIgnore
    private Set<Module> modules = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public Unit label(String label) {
        this.label = label;
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAvatar() {
        return avatar;
    }

    public Unit avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public Unit description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isFeatured() {
        return featured;
    }

    public Unit featured(Boolean featured) {
        this.featured = featured;
        return this;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public Unit modules(Set<Module> modules) {
        this.modules = modules;
        return this;
    }

    public Unit addModules(Module module) {
        this.modules.add(module);
        module.setUnit(this);
        return this;
    }

    public Unit removeModules(Module module) {
        this.modules.remove(module);
        module.setUnit(null);
        return this;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Unit unit = (Unit) o;
        if (unit.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), unit.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Unit{" +
            "id=" + getId() +
            ", label='" + getLabel() + "'" +
            ", avatar='" + getAvatar() + "'" +
            ", description='" + getDescription() + "'" +
            ", featured='" + isFeatured() + "'" +
            "}";
    }
}
