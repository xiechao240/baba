import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        mpg.setTemplateEngine(new FreemarkerTemplateEngine()); //两种模板，我测试发现，生成的代码一模一样，有需要的时候再研究吧
//        mpg.setTemplateEngine(new VelocityTemplateEngine());


        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        System.out.println("当前目录：" + projectPath);
        //        gc.setOutputDir("/src/main/java");
        gc.setOutputDir(projectPath +"/baba-code-generator" + "/src/main/java");

        gc.setAuthor("xiechao");//开发人员
        gc.setOpen(false);//代码生成完，是否打开输出目录，true为打开，false不打开
//        gc.setEntityName("%sEntity");   //*************************************再开发系统采用这种？？？？？？？？？？？
        //gc.setServiceName("I%sService");//service 命名方式  **********************再开发系统采用这种？？？？？？？？？？？
        gc.setServiceName("%sService");//service 命名方式
        gc.setServiceImplName("%sServiceImpl");//service impl 命名方式
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setFileOverride(true);  //是否覆盖已有文件
        gc.setActiveRecord(false);  //实体entity类继承 Model类实现crud功能
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList  *************


        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setIdType(IdType.ASSIGN_UUID);//这个是3.3.1才开始有的，而且IdType.UUID即将过时
//        gc.setIdType(IdType.UUID);
        mpg.setGlobalConfig(gc);




        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/baba?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));//父包模块名
        pc.setParent("com.baba");//父包名。// 自定义包路径  如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setEntity("pojo");
//        pc.setMapper("dao");   //pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");//设置控制器包名
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        //下面是控制生成mapper.xml自定义sql的xml文件的
        String templatePath = "/templates/mapper.xml.ftl";//替换为自己编写的,用来生成xml文件的模板引擎
//        String templatePath = "/templates/mapper.xml.ftl";//此模板为，有格式化输出的模板
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/baba-code-generator" + "/src/main/resources/mapper/" //+ pc.getModuleName()
                        + "/"
                        +  tableInfo.getMapperName()
//                +  tableInfo.getEntityName()
                        + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
         templateConfig.setController("/templates/controller.java");//生成的@RequestMapping("user"),而不是生成@RequestMapping("/user"),能省点事，就省点事

//        templateConfig.setXml("/templates/mapper.xml"); //可以再次输出到com.baba.mapper.xml下
        templateConfig.setXml(null);

        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");//自定义继承的Entity类全称，带包名
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);//生成 @RestController 控制器, @RestController即这个类中定义的所有的方法都返回@ResponseBody即json的方式
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");//自定义继承的Controller类全称，带包名, com.baomidou.ant.common.BaseController 这个为举的例子
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");//自定义基础的Entity类，公共字段
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("tb_", "sys_");//表前缀
//        strategy.setLogicDeleteFieldName("deleted");//配置逻辑删除字段，全库逻辑删除都采用此字段命名，3.3.0开始，在配置文件中全局配置，Pojo类中不用再添加@TableLogic注解了

        // 表的自动填充字段,目前只设置自动更新，逻辑删除两个字段即可
        List<TableFill> tableFills = new ArrayList<>();
        TableFill deleted = new TableFill("deleted", FieldFill.INSERT_UPDATE);
        TableFill createDateTime  = new TableFill("create_date_time", FieldFill.INSERT);//创建时间，只新增的时候进行补全
        TableFill updateDateTime = new TableFill("update_date_time", FieldFill.INSERT_UPDATE);
//        TableFill updateById = new TableFill("update_by_id", FieldFill.INSERT_UPDATE);//更新人ID，其实也可以自动补全至数据库，到时候再扩充吧
        tableFills.add(deleted);
        tableFills.add(createDateTime);
        tableFills.add(updateDateTime);
//        tableFills.add(updateById);
        strategy.setTableFillList(tableFills);


        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}