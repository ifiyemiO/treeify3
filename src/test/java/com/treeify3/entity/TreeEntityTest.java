package com.treeify3.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TreeEntityTest {

    @Test
    public void testSetters() {
        TreeEntity entity = new TreeEntity();

        entity.setInputNumbers("1,2,3,4,5");
        entity.setTreeStructure("{\"value\":2,\"left\":null,\"right\":{\"value\":3}}");

        assertEquals("1,2,3,4,5", entity.getInputNumbers());
        assertEquals("{\"value\":2,\"left\":null,\"right\":{\"value\":3}}", entity.getTreeStructure());
    }
}

