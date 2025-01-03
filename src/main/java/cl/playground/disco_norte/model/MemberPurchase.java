package cl.playground.disco_norte.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="member_purchase")
public class MemberPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_purchase_id")
    private Long menberPurchaseId;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member memberId;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album albumId;


    @Column(name = "quantity", nullable = false)
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branchId;
}
