package com.hackerrank.orm;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.hackerrank.orm.model.Item;
import com.hackerrank.orm.repository.ItemRepository;
import com.hackerrank.orm.service.ItemService;
import com.hackerrank.orm.util.EntityGenerator;

/**
 * @author Naveen Bavu
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerTest {

  @Autowired
  private TestRestTemplate testRestTemplate;
  @Autowired
  private ItemService itemService;
  @Autowired
  private ItemRepository itemRepository;

  /**
   * This method will initialize test data.
   */
  @Before
  public void init() {
    List<Item> itemData = EntityGenerator.getItemData();
    itemRepository.saveAll(itemData);
  }

  @Test
  public void getItemById() {
    ResponseEntity<Item> response = testRestTemplate
        .getForEntity("/app/item/1", Item.class);
    Assert.assertEquals("Naveen", response.getBody().getItemLastModifiedByUser());
  }

  @Test
  public void getAllItems() {
    Object[] forObject = testRestTemplate
        .getForObject("/app/item", Object[].class);
    List<Item> list = (List) Arrays.asList(forObject);
    Assert.assertEquals(2, list.size());
  }

  @Test
  public void deleteByItemId() {
    testRestTemplate
        .delete("/app/item/1", Item.class);
    Object[] forObject = testRestTemplate
        .getForObject("/app/item", Object[].class);
    List<Item> list = (List) Arrays.asList(forObject);

    Assert.assertEquals(1, list.size());
  }

  @Test
  public void deleteAllItems() {
    testRestTemplate
        .delete("/app/item", Item.class);
    List<Item> allItems = itemService.findAllItems();
    Assert.assertEquals(0, allItems.size());
  }


  @After
  public void destroy() {
    itemRepository.deleteAll();
  }


}
