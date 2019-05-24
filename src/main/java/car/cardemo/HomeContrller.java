package car.cardemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class HomeContrller {
    @Autowired CarRepository carRepository;

    @Autowired CatagoryRepository catagoryRepository;

    @RequestMapping("/")
    public String listcar(Model model){
        model.addAttribute("cars",carRepository.findAll());
        return "list";

    }
    @GetMapping("/add")
    public String courseForm(Model model){
        model.addAttribute("car",new Car());
        return "carform";
    }
    @PostMapping("/process")

    public String processForm(@Valid Car car, BindingResult result){
        if(result.hasErrors()){
            return "carform";
        }
        carRepository.save(car);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car",carRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car",carRepository.findById(id).get());
        return "carform";
    }
    @RequestMapping("/delete/{id}")

    public String deleteCar(@PathVariable("id") long id){
        carRepository.deleteById(id);
        return "redirect:/";
    }




    @RequestMapping("/home")
    public String listcategory(Model model){
        model.addAttribute("category",catagoryRepository.findAll());
        return "lists";

    }
    @GetMapping("/addcategory")
    public String categoryForm(Model model){
        model.addAttribute("category",new Catagory());
        return "categoryform";
    }
    @PostMapping("/process's")

    public String processcategoryForm(@Valid Catagory catagory, BindingResult result){
        if(result.hasErrors()){
            return "categoryform";
        }
        catagoryRepository.save(catagory);
        return "redirect:/home";
    }

    @PostMapping("/add")

    public String processActor(@ModelAttribute Car car, @RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {

            return "redirect:/add";

        }
        return "redirect:/";

    }
}
