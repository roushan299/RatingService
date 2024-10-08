package com.roushan.ratingservice.communicator;

import com.roushan.ratingservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE", url = "http://HOTELSERVICE/hotel")
public interface HotelServiceCommunicator {

    @GetMapping("/{hotelId}")
    Hotel getHotelById(@PathVariable("hotelId") String hotelId);

}
