package cl.playground.disco_norte.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    @ToString.Exclude
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    @ToString.Exclude
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "membership_type_id", nullable = false)
    @ToString.Exclude  // Agregado para consistencia
    private MembershipType membership;
}