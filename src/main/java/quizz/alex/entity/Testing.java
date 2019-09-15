package quizz.alex.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "test")
public class Testing extends TemplateEntity {

    @ManyToMany(mappedBy = "testings")
    private final List<Question> questions = new ArrayList<>();
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public List<Question> getQuestions() {
        return questions;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
