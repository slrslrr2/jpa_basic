package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member{
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private long id;

    @Column(name="USERNAME")
    private String username;

    // 집주소 homAddress
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name="FAVORIT_FOOD")
    @Column(name="FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name="ADDRESS_HISTORY")
//    private List<Address> addressesHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressEntities = new ArrayList<>();

    public List<AddressEntity> getAddressEntities() {
        return addressEntities;
    }

    public void setAddressEntities(List<AddressEntity> addressEntities) {
        this.addressEntities = addressEntities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

/**
    // fetch = FetchType.LAZY 로 하면
    // 프록시 객체로 조회한다.
    // 즉. team이 필요할 때 조회하고
    // Member 조회할 때에는 조회X
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "TEAM_ID", nullable = false)
    private Team team;
    **/
}
