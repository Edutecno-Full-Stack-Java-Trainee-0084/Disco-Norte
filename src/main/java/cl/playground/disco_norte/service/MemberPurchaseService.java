package cl.playground.disco_norte.service;

import cl.playground.disco_norte.model.MemberPurchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberPurchaseService {

    Page<MemberPurchase> getAllMememberPurchases(Pageable pageable);

    MemberPurchase getMememberPurchasesByID(Long id);
}
