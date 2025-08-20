package com.example.PahanaEduProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.PahanaEduProject.repository.CustomerRepository;
import com.example.PahanaEduProject.repository.ItemRepository;
import com.example.PahanaEduProject.repository.BillRepository;

@Controller
public class DashboardController {

    private final CustomerRepository customerRepo;
    private final ItemRepository itemRepo;
    private final BillRepository billRepo;

    public DashboardController(CustomerRepository customerRepo, ItemRepository itemRepo, BillRepository billRepo) {
        this.customerRepo = customerRepo;
        this.itemRepo = itemRepo;
        this.billRepo = billRepo;
    }

    @GetMapping("/admin-dashboard.html")
    public String dashboard(Model model) {
        model.addAttribute("totalCustomers", customerRepo.count());
        model.addAttribute("totalItems", itemRepo.count());
        model.addAttribute("totalBills", billRepo.count());

        double totalRevenue = billRepo.findAll()
                                      .stream()
                                      .mapToDouble(b -> b.getTotalAmount())
                                      .sum();
        model.addAttribute("totalRevenue", totalRevenue);

        return "admin_dashboard.html"; // Thymeleaf template name
    }
}
