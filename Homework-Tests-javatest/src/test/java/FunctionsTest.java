import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTest {

    private Functions functions;

    @BeforeEach
    void setUp() {
        functions = new Functions();
        System.out.println("Иницилиазировали.");
    }

    @AfterEach
    void tearDown() {
        functions = null;
        System.out.println("Топи топ очистка прошла успешно.");
    }

    @ParameterizedTest
    @CsvSource({
            "'Селяне еле еле офигели', 'офигели'", // "офигели" содержит больше "и"
            "'Протоптал все половици', 'половици'", // "половици" содержит больше "и"
    })
    @DisplayName("Найти слово с наибольшим количеством 'и'")
    void testFindWordWithMostI(String text, String expected) {
        assertEquals(expected, functions.findWordWithMostI(text));
    }

    @Test
    @DisplayName("Проверка слова с наибольшим количеством 'и'")
    void testFindWordWithMostIPerformance() {
        assertTimeout(Duration.ofMillis(100), () -> {
            String text = "Изподтижка еле еле офигели";
            String result = functions.findWordWithMostI(text);
            assertEquals("офигели", result); // "офигели" содержит больше "и"
        });
    }

    @Test
    @DisplayName("Получить максимальную сумму диагонали в матрице")
    void testGetMaxDiagonalSum() {
        int[][] matrix = {
                {5, 2, 3},
                {4, 10, 6},
                {7, 8, 15}
        };
        assertEquals(30, functions.getMaxDiagonalSum(matrix));
    }

    @Disabled
    @Test
    @DisplayName("Получить заглавные инициалы из предложения")
    void testGetUpperCaseInitials() {
        assertThrows(IllegalArgumentException.class, () -> functions.getUpperCaseInitials(""));
        assertEquals("СЕН", functions.getUpperCaseInitials("Сила единства народа"));
        assertEquals("СВЕН", functions.getUpperCaseInitials("Сила в единстве народа"));
    }
}
