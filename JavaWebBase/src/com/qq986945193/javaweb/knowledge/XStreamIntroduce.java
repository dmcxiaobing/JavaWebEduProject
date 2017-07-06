package com.qq986945193.javaweb.knowledge;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.qq986945193.javaweb.domain.City;
import com.qq986945193.javaweb.domain.Province;
import com.thoughtworks.xstream.XStream;

/**
 * xstream的使用简单介绍
 */
public class XStreamIntroduce {

	/**
	 * 返回javabean的list集合
	 */
	public List<Province> getProvinceList() {


		Province p1 = new Province();
		p1.setName("广东省");
		p1.addCity(new City("广州", "广州市"));
		p1.addCity(new City("深圳","深圳市"));


		Province p2 = new Province();
		p2.setName("河南省");
		p2.addCity(new City("郑州", "郑州市"));
		p2.addCity(new City("商丘","商丘市"));
		List<Province> provincelists = new ArrayList<Province>();
		provincelists.add(p1);
		provincelists.add(p2);
		return provincelists;
	}
	
	/**
	 * 利用xtream将java bean的集合转换成xml字符串 
	 *	得到的结果是.
	 *<list>
  			<com.qq986945193.javaweb.domain.Province>
    			<name>广东省</name>
    				<lists>
	      				<com.qq986945193.javaweb.domain.City>
	        				<name>广州</name>
	        				<description>广州市</description>
	      				</com.qq986945193.javaweb.domain.City>
      				</lists>
		  </com.qq986945193.javaweb.domain.Province>
		  <com.qq986945193.javaweb.domain.Province>
		    	<name>河南省</name>
		    	<lists>
		      		<com.qq986945193.javaweb.domain.City>
		        		<name>郑州</name>
		        		<description>郑州市</description>
		      		</com.qq986945193.javaweb.domain.City>
		    	</lists>
		  	</com.qq986945193.javaweb.domain.Province>
		</list>
	 */
	@Test
	public void xstreamToXml(){
		//得到集合
		List<Province> lists = getProvinceList();
		
		//创建Xstream对象。然后调用toXML()把集合转换成xml字符串
		XStream xStream = new XStream();
		String xmlString = xStream.toXML(lists);

		System.out.println(xmlString);
	
	}
	/**
	 *设置别名alias
	 **希望：默认List类型对应<list>元素，系统让List类型对应<china>元素
	 **    默认Province类型对应（ <com.qq986945193.javaweb.domain.Province>）,希望它对应Province
	 *		默认City类型对应（<com.qq986945193.javaweb.domain.City>）,希望它对应<city>元素
	 *
	 *
	 *<china>
		  <province>
		    <name>广东省</name>
		    <lists>
		      <city>
		        <name>广州</name>
		        <description>广州市</description>
		      </city>
		    </lists>
		  </province>
		  <province>
		    <name>河南省</name>
		    <lists>
		      <city>
		        <name>郑州</name>
		        <description>郑州市</description>
		      </city>
		    </lists>
		  </province>
		</china>
	 */
	@Test
	public void xstreamToXmlAlias(){
		//得到集合
		List<Province> lists = getProvinceList();
		
		//创建Xstream对象。然后调用toXML()把集合转换成xml字符串
		XStream xStream = new XStream();
		/**
		 * 给指定的类型设置别名
		 */
		xStream.alias("china", List.class);//给List类型指定别名为china
		xStream.alias("province", Province.class);//给Province设置别名为province
		xStream.alias("city", City.class);//给City类型设置别名为city
		String xmlString = xStream.toXML(lists);
		
		System.out.println(xmlString);
	
	}
	/**
	 * <china>
		  <province name="广东省">
		    <citys>
		      <city>
		        <name>广州</name>
		        <description>广州市</description>
		      </city>
		      <city>
		        <name>深圳</name>
		        <description>深圳市</description>
		      </city>
		    </citys>
		  </province>
		  <province name="河南省">
		    <citys>
		      <city>
		        <name>郑州</name>
		        <description>郑州市</description>
		      </city>
		      <city>
		        <name>商丘</name>
		        <description>商丘市</description>
		      </city>
		    </citys>
		  </province>
		</china>
	 */
	@Test
	public void xstreamToxmlalias(){
		List<Province> lists = getProvinceList();
		//创建Xstream对象
		XStream xStream = new XStream();
		/**
		 * 给指定的类型设置别名
		 */
		xStream.alias("china",List.class);
		xStream.alias("province", Province.class);
		xStream.alias("city", City.class);
		/**
		 * 把Province类型的name属性，生成<province>元素的属性
		 */
		xStream.useAttributeFor(Province.class, "name");
		/**
		 * 去除<citys>类型的Collection类型的属性
		 * 去除province类的名为citys的List类型的属性
		 */
		/**
		 * <china>
			  <province name="广东省">
			    <city>
			      <name>广州</name>
			      <description>广州市</description>
			    </city>
			    <city>
			      <name>深圳</name>
			      <description>深圳市</description>
			    </city>
			  </province>
			  <province name="河南省">
			    <city>
			      <name>郑州</name>
			      <description>郑州市</description>
			    </city>
			    <city>
			      <name>商丘</name>
			      <description>商丘市</description>
			    </city>
			  </province>
			</china>
		 */
		xStream.addImplicitCollection(Province.class, "citys");
		/**
		 * 让City类的，名为description属性不生成对应的xml元素
		 */
		/**
		 * <china>
			  <province name="广东省">
			    <city>
			      <name>广州</name>
			    </city>
			    <city>
			      <name>深圳</name>
			    </city>
			  </province>
			  <province name="河南省">
			    <city>
			      <name>郑州</name>
			    </city>
			    <city>
			      <name>商丘</name>
			    </city>
			  </province>
			</china>
		 */
		xStream.omitField(City.class, "description");
		String s = xStream.toXML(lists);
		System.out.println(s);
		
	}
}

















