package com.ningkangkj.wxWebService.util;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 *  @Description 更加数据表自动生成相关的map,dao,service等文件
 *  @Author luckypt
 *  @Date 2018/04/24
 */

public class CustomGenerator {
    public static void main(String[] args) throws InterruptedException {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        //java源码所在目录
        //windows目录
        //gc.setOutputDir("D:\\workspace\\github\\wxWebService\\wxWebService\\wxWebService\\src\\main\\java");
        //linux目录
        gc.setOutputDir("/home/Work/idea/wxWebService/wxWebService/src/main/java");

        gc.setFileOverride(true);
        gc.setActiveRecord(false);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList

        //设置作者
        gc.setAuthor("luckypt");

        // 自定义文件命名，注意 %s 指数据库中的表名称！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        /*dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });*/
        dsc.setDriverName("com.mysql.jdbc.Driver");

        /*
        dsc.setUrl(
            "jdbc:mysql://192.168.1.15:3306/videowebservice?useUnicode=true&amp;characterEncoding=UTF-8&amp;generateSimpleParameterMetadata=true");
        */
        dsc.setUrl(
                "jdbc:mysql://127.0.0.1:3306/wxWebService?useUnicode=true&amp;characterEncoding=UTF-8&amp;generateSimpleParameterMetadata=true");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        // strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        //多表示例：{"file_info","t_ems_order"}
        strategy.setInclude(new String[] {"file_info"}); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.ningkangkj.wxWebService");
        pc.setModuleName("customGenerator");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}
