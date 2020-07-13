package root.controllers;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import root.da.ListRepository;
import root.da.TaskRepository;
import root.domain.ListEntity;
import root.domain.TaskEntity;


@Controller
public class ListController {
    @Autowired
    private ListRepository listRepository;
    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        Map<Long, ListEntity> lists = getLists();
        Iterable<TaskEntity> tasks = taskRepository.findAll();

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(null));
        model.addAttribute("tasks", tasks);

        return "index";
    }

    @RequestMapping(value = {"/index/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable Long id){
        Map<Long, ListEntity> lists = getLists();
        Map<Long, TaskEntity> tasks = getTasks(id);

        model.addAttribute("lists", lists.values());
        model.addAttribute("currentList", lists.get(id));
        model.addAttribute("tasks", tasks.values());

        return "index";
    }

    private Map<Long, ListEntity> getLists(){
        Map<Long, ListEntity> result = new HashMap<>();
        Iterable<ListEntity> lists = listRepository.findAll();

        result.put(null, new ListEntity("Все"));

        for (ListEntity entity: lists) {
            result.put(entity.getId(), entity);
        }
        return result;
    }

    private Map<Long, TaskEntity> getTasks(Long id){
        Map<Long, TaskEntity> result = new HashMap<>();
        Iterable<TaskEntity> tasks = taskRepository.findAll();

        for (TaskEntity entity: tasks) {
            if (entity.getParent() == id)
                result.put(entity.getId(), entity);
        }
        return result;
    }

    @RequestMapping(value = {"/index/{id}/delete"})
    public String removeList(@PathVariable Long id) {
        listRepository.deleteById(id);
        return "redirect:/index";
    }

    @RequestMapping(value = {"/task/{taskId}/delete"})
    public String removeTask(@PathVariable Long taskId) {
        TaskEntity task = taskRepository.findById((long)taskId);
        Long id = task.getParent();
        taskRepository.deleteById(taskId);
        return "redirect:/index/" + id;
    }

    @RequestMapping(value = "/index/addTask", method = RequestMethod.GET)
    public String taskForm(Model model) {
        model.addAttribute("addTask", new TaskEntity());
        return "addTask";
    }

    @RequestMapping(value = {"/index/addTask"}, method = RequestMethod.POST)
    public String categorySubmit(@ModelAttribute TaskEntity addtask, Model model){
        taskRepository.save(new TaskEntity(addtask.getParent(), addtask.getTitle()));
        return "redirect:/index/" + addtask.getParent();
    }
}