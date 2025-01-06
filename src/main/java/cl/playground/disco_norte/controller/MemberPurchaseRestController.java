package cl.playground.disco_norte.controller;

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

@RestController
@RequestMapping("/api/purchase")
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
//    @GetMapping("/{id}")
//    public Page<MemberPurchase> getPurchaseById(@PathVariable Long id, Pageable pageable) {
//        return memberPurchaseService.getMememberPurchasesByID(pageable, id);
//    }
/*
    @GetMapping("/simplified")
    public ResponseEntity<Map<String, Object>> getPurchasesSimplified(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<MemberPurchase> purchasePage = memberPurchaseService.getAllMemberPurchases(
                PageRequest.of(page, size)
        );

        return ResponseEntity.ok(createPaginationResponse(purchasePage));
    }


    @GetMapping("/{id}")
    public ResponseEntity<MemberPurchase> getMemberPurchaseDetails(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        MemberPurchase memberPurchases = memberPurchaseService.getMemberPurchasesByID(id);
        if (memberPurchases == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memberPurchases);
    }


    private Map<String, Object> createPaginationResponse(Page<?> page) {
        Map<String, Object> response = new HashMap<>();
        response.put("content", page.getContent());
        response.put("currentPage", page.getNumber());
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());
        response.put("size", page.getSize());
        response.put("hasNext", page.hasNext());
        response.put("hasPrevious", page.hasPrevious());
        return response;
    }
    */

}
