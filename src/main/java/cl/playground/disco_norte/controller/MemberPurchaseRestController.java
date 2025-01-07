package cl.playground.disco_norte.controller;

import cl.playground.disco_norte.dto.MemberPurchaseDetailsResponseDTO;
import cl.playground.disco_norte.dto.MemberPurchaseResponseDTO;
import cl.playground.disco_norte.model.MemberPurchase;
import cl.playground.disco_norte.service.MemberPurchaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchases")
public class MemberPurchaseRestController {

    private final MemberPurchaseService memberPurchaseService;

    public MemberPurchaseRestController(MemberPurchaseService memberPurchaseService) {
        this.memberPurchaseService = memberPurchaseService;
    }

    @GetMapping
    public ResponseEntity<Page<MemberPurchaseResponseDTO>> getAllPurchases(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return ResponseEntity.ok(memberPurchaseService.getAllPurchases(pageRequest));
    }
    //Voy  aprobar algo
//    @GetMapping
//    public Page<MemberPurchase> getAllPurchases(Pageable pageable) {
//        return memberPurchaseService.getAllMememberPurchases(pageable);
//    }
//
    @GetMapping("/{id}")
    public ResponseEntity<MemberPurchaseDetailsResponseDTO> getPurchaseById(@PathVariable Long id) {
        Optional<MemberPurchaseDetailsResponseDTO> purchase = memberPurchaseService.getPurchase(id);

        // Map<String, Object> errors....
        if (purchase.isPresent()) {
            return ResponseEntity.ok(purchase.get());
        }

        return ResponseEntity.notFound().build();
    }

}
