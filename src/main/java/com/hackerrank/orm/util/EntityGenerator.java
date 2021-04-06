package com.hackerrank.orm.util;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import com.hackerrank.orm.enums.ItemStatus;
import com.hackerrank.orm.model.Item;

/**
 * @author Naveen Bavu
 */
public class EntityGenerator {


  public static List<Item> getItemData() {

    Item item1 = Item.builder().itemBuyingPrice(123)
        .itemEnteredDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
        .itemLastModifiedByUser("Naveen")
        .itemName("banana")
        .itemId(1)
        .itemSellingPrice(100)
        .itemEnteredByUser("naveen")
        .itemLastModifiedDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
        .itemStatus(ItemStatus.AVAILABLE)
        .build();

    Item item2 = Item.builder().itemBuyingPrice(123)
        .itemEnteredDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
        .itemLastModifiedByUser("Naveen")
        .itemName("banana")
        .itemId(2)
        .itemSellingPrice(100)
        .itemEnteredByUser("naveen")
        .itemLastModifiedDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
        .itemStatus(ItemStatus.AVAILABLE)
        .build();

    return Arrays.asList(item1, item2);


  }
}
