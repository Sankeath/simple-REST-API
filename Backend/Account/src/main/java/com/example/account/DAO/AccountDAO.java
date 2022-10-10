package com.example.account.DAO;

import org.springframework.stereotype.Repository;

import com.example.onlineshop.Model.Item;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OnlineShopDAO {

    private Item Additem;

    private static Item item1 = new Item("1", "water", "drink it", "idw", 1.50);
    private static List<Item> itemList = new ArrayList<Item>();


    static {
        itemList.add(item1);

    }


    public List<Item> getItemList() {
        return itemList;
    }

    public void createItem(Item item) {
        Additem = item;
        itemList.add(Additem);
    }

    public String findItem(String id) {
        String item = "Not found";
        String itemID = "";

        for (int i = 0; i < itemList.size(); i++) {
            itemID = itemList.get(i).getId();
            if (itemID.equals(id)) {
                item = itemList.get(i).toString();
            }
        }

        return item;
    }

    public boolean updateItem(String id, Item item) {
        String itemID = "";
        boolean returnval = false;
        for (int i = 0; i < itemList.size(); i++) {
            itemID = itemList.get(i).getId();
            if (itemID.equals(id)) {
                itemList.remove(i);
                itemList.add(i, item);
                returnval = true;
            }
        }
        return returnval;
    }

    public boolean deleteItem(String id) {
        String itemID = "";
        boolean returnval = false;
        for (int i = 0; i < itemList.size(); i++) {
            itemID = itemList.get(i).getId();
            if (itemID.equals(id)) {
                itemList.remove(i);

                returnval = true;
            }
        }
        return returnval;
    }
}
