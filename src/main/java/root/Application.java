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
        CategoryRepository repository= context.getBean(CategoryRepository.class);
        repository.save(new Category(1L,"Общие"));
        repository.save(new Category(2L,"Дом"));
        repository.save(new Category(3L,"Работа"));
        repository.save(new Category(4L,"Семья"));
        repository.save(new Category(5L,"Друзья"));
        repository.save(new Category(6L,"Встречи"));
        repository.save(new Category(7L,"Покупки"));
        repository.save(new Category(8L,"Покупки2"));

    }
}