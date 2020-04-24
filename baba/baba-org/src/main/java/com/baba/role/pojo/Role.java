package com.baba.role.pojo;

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
 * 角色表
 * </p>
 *
 * @author xiechao
 * @since 2020-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_role")
@ApiModel(value="Role对象", description="角色表")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    @TableId(value = "role_id", type = IdType.ASSIGN_UUID)
    private String roleId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "是否为超级管理员（0代表不是超级管理员角色，1代表是超级管理员）")
    private Boolean isAdmin;

    @ApiModelProperty(value = "是否启用，1：启用，0：停用")
    private Boolean available;

    @ApiModelProperty(value = "创建人")
    private String createrById;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDateTime;

    @ApiModelProperty(value = "备注")
    private String remark;


}
