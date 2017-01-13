import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created by lis on 17/1/13.
 */
@SpringBootApplication
public class Application  implements CommandLineRunner{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void run(String... strings) throws Exception {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String key = "testKey";
        if (!this.stringRedisTemplate.hasKey(key)) {
            ops.set(key, "testValue");
        }
        System.out.println("Found key " + key + ", value=" + ops.get(key));
    }
    public static void main(String[] args) throws Exception {
        // Close the context so it doesn't stay awake listening for redis
        SpringApplication.run(Application.class, args).close();
    }

}
