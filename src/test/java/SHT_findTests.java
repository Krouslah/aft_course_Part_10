import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SHT_findTests {
    @ParameterizedTest
    @MethodSource("methodForFind")
    void find(String line1, String line2, int index, String line3) {
        StringHelper stringHelper = new StringHelper(line1);
        assertEquals(line2, stringHelper.find(index, line3), "Ожидалось - " + line2 + " Получено - " + stringHelper.find(index, line3));
        assertNotEquals(line3, stringHelper.find(index, line3));
    }
    static Stream<Arguments> methodForFind(){
        return Stream.of(
                Arguments.arguments("qewqeqw eqwe qwe qwe qweq wwert qw qwrqt qrqw etq wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we eqwee qweqe",
                        "qeqw eqwe qwe qwe qweq wwert qw qwrqt qrqw etq wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we eqwee qweqe", 3, "qeqw"),
                Arguments.arguments("123qeqw eqwe qwe qwe qweq wwert qw qwrqt qrqw etq wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we eqwee qwege",
                        "w eqwe qwe qwe qweq wwert qw qwrqt qrqw etq wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we eqwee qwege", 6, "w eq"),
                Arguments.arguments("123qeqw eqwe qwe qwe qweq wwert qw qwrqt qrqw 123 wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we eqwee qw123",
                        " qwe qwe qweq wwert qw qwrqt qrqw 123 wrwqr etqt qwee qwee eqweqewewq eqwe eweqwe we eqwee qw123", 11, " qwe"),
                Arguments.arguments("1231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231",
                        "31231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231231", 5, "312"),
                Arguments.arguments("qweqweqweqweqweqweqweqweqweqweqwweqweqweqweqweqweqweqweqwweqweqweqweqweqweqweqweqweqweqweqweqweqwqwq",
                        "weqweqweqweqweqweqweqweqweqweqwweqweqweqweqweqweqweqweqwweqweqweqweqweqweqweqweqweqweqweqweqweqwqwq", 1, "weqweq"),
                Arguments.arguments("qweqwe - qweqwe 123123 / qwe213qweqweqwe - qweqwe 123123 / qwe213qweqweqwe = qweqwe 123123 / qwe213q",
                        "- qweqwe 123123 / qwe213qweqweqwe - qweqwe 123123 / qwe213qweqweqwe = qweqwe 123123 / qwe213q", 7, "-"),
                Arguments.arguments("","0", 200, "qwedsz123?"),
                Arguments.arguments("StringHelper", "В исходной строке вообще нет данной подстроки", 7, "HALP"),
                Arguments.arguments("StringHelper", "Строка не содержит в себе искомую подстроку", 2, "String")
        );
    }
}
