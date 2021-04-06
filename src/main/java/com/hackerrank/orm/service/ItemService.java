package com.hackerrank.orm.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import com.hackerrank.orm.model.Item;
import com.hackerrank.orm.model.ItemPage;

public interface ItemService {


  public Optional<Item> findItemByItemId(Integer itemId);

  public List<Item> findAllItems();

  public Item saveItem(Item item);

  public void deleteItemById(Integer itemId);

  public void deleteAllItems();

  public Page<Item> findAllByPageAndSort(ItemPage itemPage);


}
