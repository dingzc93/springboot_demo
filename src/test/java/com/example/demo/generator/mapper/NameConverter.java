package com.example.demo.generator.mapper;

import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Set;

public class NameConverter implements INameConvert {

    private StrategyConfig config;

    public NameConverter(StrategyConfig config) {
        this.config = config;
    }

    @Override
    public String entityNameConvert(TableInfo tableInfo) {
        return NamingStrategy.capitalFirst(this.processName(tableInfo.getName(), this.config.getNaming(), this.config.getTablePrefix())) + "DO";
    }

    @Override
    public String propertyNameConvert(TableField field) {
        return this.processName(field.getName(), this.config.getNaming(), this.config.getFieldPrefix());
    }

    private String processName(String name, NamingStrategy strategy, Set<String> prefix) {
        boolean removePrefix = false;
        if (prefix != null && prefix.size() != 0) {
            removePrefix = true;
        }

        String propertyName;
        if (removePrefix) {
            if (strategy == NamingStrategy.underline_to_camel) {
                propertyName = NamingStrategy.removePrefixAndCamel(name, prefix);
            } else {
                propertyName = NamingStrategy.removePrefix(name, prefix);
            }
        } else if (strategy == NamingStrategy.underline_to_camel) {
            propertyName = NamingStrategy.underlineToCamel(name);
        } else {
            propertyName = name;
        }

        return propertyName;
    }

}
