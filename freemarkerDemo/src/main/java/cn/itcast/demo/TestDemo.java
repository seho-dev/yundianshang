package cn.itcast.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class TestDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		第一步：创建一个 Configuration 对象，直接 new 一个对象。构造方法的参数就是 freemarker的版本号。
		Configuration configuration = new Configuration(Configuration.getVersion());
//		第二步：设置模板文件所在的路径。
		configuration.setDirectoryForTemplateLoading( new File("E:/SSH/workspace_pingyougou/freemarkerDemo/src/main/resources/"));
//		第三步：设置模板文件使用的字符集。一般就是 utf-8.
		configuration.setDefaultEncoding("GBK");
//		第四步：加载一个模板，创建一个模板对象。
		Template template = configuration.getTemplate("test.ftl");
//		第五步：创建一个模板使用的数据集，可以是 pojo 也可以是 map。一般是 Map。
		Map map = new HashMap();
		map.put("name", "tom");
		map.put("message", "is my pinyougou");
		map.put("success", true);
		map.put("tody", new Date());
		map.put("point", 155251365);
		
		
		
		List goodList = new ArrayList();
		Map map1 = new HashMap();
		map1.put("name", "苹果");
		map1.put("price", "500");
		Map map2 = new HashMap();
		map2.put("name", "粒子");
		map2.put("price", "300");
		Map map3 = new HashMap();
		map3.put("name", "香蕉");
		map3.put("price", "200");
		
		goodList.add(map1);
		goodList.add(map2);
		goodList.add(map3);
		
		map.put("goodList", goodList);
		
		
//		第六步：创建一个 Writer 对象，一般创建一 FileWriter 对象，指定生成的文件名。
		Writer out = new FileWriter(new File("d:\\test.html"));
//		第七步：调用模板对象的 process 方法输出文件。
		template.process(map, out);
//		第八步：关闭流
		out.close();

	}

}
