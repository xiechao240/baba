package com.baba.org.controller;


import com.baba.org.pojo.Org;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<List<Org>> queryOrgListTreeByOrgId(@RequestParam(defaultValue = "0") String orgId, @RequestParam(defaultValue = "") String orgName){
        System.out.println(orgId);
        System.out.println(orgName);

        return null;
    }

    /**
     * 根据结构结构ID，返回结构结果名称集合（常用于面包屑功能）
     * @param ids 组织结构编号集合
     * @return
     */
    @GetMapping("names")
    @ApiOperation(value = "返回整个组织结构树形结果", notes = "获取组织结构")
    @ApiImplicitParam(name = "id", dataType = "List<String>", required = false, value = "组织结构编号，不传返回整个树形组织结构，传则返回指定的树形结构")
    @ApiResponses({
            @ApiResponse(code = 200, message = "组织结构名称结果集合"),
            @ApiResponse(code = 404, message = "没有查询到结果"),
            @ApiResponse(code = 500, message = "查询失败"),
    })
    public ResponseEntity<List<String>> queryNamesByIds(@RequestParam("ids") List<String> ids){
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

      删除部门  新增部门

//修改部门
    @ApiOperation(value = "修改部门名称接口")
    @ApiJsonObject(name = "updateOrg", value = {
            @ApiJsonProperty(name = OrgJson.orgId),
            @ApiJsonProperty(name = OrgJson.orgName),
            @ApiJsonProperty(name = OrgJson.orderNum)})
    @ApiImplicitParam(name = "params", required = true, dataType = "updateOrg")
    @PostMapping("/updateOrg")
    public Result updateOrg(@RequestBody String params) {
        try {
            System.out.println("params参数为：" + params);

            JSONObject jsonObject = JSON.parseObject(params);
            String orgId = String.valueOf(jsonObject.get("orgId"));
            String orgName = String.valueOf(jsonObject.get("orgName"));
            String orderNum = String.valueOf(jsonObject.get("orderNum"));

            StringUtil.validateIsNull(orgId, "部门ID不能为空");
            StringUtil.validateIsNull(orgId, "部门名称不能为空");
            StringUtil.validateIsNull(orderNum, "排序值不能为空");

            OrgEntity entity = orgService.getById(orgId);
            entity.setOrgName(orgName);
            entity.setOrderNum(Integer.parseInt(orderNum));

            this.orgService.saveOrUpdate(entity);

            return Result.success("修改部门成功！");
        } catch (BusinessException e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("修改部门失败，失败原因：" + e.getMessage());
        }
    }


}
