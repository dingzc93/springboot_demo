package com.example.demo.generator.mapper;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMybatisPlusGenerator {

    public AbstractMybatisPlusGenerator() {
    }

    public void generate() {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new MyVelocityTemplateEngine());
        GlobalConfig globalConfig = this.createGlobalConfig(this.moduleName(), this.overrideFile());
        DataSourceConfig dataSourceConfig = this.createDataSourceConfig(this.datasourceUrl(), this.datasourceDriverName(), this.datasourceUsername(), this.datasourcePassword());
        PackageConfig packageConfig = this.createPackageConfig(this.packageName());
        InjectionConfig injectionConfig = this.createInjectionConfig(this.moduleName(), this.overrideMapper());
        StrategyConfig strategyConfig = this.createStrategyConfig(this.tables());
        TemplateConfig templateConfig = this.createTemplateConfig(this.overrideMapper());
        mpg.setConfig(new MyConfigBuilder(packageConfig, dataSourceConfig, strategyConfig, templateConfig, globalConfig));
        injectionConfig.setConfig(mpg.getConfig());
        mpg.setGlobalConfig(globalConfig);
        mpg.setDataSource(dataSourceConfig);
        mpg.setPackageInfo(packageConfig);
        mpg.setCfg(injectionConfig);
        mpg.setStrategy(strategyConfig);
        mpg.setTemplate(templateConfig);
        mpg.execute();
    }

    public abstract String moduleName();

    public abstract String packageName();

    public abstract String[] tables();

    public abstract String datasourceUrl();

    public abstract String datasourceUsername();

    public abstract String datasourcePassword();

    public String datasourceDriverName() {
        return "com.mysql.cj.jdbc.Driver";
    }

    public boolean overrideMapper() {
        return true;
    }

    public boolean overrideFile() {
        return false;
    }

    protected GlobalConfig createGlobalConfig(String moduleName, boolean overrideFile) {
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        if (StringUtils.isBlank(moduleName)) {
            globalConfig.setOutputDir(projectPath + "/src/main/java");
        } else {
            globalConfig.setOutputDir(projectPath + "/" + moduleName + "/src/main/java");
        }

        globalConfig.setAuthor("mybatis plus");
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(overrideFile);
        globalConfig.setDateType(DateType.ONLY_DATE);
        return globalConfig;
    }

    protected DataSourceConfig createDataSourceConfig(String url, String driverName, String username, String password) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setDriverName(driverName);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        return dataSourceConfig;
    }

    protected PackageConfig createPackageConfig(String packageName) {
        PackageConfig pc = new PackageConfig();
        pc.setEntity("domain.model");
        pc.setParent(packageName);
        return pc;
    }

    protected InjectionConfig createInjectionConfig(final String moduleName, boolean overrideMapper) {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };
        if (overrideMapper) {
            final String projectPath = System.getProperty("user.dir");
            String templatePath = "/templates/mapper.xml.vm";
            List<FileOutConfig> focList = new ArrayList();
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return StringUtils.isBlank(moduleName) ? projectPath + "/src/main/resources/mapper/" + tableInfo.getXmlName() + ".xml" : projectPath + "/" + moduleName + "/src/main/resources/mapper/" + tableInfo.getXmlName() + ".xml";
                }
            });
            cfg.setFileOutConfigList(focList);
        }

        return cfg;
    }

    protected StrategyConfig createStrategyConfig(String[] tableNames) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setCapitalMode(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setInclude(tableNames);
        NameConverter nameConverter = new NameConverter(strategyConfig);
        strategyConfig.setNameConvert(nameConverter);
        return strategyConfig;
    }

    protected TemplateConfig createTemplateConfig(boolean overrideMapper) {
        TemplateConfig tc = new TemplateConfig();
        tc.setMapper("/templates/mapper.java");
        tc.setController((String)null);
        tc.setService((String)null);
        tc.setServiceImpl((String)null);
        tc.setXml((String)null);
        if (!overrideMapper) {
            tc.setMapper((String)null);
        }
        return tc;
    }

}
