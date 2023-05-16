package com.example.demo.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;


@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(Integer id) {
        return hotelRepository.findById(id);
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Integer id) {
        hotelRepository.deleteById(id);
    }

    public List<Hotel> getAllHotels(Integer stars, Double minDailyRate) {
        Stream<Hotel> hotelStream = hotelRepository.findAll().stream();
    
        if (stars != null) {
            hotelStream = hotelStream.filter(hotel -> hotel.getStars().equals(stars));
        }
    
        if (minDailyRate != null) {
            hotelStream = hotelStream.filter(hotel -> hotel.getDailyRate() >= minDailyRate);
        }
    
        return hotelStream.collect(Collectors.toList());
    }
}
