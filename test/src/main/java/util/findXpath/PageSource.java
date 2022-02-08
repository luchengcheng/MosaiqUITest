package util.findXpath;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PageSource {
   public  ArrayList<String> xpathNameList=new ArrayList<String>();
    public  ArrayList<String> xpathAutomationIdList=new ArrayList<String>();
    /*
    1. this method is to  generate xml file for current page source.
     */
        public static String getXMLFile(String pageSource){
            FileOutputStream out= null;
            String filePath = "./Data/PageSource/"+System.currentTimeMillis()+".xml";
            try {
                File currentPageSource = new File(filePath);
                currentPageSource.createNewFile(); // if file already exists will do nothing
                out = new FileOutputStream(filePath);
                out.write(pageSource.getBytes());
                out.close();
                if(currentPageSource.exists())
                    return currentPageSource.getAbsolutePath();
                else
                    return "Can not find page source file";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "exception found when generate page source xml";
        }

    public  void getXpathNameList( String pageSource) {
        String filePath = getXMLFile(pageSource);
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        try{
            FileInputStream in = new FileInputStream(filePath);
            Reader read = new InputStreamReader(in, "GBK");
            Document document = reader.read(read);
            //获取根节点元素对象
            Element root = document.getRootElement();
            //遍历
            listNodesName(root,  "");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void getXpathAutomationIdList( String pageSource) {
        String filePath = getXMLFile(pageSource);

        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        try{
            FileInputStream in = new FileInputStream(filePath);
            Reader read = new InputStreamReader(in, "GBK");
            Document document = reader.read(read);
            //获取根节点元素对象
            Element root = document.getRootElement();
            //遍历
            listNodesAutomationId(root,  "");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void listNodesName(Element node,  String xpath){
        List<Attribute> list = node.attributes();
//        System.out.println("当前属性:"+node.getName());

        if( node.attribute("Name")==null|| node.attribute("Name").getValue().equalsIgnoreCase(""))
            xpath =xpath+"/"+node.getName()+"[@"+node.attribute("ClassName").getName()+"=\""+node.attribute("ClassName").getValue()+"\"]";
        else
            xpath =xpath+"/"+node.getName()+"[@"+node.attribute("ClassName").getName()+"=\""+node.attribute("ClassName").getValue()+"\"]"+"[@"+node.attribute("Name").getName()+"=\""+node.attribute("Name").getValue()+"\"]";
        //同时迭代当前节点下面的所有子节点
        //使用递归
//        System.out.println("当前属性:"+xpath);
        xpathNameList.add(xpath);
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            listNodesName(e,  xpath);
        }
    }

    public  void listNodesAutomationId(Element node,  String xpath){
        List<Attribute> list = node.attributes();
//        System.out.println("当前属性:"+node.getName());

        if( node.attribute("AutomationId")==null|| node.attribute("AutomationId").getValue().equalsIgnoreCase(""))
            xpath =xpath+"/"+node.getName()+"[@"+node.attribute("ClassName").getName()+"=\""+node.attribute("ClassName").getValue()+"\"]";
        else
            xpath =xpath+"/"+node.getName()+"[@"+node.attribute("ClassName").getName()+"=\""+node.attribute("ClassName").getValue()+"\"]"+"[@"+node.attribute("AutomationId").getName()+"=\""+node.attribute("AutomationId").getValue()+"\"]";
        //同时迭代当前节点下面的所有子节点
        //使用递归
//        System.out.println("当前属性:"+xpath);
        xpathAutomationIdList.add(xpath);
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            listNodesAutomationId(e,  xpath);
        }
    }

    public String getXpathByName(String name){
            for(int i=0;i<xpathNameList.size();i++){
                if(xpathNameList.get(i).contains(name))
                    return xpathNameList.get(i);
            }
            return "can not find xpath";

    }

    public String getXpathByNameAndAttribution(String name, String attribution){
        for(int i=0;i<xpathNameList.size();i++){
            if(xpathNameList.get(i).contains(name) && xpathNameList.get(i).contains(attribution) )
                return xpathNameList.get(i);
        }
        return "can not find xpath";

    }

    public String getXpathByAutomationIdAndAttribution(String name, String attribution){
        for(int i=0;i<xpathAutomationIdList.size();i++){
            if(xpathAutomationIdList.get(i).contains(name) && xpathAutomationIdList.get(i).contains(attribution) )
                return xpathAutomationIdList.get(i);
        }
        return "can not find xpath";

    }

    public String getXpathByNameAndAttributionOnLastOne(String name, String attribution){
        for(int i=0;i<xpathNameList.size();i++){
            if(xpathNameList.get(i).contains(name)){
                System.out.println("go to check");
                if((xpathNameList.get(i).length() - xpathNameList.get(i).indexOf(name))==name.length() && xpathNameList.get(i).contains(attribution) ){
                    return xpathNameList.get(i);
                }
            }

        }
        return "can not find xpath";

    }

    public String getXpathByAutomationId(String automationId){
        for(int i=0;i<xpathAutomationIdList.size();i++){
            if(xpathAutomationIdList.get(i).contains(automationId))
                return xpathAutomationIdList.get(i);
        }
        return "can not find xpath";
    }

    public Boolean findWindowHandle(String windowName, String pageSource){
        String filePath = getXMLFile(pageSource);

        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //读取文件 转换成Document
        try{
            FileInputStream in = new FileInputStream(filePath);
            Reader read = new InputStreamReader(in, "GBK");
            Document document = reader.read(read);
            //获取根节点元素对象
            Element root = document.getRootElement();
            if(root.attribute("Name")!=null && root.attribute("Name").getValue().equalsIgnoreCase(windowName))
                return true;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }






}
