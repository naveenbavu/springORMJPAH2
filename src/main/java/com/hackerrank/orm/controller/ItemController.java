package com.hackerrank.orm.controller;

import com.hackerrank.orm.service.ItemService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.hackerrank.orm.model.Item;
import com.hackerrank.orm.model.ItemPage;

@RestController
@RequestMapping(
    value = "app/item")
public class ItemController {

  @Autowired
  ItemService itemService;

  //1.post

  @PostMapping()
  public ResponseEntity<Item> saveItemDetails(@RequestBody Item item) {
    Optional<Item> tutorialData = itemService.findItemByItemId(item.getItemId());
    if (tutorialData.isPresent()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item already exist",
          new Exception("Item already exist"));
    }
    itemService.saveItem(item);
    return new ResponseEntity(item, HttpStatus.CREATED);
  }


  //2. update PUT
  @PutMapping()
  public ResponseEntity<Item> updateItemDetails(@RequestBody Item item) {
    Optional<Item> itemExist = itemService.findItemByItemId(item.getItemId());
    if (itemExist.isPresent()) {
      itemService.saveItem(item);
      return new ResponseEntity(item, HttpStatus.OK);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not Found",
          new Exception("Item not found"));
    }
  }

  //2. update PUT
  @PatchMapping(value = "/{itemId}")
  public ResponseEntity<Item> patchItemDetails(@PathVariable int itemId, @RequestBody Item item) {
    Item itemRes =   itemService.findItemByItemId(itemId).get();
    itemRes.setItemEnteredByUser(item.getItemEnteredByUser());
    itemService.saveItem(itemRes);
    return new ResponseEntity(item, HttpStatus.OK);
  }

  //3. delete by itemId DELETE
  @DeleteMapping(value = "/{itemId}")
  public void deleteItemById(@PathVariable("itemId") Integer itemId) {
    Optional<Item> itemExist = itemService.findItemByItemId(itemId);
    if (itemExist.isPresent()) {
      itemService.deleteItemById(itemId);
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item Not Found",
          new Exception("Item not found"));
    }
  }

  //4. delete all DELETE
  @DeleteMapping()
  public void deleteAllItems() {
    itemService.deleteAllItems();
  }

  //5. get by itemId GET
  @GetMapping(value = "/{itemId}")
  public ResponseEntity<Item> findItemByItemId(@PathVariable("itemId") Integer itemId) {
    Optional<Item> itemExist = itemService.findItemByItemId(itemId);
    if (!itemExist.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Not Found",
          new Exception("Item not found"));
    }
    return new ResponseEntity(itemExist, HttpStatus.OK);
  }

  //6. get all GET
  @GetMapping()
  public List<Item> findItemByItemId() {
    return itemService.findAllItems();
  }

  //7. filters by fields ?itemStatus={status}&itemEnteredByUser={modifiedBy} GET



  //8. select all with sorting and pagination ?pageSize={pageSize}&page={page}&sortBy={sortBy} GET
  @GetMapping("page")
  public ResponseEntity<Page<Item>> selectAllItemsByPageAndSort(ItemPage itemPage) {
    return new ResponseEntity<>(itemService.findAllByPageAndSort(itemPage), HttpStatus.OK);
  }

}
