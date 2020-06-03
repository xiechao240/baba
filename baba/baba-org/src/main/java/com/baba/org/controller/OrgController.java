package com.baba.org.controller;


import com.baba.org.pojo.Org;
import com.baba.org.service.OrgService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 组织架构表，顶级节点：大立教育 前端控制器
 * </p>
 *
 * @author xiechao
 * @since 2020-04-24
 */
@RestController
@RequestMapping("org")
@Api("组织机构服务接口")
public class OrgController {

    @Autowired
    OrgService orgService;

    /**
     * 根据父节点，查询子节点的组织机构
     * @param orgId
     * @return
     */
    @GetMapping("list/{orgId}")
    @ApiOperation(value = "根据组织编号，查找下一级的组织节点", notes = "查询组织结构")
    @ApiImplicitParam(name = "id", dataType = "String", required = true, value = "组织结构编号")
    @ApiResponses({
            @ApiResponse(code = 200, message = "组织结构结果集合"),
            @ApiResponse(code = 404, message = "没有查询到结果"),
            @ApiResponse(code = 500, message = "查询失败"),
    })
    public ResponseEntity<List<Org>> queryOrgListByOrgId(@PathVariable(value = "orgId", required = true) String orgId){
        return null;
    }

    /**
     * 返回整个组织结构树形结果
     * @param orgId 组织结构编号，不传返回整个树形组织结构，传则返回指定的树形结构
     * @return
     */
    @GetMapping("list-tree")
    @ApiOperation(value = "返回整个组织结构树形结果", notes = "获取组织结构")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orgId", dataType ="String", required = false, value = "组织结构编号，不传返回整个树形组织结构，传则返回指定的树形结构")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "组织结构树形结果集合"),
            @ApiResponse(code = 404, message = "没有查询到结果"),
            @ApiResponse(code = 500, message = "查询失败"),
    })
    public ResponseEntity<List<Org>> queryOrgListTreeByOrgId(@RequestParam(defaultValue = "0") String orgId){
        System.out.println(orgId);
//        System.out.println(orgName);

        List<Org> list = orgService.queryOrgListTreeByOrgId(orgId);


        return null;
    }

    /**
     * 根据结构结构ID，返回结构结果名称集合（常用于面包屑功能）
     * @param ids 组织结构编号集合
     * @return
     */
    @GetMapping("names")
    @ApiOperation(value = "返回组织结构名称集合（常用于面包屑功能）", notes = "获取组织结构名称集合（常用于面包屑功能）")
    @ApiImplicitParam(name = "id", dataType = "List<String>", required = false, value = "组织结构编号，不传返回整个树形组织结构，传则返回指定的树形结构")
    @ApiResponses({
            @ApiResponse(code = 200, message = "组织结构名称结果集合"),
            @ApiResponse(code = 404, message = "没有查询到结果"),
            @ApiResponse(code = 500, message = "查询失败"),
    })
    public ResponseEntity<List<String>> queryNamesByIds(@RequestParam(value = "ids", required = true) List<String> ids){
//        List<String> list = this.categoryService.queryNamesByIds(ids);
//        // 判断是否查询到
//        if(list == null || list.size() <= 0 ){
//            // 返回404
//            return ResponseEntity.notFound().build();
//        }
//        // 成功返回200
//        return ResponseEntity.ok(list);
        return null;
    }


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
        return null;
    }


    /**
     * 修改部门(此接口不调用，只是展示代码的另一种返回值的写法)
     *
     * @param orgId 组织机构ID
     * @param orgName 组织机构名称
     * @param sortNum 排序号
     * @return
     */
    @PutMapping("update-org-info/{orgId}")
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
    public ResponseEntity<Void> updateOrgInfo(@PathVariable(value = "orgId",required = true) String orgId,
                                             @RequestParam(value = "orgName") String orgName,
                                             @RequestParam(value = "sortNum") Integer sortNum) {
        return ResponseEntity.ok().build();
    }


    /**
     * 删除组织机构
     * @param orgId 组织机构ID
     * @return
     */
    @DeleteMapping("delete/{orgId}")
    @ApiOperation(value = "删除组织机构", notes = "删除组织机构")
    @ApiImplicitParam(name = "orgId", dataType = "String", required = true, value = "组织机构ID")
    public ResponseEntity<Void> deleteOrgById(@PathVariable(value = "orgId", required = true) String orgId){
        return ResponseEntity.ok().build();
    }


    /**
     * 新建部门或机构
     *
     * @param org 组织机构对象
     * @return
     */
    @PostMapping
    @ApiOperation(value = "创建机构部门接口，返回订单编号", notes = "创建订单")
    @ApiImplicitParam(name = "order", required = true, value = "订单的json对象,包含订单条目和物流信息")
    public ResponseEntity<Long> createOrder(@RequestBody @Valid Org org) {
        return null;
//        return ResponseEntity.ok(id);
//        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }



}
