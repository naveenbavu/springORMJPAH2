package com.hackerrank.orm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hackerrank.orm.enums.ItemStatus;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityScan("com.hackerrank.com.*")
@Entity
public class Item implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int itemId;
  private String itemName;
  private String itemEnteredByUser;
  @CreationTimestamp
  private Timestamp itemEnteredDate;
  private double itemBuyingPrice;
  private double itemSellingPrice;
  private Date itemLastModifiedDate = new Date();
  private String itemLastModifiedByUser;
  @Enumerated(EnumType.STRING)
  private ItemStatus itemStatus = ItemStatus.AVAILABLE;
}
