package quizz.alex.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "candidate")
public class Candidate extends TemplateEntity {


    @Column(name = "email")
    private String email;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;

//    @OneToOne(optional = false)
//    @JoinColumn(name = "question", referencedColumnName = "id")
//    Question question;
//
//    public Question getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Question question) {
//        this.question = question;
//    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
