package com.breedingjournal.controllers;

import com.breedingjournal.domain.Cocoon;
import com.breedingjournal.form.CocoonForm;
import com.breedingjournal.repositories.CocoonRepository;
import com.breedingjournal.repositories.CopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class CocoonController {
    @Autowired
    private CopulationRepository copulationRepository;
    @Autowired
    private CocoonRepository cocoonRepository;

    @RequestMapping(value= "/addcocoon/{id}", method= RequestMethod.GET)
    public String addKokon(CocoonForm cocoonForm, @PathVariable("id") Long id, Model model) {
        model.addAttribute("copulation", copulationRepository.findOne(id));
        return "addcocoon";
    }

    @RequestMapping(value = "/addcocoon/{id}", method = RequestMethod.POST)
    public String addNewKokon(@Valid CocoonForm cocoonForm, @PathVariable("id") Long id, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/addcocoon";
        }


        cocoonRepository.save(new Cocoon( copulationRepository.findOne(id),
                                        cocoonForm.getCocoonNumber(),
                                        cocoonForm.getCocoonPlaceDate(),
                                        cocoonForm.getCocoonHatchDate(),
                                        cocoonForm.getCocoonTransferDate(),
                                        cocoonForm.getComments()));


        return "redirect:/cocoonlist";
    }

    @RequestMapping(value = "/cocoonlist/{id}", method = RequestMethod.GET)
    public String showKokonById (@PathVariable("id") Long id, Model model) {
        model.addAttribute("cocoons", cocoonRepository.findByCopulationId(id));
        return "cocoondetails";

    }

    @RequestMapping(value = "/cocoonlist", method = RequestMethod.GET)
    public String showAllCocoons(Model model) {
        model.addAttribute("cocoons", cocoonRepository.findAll());
        return "cocoonlist";

    }

}
