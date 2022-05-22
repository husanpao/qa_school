package cn.ch.qa_school;

import com.github.drinkjava2.jdialects.TableModelUtils;
import com.github.drinkjava2.jsqlbox.DbContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class QaSchoolApplicationTests {

    @Test
    void contextLoads() {
        Map<String, Object> setting = new HashMap<String, Object>();
        setting.put(TableModelUtils.OPT_EXCLUDE_TABLES, Arrays.asList("Dbsample")); // 排除个别表名
        setting.put(TableModelUtils.OPT_PACKAGE_NAME, "cn.ch.qa_school.bean");// 包名
        setting.put(TableModelUtils.OPT_IMPORTS, "import java.util.Map;\n"); // 追加新的imports
        setting.put(TableModelUtils.OPT_REMOVE_DEFAULT_IMPORTS, false); // 是否去除自带的imports
        setting.put(TableModelUtils.OPT_CLASS_DEFINITION, "public class $Class extends ActiveRecord<$Class> {");// 类定义模板
        setting.put(TableModelUtils.OPT_FIELD_FLAGS, true); // 全局静态属性字段标记
        setting.put(TableModelUtils.OPT_FIELD_FLAGS_STATIC, true); // 全局静态属性字段标记
        setting.put(TableModelUtils.OPT_FIELD_FLAGS_STYLE, "upper"); // 全局静态属性字段标记可以有upper,lower,normal,camel几种格式
        setting.put(TableModelUtils.OPT_FIELDS, true); // 是否生成JavaBean属性
        setting.put(TableModelUtils.OPT_GETTER_SETTERS, true); // 是否生成getter setter
        setting.put(TableModelUtils.OPT_PUBLIC_FIELD, false); // JavaBean属性是否定义成public
        setting.put(TableModelUtils.OPT_LINK_STYLE, true); // getter/setter是否生成为链式风格

        TableModelUtils.db2JavaSrcFiles(DbContext.getGlobalDbContext().getDataSource(), DbContext.getGlobalDbContext().getDialect(), "c:/temp", setting);
    }

}
