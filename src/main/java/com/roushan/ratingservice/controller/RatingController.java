package com.roushan.ratingservice.controller;

import com.roushan.ratingservice.entities.Rating;
import com.roushan.ratingservice.service.RatingService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody  Rating rating) {
        Rating savedRating = ratingService.createRating(rating);
        return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("userId") String userId) {
        List<Rating> ratingList = this.ratingService.getRatingsByUserId(userId);
        return new ResponseEntity<>(ratingList, HttpStatus.OK);
    }

    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable("hotelId") String hotelId) {
        List<Rating> ratingList = this.ratingService.getRatingsByHotelId(hotelId);
        return new ResponseEntity<>(ratingList, HttpStatus.OK);
    }
}
