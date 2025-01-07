package cl.playground.disco_norte.controller;
import cl.playground.disco_norte.dto.MemberPurchaseResponseDTO;
import cl.playground.disco_norte.service.MemberPurchaseService;
import cl.playground.disco_norte.model.MemberPurchase;

import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;

@Controller
@RequestMapping("/purchases")
public class MemberPurchaseViewController {

    private final MemberPurchaseService memberPurchaseService;

    public MemberPurchaseViewController(MemberPurchaseService memberPurchaseService) {
        this.memberPurchaseService = memberPurchaseService;
    }

    @GetMapping()
    public String getAllPurchases(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {

        Page<MemberPurchaseResponseDTO> purchasePage = memberPurchaseService.getAllPurchases(PageRequest.of(page, size));

        model.addAttribute("purchases", purchasePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", purchasePage.getTotalPages());
        model.addAttribute("totalItems", purchasePage.getTotalElements());

        model.addAttribute("size", size);
        model.addAttribute("hasNext", purchasePage.hasNext());
        model.addAttribute("hasPrevious", purchasePage.hasPrevious());

        return "purchaseList";
    }

    @GetMapping("/detail/{id}")
    public String getPurchaseDetails(@PathVariable Long id, Model model) {
        /*
        MemberPurchase purchaseDetail = memberPurchaseService.getMemberPurchasesByID(id);

        if (purchaseDetail == null) {
            model.addAttribute("error", "Compra no encontrada");
            return "404";
        }

        model.addAttribute("purchase", purchaseDetail);*/
        return "purchaseDetail";
    }

}