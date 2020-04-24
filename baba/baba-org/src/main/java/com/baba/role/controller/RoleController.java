package com.baba.role.controller;


import com.baba.org.pojo.Org;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author xiechao
 * @since 2020-04-24
 */
@RestController
@RequestMapping("role")
@Api("角色服务接口")
public class RoleController {

    /**
     * 加载角色列表
     * @return
     */
    @GetMapping("list")
    @ApiOperation(value = "返回角色列表", notes = "返回角色列表")
    @ApiResponses({
            @ApiResponse(code = 200, message = "组织结构结果集合"),
            @ApiResponse(code = 404, message = "没有查询到结果"),
            @ApiResponse(code = 500, message = "查询失败"),
    })
    public ResponseEntity<List<Org>> queryRoleList(){
        return null;
    }
}
