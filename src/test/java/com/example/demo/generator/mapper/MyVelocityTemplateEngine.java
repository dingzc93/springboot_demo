package com.example.demo.generator.mapper;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Map;

public class MyVelocityTemplateEngine extends VelocityTemplateEngine {

    public MyVelocityTemplateEngine() {
    }

    @Override
    public Map<String, Object> getObjectMap(TableInfo tableInfo) {
        Map<String, Object> objectMap = super.getObjectMap(tableInfo);
        objectMap.put("annotation", "@Mapper");
        objectMap.put("annotationClassPackage", "org.apache.ibatis.annotations.Mapper");
        return objectMap;
    }

}
