package com.thxy.domtest.create;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {
	public DocumentBuilder getDocumentBuilder() {
		// 创建一个DocumentBuilderFactory的对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 创建DocumentBuilder对象
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db;
	}

	/**
	 * 生成xml
	 */
	public void createXML() {
		DocumentBuilder db = getDocumentBuilder();
		Document document = db.newDocument();
		document.setXmlStandalone(true);
		Element bookStore = document.createElement("bookStore");
		// 向bookStore根节点添加子节点book
		Element book = document.createElement("book");
		Element name = document.createElement("name");
		Element price = document.createElement("price");
		// name.setNodeValue("小王子");
		name.setTextContent("小王子");
		price.setTextContent("88");
		
		book.appendChild(price);
		book.appendChild(name);
		book.setAttribute("id", "1");
		// 将book节点添加到bookStore根节点中
		bookStore.appendChild(book);
		// 将bookStore节点（包含了book）添加到DOM树中
		document.appendChild(bookStore);
		// 创建TransformerFactory对象
		TransformerFactory tff = TransformerFactory.newInstance();
		try {
			// 创建Transformer对象
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document), new StreamResult(new File("books1.xml")));
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void main(String args[]) {
		CreateXML createXml = new CreateXML();
		createXml.createXML();
	}
}
