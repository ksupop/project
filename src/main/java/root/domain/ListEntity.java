package root.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public ListEntity() {}

    public ListEntity(String name) {
        this (null, name);
    }

    public ListEntity(Long id, String name) {
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
}