import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Tag("fs")
public class SHT_GetWordsCountTest extends StringHelperTest{
    @ParameterizedTest
    @MethodSource("methodGetWordCount")
    void getWordsCountTestForDifferentInput(int a, String line){
        StringHelper stringHelper = new StringHelper(line);
        assertEquals(a, stringHelper.getWordsCount());
    }
    static Stream<Arguments> methodGetWordCount(){
        return Stream.of(
                Arguments.arguments(20, "qewqeqw eqwe qwe qwe qweq wwert qw qwrqt qrqw etq wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we eqwee qweqe",
                        "qewqeqw eqwe qwe qwe qweq wwert qw qwrqt qrqw etq wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we..."),
                Arguments.arguments(20,  "123qeqw eqwe qwe qwe qweq wwert qw qwrqt qrqw etq wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we eqwee qwege",
                        "123qeqw eqwe qwe qwe qweq wwert qw qwrqt qrqw etq wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we..."),
                Arguments.arguments(19,  "123qeqw eqwe qwe qwe qweq wwert qw qwrqt qrqw 123 wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we eqwee qw123",
                        "123qeqw eqwe qwe qwe qweq wwert qw qwrqt qrqw 123 wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we..."),
                Arguments.arguments(0,  "1231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231",
                        "1231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231..."),
                Arguments.arguments(1,  "qweqweqweqweqweqweqweqweqweqweqwweqweqweqweqweqweqweqweqwweqweqweqweqweqweqweqweqweqweqweqweqweqwqwq",
                        "qweqweqweqweqweqweqweqweqweqweqwweqweqweqweqweqweqweqweqwweqweqweqweqweqweqweqweqweqweqweqweqweqw..."),
                Arguments.arguments(13,  "qweqwe - qweqwe 123123 / qwe213qweqweqwe - qweqwe 123123 / qwe213qweqweqwe = qweqwe 123123 / qwe213q",
                        "qweqwe - qweqwe 123123 / qwe213qweqweqwe - qweqwe 123123 / qwe213qweqweqwe = qweqwe 123123 /..."),
                Arguments.arguments(0, "", "0"),
                Arguments.arguments(27, "qwe qwe qwe qwe qwe qwe qwee qwe qwe qwe qwe qwe qwe qwee qw eqwe qwe qwe qwe qwe qwe qwe qwe qwe qwe qwe qwe",
                        "qwe qwe qwe qwe qwe qwe qwee qwe qwe qwe qwe qwe qwe qwee qw eqwe qwe qwe qwe qwe qwe qwe qwe qwe..."),
                Arguments.arguments(10, "qwe qwe qwe qwe qwe qwe qwe qwe qwe qwe", "qwe qwe qwe qwe qwe qwe qwe qwe qwe qwe")

        );
    }
}
