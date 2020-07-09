package root.controllers;

import root.domain.List;
import root.domain.Task;
import root.da.ListRepository;
import root.da.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import antlr.StringUtils.*;


@Controller
public class ListController {
    @Autowired
    private ListRepository listRepository;

    //@Autowired
    //private TaskRepository taskRepository;

    @RequestMapping(value ={"/", "/index"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        Map<Long, List> lists = getLists();
        //Iterable<List> lists = listRepository.findAll();
        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(null));
        return "index";
    }

    @RequestMapping(value = {"/index/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable Long id){
        Map<Long, List> lists = getLists();

        //Optional<List> list = listRepository.findById(id);
        //Iterable<Task> tasks = list.getTask();

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(null));
        return "index";
    }

    private  Map<Long, List> getLists(){
        Map<Long, List> result = new HashMap<>();
        Iterable<List> lists = listRepository.findAll();
        for(List list: lists){
            result.put(list.getId(), list);
        }
        return result;
    }


    @RequestMapping(value = {"/index/{id}/delete"})
    public String removeList(@PathVariable Long id) {
        listRepository.deleteById(id);
        return "redirect:/index";
    }

}