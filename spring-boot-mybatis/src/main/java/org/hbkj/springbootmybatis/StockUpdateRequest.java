package org.hbkj.springbootmybatis;

import lombok.Data;

@Data
public class StockUpdateRequest {
    private Long id; // 商品ID
    private int quantity; // 购买数量
}