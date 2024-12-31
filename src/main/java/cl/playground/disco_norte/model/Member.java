package cl.playground.disco_norte.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 100, nullable = false)

    private String lastName;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "membership_type_id", nullable = false)
    private MembershipType membership;
}
