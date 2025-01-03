package cl.playground.disco_norte.repository;

import cl.playground.disco_norte.model.MemberPurchase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberPurchaseRepository extends JpaRepository<MemberPurchase, Long> {

    @Query(value = """
            SELECT
                mp.member_purchase_id AS purchase_id,
                CONCAT(m.first_name, ' ', m.last_name) AS member_name,
                mt.membership_type_description AS membership_type,
                a.album_title,
                mp.quantity,
                (mp.quantity * a.price) AS total_price,
                b.branch_description AS branch
            FROM
                member_purchase mp
            JOIN
                member m ON mp.member_id = m.member_id
            JOIN
                membership_type mt ON m.membership_type_id = mt.membership_type_id
            JOIN
                album a ON mp.album_id = a.album_id
            JOIN
                branch b ON mp.branch_id = b.branch_id
            ORDER BY
                mp.member_purchase_id
            LIMIT
                10 OFFSET 0;
            """, nativeQuery = true)
    Page<MemberPurchase> findAllMemberPurchaseDetails(Pageable pageable);


    @Query(value = """
            SELECT\s
                CONCAT(m.first_name, ' ', m.last_name) AS member_name,
                m.email AS member_email,
                mt.membership_type_description AS membership_type,
                a.album_title,
                a.artist_name,
                a.price,
                a.music_genre,
                mp.quantity,
                (mp.quantity * a.price) AS total_price,
                b.branch_description AS branch
            FROM\s
                member_purchase mp
            JOIN\s
                member m ON mp.member_id = m.member_id
            JOIN\s
                membership_type mt ON m.membership_type_id = mt.membership_type_id
            JOIN\s
                album a ON mp.album_id = a.album_id
            JOIN\s
                branch b ON mp.branch_id = b.branch_id
            WHERE\s
                mp.member_purchase_id = :id;
            """, nativeQuery = true)
   MemberPurchase findMemberPurchaseDetailsById(@Param("id") Long id);

}
