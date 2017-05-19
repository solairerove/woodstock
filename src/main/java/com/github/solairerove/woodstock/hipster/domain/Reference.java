package com.github.solairerove.woodstock.hipster.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Reference.
 */
@Entity
@Table(name = "reference")
public class Reference implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "version")
    private String version;

    @OneToMany(mappedBy = "reference")
    @JsonIgnore
    private Set<Chapter> chapters = new HashSet<>();

    @ManyToOne
    private Module module;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Reference title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public Reference version(String version) {
        this.version = version;
        return this;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public Reference chapters(Set<Chapter> chapters) {
        this.chapters = chapters;
        return this;
    }

    public Reference addChapters(Chapter chapter) {
        this.chapters.add(chapter);
        chapter.setReference(this);
        return this;
    }

    public Reference removeChapters(Chapter chapter) {
        this.chapters.remove(chapter);
        chapter.setReference(null);
        return this;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }

    public Module getModule() {
        return module;
    }

    public Reference module(Module module) {
        this.module = module;
        return this;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reference reference = (Reference) o;
        if (reference.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reference.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Reference{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", version='" + getVersion() + "'" +
            "}";
    }
}
