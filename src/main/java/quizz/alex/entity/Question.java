package quizz.alex.entity;

import quizz.alex.enums.QuestionDifficulty;
import quizz.alex.enums.QuestionType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question extends TemplateEntity {

    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_difficulty")
    private QuestionDifficulty questionDifficulty;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_type")
    private QuestionType questionType;

    @OneToMany(mappedBy = "question")
    private final List<Answer> answers = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "test_question",
            joinColumns = {@JoinColumn(name = "question_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "test_id", referencedColumnName = "id")})
    private final List<Testing> testings = new ArrayList<>();
    @ManyToOne(optional = false)
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Testing> getTestings() {
        return testings;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public QuestionDifficulty getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(QuestionDifficulty questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
