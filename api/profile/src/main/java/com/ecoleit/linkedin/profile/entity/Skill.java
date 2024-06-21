package com.ecoleit.linkedin.profile.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "skills", schema = "linkedin_profile", catalog = "")
public class Skill {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Profile> profiles;

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill skill)) return false;
        return id == skill.id && Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
