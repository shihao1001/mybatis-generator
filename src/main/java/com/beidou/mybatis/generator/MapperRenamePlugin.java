package com.beidou.mybatis.generator;

import com.beidou.mybatis.generator.utils.PluginUtils;
import java.util.List;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * Created by beidou on 2018/4/11.
 */
public class MapperRenamePlugin extends PluginAdapter {

  private String getToBeReplace() {
    return this.getProperties().getProperty("toBeReplace", "");
  }

  public boolean validate(List<String> list) {
    return true;
  }

  @Override
  public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
      IntrospectedTable introspectedTable) {
    System.out.println("toBeReplace: " + getToBeReplace());
    FullyQualifiedJavaType type = interfaze.getType();
    PluginUtils.replace(type, "baseShortName", getToBeReplace(), "");
    PluginUtils.replace(type, "baseQualifiedName", getToBeReplace(), "");
    return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
  }

  @Override
  public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
    XmlElement root = document.getRootElement();
    Attribute namespace = root.getAttributes().get(0);
    PluginUtils.replace(namespace, "value", getToBeReplace(), "");

    return super.sqlMapDocumentGenerated(document, introspectedTable);
  }

  @Override
  public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
    PluginUtils.replace(sqlMap, "fileName", getToBeReplace(), "");
    return super.sqlMapGenerated(sqlMap, introspectedTable);
  }
}
