package tictactoe;

import java.util.Random;

public class EasyAI implements Player {
    Random random = new Random();

    @Override
    public void move(Field field) {
        System.out.println(field);
        System.out.println("Making move level \"easy\"");
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (field.getCell(x, y) != ' ');
        field.set(x, y);
    }
}