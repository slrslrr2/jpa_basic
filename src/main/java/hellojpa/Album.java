package hellojpa;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Album")
public class Album extends Item{
    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
