package com.bananascrum.szkolenia.pageObjectPatterns;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by Administrator on 2015-02-11.
 */
public class ProductSprintTest extends SeleniumBase {

    String TITLE = "PiotrJ" + UUID.randomUUID().toString();

    @Test
    public void shouldAddItemToSprint() {

        LoginPage lp = new LoginPage(driver);
        lp.open();
        BacklogPage bp = lp.logInCorrectly("admin", "password");

        bp.addBackLogItem(TITLE);

        SprintPage sp = bp.goToSprintPage();
        PlanPage pp = sp.goToPlanPage();
        pp.moveItemToTest(TITLE);

        pp.goToSprintPage();
        //assert sp.isItemInTest(TITLE);


    }



}
