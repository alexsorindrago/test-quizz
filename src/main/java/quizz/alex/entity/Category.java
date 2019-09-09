package quizz.alex.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class Category extends TemplateEntity {


    @Basic(optional = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
