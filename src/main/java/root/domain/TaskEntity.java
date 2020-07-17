package root.domain;
import java.util.Date;
import javax.persistence.*;
import java.time.ZoneId;
import java.time.LocalDateTime;
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Long parentId;
    private Long parent;
    private String title;
    private String discription;
    private Boolean done;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public TaskEntity() {}

    public TaskEntity(Long parent, String title) {
        this(null, parent, title, null, false, null, null, null);
        LocalDateTime currentDataTime = LocalDateTime.now();
        this.createDate = Date.from(currentDataTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public TaskEntity(Long id, Long parent, String title, String discription, Boolean done,
                      Date createDate, Date updateDate, Date date) {
        this.id = id;
        this.parent = parent;
        this.title = title;
        this.discription = discription;
        this.done = done;
        this.createDate = createDate;
        this.updateDate = updateDate;
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

    public void setDiscription(String discription){
        this.discription = discription;
    }

    public String getDiscription(){
        return discription;
    }

    public void setDone(Boolean done){
        this.done = done;
    }

    public Boolean getDone(){
        return done;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }

    public Date getCreateDate(){
        return createDate ;
    }

    public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
    }

    public Date getUpdateDate(){
        return updateDate ;
    }


}