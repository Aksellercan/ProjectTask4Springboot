package com.example.ProjectTask4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.ArrayList;
import java.util.List;

//all CRUD operations
@Controller
@RequestMapping(path = "/smartphones")
public class MainController {
    @Autowired
    private SmartphoneRepository smartphoneRepository;
    //private OperatingSystemRepository operatingSystemRepository;

    //Add a new smartphone
    @PostMapping(path = "/add")
    public String addNewSmartphone(@RequestParam String name, @RequestParam int ram, @RequestParam double processorspeed,
      @RequestParam int batterysize, @RequestParam double screensize, @RequestParam int storage, @RequestParam OperatingSystem operatingsystem) {
        Smartphone smartphone = new Smartphone();
        smartphone.setName(name);
        smartphone.setRam(ram);
        smartphone.setProcessorspeed(processorspeed);
        smartphone.setBatterysize(batterysize);
        smartphone.setScreensize(screensize);
        smartphone.setStorage(storage);
        smartphone.setOperatingSystem(operatingsystem);
        smartphoneRepository.save(smartphone);
        //return "Saved " + smartphone.getName() ;
        return "redirect:/";
    }

    //Remove selected smartphone from database

    @PostMapping(path = "/remove")
    public String removeSmartphone(@RequestParam long id, RedirectAttributes redirectAttributes) {
        if (smartphoneRepository.existsById(id)) {
            String deletedName = smartphoneRepository.findById(id).get().getName();
            smartphoneRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Deleted " + deletedName);
        } else {
            redirectAttributes.addFlashAttribute("message", "Smartphone with ID " + id + " not found.");
        }
        return "redirect:/smartphones/remove";
    }

    //Display all smartphones in database in JSON format
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<SmartphoneDTO> getAll() {
        Iterable<Smartphone> smartphones = smartphoneRepository.findAll();
        List<SmartphoneDTO> smartphonesdto = new ArrayList<>();
        for (Smartphone smartphone : smartphones) {
            smartphonesdto.add(new SmartphoneDTO(smartphone));
        }
        return smartphonesdto;
    }

    //DONE TODO add update function

    //Update details of selected smartphone from the database
    @PostMapping(path = "/update")
    public @ResponseBody String updateSmartphone(@RequestParam long id, @RequestParam String name ,@RequestParam int ram, @RequestParam double processorspeed,
      @RequestParam int batterysize, @RequestParam double screensize, @RequestParam int storage, @RequestParam OperatingSystem operatingsystem) {
        Smartphone smartphone = smartphoneRepository.findById(id).get();
        smartphone.setName(name);
        smartphone.setRam(ram);
        smartphone.setProcessorspeed(processorspeed);
        smartphone.setBatterysize(batterysize);
        smartphone.setScreensize(screensize);
        smartphone.setStorage(storage);
        smartphone.setOperatingSystem(operatingsystem);
        return smartphoneRepository.save(smartphone).getName();
    }

    //Get phones by ID
    @GetMapping
    public @ResponseBody Smartphone getSmartphones(@RequestParam long id) {
        Smartphone smartphone = smartphoneRepository.findById(id).get();
        return smartphone;
    }

    //Update phone details page
    @GetMapping(path = "/smartphoneupdate")
    public String smartphoneupdate() {
        return "smartphoneupdate";
    }

    //Remove phones page
    @GetMapping(path = "/remove")
    public String removeSmartphonePage(Model model) {
        List<Smartphone> smartphones = (List<Smartphone>) smartphoneRepository.findAll();
        model.addAttribute("smartphones", smartphones);
        return "removeSmartphone";
    }

    //Add phones page
    @GetMapping(path = "/add")
    public String addSmartphonePage() {
        return "addphone";
    }

    @GetMapping(path = "/list")
    public String listSmartphones(Model model) {
        List<Smartphone> smartphones = (List<Smartphone>) smartphoneRepository.findAll();
        model.addAttribute("smartphones", smartphones);
        return "listSmartphones"; // Name of the Thymeleaf template
    }

}