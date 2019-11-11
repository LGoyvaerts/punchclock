package ch.zli.m223.punchclock.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonManagedReference("job")
    @OneToMany(mappedBy = "job")
    private List<ApplicationUser> applicationUser;

    public Job() {
    }

    public Job(String name) {
        this.name = name;
    }

    public Job(String name, List<ApplicationUser> applicationUser) {
        this.name = name;
        this.applicationUser = applicationUser;
    }

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
}
