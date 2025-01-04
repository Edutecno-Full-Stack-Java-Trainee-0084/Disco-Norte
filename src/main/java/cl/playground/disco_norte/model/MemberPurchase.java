package cl.playground.disco_norte.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "member_purchase")
public class MemberPurchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_purchase_id")
    private Long memberPurchaseId;

    @ToString.Include
    private String getMemberInfo() {
        return String.format("Member: %s %s (%s)",
                memberId.getFirstName(),
                memberId.getLastName(),
                memberId.getMembership().getMembershipTypeDescription());
    }

    @ToString.Include
    private String getAlbumInfo() {
        return String.format("Album: %s by %s ($%d)",
                albumId.getAlbumTitle(),
                albumId.getArtistName(),
                albumId.getPrice());
    }

    @ToString.Include
    private String getBranchInfo() {
        return String.format("Branch: %s", branchId.getBranchDescription());
    }

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    @ToString.Exclude
    private Member memberId;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    @ToString.Exclude
    private Album albumId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    @ToString.Exclude
    private Branch branchId;
}