package dto.application;

import dto.domain.Cart;
import dto.domain.Item;

import java.util.List;

public class CartAssembler {
    public Cart fromDto(CartDto cartDto){

        List<Item> items = createItems(cartDto.itemsDto);
        return new Cart(items);
    }

    private List<Item> createItems(List<ItemDto> itemsDto){
        return itemsDto.stream().map(itemDto -> new Item(itemDto.name(), itemDto.price())).toList();

    }
}
