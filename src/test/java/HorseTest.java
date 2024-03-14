import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
class HorseTest {
    public static Horse horse;
    @BeforeEach
    public void setUp(){
        horse = new Horse("Mikael", 10, 20);
    }
    @Test
    public void constructorFirstArgumentIsNull_throw_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1));
    }
    @Test
    public void constructorFirstArgumentIsNull_throw_IllegalArgumentException_WithMessage(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1 ));
        assertEquals("Name cannot be null.", exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "\t", "\u000B", "\n"})
    public void constructorWithParameterizedArguments_throw_IllegalArgumentException(String input){
        assertThrows(IllegalArgumentException.class, () -> new Horse(input, 1));
    }
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "\t", "\u000B", "\n"})
    public void constructorWithParameterizedArguments_throw_IllegalArgumentException_WithMessage(String input){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(input, 1));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }
    @Test
    public void constructorSecondArgumentIsNegative_throw_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> new Horse("Test", -1));
    }
    @Test
    public void constructorSecondArgumentIsNegative_throw_IllegalArgumentException_WithMessage(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Test", -1));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }
    @Test
    public void constructorThirdArgumentIsNegative_throw_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> new Horse("Test", 1, -1));
    }
    @Test
    public void constructorThirdArgumentIsNegative_throw_IllegalArgumentException_WithMessage(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse("Test", 1, -1));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }
    @Test
    public void getName_ReturnFirstConstructorArgument(){
        assertEquals("Mikael", horse.getName());
    }
    @Test
    public void getSpeed_ReturnSecondConstructorArgument(){
        assertEquals(10, horse.getSpeed());
    }
    @Test
    public void getDistance_ReturnThirdConstructorArgument(){
        assertEquals(20, horse.getDistance());
    }
    @Test
    public void getDistance_ReturnZeroWithTwoArgumentsConstructor(){
        Horse testHorse = new Horse("Horse", 10);
        assertEquals(0, testHorse.getDistance());
    }
    @Test
    public void move_CallGetRandomDoubleInner(){
        try(MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)){
            mockedStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.5);
            horse.move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
            assertEquals(25, horse.getDistance());
        }
    }
}