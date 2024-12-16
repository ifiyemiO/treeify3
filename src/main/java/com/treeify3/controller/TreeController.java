package com.treeify3.controller;

import com.treeify3.entity.TreeEntity;
import com.treeify3.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5500")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @PostMapping("/process-numbers")
    public TreeEntity processNumbers(@RequestParam String numbers) throws Exception {
        return treeService.createTree(numbers);
    }

    @GetMapping("/previous-trees")
    public List<TreeEntity> getPreviousTrees() {
        return treeService.getAllTrees();
    }
}
