package cl.playground.disco_norte.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberPurchaseResponseDTO {
    private Long purchaseId;
    private MemberDTO member;
    private AlbumDTO album;
    private String branchName;
    private int quantity;
    private int totalAmount;

    @Data
    @Builder
    public static class MemberDTO {
        private String fullName;
        private String membershipType;
    }

    @Data
    @Builder
    public static class AlbumDTO {
        private String title;
        private String artist;
        private int price;
    }

}
