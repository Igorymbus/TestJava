import java.util.Arrays;
import java.util.stream.Collectors;

public class Functions {

    public String findWordWithMostI(String text) {
        if (text == null || text.isEmpty()) return "";

        return Arrays.stream(text.split("\\s+"))
                .filter(word -> word.length() > 1) // Исключить одиночные буквы
                .max((a, b) -> {
                    long countA = a.chars().filter(c -> c == 'и').count();
                    long countB = b.chars().filter(c -> c == 'и').count();

                    if (countA == countB) {
                        // Если количество "и" одинаково, вернуть более длинное слово
                        return Integer.compare(b.length(), a.length());
                    }

                    // Сравнение по количеству букв "и"
                    return Long.compare(countA, countB);
                })
                .orElse(""); // Если нет подходящих слов
    }

    public int getMaxDiagonalSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int diagonal1 = 0, diagonal2 = 0;
        int limit = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < limit; i++) {
            diagonal1 += matrix[i][i];
            diagonal2 += matrix[i][limit - 1 - i];
        }
        return Math.max(diagonal1, diagonal2);
    }

    public String getUpperCaseInitials(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой или равна 0.");
        }
        return Arrays.stream(text.trim().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .map(s -> String.valueOf(Character.toUpperCase(s.charAt(0))))
                .collect(Collectors.joining());
    }
}
