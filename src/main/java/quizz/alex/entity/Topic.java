package quizz.alex.entity;

import quizz.alex.enums.TopicDifficulty;

import javax.persistence.*;

@Entity
@Table(name = "topic")
public class Topic extends TemplateEntity {

    @Column(name = "number_of_questions")
    int numberOfQuestions;

    @Column(name = "difficulty")
    @Enumerated(EnumType.STRING)
    private TopicDifficulty topicDifficulty;

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public TopicDifficulty getTopicDifficulty() {
        return topicDifficulty;
    }

    public void setTopicDifficulty(TopicDifficulty topicDifficulty) {
        this.topicDifficulty = topicDifficulty;
    }
}
