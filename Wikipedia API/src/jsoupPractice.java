import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoupPractice {
              public static void main(String[] args) throws IOException{
                             
                             
//                         Document doc = Jsoup.connect(https://www.wikipedia.org/wiki/Elon_Musk).get();
                             
//                         String title = doc.title();
//                         System.out.println(title);
                             
                             
//                         Elements table = doc.getElementsByAttributeValueMatching("style", "width:22em");
//                         Elements table = doc.select("body, table");
//
//                         String summary = table.text();
                             
                             
//                         Elements table = doc.getElementsByAttributeValueMatching("style", "width:22em").select("td");                      
//                         Elements titles = doc.getElementsByAttributeValueMatching("scope", "row").select("th");
                             
                             
                             
//                         
//                         Elements info = doc.select("th:contains(Born)");               
//                         Elements infoContent = doc.select("th:contains(Born) + td");
//                         
//                         String summary = "";
//                         
//                         for (int i = 0; i < table.size() - 3; i++) {
//                                        summary += titles.get(i).text() + ": " + table.get(i + 3).text() + "\n";
//                         }
//                         System.out.println(summary);

//                         System.out.println(info.text());
//                         System.out.println(infoContent.text());
                             try {
//                                        System.out.println(getBorn());
                                           Document doc = Jsoup.connect("https://www.wikipedia.org/wiki/Elon_Musk").get();
                                           Elements keywords = doc.select("table[] > th");
                                           System.out.println(getInfo("Date"));
                                           System.out.println(getInfo("Location"));
                                           System.out.println(getInfo("Result"));
                             }
                             catch(Exception e) {
                                           System.out.println(e.getMessage());
                             }
                             
              }
              
              public static String getBorn() throws Exception {
                             String born = "";
                             Document doc;
                             try {
                                           doc = Jsoup.connect("https://www.wikipedia.org/wiki/").get();                
                                           Elements date_loc = doc.select("th:contains(Born) + td");
                                           born = date_loc.text();
                                           if (born.equals("")) {
                                                          throw new Exception ("There is no available birthdate for this query.");
                                           }
                             } catch (IOException e) {
                                           // TODO Auto-generated catch block
                                           e.printStackTrace();
                             }
                             return born;
              }
              
              public static String getInfo(String key) throws IOException {
                                           String format = "th:contains(" + key + ") + td";
                                           Document doc = Jsoup.connect("https://www.wikipedia.org/wiki/Battle_of_Hastings").get();                             
                                           Elements info = doc.select(format);
                                           return info.text();

              }
              public static String getSection(String key) {
            	  Do
            	  return "";
              }
}
