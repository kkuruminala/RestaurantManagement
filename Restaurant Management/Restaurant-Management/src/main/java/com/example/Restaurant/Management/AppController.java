package com.example.Restaurant.Management;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @Autowired
    private R_service service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Restaurant> listRestaurant = service.listAll();
        model.addAttribute("listRestaurant", listRestaurant);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewRestaurantPage(Model model) {
        Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurant", restaurant);

        return "new_restaurant";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
        service.save(restaurant);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditRestaurantPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_restaurant");

        Restaurant restaurant = service.get(id);
        mav.addObject("restaurant", restaurant);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}