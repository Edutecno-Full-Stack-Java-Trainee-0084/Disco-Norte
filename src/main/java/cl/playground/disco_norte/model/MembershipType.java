package cl.playground.disco_norte.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "membership_type")
public class MembershipType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipTypeId;

    @Column(name = "membership_type_description", length = 50, nullable = false)
    private String branchDescription;

    @OneToMany(mappedBy = "membership", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();
}
