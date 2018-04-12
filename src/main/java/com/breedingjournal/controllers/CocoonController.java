package com.breedingjournal.controllers;

import com.breedingjournal.WebSecurityConfig;
import com.breedingjournal.domain.Cocoon;
import com.breedingjournal.form.CocoonForm;
import com.breedingjournal.repositories.CocoonRepository;
import com.breedingjournal.repositories.CopulationRepository;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class CocoonController {
    /**
     *
     */
    @Autowired
    private CopulationRepository copulationRepository;
    @Autowired
    private CocoonRepository cocoonRepository;

    private static final Logger logger = LogManager.getLogger("CocoonController");

    @RequestMapping(value = "/addcocoon/{id}", method = RequestMethod.GET)
    public String addKokon(CocoonForm cocoonForm, @PathVariable("id") Long id, Model model) {
        model.addAttribute("copulation", copulationRepository.findOne(id));

        return "addcocoon";
    }

    @RequestMapping(value = "/addcocoon/{id}", method = RequestMethod.POST)
    public String addNewKokon(@Valid CocoonForm cocoonForm, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("copulation", copulationRepository.findOne(id));

            return "addcocoon";
        }


        cocoonRepository.save(new Cocoon(copulationRepository.findOne(id),
                cocoonForm.getCocoonNumber(),
                cocoonForm.getCocoonPlaceDate(),
                cocoonForm.getCocoonHatchDate(),
                cocoonForm.getCocoonTransferDate(),
                cocoonForm.getComments()));

        logger.info("dodano kokon");
        return "redirect:/cocoonlist";
    }

    @RequestMapping(value = "/editcocoon/{id}", method = RequestMethod.GET)

    public String showKokonById(CocoonForm cocoonForm, @PathVariable("id") Long id, Model model) {
        Cocoon cocoon = cocoonRepository.findOne(id);
        model.addAttribute("cocoons", cocoonRepository.findOne(id));
        model.addAttribute("copulation", copulationRepository.findById(cocoon.getCopulation().getId()));

        return "editcocoon";

    }


    @RequestMapping(value = "/editcocoon/{id}", method = RequestMethod.POST)
    public String editKokon(@Valid CocoonForm cocoonForm, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        Cocoon cocoon = cocoonRepository.findOne(id);
        if (bindingResult.hasErrors()) {

            model.addAttribute("copulation", copulationRepository.findOne(id));
            model.addAttribute("copulation", copulationRepository.findById(cocoon.getCopulation().getId()));
            return "editcocoon";
        }


        cocoon.setCocoonNumber(cocoonForm.getCocoonNumber());
        cocoon.setCocoonPlaceDate(cocoonForm.getCocoonPlaceDate());
        cocoon.setCocoonHatchDate(cocoonForm.getCocoonHatchDate());
        cocoon.setCocoonTransferDate(cocoonForm.getCocoonTransferDate());
        cocoon.setComments(cocoonForm.getComments());
        cocoonRepository.save(cocoon);

        logger.info("zmieniono kokon nr: " + cocoon.getCocoonNumber());
        return "redirect:/cocoonlist";
    }


    @RequestMapping(value = "/editcocoon/delete/{id}", method = RequestMethod.POST)

    public String delete(@PathVariable("id") Long id) {

        Cocoon cocoon = cocoonRepository.findOne(id);
        cocoon.setCopulation(null);


        cocoonRepository.delete(id);
        logger.info("usunieto kokon : " + id);
        return "redirect:/cocoonlist";
    }


    @RequestMapping(value = "/cocoonlist", method = RequestMethod.GET)
    public String showAllCocoons(Model model) {
        model.addAttribute("cocoons", cocoonRepository.findAll());
        return "cocoonlist";

    }

}
