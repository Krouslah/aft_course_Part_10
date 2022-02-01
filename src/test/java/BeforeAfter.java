import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BeforeAfter {
    @BeforeEach
    void print(){
        System.out.println("Я запускаюсь...");
    }
    @AfterEach
    void print2(){
        System.out.println("Получается все.");
    }
}
