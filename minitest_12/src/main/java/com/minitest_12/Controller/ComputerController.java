package com.minitest_12.Controller;

import com.minitest_12.model.Computer;
import com.minitest_12.model.TypeComputer;
import com.minitest_12.service.computer.IComputerService;
import com.minitest_12.service.type_computer.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private IComputerService computerService;

    @Autowired
    private ITypeService typeService;


    @ModelAttribute("types")
    public Iterable<TypeComputer> listTypes() {
        return typeService.getAll();
    }


    @GetMapping
    public ModelAndView listComputer(@PageableDefault(size = 3) Pageable pageable) {
        Page<Computer> computers = computerService.findAll(pageable);
        ModelAndView mav = new ModelAndView("/computer_view/list");
        mav.addObject("computers", computers);
        return mav;
    }

    @GetMapping("/search")
    public ModelAndView searchComputer(@RequestParam("search") Optional<String> search, Pageable pageable) {
        Page<Computer> computers;
        if (search.isPresent()) {
            computers = computerService.findAllByCodeContaining(search.get(), pageable);
        } else {
            computers = computerService.findAll(pageable);
        }
        ModelAndView mav = new ModelAndView("/computer_view/search_results");
        mav.addObject("computers", computers);
        return mav;
    }

    @GetMapping("/create-computer")
    public ModelAndView createComputerForm() {
        ModelAndView mav = new ModelAndView("/computer_view/create");
        mav.addObject("computer", new Computer());
        return mav;
    }

    @PostMapping("/save-computer")
    public String createComputer(@ModelAttribute("computer") @Validated Computer computer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/computer_view/create";
        }
        computerService.save(computer);
        redirectAttributes.addFlashAttribute("message", "Computer Created Successfully");
        return "redirect:/computers";
    }

    @GetMapping("/update-computer/{id}")
    public ModelAndView updateComputerForm(@PathVariable Long id) {
        Optional<Computer> computer = computerService.getById(id);
        if (computer.isPresent()) {
            ModelAndView mav = new ModelAndView("/computer_view/update");
            mav.addObject("computer", computer.get());
            return mav;
        } else {
            return new ModelAndView("/another_view/error");
        }
    }

    @PostMapping("/update-computer/{id}")
    public String updateComputer(@ModelAttribute("computer") @Validated Computer computer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/computer_view/update";
        }
        computerService.save(computer);
        redirectAttributes.addFlashAttribute("message", "Computer Updated Successfully");
        return "redirect:/computers";
    }

    @GetMapping("/delete/{id}")
    public String deleteComputer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        computerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Computer Deleted Successfully");
        return "redirect:/computers";
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandlerFoundException(NoHandlerFoundException e) {
        ModelAndView mav = new ModelAndView("/another_view/error");
        mav.addObject("errorMessage", "This URL was not found on this server");
        return mav;
    }

}
