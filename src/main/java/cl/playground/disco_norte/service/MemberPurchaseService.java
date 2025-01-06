package cl.playground.disco_norte.service;

import cl.playground.disco_norte.dto.MemberPurchaseResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberPurchaseService {

    Page<MemberPurchaseResponseDTO> getAllPurchases(Pageable pageable);
}
