package com.baba.item.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表，所有登录CRM系统的员工账号都存储在此表
 * </p>
 *
 * @author xiechao
 * @since 2020-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_user")
@ApiModel(value="User对象", description="用户表，所有登录CRM系统的员工账号都存储在此表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id", type = IdType.ASSIGN_UUID)
    private String userId;

    @ApiModelProperty(value = "登录账号")
    private String loginName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "密码盐，确保同样的密码保存入库为不一样的值")
    private String salt;

    @ApiModelProperty(value = "用户数据访问权限, -1:系统所有数据; 0:用户自定义数据访问权限; 1:自己的数据; 2:仅所属部门数据; 3:所属部门及其以下所有数据; ")
    private Integer dataScope;

    @ApiModelProperty(value = "用户类型（与角色类型对应） 1：超级管理员，2：区域管理员，3：分校管理员，4：部门管理员，5：销售人员，6：普通用户，7：代理商用户")
    private String userType;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "状态，0：禁用状态，1：可用状态，2：离职状态")
    private String state;

    @ApiModelProperty(value = "性别，1：男，2：女")
    private String sex;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "公司名称（用户无修改权限）")
    private String companyName;

    @ApiModelProperty(value = "部门（用户无修改权限）")
    private String department;

    @ApiModelProperty(value = "职位（用户无修改权限）")
    private String job;

    @ApiModelProperty(value = "行业（用户无修改权限）")
    private String trade;

    @ApiModelProperty(value = "地址（用户无修改权限）")
    private String address;

    @ApiModelProperty(value = "网址（用户无修改权限）")
    private String site;

    @ApiModelProperty(value = "微信授权")
    private String weixinAuthorId;

    @ApiModelProperty(value = "邮箱授权")
    private String emailAuthorId;

    @ApiModelProperty(value = "登录时间")
    private LocalDateTime loginDateTime;

    @ApiModelProperty(value = "账号创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDateTime;

    @ApiModelProperty(value = "上次登录时间")
    private LocalDateTime preLoginDateTime;

    @ApiModelProperty(value = "本次登录时间")
    private LocalDateTime thisLoginDateTime;

    @ApiModelProperty(value = "账号更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDateTime;

    @ApiModelProperty(value = "地区(省或自治区)ID（用户无修改权限）")
    private String provinceId;

    @ApiModelProperty(value = "地区(省)名称（冗余）（用户无修改权限）")
    private String provinceName;

    @ApiModelProperty(value = "地区(市)ID（用户无修改权限）")
    private String cityId;

    @ApiModelProperty(value = "地区(市)名称（冗余）（用户无修改权限）")
    private String cityName;

    @ApiModelProperty(value = "地区(区)（用户无修改权限）")
    private String areaId;

    @ApiModelProperty(value = "地区(区)名称（冗余）（用户无修改权限）")
    private String areaName;

    @ApiModelProperty(value = "创建人（比如谁创建的代理商）")
    private String createUserId;

    @ApiModelProperty(value = "修改人（比如谁修改的代理商拥有的业务组等）")
    private String updateUserId;

    @ApiModelProperty(value = "删除标记，是true：1 ；否false：0")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Boolean deleted;


}
