package car.cardemo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeContrller {
    @Autowired CarRepository carRepository;
    @Autowired CloudinaryConfig cloudc;

    @Autowired CatagoryRepository catagoryRepository;

    @RequestMapping("/")
    public String listcar(Model model){
        model.addAttribute("cars",carRepository.findAll());
        return "list";

    }
    @GetMapping("/add")
    public String carForm(Model model){
        model.addAttribute("car",new Car());
        return "carform";
    }
    @PostMapping("/process")

    public String processActor(@ModelAttribute Car car, @RequestParam("file") MultipartFile file){

        carRepository.save(car);


            if(file.isEmpty()){
                return "redirect:/add";
                }
            try{
                Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype","auto"));
                car.setHeadshot(uploadResult.get("url").toString());
                carRepository.save(car);
            }catch (IOException e){
                e.printStackTrace();
                return "redirect:/add";
            }

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
        model.addAttribute("categorys",catagoryRepository.findAll());
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





}
