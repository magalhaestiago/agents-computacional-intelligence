import java.util.Random;

public class ReactiveAgent {
    private String name;
    private int steps;
    private int score;
    private Position position; 
    // private Position position;

    public ReactiveAgent(String name) {
        this.name = name;
        this.score = 0;
        this.steps = 0;
        this.position = new Position(0, 0); // Default position
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }
    public int getSteps() {
        return steps;
    }
    public void setSteps(int steps) {
        this.steps = steps;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void incrementScore() {
        this.score += 2;
    }
    public void decrementScore() {
        this.score -= 1;
    }

    public int operation() {
        Random random = new Random();
        int operation = random.nextInt(4); 

        switch(operation) {
            case 0 -> {
                // up
                System.out.println(name + "'s action: Move up");
                this.decrementScore();
                this.setSteps(this.getSteps() + 1);
            }
            case 1 -> {
                // down
                System.out.println(name + "'s action: Move down");
                this.decrementScore();
                this.setSteps(this.getSteps() + 1);
            }
            case 2 -> {
                // left
                System.out.println(name + "'s action: Move left");
                this.decrementScore();
                this.setSteps(this.getSteps() + 1);
            }
            case 3 -> {
                // right
                System.out.println(name + "'s action: Move right");
                this.decrementScore();
                this.setSteps(this.getSteps() + 1);
            }
            case 4 -> {
                // do nothing
                System.out.println(name + "'s action: Do nothing");
                this.decrementScore();
                this.setSteps(this.getSteps() + 1);
            }
        }
        return operation;
    }
}
