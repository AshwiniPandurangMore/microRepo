package com.micro.demoMicroWithMVR.controller;

import com.micro.demoMicroWithMVR.model.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/user")
public class UserController {
    public static void main(String[] args) {
        String filePath = "info.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("Records");
            // now XML is loaded as Document in memory, lets convert it to Object List
            List<User> userList = new ArrayList<User>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                userList.add(getUser(nodeList.item(i)));
            }
            // lets print User list information
            for (User emp : userList) {
                System.out.println(emp.toString());
                //PrintWriter printWriter = new PrintWriter("output.txt", "UTF-8");
               // printWriter.write(userList.toString());

               // printWriter.close();
                /* ...........*/

                /*................. */
            }
        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }

    }

    private static User getUser(Node node) {
        User user = new User();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;

            user.setUserid(Long.parseLong(getTagValue("userid",element)));
            user.setName(getTagValue("name",element));
            user.setDob(getTagValue(" dob",element));
            user.setHt(getTagValue("ht", element));
            user.setWt(getTagValue("wt",element));
            user.setGender(getTagValue("gender",element));
            user.setGender(getTagValue("gender",element));
            user.setPostal_code(Integer.parseInt(getTagValue("postal_code", element)));

        }
        return user;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }


}
