package cl.playground.disco_norte.service;

import cl.playground.disco_norte.dto.MemberPurchaseDetailsResponseDTO;
import cl.playground.disco_norte.dto.MemberPurchaseResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MemberPurchaseService {

    Page<MemberPurchaseResponseDTO> getAllPurchases(Pageable pageable);
    Optional<MemberPurchaseDetailsResponseDTO> getPurchase(Long id);
}
