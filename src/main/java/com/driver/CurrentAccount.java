package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
        if(getBalance()<5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        for (int i = 0;i<tradeLicenseId.length()-1;i++){
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(1+1)){
                String r = rearrangedID(tradeLicenseId);
                if(!isvalidateLicenseId(r)) throw new Exception("Valid License can not be generated");
            }
        }
    }

    public boolean isvalidateLicenseId(String r) {
        char[] c = r.toCharArray();
        for (int i = 0;i<c.length-1;i++){
            if(c[i]==c[i+1]) return false;
        }
        return true;
    }

    public String rearrangedID(String tradeLicenseId) {
        char[] c = tradeLicenseId.toCharArray();
        for (int i = 0;i<c.length-1;i++){
            if (c[i] == c[i+1]){
                for (char a ='A';a<= 'Z'; a++){
                    if(c[i]!=a && (i==c.length-2|| a!=c[i+2])){
                        c[i+1] = a;
                        break;
                    }
                }
            }
        }
        return new String(c);
    }

}
