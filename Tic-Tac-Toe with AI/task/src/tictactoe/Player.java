package tictactoe;

interface Player {
    static Player of(String type) {
        switch (type) {
            case "easy":
                return new EasyAI();
            case "user":
                return new RealPlayer();
            case "medium":
                return new MediumAI();
            case "hard":
                return new HardAI();
            default:
                return null;
        }
    }

    void move(Field field);
}