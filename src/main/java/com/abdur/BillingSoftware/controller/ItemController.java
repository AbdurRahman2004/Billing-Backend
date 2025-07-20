package com.abdur.BillingSoftware.controller;

import com.abdur.BillingSoftware.io.ItemRequest;
import com.abdur.BillingSoftware.io.ItemResponse;
import com.abdur.BillingSoftware.service.ItemService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.plaf.multi.MultiPanelUI;
import java.nio.channels.MulticastChannel;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/admin/items")
    public ItemResponse addItem(@RequestPart("item")String itemString, @RequestPart("file")MultipartFile file){
        ObjectMapper objectMapper = new ObjectMapper();
        ItemRequest itemRequest = null;
        try {
            itemRequest = objectMapper.readValue(itemString,ItemRequest.class);
           return itemService.add(itemRequest,file);
        } catch (JsonProcessingException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error Occured while processing the Request");
        }
    }

    @GetMapping("/items")
    public List<ItemResponse> readItems(){
        return itemService.fetchItems();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/admin/items/{itemId}")
    public void removeItem(@PathVariable String itemId){

        try {
            itemService.deleteItem(itemId);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not found");
        }
    }
}
