package cl.playground.disco_norte.mapper;

import cl.playground.disco_norte.dto.MemberPurchaseDetailsResponseDTO;
import cl.playground.disco_norte.model.MemberPurchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseDetailsMapper {

    public MemberPurchaseDetailsResponseDTO toDTO (MemberPurchase memberPurchase){
        return MemberPurchaseDetailsResponseDTO.builder()
                .purchaseId(memberPurchase.getMemberPurchaseId())
                .member(MemberPurchaseDetailsResponseDTO.MemberDTO.builder()
                        .fullName(memberPurchase.getMemberId().getFirstName() + " " + memberPurchase.getMemberId().getLastName())
                        .membershipType(memberPurchase.getMemberId().getMembership().getMembershipTypeDescription())
                        .email(memberPurchase.getMemberId().getEmail())
                        .build())
                .album(MemberPurchaseDetailsResponseDTO.AlbumDTO.builder()
                        .title(memberPurchase.getAlbumId().getAlbumTitle())
                        .artist(memberPurchase.getAlbumId().getArtistName())
                        .gender(memberPurchase.getAlbumId().getMusicGenre())
                        .price(memberPurchase.getAlbumId().getPrice())
                        .build())
                .branchName(memberPurchase.getBranchId().getBranchDescription())
                .quantity(memberPurchase.getQuantity())
                .totalAmount(memberPurchase.getQuantity() * memberPurchase.getAlbumId().getPrice())
                .build();
    }
}
