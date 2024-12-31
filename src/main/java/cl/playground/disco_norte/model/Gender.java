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
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genderId;

    @Column(name = "gender_description", length = 50, nullable = false)
    private String genderDescription;

    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();
}
