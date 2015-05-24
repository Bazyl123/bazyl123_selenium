package com.bananascrum.szkolenia.pageObjectPatterns;

import org.junit.Test;
import java.util.UUID;

/**
 * Created by Administrator on 2015-02-11.
 */
public class ProductBacklogTest extends SeleniumBase {

    String TITLE = "PiotrJ" + UUID.randomUUID().toString();

    @Test
    public void shouldAddItem() {

        LoginPage lp = new LoginPage(driver);
        lp.open();
        BacklogPage bp = lp.logInCorrectly("admin", "password");

        bp.addBackLogItem(TITLE);
        assert bp.isItemInBacklog(TITLE);

        bp.removeBackLogItem(TITLE);
        assert !bp.isItemInBacklog(TITLE);
    }



}
