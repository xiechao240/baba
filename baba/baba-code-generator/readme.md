
resources/templates目录下，我重写了mybatis plus的用来生成controller类，mapper.xml映射文件的模板
功能如下：
    controller类，增加如下功能：
        @RequestMapping("org")
        @Api("组织架构服务接口")
    
    mapper.xml，增加如下功能：
        生成如下的别名列，在自定义sql及返回resultMap为HashMap时使用
            Alias_Base_Column_List，Alias_Param_Base_Column_List
            
