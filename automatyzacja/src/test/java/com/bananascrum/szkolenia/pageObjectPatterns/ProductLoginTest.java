package com.bananascrum.szkolenia.pageObjectPatterns;

import org.junit.Test;

/**
 * Created by Administrator on 2015-02-11.
 */
public class ProductLoginTest extends SeleniumBase {

    @Test
    public void loginWithCorrectCredentials() {
        LoginPage lp = new LoginPage(driver);
        lp.open();

        lp.LogIn("admin","password");
        BacklogPage bp = new BacklogPage(driver);

        assert bp.isOpen();
    }
}

