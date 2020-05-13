package parsexml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

/**
 * 原生javaAPI提供的方式 不需要导包
 * DOM-->Document Object Model
 */
public class DOM {
    public static void main(String[] args) {
        try {
            //1.需要一个工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //2.通过工厂创建工人
            DocumentBuilder builder = factory.newDocumentBuilder();
            //3.让工人解析xml文件 得到一个document对象
            File file = new File("src/myxml/school.xml");
            Document document = builder.parse(file);

            //4.获取xml文件内容
            //获取根标签
            Element school = document.getDocumentElement();
            //  获取学校信息
            String schoolID = school.getAttribute("id");
            String schoolName = school.getAttribute("name");
            String schoolLOC = school.getAttribute("loc");
            System.out.println(schoolID+"---"+schoolName+"---"+schoolLOC);
            //  获取学校里的班级信息
            NodeList classList = school.getElementsByTagName("class");
            for(int i = 0;i < classList.getLength();i++){
                Element classEle = (Element)classList.item(i);
                String classID = classEle.getAttribute("id");
                String className = classEle.getAttribute("name");
                String classLOC = classEle.getAttribute("loc");
                System.out.println("\t"+classID+"---"+className+"---"+classLOC);
                //获取老师信息
                Element teacher = (Element)classEle.getElementsByTagName("teacher").item(0);
                String teacherID = teacher.getAttribute("id");
                String teacherName = teacher.getAttribute("name");
                Element subjectEle = (Element)teacher.getElementsByTagName("subject").item(0);
                String subject = subjectEle.getTextContent();
                System.out.println("\t\t"+teacherID+"---"+teacherName+"---"+subject);
                //获取学生信息
                NodeList studentList = classEle.getElementsByTagName("student");
                for(int j = 0;j < studentList.getLength();j++){
                    Element studentEle = (Element)studentList.item(j);
                    String studentID = studentEle.getAttribute("id");
                    String studentName = studentEle.getAttribute("name");
                    Element sexEle = (Element)studentEle.getElementsByTagName("sex").item(0);
                    String sex = sexEle.getTextContent();
                    System.out.println("\t\t"+studentID+"---"+studentName+"---"+sex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
