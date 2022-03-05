package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {
    @Id
    @GeneratedValue
    @Column(name="PARENT_ID")
    private long id;
    private String Name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Child> childs = new ArrayList<>();

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

    public List<Child> getChilds() {
        return childs;
    }

    public void addChild(Child child) {
        this.childs.add(child);
        child.setParent(this);
    }
}
