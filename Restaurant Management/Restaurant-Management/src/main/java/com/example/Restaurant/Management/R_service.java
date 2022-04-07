package com.example.Restaurant.Management;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional

public class R_service {
    @Autowired
    private RestaurantRepository repo;
    public List<Restaurant> listAll() {
        return repo.findAll();
    }

    public void save(Restaurant restaurant) {
        repo.save( restaurant);
    }

    public Restaurant get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}