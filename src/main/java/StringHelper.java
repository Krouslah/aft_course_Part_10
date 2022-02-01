import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

public class StringHelper {
    private String line;

    public StringHelper(String line) {
        this.line = line;
    }

    public int getWordsCount() {
        if (this.line.equals("")) {
            return 0;
        } else {
            if (this.line.trim().replaceAll("\\b\\d+\\b", "").replaceAll("\\s+", " ").trim().isEmpty()) {
                return 0;
            } else {
                return this.line.trim().replaceAll("\\b\\d+\\b", "").replaceAll("\\s+", " ").trim().split(" ").length;
            }
        }
    }

    public String cut() {
        if (this.line.equals("")){
            return "0";
        }
        String str1 = this.line.trim();
        if (str1.length() > 97) {
            String[] array1 = str1.split(" ");
            String[] array2 = str1.substring(0, 98).split(" ");
            if (array1.length == 1){
                return str1.substring(0, 97).trim() + "...";
            }
            if (array1[(array1.length - 1)].equals(array2[array2.length - 1])) {
                return str1.substring(0, 97).trim() + "...";
            } else {
                return str1.substring(0, (97 - array2[array2.length - 1].length())).trim() + "...";
            }
        } else {
            return this.line;
        }
    }

    public String find(int index, String str) {
        if (this.line.equals("")){
            return "0";
        }
        if (this.line.trim().toLowerCase().contains(str.toLowerCase())) {
            String str1 = this.line.trim().substring(index);
            if (str1.toLowerCase().contains(str.toLowerCase())) {
                return str1.substring(str1.toLowerCase().indexOf(str.toLowerCase()));
            } else {
                return "Строка не содержит в себе искомую подстроку";
            }
        } else {
            return "В исходной строке вообще нет данной подстроки";
        }
    }

    public String getFirstNumber() {
        Optional<String> output = Arrays.stream(this.line.replaceAll("\\p{Punct}", "").split(" ")).filter(n -> Pattern.matches("\\d+", n)).findFirst();
        return output.orElse("RE");
    }
}
