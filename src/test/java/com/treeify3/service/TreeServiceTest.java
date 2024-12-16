package com.treeify3.service;

import com.treeify3.entity.TreeEntity;
import com.treeify3.repository.TreeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class TreeServiceTest {

    @Mock
    private TreeRepository treeRepository;

    @InjectMocks
    private TreeService treeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTree() throws Exception {
        // Mock repository save behavior
        TreeEntity mockEntity = new TreeEntity();
        mockEntity.setInputNumbers("1,2,3");
        mockEntity.setTreeStructure("{\"value\":1,\"left\":null,\"right\":{\"value\":2}}");

        when(treeRepository.save(any(TreeEntity.class))).thenReturn(mockEntity);

        // Test the createTree method
        TreeEntity tree = treeService.createTree("1,2,3");

        assertNotNull(tree);
        assertEquals("1,2,3", tree.getInputNumbers());
        assertEquals("{\"value\":1,\"left\":null,\"right\":{\"value\":2}}", tree.getTreeStructure());
    }
}
