package root.domain;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TaskEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Long parent;
    private String title;
    private String discription;
    private Boolean done;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date upDateDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public TaskEntity() {}

    public TaskEntity(Long parent, String title) {
        this(null, parent, title, null, false, null, null, null);

    }

    public TaskEntity(Long id, Long parent, String title, String discription, Boolean done,
                      Date createDate, Date upDateDate, Date date) {
        this.id = id;
        this.parent = parent;
        this.title = title;
        this.discription = discription;
        this.done = done;
        this.createDate = createDate;
        this.upDateDate = upDateDate;
        this.date = date;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setParent(Long parent){
        this.parent = parent;
    }

    public Long getParent(){
        return parent;
    }

    public void setTitle(String tittle){
        this.title = tittle;
    }

    public String getTitle(){
        return title;
    }

  

}