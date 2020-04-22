package com.baba.order.client;

import com.baba.order.client.fallback.GoodsClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: 98050
 * Time: 2018-12-11 20:50
 * Feature:商品FeignClient
 */
@FeignClient(value = "item-service", fallback = GoodsClientFallBack.class)
//public interface GoodsClient extends GoodsApi {
public interface GoodsClient{
}
