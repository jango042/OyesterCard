package com.alef.education.oyistercardsystem.model;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private BigDecimal accountBalance;

    public void addMoney(BigDecimal money){
        this.accountBalance = accountBalance.add(money);
    }

    public void out(BigDecimal fare) {
        validade(fare);
        this.accountBalance = this.accountBalance.subtract(fare);

    }

    public void validade(BigDecimal fare) {
        if(accountBalance.compareTo(fare) < 0){

        }
//            throw  new FareException("Don't have balnce");
    }
    public void in(BigDecimal f) {
        this.accountBalance = this.accountBalance.add(f);

    }
}
