package com.example.account.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ResponseStatusException;

import com.example.account.DAO.accountDAO;
import com.example.account.Model.Item;

import java.util.List;

@RestController
@RequestMapping(path = "/item")
public class OnlineShopController {

    @Autowired
    private OnlineShopDAO onlineShopDAO;
    @PutMapping(path = "/item/{id}",consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> UpdateItem(@RequestBody Item item,@PathVariable String id){
        if(onlineShopDAO.updateItem(id,item)){
            return new ResponseEntity<>("Item Updated.", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Item Could Not Be Found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/item/{id}",produces = "application/json")
    public ResponseEntity<String> DeleteItem(@PathVariable String id){
        if(onlineShopDAO.deleteItem(id)){
            return new ResponseEntity<>("Item Deleted.", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Item Could Not Be Found.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path= "/",consumes = "application/json",produces ="application/json")
    public ResponseEntity<String> CreateItem(@RequestBody Item item){
        onlineShopDAO.createItem(item);
        return new ResponseEntity<>("Item Added.", HttpStatus.OK);
    }

    @GetMapping(path = "/item" ,produces ="application/json")
    public List<Item> getItemList(){
        List<Item> itemList = onlineShopDAO.getItemList();
        return itemList;
    }

    @GetMapping(path = "/item/{id}" ,produces ="application/json")
    public String getItem(@PathVariable String id){
        String item;
        item = onlineShopDAO.findItem(id);
        if (item.equals("Not found")){
            return "Item that you specified was not found";
        }

        return item;
    }

    


}
