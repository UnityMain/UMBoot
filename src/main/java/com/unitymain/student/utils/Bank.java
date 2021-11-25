package com.unitymain.student.utils;

import java.util.List;

public class Bank {

    private String name;

    private String address;

    private List<Account> accounts;

    static class Account{
        private int accoutId;
        private String accountName;
        private double accountMoeny;
        private String telNum;

        public int getAccoutId() {
            return accoutId;
        }

        public void setAccoutId(int accoutId) {
            this.accoutId = accoutId;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public double getAccountMoeny() {
            return accountMoeny;
        }

        public void setAccountMoeny(double accountMoeny) {
            this.accountMoeny = accountMoeny;
        }

        public String getTelNum() {
            return telNum;
        }

        public void setTelNum(String telNum) {
            this.telNum = telNum;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Bank [name=" + name + ", address=" + address + ", accounts=" + accounts + "]";
    }
}
