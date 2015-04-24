package com.smartscore.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.smartscore.inter.ScreenScrapInterface;
import com.smartscore.modal.Amenity;

/**
 * @author MohanRaj
 *
 */
public class ScreenScrapingFlipKey implements ScreenScrapInterface {

  //  public static String url ="https://www.flipkey.com/plai-laem-condo-rentals/p1067902/";
   static String result = "";
  
    public Set<Amenity> getFlipKeyAmenities(String url) {
        //System.out.println(download(url));
        
        download(url);
        String text = result;

        List<String> tokens = new ArrayList<String>();
        tokens.add("Washing Machine");
        tokens.add("Towels Provided");  
        tokens.add("Linens Provided");
        tokens.add("A/C or climate control"); 
        tokens.add("Fitness Room"); 
        tokens.add("Shared outdoor pool"); 
        tokens.add("Elevator access"); 
        tokens.add("Parking"); 
        tokens.add("Microwave"); 
        tokens.add("Kettle"); 
        tokens.add("Kitchen"); 
        tokens.add("Refrigerator"); 
        tokens.add("Freezer"); 
        tokens.add("Toaster"); 
        tokens.add("Pool Table"); 
        tokens.add("Television"); 
        tokens.add("Balcony or terrace"); 
        tokens.add("Garden"); 
        tokens.add("Dining chairs"); 
        tokens.add("Lounge chairs"); 
        tokens.add("Pet friendly - no"); 
        tokens.add("Smoking allowed - no"); 
        tokens.add("Suitable for children - yes"); 
        tokens.add("Suitable for the elderly - elevator access"); 
        tokens.add("Wheelchair accessible - ask"); 
        tokens.add("Grill"); 
        tokens.add("Suitable for children - over five"); 
        tokens.add("Suitable for the elderly - no"); 
        tokens.add("Wheelchair accessible - no"); 
        tokens.add("High chair"); 
        tokens.add("Internet Access"); 
        tokens.add("Wireless Internet");
        tokens.add("Clothes Dryer"); 
        tokens.add("Stove or Oven"); 
        tokens.add("Blender"); 
        tokens.add("Satellite or cable TV"); 
        tokens.add("DVD Player"); 
        tokens.add("Smoking allowed - yes"); 
        tokens.add("Suitable for children - yes"); 
        tokens.add("Short breaks allowed (1-4 days)"); 
        tokens.add("Soap/Shampoo Provided"); 
        tokens.add("Hair dryer"); 
        tokens.add("Corporate bookings allowed"); 
        tokens.add("Alarm Clock"); 
        tokens.add("Central heating"); 
        tokens.add("Telephone"); 
        tokens.add("Dishwasher"); 
        tokens.add("Pet friendly - ask"); 
        tokens.add("Iron"); 
        tokens.add("Safe"); 
        tokens.add("Ocean or water views"); 
        tokens.add("Outdoor Dining Area"); 
        tokens.add("Suitable for children - ask"); 
       
        String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        HashSet<Amenity> amenities=new HashSet<Amenity>();  
        while (matcher.find()) {
            amenities.add(new Amenity(matcher.group(1)));
            //System.out.println(matcher.group(1));
        }
//        Iterator<String> itr=al.iterator();  
//        while(itr.hasNext()){  
//         System.out.println(itr.next());  
//        } 
        return amenities;
    }

    static String download(String urlToRead) {
        java.net.CookieManager cm = new java.net.CookieManager();
        java.net.CookieHandler.setDefault(cm);
       
        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Cookie", "onlineCampusSelection=C");

            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result += line + "\n";
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
