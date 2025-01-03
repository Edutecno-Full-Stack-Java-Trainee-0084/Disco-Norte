package cl.playground.disco_norte.service;

import cl.playground.disco_norte.model.MemberPurchase;
import cl.playground.disco_norte.repository.MemberPurchaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberPurchaseServicelmpl implements MemberPurchaseService {
    private final MemberPurchaseRepository memberPurchaseRepository;

    public MemberPurchaseServicelmpl(MemberPurchaseRepository memberPurchaseRepository) {
        this.memberPurchaseRepository = memberPurchaseRepository;
    }

    @Override
    public Page<MemberPurchase> getAllMememberPurchases(Pageable pageable) {
        return memberPurchaseRepository.findAll(pageable);
    }

    @Override
    public MemberPurchase getMememberPurchasesByID(Long id) {
        return memberPurchaseRepository.findMemberPurchaseDetailsById(id);
    }
}
