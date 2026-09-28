package dto.domain;

import dto.application.CartDto;

public class Customer {
    private String email;
    private String name;
    private PaiementMethod paiementMethod;

    public Customer(String email, String name, PaiementMethod paiementMethod) {
        this.email = email;
        this.name = name;
        this.paiementMethod = paiementMethod;
    }

    public void confirmCart(Cart cart){
        cart.confirm(paiementMethod);
    }
}
