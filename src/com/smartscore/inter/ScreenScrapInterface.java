package com.smartscore.inter;

import java.util.Set;

import com.smartscore.modal.Amenity;

/**
 * @author MohanRaj
 *
 */
public interface ScreenScrapInterface {

    public Set<Amenity> getFlipKeyAmenities(String url);
}
