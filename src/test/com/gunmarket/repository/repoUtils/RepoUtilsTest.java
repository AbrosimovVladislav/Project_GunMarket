package com.gunmarket.repository.repoUtils;

import org.testng.annotations.Test;

import static com.gunmarket.repository.basicRepo.repoUtils.RepoUtils.firstUpperCase;
import static com.gunmarket.repository.basicRepo.repoUtils.RepoUtils.replaceLastChar;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class RepoUtilsTest {

    @Test
    public void testReplaceLastChar(){
        assertEquals(replaceLastChar("String"),"Strin");
        assertEquals(replaceLastChar(""),"");
        assertNull(replaceLastChar(null));
    }

    @Test
    public void testFirstUpperCase(){
        assertEquals(firstUpperCase("string"),"String");
        assertEquals(firstUpperCase(""),"");
        assertNull(firstUpperCase(null));
    }

}
