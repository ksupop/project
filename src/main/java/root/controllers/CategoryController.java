package root.controllers;
import root.domain.Category;
import root.domain.Task;
import root.da.CategoryRepository;
import root.da.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;
@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(Model model){
        Iterable<Category> categories = categoryRepository.findAll();

        model.addAttribute("categories", categories);
        return "index";
    }
    private Map<Long, Task> getLists(){
        Map<Long, Task> result = new HashMap<>();
        Iterable<Task> categories = taskRepository.findAll();

        for (Task entity: categories){
            result.put(entity.getId(), entity);
        }
        return result;
    }


    /*@RequestMapping(value = {"/index/{id}"}, method = RequestMethod.GET)
    public String getIndex1(Model model){
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }*/
}