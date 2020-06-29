package root;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import root.da.CategoryRepository;
import root.domain.Category;

@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        CategoryRepository repository = context.getBean(CategoryRepository.class);
        repository.save(new Category((long) 1,"category"));
        repository.save(new Category((long) 2,"category 2"));

        Iterable<Category> lists = repository.findAll();

        for (Category entity: lists){
            System.out.println(entity.getName());
        }
        context.close();
    }

}
