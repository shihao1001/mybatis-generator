package com.beidou.mybatis.generator;

import java.util.List;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * Created by beidou on 2018/4/11.
 */
public class ModelCommentsPlugin extends PluginAdapter {

  public boolean validate(List<String> list) {
    return true;
  }

  @Override
  public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass,
      IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
      ModelClassType modelClassType) {
    field.addAnnotation("/** " + introspectedColumn.getRemarks() + "**/");
    return super.modelFieldGenerated(field, topLevelClass, introspectedColumn, introspectedTable,
        modelClassType);
  }

  @Override
  public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
      IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
      ModelClassType modelClassType) {
//    StringBuilder sb = new StringBuilder();
//    sb.append("/**\n").append("* 获取").append(introspectedColumn.getRemarks()).append("\n")
//        .append("* @Return ").append(introspectedColumn.getRemarks()).append("\n").append("**/");
//    method.addAnnotation(sb.toString());
    return super
        .modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable,
            modelClassType);
  }

  @Override
  public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
      IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
      ModelClassType modelClassType) {
    return super
        .modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable,
            modelClassType);
  }
}
