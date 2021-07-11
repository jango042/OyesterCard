package com.alef.education.oyistercardsystem;

import com.alef.education.oyistercardsystem.model.Account;
import org.junit.Test;

import java.math.BigDecimal;

public class AccountTest {
    @Test(expected = Exception.class)
    public void testValidadeExeption() {
        Account account = new Account(new BigDecimal("30.0"));
        account.validade(new BigDecimal("31.0"));
    }

    @Test(expected = Exception.class)
    public void testOutException() {
        Account account = new Account(new BigDecimal("30.0"));
        account.out(new BigDecimal("31.0"));
    }
}
