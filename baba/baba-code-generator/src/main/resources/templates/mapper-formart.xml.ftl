<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

    <#if enableCache>
        <!-- 开启二级缓存 -->
        <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>

    </#if>
    <#if baseResultMap>
        <!-- 通用查询映射结果 -->
        <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
            <#list table.fields as field>
                <#if field.keyFlag><#--生成主键排在第一位-->
                    <id column="${field.name}" property="${field.propertyName}" />
                </#if>
            </#list>
            <#list table.commonFields as field><#--生成公共字段 -->
                <result column="${field.name}" property="${field.propertyName}" />
            </#list>
            <#list table.fields as field>
                <#if !field.keyFlag><#--生成普通字段 -->
                    <result column="${field.name}" property="${field.propertyName}" />
                </#if>
            </#list>
        </resultMap>

    </#if>
    <#if baseColumnList>
        <!-- 通用查询结果列 -->
        <sql id="Base_Column_List">
            <#list table.commonFields as field>
                ${field.name},
            </#list>
            ${table.fieldNames}
        </sql>

    </#if>
    <#if baseColumnList>
        <!-- 通用查询结果列（用别名） -->
        <sql id="Alias_Base_Column_List">
            <#list table.fields as field><#if !field_has_next>${field.name} as ${field.propertyName}<#break></#if>${field.name} as ${field.propertyName}, </#list>
        </sql>
    </#if>


    <!-- 通用别名查询结果列(建议复杂关联查询时，使用) -->
    <sql id="Alias_Param_Base_Column_List">
        <#list table.fields as field>
            <#if !field_has_next>
                ${r"${alias}."}${field.name} as ${field.propertyName}
                <#break>
            </#if>
            ${r"${alias}."}${field.name} as ${field.propertyName},
        </#list>
    </sql>
</mapper>
