package cl.playground.disco_norte.mapper;

import cl.playground.disco_norte.dto.MemberPurchaseResponseDTO;
import cl.playground.disco_norte.model.MemberPurchase;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {

    public MemberPurchaseResponseDTO toDTO(MemberPurchase purchase) {
        return MemberPurchaseResponseDTO.builder()
                .purchaseId(purchase.getMemberPurchaseId())
                .member(MemberPurchaseResponseDTO.MemberDTO.builder()
                        .fullName(purchase.getMemberId().getFirstName() + " " + purchase.getMemberId().getLastName())
                        .membershipType(purchase.getMemberId().getMembership().getMembershipTypeDescription())
                        .build())
                .album(MemberPurchaseResponseDTO.AlbumDTO.builder()
                        .title(purchase.getAlbumId().getAlbumTitle())
                        .artist(purchase.getAlbumId().getArtistName())
                        .price(purchase.getAlbumId().getPrice())
                        .build())
                .branchName(purchase.getBranchId().getBranchDescription())
                .quantity(purchase.getQuantity())
                .totalAmount(purchase.getQuantity() * purchase.getAlbumId().getPrice())
                .build();
    }

    public Page<MemberPurchaseResponseDTO> toDTO(Page<MemberPurchase> purchases) {
        return purchases.map(this::toDTO);
    }

}
