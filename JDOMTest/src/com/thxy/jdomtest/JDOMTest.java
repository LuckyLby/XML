package com.thxy.jdomtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.thxy.entity.Book;

public class JDOMTest {
	private static ArrayList<Book> booksList = new ArrayList<Book>();

	private void parseXML() {
		// 进行对book.xml文件的JDOM解析
		// 准备工作
		// 1.创建一个SAXBilder的对象
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			// 2.创建一个输入流，将xml文件加载到输入流中
			InputStream in = new FileInputStream("src/res/books.xml");
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			// 3.通过saxBuilder的build方法，将输入流加载到saxBuilder中
			Document document = saxBuilder.build(isr);
			// 4.通过document对象获取xml文件的根节点
			Element rootElement = document.getRootElement();
			// 5.获取根节点下的子节点的List集合
			List<Element> bookList = rootElement.getChildren();
			// 继续进行解析
			for (Element book : bookList) {
				Book bookEntity = new Book();
				System.out.println("=====开始解析第" + (bookList.indexOf(book) + 1) + "本书===============");
				// 解析book的属性
				List<Attribute> attrList = book.getAttributes();
				// //知道节点下属性名称时，获取节点值
				// book.getAttribute("id");
				// 遍历attrList(针对不清楚book节点下属性的名字及数量)
				for (Attribute attr : attrList) {
					// 遍历属性名
					String attrName = attr.getName();
					// 遍历属性值
					String attrValue = attr.getValue();
					System.out.println("属性名：" + attrName + "-----属性值：" + attrValue);
					if (attrName.equals("id")) {
						bookEntity.setId(attrValue);
					}
				}
				// 对book节点的子节点的节点名以及节点值的遍历
				List<Element> bookChilds = book.getChildren();
				for (Element child : bookChilds) {
					System.out.println("节点名:" + child.getName() + "-----节点值：" + child.getValue());
					if (child.getName().equals("name")) {
						bookEntity.setName(child.getValue());
					} else if (child.getName().equals("author")) {
						bookEntity.setAuthor(child.getValue());
					} else if (child.getName().equals("year")) {
						bookEntity.setYear(child.getValue());
					} else if (child.getName().equals("price")) {
						bookEntity.setPrice(child.getValue());
					} else if (child.getName().equals("language")) {
						bookEntity.setLanguage(child.getValue());
					}
				}
				System.out.println("=====结束解析第" + (bookList.indexOf(book) + 1) + "本书===============");
				booksList.add(bookEntity);
				bookEntity = null;
				System.out.println(booksList.size());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 创建xml文件
	private void createXML() {
		// 1.生成一个根节点
		Element rss = new Element("rss");
		// 2.为节点添加属性
		rss.setAttribute("version", "2.0");
		// 3.生成一个document对象
		Document document = new Document(rss);
		Element channel = new Element("channel");
		rss.addContent(channel);
		// CDATA cdata = new CDATA("<![CDATA[上海移动互联网产业促进中心正式揭牌]]>");
		Element title = new Element("title");
		title.setText("<![CDATA[上海移动互联网产业促进中心正式揭牌]]>");
		channel.addContent(title);

		// 格式化
		Format format = Format.getCompactFormat();
		format.setIndent("");
		format.setEncoding("GBK");
		// 4.创建XMLOutputter对象
		XMLOutputter outputer = new XMLOutputter(format);
		try {
			// 5.利用outputer将document对象转换成xml文档
			outputer.output(document, new FileOutputStream(new File("rssnews.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new JDOMTest().createXML();
	}
}
