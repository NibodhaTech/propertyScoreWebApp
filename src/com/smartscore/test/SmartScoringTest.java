package com.smartscore.test;

import java.util.Set;

import com.smartscore.inter.ScreenScrapInterface;
import com.smartscore.modal.Amenity;
import com.smartscore.pms.ScreenScrapingFlipKey;

/**
 * @author MohanRaj
 *
 */
public class SmartScoringTest {

    public static void main(String[] args) {
        String url ="https://www.flipkey.com/plai-laem-condo-rentals/p1067902/";
        ScreenScrapInterface  screenScrapInterface = new ScreenScrapingFlipKey();
        Set<Amenity> amenities=  screenScrapInterface.getFlipKeyAmenities(url);
        System.out.println(amenities);
    }

}
