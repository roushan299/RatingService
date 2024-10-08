package com.roushan.ratingservice.service;

import com.roushan.ratingservice.communicator.HotelServiceCommunicator;
import com.roushan.ratingservice.entities.Hotel;
import com.roushan.ratingservice.entities.Rating;
import com.roushan.ratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private HotelServiceCommunicator hotelServiceCommunicator;

    @Override
    public Rating createRating(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        List<Rating> ratingList = this.ratingRepository.findAll();
        for (Rating rating : ratingList) {
            Hotel hotel = this.hotelServiceCommunicator.getHotelById(rating.getHotelId());
        }
        return ratingList;
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return this.ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return this.ratingRepository.findByHotelId(hotelId);
    }
}
