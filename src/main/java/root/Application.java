package root;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import root.da.ListRepository;
import root.da.TaskRepository;

@ComponentScan
@EnableAutoConfiguration
public class Application {
    public Application() {
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);

    }
}