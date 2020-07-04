package root.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import root.da.CategoryRepository;
import root.da.TaskRepository;
import root.domain.Category;

@Controller
public class DemoCategoryView {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "demo-list", method = RequestMethod.GET)
    public String getIndex (Model model){
        Iterable<Category> categories =categoryRepository.findAll();

        model.addAttribute("categories", categories);

        return "category";
    }
}
