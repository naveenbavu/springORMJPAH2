package com.hackerrank.orm.service;

import com.hackerrank.orm.repository.ItemRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hackerrank.orm.model.Item;
import com.hackerrank.orm.model.ItemPage;

@Transactional
@Service
public class ItemServiceImplntation implements ItemService {

  @Autowired
  public ItemRepository itemRepository;

  public Optional<Item> findItemByItemId(Integer itemId) {
    return itemRepository.findById(itemId);
  }

  public List<Item> findAllItems() {
    return itemRepository.findAll();
  }

  public Item saveItem(Item item) {
    return itemRepository.save(item);
  }

  public void deleteItemById(Integer itemId) {
    itemRepository.deleteById(itemId);
  }

  public void deleteAllItems() {
    itemRepository.deleteAll();
  }

  public Page<Item> findAllByPageAndSort(ItemPage itemPage) {
    Sort sort = Sort.by(itemPage.getSortDirection(), itemPage.getSortBy());
    Pageable pageable = PageRequest.of(itemPage.getPageNumber(), itemPage.getPageSize(), sort);
    return itemRepository.findAll(pageable);
  }


}
