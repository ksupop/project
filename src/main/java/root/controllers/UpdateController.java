package root.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import root.domain.ListEntity;
import root.da.ListRepository;

import java.util.Optional;


@Controller
public class UpdateController {
    @Autowired
    private ListRepository listRepository;

    @GetMapping(value = {"/index/{id}/change"})
    public String upListForm(Model model, @PathVariable long id) {
        ListEntity list = listRepository.findById(id);
        model.addAttribute("list", list);
        return "/change";
    }
    @RequestMapping(value = {"/index/{id}/change"}, method = {RequestMethod.POST})
    public String upListSubmit(Model model, @PathVariable long id,
                               @ModelAttribute("list") ListEntity list) {
        ListEntity listToUpdate = listRepository.findById(id);
        listToUpdate.setName(list.getName());
        listRepository.save(listToUpdate);

        return "redirect:/index/" + id;
    }


}