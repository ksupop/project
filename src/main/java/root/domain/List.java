package root.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class List {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public List() {}

    public List(String name) {
        this (null, name);
    }

    public List(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "list")
    private Set<Task> tasks;

    public Set<Task> getTask() {
        return tasks;
    }

    public void setTask(Set<Task> tasks) {
        this.tasks = tasks;
    }
}