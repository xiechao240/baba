/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.xiaominfo.swagger.service.order.controller;

import com.google.common.collect.Lists;
import com.xiaominfo.swagger.service.order.common.Rest;
import com.xiaominfo.swagger.service.order.model.Order;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 *
 * @since:swagger-bootstrap-ui 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2019/05/04 11:26
 */
@Api(tags = "订单模块")
@RestController
@RequestMapping("/user")
public class OrderController {

    /**
     * 修改部门
     *
     * @param orgId 组织机构ID
     * @param orgName 组织机构名称
     * @param sortNum 排序号
     * @return
     */
    @PutMapping("update/{orgId}")
    @ApiOperation(value = "更新组织机构", notes = "更新组织机构")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orgId", value = "组织机构ID", type = "String"),
            @ApiImplicitParam(name = "orgName", value = "组织机构名称", type = "String"),
            @ApiImplicitParam(name = "sortNum", value = "排序号", type = "Integer")
    })
    @ApiResponses({
            @ApiResponse(code = 204, message = "true：修改状态成功；false：修改状态失败"),
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 500, message = "查询失败")
    })
    public ResponseEntity<Boolean> updateOrg(@PathVariable(value = "orgId",required = true) String orgId,
                                             @RequestParam(value = "orgName") String orgName,
                                             @RequestParam(value = "sortNum") Integer sortNum) {
//        Boolean boo = this.orderService.updateStatus(id, status);
//        if (boo == null) {
//            // 返回400
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        // 返回204
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(true);
    }


    @ApiOperation(value = "查询订单列表")
    @PostMapping(value = "/list")
    public Rest<List<Order>> list(){
        Rest<List<Order>> rest=new Rest<>();
        List<Order> list= Lists.newArrayList(new Order(),new Order(),new Order(),new Order(),new Order(),new Order());
        rest.setData(list);
        return rest;
        //不要再采用返回这种Rest或者Result这种东西了
    }

    @ApiOperation(value = "查询订单列表2")
    @PostMapping(value = "/list2")
    public ResponseEntity<List<Order>> list2(){
        Rest<List<Order>> rest=new Rest<>();
        List<Order> list= Lists.newArrayList(new Order(),new Order(),new Order(),new Order(),new Order(),new Order());
        rest.setData(list);
        return ResponseEntity.ok(list);
    }



    @ApiOperation(value = "根据订单id查询订单详情")
    @GetMapping("/queryById")
    public ResponseEntity<Order> queryById(@RequestParam(value = "id") String id){
        Rest<Order> userRest=new Rest<>();
        userRest.setData(new Order());

        return ResponseEntity.ok(new Order());
    }







}
