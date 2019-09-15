package quizz.alex.entity;


import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer extends TemplateEntity {

    @Column(name = "text")
    private String text;

    @Column(name = "value")
    private boolean value;

    @ManyToOne(optional = false)
    @JoinColumn(name = "question", referencedColumnName = "id")
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
