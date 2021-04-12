package com.example.demo.generator.mapper;

public class MybatisPlusGenerator extends AbstractMybatisPlusGenerator {

    public static void main(String[] args) {
        MybatisPlusGenerator generator = new MybatisPlusGenerator();
        generator.generate();
    }

    @Override
    public String moduleName() {
        return "";
    }

    @Override
    public String packageName() {
        return "com.example.demo";
    }

    @Override
    public String[] tables() {
        return new String[]{"user_login_info"};
    }

    @Override
    public String datasourceUrl() {
        return "jdbc:mysql://localhost:3306/demo?useUnicode=true&useSSL=false&characterEncoding=utf8";
    }

    @Override
    public String datasourceUsername() {
        return "root";
    }

    @Override
    public String datasourcePassword() {
        return "dzc@2231";
    }

    /**
     * 是否覆盖已生成文件
     */
    public boolean overrideFile() {
        return true;
    }

}
