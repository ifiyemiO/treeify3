package com.treeify3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.treeify3.entity.TreeEntity;
import com.treeify3.model.BinarySearchTree;
import com.treeify3.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    public TreeEntity createTree(String numbers) throws Exception {
        BinarySearchTree tree = new BinarySearchTree();
        String[] numArray = numbers.split(",");
        for (String num : numArray) {
            tree.insert(Integer.parseInt(num.trim()));
        }

        ObjectMapper mapper = new ObjectMapper();
        String treeJson = mapper.writeValueAsString(tree.getRoot());

        TreeEntity entity = new TreeEntity();
        entity.setInputNumbers("1,2,3,4,5");
        String inputNumbers = entity.getInputNumbers();

        entity.setTreeStructure(treeJson);

        // Save to database
        return treeRepository.save(entity);
    }

    public List<TreeEntity> getAllTrees() {
        return treeRepository.findAll();
    }
}
