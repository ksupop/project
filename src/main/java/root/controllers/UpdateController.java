package root.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import root.domain.ListEntity;
import root.da.ListRepository;
import root.domain.TaskEntity;
import root.da.TaskRepository;
import java.util.Optional;


@Controller
public class UpdateController {
    @Autowired
    private ListRepository listRepository;
    @Autowired
    private TaskRepository taskRepository;

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

    @GetMapping(value = {"/task/{taskId}/change"})
    public String upTaskForm(Model model, @PathVariable long taskId) {
        TaskEntity task = taskRepository.findById(taskId);

        model.addAttribute("task", task);

        return "/changeTask";
    }

    @RequestMapping(value = {"/task/{taskId}/change"}, method = {RequestMethod.POST})
    public String upTaskSubmit(Model model, @PathVariable long taskId,
                               @ModelAttribute("task") TaskEntity task) {
        TaskEntity taskToUpdate = taskRepository.findById(taskId);
        taskToUpdate.setTitle(task.getTitle());
        taskToUpdate.setDiscription(task.getDiscription());
        taskToUpdate.setDone(task.getDone());
        taskRepository.save(taskToUpdate);

        Long id = taskToUpdate.getParent();

        return "redirect:/index/" + id;
    }

}