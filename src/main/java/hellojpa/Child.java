package hellojpa;

import javax.persistence.*;

@Entity
public class Child {
    @Id
    @GeneratedValue
    private long id;
    private String Name;

    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    private Parent parent = new Parent();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
