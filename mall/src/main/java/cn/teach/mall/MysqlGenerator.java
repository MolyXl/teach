package cn.teach.mall;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

/**
 * <p>
 * mysql 代码生成器演示例子
 * </p>
 *
 * @author jobob
 * @since 2018-09-12
 */
public class MysqlGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        String[] split = "teach_course,teach_teaching,teach_revolution,teach_practise_paper,teach_practise_other,teach_practise_inspect,teach_practise_course,teach_practise_competition,teach_exam,teach_course".replace(" ", "").split(",");
        for (int i = 0; i < split.length; i++) {
            String model = "teach";
            //model = scanner("模块名");
            //String prefix = "marketing";
            //prefix = scanner("表前缀");

            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();
            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            String projectPath = System.getProperty("user.dir");
            //gc.setFileOverride(true);//开启需谨慎
            //gc.setActiveRecord(true);
            //gc.setEnableCache(false);
            gc.setOutputDir(projectPath + "/" + model + "/src/main/java");
            gc.setAuthor("MaZhuli");
            gc.setBaseResultMap(true);
            gc.setBaseColumnList(true);
            //gc.setXmlName("%sMapper");//是否生成xml
            gc.setDateType(DateType.ONLY_DATE);//时间日期类型
            gc.setOpen(false);
            mpg.setGlobalConfig(gc);

            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:mysql://127.0.0.1:3308/teach?useUnicode=true&useSSL=false&characterEncoding=utf8");
            // dsc.setSchemaName("public");
            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("mylord");
            mpg.setDataSource(dsc);

            // 包配置
            PackageConfig pc = new PackageConfig();
            //pc.setModuleName(scanner("模块名"));
            pc.setParent("cn.buyer.web");
            mpg.setPackageInfo(pc);


            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            //strategy.setSuperEntityClass("cn.pxkj.web");
            //strategy.setEntityLombokModel(true);
            //strategy.setSuperControllerClass("cn.pxkj.web.controller");
            strategy.setInclude(split[i]);
            //strategy.setSuperEntityColumns("id");
            //strategy.setControllerMappingHyphenStyle(true);

            strategy.setTablePrefix("");                  //修改此处表名前缀
            mpg.setStrategy(strategy);
            // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
            //mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            mpg.execute();
        }
    }

}