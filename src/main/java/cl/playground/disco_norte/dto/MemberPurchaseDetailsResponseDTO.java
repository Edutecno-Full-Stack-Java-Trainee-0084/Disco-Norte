package cl.playground.disco_norte.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberPurchaseDetailsResponseDTO {
    private Long purchaseId;
    private MemberPurchaseDetailsResponseDTO.MemberDTO member;
    private MemberPurchaseDetailsResponseDTO.AlbumDTO album;
    private String branchName;
    private int quantity;
    private int totalAmount;

    @Data
    @Builder
    public static class MemberDTO {
        private String fullName;
        private String membershipType;
        private String email;
    }

    @Data
    @Builder
    public static class AlbumDTO {
        private String title;
        private String artist;
        private String gender;
        private int price;
    }
}
