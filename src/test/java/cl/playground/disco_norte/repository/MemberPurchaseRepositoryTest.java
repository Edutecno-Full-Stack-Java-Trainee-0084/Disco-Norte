package cl.playground.disco_norte.repository;

import cl.playground.disco_norte.model.MemberPurchase;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@SpringBootTest
@Transactional
public class MemberPurchaseRepositoryTest {
    @Autowired
    private MemberPurchaseRepository repository;
    @Test
    void testPageRequest() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<MemberPurchase> members = repository.findAllPurchasesWithDetails(pageable);
        members.forEach(System.out::println);
    }



}
