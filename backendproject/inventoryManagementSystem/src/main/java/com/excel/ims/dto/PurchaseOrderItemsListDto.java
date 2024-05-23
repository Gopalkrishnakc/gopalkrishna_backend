package com.excel.ims.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderItemsListDto {
	private Integer itemId;
	private String supplier;
	private List<PurchaseOrderItemsDto> orderItems;
	
	
	
}
