package com.breedingjournal.controllers;


import com.breedingjournal.domain.Copulation;
import com.breedingjournal.form.CopulationForm;
import com.breedingjournal.repositories.CocoonRepository;
import com.breedingjournal.repositories.CopulationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by AN-KOP on 2016-11-19.
 */
@Controller
public class CopulationController {

    private static final Logger logger = LogManager.getLogger("journal");


    @Autowired
    private CopulationRepository copulationRepository;
    @Autowired
    private CocoonRepository cocoonRepository;


//    String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName();

    public String printUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        return name;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(CopulationForm copulationForm, Model model) {
        return "addcopulation";
    }

    @RequestMapping(value = "/sukces", method = RequestMethod.GET)
    public String indexi(Model model) {
        return "sukces";
    }


    @RequestMapping(value = "/addcopulation", method = RequestMethod.GET)
    public String addCopulation(CopulationForm copulationForm) {
        return "addcopulation";
    }

    @RequestMapping(value = "/addcopulation", method = RequestMethod.POST)
    public String addNewCopulation(@Valid CopulationForm copulationForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addcopulation";
        }


        copulationRepository.save(new Copulation(copulationForm.getCopulationDate(),
                                               copulationForm.getFemaleNumber(),
                                               copulationForm.getMaleNumber()));
        logger.info("Copulation SAVED by:" +printUser() + ", date="+copulationForm.getCopulationDate()+", female="+copulationForm.getFemaleNumber()+ ", male="+copulationForm.getMaleNumber());
        return "redirect:/copulationlist";
    }
    @RequestMapping(value = "/copulationlist", method = RequestMethod.GET)
    public String showAllKopulacja(Model model) {
        model.addAttribute("copulations", copulationRepository.findAll());
        return "copulationlist";

    }

    @RequestMapping(value = "/copulationlist/delete/{id}", method = RequestMethod.POST)
    public String deleteCopulation(@PathVariable("id") Long id) {
//        cocoonRepository.delete(cocoonRepository.findByCopulationId(id));
        copulationRepository.delete(id);

        logger.info("Copulation DELETE by:" +printUser() + ", id=" + id);

        return "redirect:/copulationlist";

    }



    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

}
