import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SHT_getFirstNumberTests {
    @ParameterizedTest
    @MethodSource("methodForGetFirstNumber")
    void getFirstNumber(String line, String result) {
        StringHelper stringHelper = new StringHelper(line);
        assertTrue(result.equals(stringHelper.getFirstNumber()));
        assertEquals(result, stringHelper.getFirstNumber(), "Ожидалось - " + result + " Получено - " + stringHelper.getFirstNumber());
    }
    static Stream<Arguments> methodForGetFirstNumber(){
        return Stream.of(
                Arguments.arguments("123 dqdwq23 123123 ", "123"),
                Arguments.arguments(" 234 213 1234 qweweq 124", "234"),
                Arguments.arguments("qwe weqd21efwg 1233 qwqd123", "1233"),
                Arguments.arguments("12312", "12312"),
                Arguments.arguments("2147483647123123123121213121321323121321321321321321321132132132132123132132132132132132123123", "2147483647123123123121213121321323121321321321321321321132132132132123132132132132132132123123"),
                Arguments.arguments("123132132132234532353253124142114q", "RE")
        );
    }
}
