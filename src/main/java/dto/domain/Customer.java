package dto.domain;

import dto.api.CartDto;

public class Customer {
    private String email;
    private String name;
    private PaiementMethod paiementMethod;

    public Customer(String email, String name, PaiementMethod paiementMethod) {
        this.email = email;
        this.name = name;
        this.paiementMethod = paiementMethod;
    }

    public void confirmCart(CartDto cartDto){
        Cart cart = new Cart(cartDto.items);
        cart.confirm(paiementMethod);
    }
}
