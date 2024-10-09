package com.project.librarymanagement.controller;

import com.project.librarymanagement.entity.Fine;
import com.project.librarymanagement.service.FineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/fines")
public class FineController {
    private FineService fineService;
    FineController(FineService fineService){
        this.fineService = fineService;
    }
    @GetMapping
    public List<Fine> getAllFines(){
        return fineService.getAll();
    }
    @GetMapping("/{id}")
    public Fine getFineById(@PathVariable Long id){
        return fineService.getById(id);
    }
    @PostMapping
    public void createFine(@RequestBody Fine fine){
        fineService.addFine(fine);
    }
    @PutMapping("/{id}")
    public Fine updateFineById(@PathVariable Long id){
        return fineService.update(id);
    }
    @DeleteMapping("/{id}")
    public void deleteFineById(@PathVariable Long id){
        fineService.deleteById(id);
    }

}
