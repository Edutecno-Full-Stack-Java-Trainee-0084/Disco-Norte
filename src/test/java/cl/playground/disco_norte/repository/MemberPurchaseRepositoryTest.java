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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
public class MemberPurchaseRepositoryTest {
    @Autowired
    private MemberPurchaseRepository repository;

    @BeforeEach
    void setup() {
        // Puedes usar datos precargados en tu base de datos de prueba o inicializar datos aquí.
        // Esto depende de cómo configures tu entorno de prueba.
    }

    @Test
    void testPageRequest() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<MemberPurchase> members = repository.findAllPurchasesWithDetails(pageable);
        members.forEach(System.out::println);
    }

    @Test
    void testGetPurchaseById() {
        // Arrange
        Long purchaseId = 1L; // Asegúrate de que este ID exista en tu base de datos de prueba.

        // Act
        Optional<MemberPurchase> result = repository.findPurchaseWithDetailsById(purchaseId);

        // Assert
        assertTrue(result.isPresent(), "The purchase with the given ID should be found.");
        MemberPurchase purchase = result.get();
        assertEquals(purchaseId, purchase.getMemberPurchaseId(), "The purchase ID should match.");

        // Additional assertions to verify the correctness of the retrieved data
        assertNotNull(purchase.getMemberId(), "Member details should not be null.");
        assertNotNull(purchase.getAlbumId(), "Album details should not be null.");
        assertNotNull(purchase.getBranchId(), "Branch details should not be null.");

        System.out.println("Purchase retrieved: " + purchase);
    }



}
