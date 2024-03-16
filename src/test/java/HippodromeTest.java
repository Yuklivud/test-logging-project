import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HippodromeTest {
    public static List<Horse> horses;
    @BeforeEach
    public void setUp(){
        horses = new ArrayList<>();
    }
    @Test
    public void constructorWithNullArgument_throw_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }
    @Test
    public void constructorWithNullArgument_throw_IllegalArgumentException_WithMessage(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }
    @Test
    public void constructorWithNullList_throw_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
    }
    @Test
    public void constructorWithNullList_throw_IllegalArgumentException_WithMessage(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }
    @Test
    public void getHorses_ReturnSameListHorses(){
        List<Horse> horseList = new ArrayList<>();
        for(int i = 0; i < 30; i++){
            horseList.add(new Horse("Horse " + i, 1, 1));
        }
        Hippodrome hippodrome = new Hippodrome(horseList);

        assertEquals(30, hippodrome.getHorses().size());
        assertEquals("Horse 0", hippodrome.getHorses().get(0).getName());
        assertEquals("Horse 1", hippodrome.getHorses().get(1).getName());
        assertEquals("Horse 10", hippodrome.getHorses().get(10).getName());
        assertEquals("Horse 28", hippodrome.getHorses().get(28).getName());
        assertEquals("Horse 29", hippodrome.getHorses().get(29).getName());
    }
    @Test
    public void move_CallMoveInAllHorses(){
        List<Horse> horseList = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            horseList.add(Mockito.mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horseList);
        hippodrome.move();

        for(Horse horse : horseList){
            Mockito.verify(horse, Mockito.times(1)).move();
        }
    }
    @Test
    public void getWinner_ReturnMostDistanceHorse(){
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("Horse 0", 10, 10));
        horseList.add(new Horse("Horse 1", 5, 17));
        horseList.add(new Horse("Horse 2", 3, 13));
        horseList.add(new Horse("Horse 3", 12, 15));

        Hippodrome hippodrome = new Hippodrome(horseList);
        assertEquals("Horse 1", hippodrome.getWinner().getName());
    }
}
