package dto.domain;

import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart(List<Item> items) {
        this.items = items;
    }

    public void confirm(PaiementMethod paiementMethod) {
        double totalCost = 0;
        for (Item item : items) {
            totalCost += item.getPrice();
        }
        paiementMethod.pay(totalCost);
    }
}
