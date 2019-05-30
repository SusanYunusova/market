package com.shoppingcenter.market.controller;

import com.shoppingcenter.market.dto.CategoryDto;
import com.shoppingcenter.market.dto.ItemDto;
import com.shoppingcenter.market.model.Item;
import com.shoppingcenter.market.service.ItemService;
import com.shoppingcenter.market.utils.ItemConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shop")
public class ItemController {

       private ItemService itemService;
       private ItemConversion itemConversion;

//controller dto ile ishleyir
//todo convertItem yaz
    @Autowired
    public ItemController(ItemService itemService, ItemConversion itemConversion) {
        this.itemService = itemService;
        this.itemConversion = itemConversion;
    }

    @PostMapping("/categories/{categoryId}/items")
    public ResponseEntity<ItemDto> createNewItem(@PathVariable int categoryId, @RequestBody ItemDto itemDto){


        return new ResponseEntity<>(itemConversion.toItemDto(itemService.
                saveItem(itemConversion.toItem(itemDto))), HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public  ResponseEntity<List<ItemDto>> getAll(){
       ResponseEntity<List<Item>> items = itemService.getAll();

        return  new ResponseEntity<>(itemConversion.toItemDto(itemService.getAll()),HttpStatus.OK);
        //todo dto teleb edir amma itemdi?
    }

    @DeleteMapping("/categories/{idItem}")
    public  ResponseEntity<String> deleteITem(@PathVariable("idItem") int idItem){
        itemService.deleteItemById(idItem);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }
}
