package parsexml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class DOM4J {
    public static void main(String[] args){
        try {
            //1.
            SAXReader reader = new SAXReader();
            //2.
            File file = new File("src/myxml/school.xml");
            Document document = reader.read(file);

            //
            Element school = document.getRootElement();
            String schoolID = school.attributeValue("id");
            String schoolName = school.attributeValue("name");
            String schoolLOC = school.attributeValue("loc");
            System.out.println(schoolID+"--"+schoolName+"--"+schoolLOC);

            //  获取学校里的班级信息
            List<Element> classList = school.elements("class");
            for(Element classEle:classList){
                String classID = classEle.attributeValue("id");
                String className = classEle.attributeValue("name");
                String classLOC = classEle.attributeValue("loc");
                System.out.println("\t"+classID+"---"+className+"---"+classLOC);
                //获取老师信息
                Element teacher = classEle.element("teacher");
                String teacherID = teacher.attributeValue("id");
                String teacherName = teacher.attributeValue("name");
                String subject = teacher.elementText("subject");
                System.out.println("\t\t"+teacherID+"---"+teacherName+"---"+subject);
                //获取学生信息
                List<Element> studentList = classEle.elements("student");
                for(Element studentEle:studentList){
                    String studentID = studentEle.attributeValue("id");
                    String studentName = studentEle.attributeValue("name");
                    String sex = studentEle.elementText("sex");
                    System.out.println("\t\t"+studentID+"---"+studentName+"---"+sex);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
