import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
@Tag("fs")
public class SHT_cutTests extends StringHelperTest{
    @ParameterizedTest
    @MethodSource("methodGetWordCount")
    void cut(int a ,String line1, String line2){
        StringHelper stringHelper = new StringHelper(line1);
        assertEquals(line2, stringHelper.cut(), "Ожидалось - " + line2 + " Получено - " + stringHelper.cut());
        assertFalse(line1.equals("4"));
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
