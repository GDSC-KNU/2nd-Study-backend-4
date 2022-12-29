package GDSC.Backend4th.Repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @NoArgsConstructor
public class Member {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @Builder
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
