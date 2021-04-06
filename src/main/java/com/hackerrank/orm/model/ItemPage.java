package com.hackerrank.orm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPage  implements Serializable {
   private int pageNumber  = 0;
   private int pageSize = 10;
   private Sort.Direction sortDirection = Direction.ASC;
   private String sortBy = "itemName";

}
