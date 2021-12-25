package com.astonm.springbootBaseProject.dao.generation;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Astonm
 * @Date 2021/12/25
 * @Description:
 **/
public class MybatisCodeGenerator {
    /**
     * 数据库连接
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/demouser?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
    /**
     * 数据库账号
     */
    private static final String USERNAME = "root";
    /**
     * 数据库密码
     */
    private static final String PASSWORD = "root";
    /**
     * 模块名
     */
    private static final String MODULE_NAME = "";
    /**
     *  src/main/java 下要生成dao文件的包名
     */
    private static final String PARENT_MODULE_NAME = "com.astonm.springbootBaseProject.dao";

    /**
     * <p>
     * 读取控制台内容
     *
     * @param </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        String module = scanner("请输入模块名称");
        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        String projectPath = System.getProperty("user.dir") + MODULE_NAME;
        System.out.println(projectPath);
        //设置文件路径和模块文件生成
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("Mybatis-Plus Generation");
        //生成类名限制
        gc.setMapperName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImp");
        gc.setControllerName("%sController");
        gc.setXmlName("%sMapper");
        gc.setIdType(IdType.AUTO);
        gc.setOpen(false);
        //是否覆盖
        gc.setFileOverride(true);
        //实体属性 Swagger2 注解
        gc.setSwagger2(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DB_URL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置:生成文件
        PackageConfig pc = new PackageConfig();
        //包路径
        pc.setParent(PARENT_MODULE_NAME);
        //包路径下的子包名称
        pc.setMapper("mapper." + module);
        pc.setController("controller." + module);
        pc.setService("service." + module);
        pc.setServiceImpl("service." + module + ".imp");
        pc.setEntity("entity");
        pc.setXml("Mapper");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                // Mapper 文件输出
                String xmlUrl = projectPath + "/src/main/resources/mappers/" + module
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                System.out.println("xml生成路径:" + xmlUrl);
                return xmlUrl;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        //是否生成注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}