package cl.playground.disco_norte.repository;

import cl.playground.disco_norte.model.MemberPurchase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberPurchaseRepository extends JpaRepository<MemberPurchase, Long> {

    /*
      MemberPurchase
        @Column(name = "member_purchase_id") PK
        @JoinColumn(name = "member_id", nullable = false) FK
        @JoinColumn(name = "album_id", nullable = false) FK
        @Column(name = "quantity", nullable = false) INT
        @JoinColumn(name = "branch_id", nullable = false) FK

        member_name: member_id -> member_name
        email: member_id -> email // NUEVO DATO PARA DETAILS
        membership_type_description: member_id -> membership_type_id -> membership_type_description
        album_title: album_id -> album_title
        music_genre: album_id -> music_genre // NUEVO DATO PARA DETAILS
        quantity: quantity
        total_price: (album_id -> price * quantity)
        branch_description: branch_id -> branch_description
    */
    @Query(value = """
            SELECT 
                mp.*
            FROM member_purchase mp
            INNER JOIN member m ON mp.member_id = m.member_id
            INNER JOIN membership_type mt ON m.membership_type_id = mt.membership_type_id
            INNER JOIN album a ON mp.album_id = a.album_id
            INNER JOIN branch b ON mp.branch_id = b.branch_id                        
            ORDER BY mp.member_purchase_id DESC
            LIMIT :#{#pageable.pageSize} 
            OFFSET :#{#pageable.offset}
            """,
            countQuery = """
                SELECT COUNT(*)
                FROM member_purchase
            """,
            nativeQuery = true)
    Page<MemberPurchase> findAllPurchasesWithDetails(Pageable pageable);

    @Query(value = """
            SELECT 
                mp.*
            FROM member_purchase mp
            INNER JOIN member m ON mp.member_id = m.member_id
            INNER JOIN membership_type mt ON m.membership_type_id = mt.membership_type_id
            INNER JOIN album a ON mp.album_id = a.album_id
            INNER JOIN branch b ON mp.branch_id = b.branch_id 
            WHERE mp.member_purchase_id = :purchaseId
            """,
            nativeQuery = true)
    Optional<MemberPurchase> findPurchaseWithDetailsById(@Param("purchaseId") Long purchaseId);
}
