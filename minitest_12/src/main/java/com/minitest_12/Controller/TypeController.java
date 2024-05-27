package com.minitest_12.Controller;

import com.minitest_12.model.Computer;
import com.minitest_12.model.TypeComputer;
import com.minitest_12.service.computer.IComputerService;
import com.minitest_12.service.type_computer.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @Autowired
    private IComputerService computerService;

    @GetMapping("/types")
    public ModelAndView listTypes() {
        Iterable<TypeComputer> typeComputers = typeService.getAll();
        ModelAndView mav = new ModelAndView("/type_view/list");
        mav.addObject("types", typeComputers);
        return mav;
    }

    @GetMapping("/create-type")
    public ModelAndView createTypeForm() {
        ModelAndView mav = new ModelAndView("/type_view/create");
        mav.addObject("type", new TypeComputer());
        return mav;
    }

    @PostMapping("/create")
    public String createType(@ModelAttribute("type") TypeComputer typeComputer, RedirectAttributes redirectAttributes) {
        typeService.save(typeComputer);
        redirectAttributes.addFlashAttribute("message", "New Type Created Successfully");
        return "redirect:/types";
    }

    @GetMapping("/update-type/{id}")
    public ModelAndView updateTypeForm(@PathVariable Long id) {
        Optional<TypeComputer> typeComputer = typeService.getById(id);
        if (typeComputer.isPresent()) {
            ModelAndView mav = new ModelAndView("/type_view/update");
            mav.addObject("type", typeComputer.get());
            return mav;
        } else {
            return new ModelAndView("/another_view/error");
        }
    }

    @PostMapping("/update/{id}")
    public String updateType(@ModelAttribute("type") TypeComputer typeComputer, RedirectAttributes redirectAttributes) {
        typeService.save(typeComputer);
        redirectAttributes.addFlashAttribute("message", "Type Updated Successfully");
        return "redirect:/types";
    }

    @GetMapping("/view-type/{id}")
    public ModelAndView viewType(@PathVariable("id") Long id) {
        Optional<TypeComputer> typeComputer = typeService.getById(id);
        if (!typeComputer.isPresent()) {
            return new ModelAndView("/another_view/error");
        } else {
            Iterable<Computer> computers = computerService.findAllByType(typeComputer.get());
            ModelAndView mav = new ModelAndView("/computer_view/list");
            mav.addObject("computerPage", computers);
            return mav;
        }
    }

    @GetMapping("/delete-type/{id}")
    public String deleteType(@PathVariable("id") Long id) {
        typeService.delete(id);
        return "redirect:/types";
    }
}
