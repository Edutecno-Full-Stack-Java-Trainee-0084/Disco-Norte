package cl.playground.disco_norte.service;

import cl.playground.disco_norte.dto.MemberPurchaseResponseDTO;
import cl.playground.disco_norte.mapper.PurchaseMapper;
import cl.playground.disco_norte.repository.MemberPurchaseRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberPurchaseServicelmpl implements MemberPurchaseService {

    private final MemberPurchaseRepository repository;
    private final PurchaseMapper purchaseMapper;

    @Override
    @Transactional(readOnly = true) // Prgeunatr en la clase
    public Page<MemberPurchaseResponseDTO> getAllPurchases(Pageable pageable) {
        return purchaseMapper.toDTO(
                repository.findAllPurchasesWithDetails(pageable)
        );
    }
}
