package com.linjie.jaxptest;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class TestJaxp {
    public static void main(String[] args) throws Exception {
//        addSex();
//        selectAll();
//        modifySex();
//        delSex();
        listElement();
    }
    //在第一个p1下面（末尾）添加<sex>nv</sex>
    public static void addSex() throws Exception{
        /**
         * 1、创建解析器工厂
         * 2、根据解析器工厂创建解析器
         * 3、解析xml，返回document
         * 4.得到第一个p1
         * 5.创建sex标签createElement
         * 6.创建文本createTextNode
         * 7.把文本添加到sex下面appendChild
         * 8.把sex添加到第一个p1下面
         * 9.回写xml
         */

        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml返回document
        Document document = builder.parse("05_xml/src/person.xml");
        //得到p1元素
        NodeList list = document.getElementsByTagName("p1");
        //得到第一个p1
        Node p1 = list.item(0);
        //创建标签
        Element sex1 = document.createElement("sex");
        //创建文本
        Text text1 = document.createTextNode("nv");
        //把文本添加到sex1下
        sex1.appendChild(text1);
        //把sex1添加到p1下面
        p1.appendChild(sex1);
        //回写xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult("05_xml/src/person.xml"));
    }

    //修改第一个p1下面的sex内容是nan
    public static void modifySex() throws Exception{
        /**
         * 1、创建解析器工厂
         * 2、根据解析器工厂创建解析器
         * 3、解析xml，返回document
         * 4.得到sex
         * 5.修改sex里面的值 setTextContent方法
         * 6.回写xml
         */
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml返回document
        Document document = builder.parse("05_xml/src/person.xml");
        //得到p1元素
        NodeList list = document.getElementsByTagName("sex");
        //得到第一个p1
        Node sex1 = list.item(0);
        sex1.setTextContent("nan");
        //回写xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult("05_xml/src/person.xml"));
    }

    //删除<sex>nan</sex>节点
    public static void delSex() throws Exception{
        /**
         * 1、创建解析器工厂
         * 2、根据解析器工厂创建解析器
         * 3、解析xml，返回document
         * 4.获取sex元素
         * 5.获取sex的父节点
         * 6.删除使用父节点删除removeChild方法
         * 7.回写xml
         */
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml返回document
        Document document = builder.parse("05_xml/src/person.xml");
        //获取sex元素
        Node sex1 = document.getElementsByTagName("sex").item(0);
        //获取sex的父节点
        Node fu = sex1.getParentNode();
        fu.removeChild(sex1);
        //回写xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult("05_xml/src/person.xml"));
    }

    public static void selectAll() throws Exception{
        //查询所有name元素的值
        /**
         * 1、创建解析器工厂
         * 2、根据解析器工厂创建解析器
         * 3、解析xml，返回document
         * 4、得到所有的name元素
         * 5、返回集合，遍历集合，得到每一个那么元素
         */

        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml返回document
        Document document = builder.parse("05_xml/src/person.xml");
        //得到name元素
        NodeList list = document.getElementsByTagName("name");
        //遍历结合
        for (int i=0;i<list.getLength();i++){
            Node name1 = list.item(i);
            String s = name1.getTextContent();
            System.out.println(s);
        }
    }

    //遍历节点，把所有元素名称打印出来
    public static void listElement() throws Exception{
        /**
         * 1、创建解析器工厂
         * 2、根据解析器工厂创建解析器
         * 3、解析xml，返回document
         *
         * ====使用递归实现====
         * 4、得到根节点
         * 5.得到根节点的子节点
         * 6.得到根节点的子节点的子节点
         */
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml返回document
        Document document = builder.parse("05_xml/src/person.xml");
        //编写一个方法实现遍历的操作
        list1(document);
    }

    //递归遍历的方法
    private static void list1(Node node) {
        //判断是元素类型的时候才打印
        if (node.getNodeType()==Node.ELEMENT_NODE){
            System.out.println(node.getNodeName());
        }
        //得到一层子节点
        NodeList list = node.getChildNodes();
        //遍历list
        for (int i=0;i<list.getLength();i++){
            Node node1 = list.item(i);
            //继续得到node1的子节点
            list1(node1);
        }
    }
}
