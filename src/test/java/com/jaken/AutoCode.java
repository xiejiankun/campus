package com.jaken;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class AutoCode {
    public static void main(String[] args) {
        //构建一个代码自动生成器对象
        AutoGenerator mpg = new AutoGenerator();
        //配置策略

        //1.全局配置
        GlobalConfig gc = new GlobalConfig();
        //获得当前项目的路径
        String projectPath = System.getProperty("user.dir");
        //将输出内容输出到当前目录下的src/main/java
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("jaken Xie");//设置作者名
        gc.setOpen(false);//是否打开文件夹
        gc.setFileOverride(true);//是否覆盖之前写的代码
        gc.setServiceName("%sService");//去service前的I前缀
        gc.setDateType(DateType.ONLY_DATE);//设置日期的类型
        gc.setSwagger2(true);//设置swagger文档
        mpg.setGlobalConfig(gc);//把全局配置加入到自动生成器对象中

        //设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/second_hand?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("secondHand");
        pc.setParent("com.jaken");//设置父目录
        pc.setEntity("pojo");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //设置要映射的表名
        strategy.setInclude("shopping_cart","order_goods","order","img","goods_cart","goods","evaluation");//////////////////////////这里是最重要的
        //设置下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);//自动生成lombok

        //设置restful风格
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);//在地址栏输入的地址风格如:localhost:8080/hello_id_2
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
