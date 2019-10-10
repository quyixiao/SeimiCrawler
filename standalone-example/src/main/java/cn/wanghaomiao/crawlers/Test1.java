package cn.wanghaomiao.crawlers;

import org.apache.commons.lang3.StringUtils;
import org.seimicrawler.xpath.JXDocument;

import java.util.List;

public class Test1 {

    public static void main(String[] args) throws Exception {
        String content = HttpUtils.get("https://www.baidu.com");

        JXDocument doc = JXDocument.create(content);



        try {
            List<Object> objects = doc.sel("//div[@class='s_form_wrapper']//div/img/@hidefocus");
            for(Object o:objects){
                System.out.println(o);
                System.out.println("============================");
            }


            List<Object> objects1 = doc.sel("//*[contains(@name,'tj_trnews')]");
            for(Object o:objects1){
                System.out.println(o);
                System.out.println("============================");
            }


            List<Object> objects2 = doc.sel("//div[@class='s_form_wrapper']//div/form/input[position()<3]");
            for(Object o:objects2){
                System.out.println(o);
                System.out.println("============================");
            }



        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
