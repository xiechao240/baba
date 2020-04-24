package com.baba.menu.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author xiechao
 * @since 2020-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_menu")
@ApiModel(value="Menu对象", description="菜单表")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单ID")
    @TableId(value = "menu_id", type = IdType.ASSIGN_UUID)
    private String menuId;

    @ApiModelProperty(value = "上级菜单ID，顶级菜单为0")
    private String parentId;

    @ApiModelProperty(value = "部门ID全路径，以,逗号分隔")
    private String fullPathId;

    @ApiModelProperty(value = "部门ID全路径名称（以》号分隔，可用来做面包屑）")
    private String fullPathName;

    @ApiModelProperty(value = "菜单名称")
    private String name;

    @ApiModelProperty(value = "访问链接路径")
    private String url;

    @ApiModelProperty(value = "菜单类型   0：目录   1：菜单   2：按钮")
    private String type;

    @ApiModelProperty(value = "菜单权限标识符，授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)")
    private String permission;

    @ApiModelProperty(value = "是否显示此菜单，0：不显示，1：显示")
    private Boolean isShow;

    @ApiModelProperty(value = "菜单排序号")
    private Integer sortNum;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    @ApiModelProperty(value = "创建人ID")
    private String createrById;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDateTime;

    @ApiModelProperty(value = "修改人ID")
    private String updaterById;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDateTime;

    @ApiModelProperty(value = "描述")
    private String remark;


}
