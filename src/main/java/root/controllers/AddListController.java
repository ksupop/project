package root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import root.da.ListRepository;
import root.domain.ListEntity;

@Controller
public class AddListController {
    @Autowired
    private ListRepository listRepository;

    @RequestMapping(value={"/addList"}, method=RequestMethod.GET)
    public String listForm(Model model) {
        model.addAttribute("addList", new ListEntity());
        return "addList";
    }

    @RequestMapping(value={"/addList"}, method=RequestMethod.POST)
    public String listSubmit(@ModelAttribute ListEntity addList) {
        if(StringUtils.hasText(addList.getName())){
            listRepository.save(new ListEntity(addList.getName()));
        }
        return "redirect:/";
    }
}