package com.baba.org.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 组织架构表，顶级节点：大立教育
 * </p>
 *
 * @author xiechao
 * @since 2020-04-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_org")
@ApiModel(value="Org对象", description="组织架构表，顶级节点：大立教育")
public class Org implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门ID")
    @TableId(value = "org_id", type = IdType.ASSIGN_UUID)
    private String orgId;

    @ApiModelProperty(value = "上级部门ID，顶级机构为0")
    private String parentId;

    @ApiModelProperty(value = "部门ID全路径，以,逗号分隔")
    private String fullPathId;

    @ApiModelProperty(value = "部门ID全路径名称（可用来做面包屑）")
    private String fullPathName;

    @NotNull
    @ApiModelProperty(value = "机构名称（部门名称）")
    private String name;

    @ApiModelProperty(value = "机构类型，0：顶级机构， 1：省份或直辖市，2：分校，3：部门， 4：代理商，5：代理商下的节点")
    private String type;

    @ApiModelProperty(value = "机构状态, 0:停用, 1:启用;")
    private Boolean state;

    @ApiModelProperty(value = "排序号")
    private Integer sortNum;

    @ApiModelProperty(value = "描述")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDateTime;

    @ApiModelProperty(value = "删除标记，是true：1 ；否false：0")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Boolean deleted;


}
