package com.example.demo.generator.mapper;

import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;

public class MyConfigBuilder extends ConfigBuilder {
    public MyConfigBuilder(PackageConfig packageConfig, DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, TemplateConfig template, GlobalConfig globalConfig) {
        super(packageConfig, dataSourceConfig, strategyConfig, template, globalConfig);
    }

    @Override
    public List<TableInfo> getTableInfoList() {
        List<TableInfo> tableInfos = super.getTableInfoList();
        if (!CollectionUtils.isEmpty(tableInfos)) {
            Iterator var2 = tableInfos.iterator();

            while(var2.hasNext()) {
                TableInfo tableInfo = (TableInfo)var2.next();
                tableInfo.setConvert(true);
                String mapperName = tableInfo.getMapperName();
                if (StringUtils.isNotEmpty(mapperName) && mapperName.endsWith("DOMapper")) {
                    int index = mapperName.indexOf("DOMapper");
                    StringBuilder nameBuilder = new StringBuilder();
                    nameBuilder.append(mapperName.substring(0, index)).append("Mapper");
                    tableInfo.setMapperName(nameBuilder.toString());
                }

                String xmlName = tableInfo.getXmlName();
                if (StringUtils.isNotBlank(xmlName) && xmlName.endsWith("DOMapper")) {
                    int index = xmlName.indexOf("DOMapper");
                    StringBuilder nameBuilder = new StringBuilder();
                    nameBuilder.append(xmlName.substring(0, index)).append("Mapper");
                    tableInfo.setXmlName(nameBuilder.toString());
                }
            }
        }

        return tableInfos;
    }

}
