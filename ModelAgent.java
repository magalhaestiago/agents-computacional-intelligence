import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ModelAgent {
    private int score;
    private Position position;
    private Position lastPosition;
    private String name;
    private Set<Position> walkedPositions = new HashSet<>();
    private int steps;


    public ModelAgent(String name) {
        this.name = name;
        this.score = 0;
        this.steps = 0;
        this.position = new Position(0, 0); // Default position
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

    public void setPosition(Position position) {
        this.position = position;
    }

    public void addWalkedSpace(Position position) {
        walkedPositions.add(position);
    }

    public Set<Position> getWalkedPositions() {
        return walkedPositions;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Position getPosition() {
        return position;
    }

    public void decrementScore() {
        this.setScore(this.score - 1);
    }

    public void incrementScore() {
        this.setScore(this.score + 2);
    }


    public Position getLastPosition() {
        return lastPosition;
    }

    public int operation() {


        ArrayList<Integer> validOperations = new ArrayList<>();

        Position up = new Position(position.getX() - 1, position.getY());
        
        Position down = new Position(position.getX() + 1, position.getY());
        
        Position left = new Position(position.getX(), position.getY() - 1);
        
        Position right = new Position(position.getX(), position.getY() + 1);

        if (!this.getWalkedPositions().contains(up)){
            validOperations.add(0); // up
        }

        if (!this.getWalkedPositions().contains(down)){
            validOperations.add(1); // Down
        }

        if (!this.getWalkedPositions().contains(left)){
            validOperations.add(2); // Left
        }

        if (!this.getWalkedPositions().contains(right)){
            validOperations.add(3); // Right
        }

        if (validOperations.isEmpty()) {
            System.out.println("No valid operations available.");
            this.setSteps(100);
            return -1;
        }


        
        Random random = new Random();

        int randomIndex = random.nextInt(validOperations.size());
        int elementChosen = validOperations.get(randomIndex);
        
        switch (elementChosen) {
            case 0 -> {
                System.out.println(name + "'s action: Move up");
                this.decrementScore();
                this.setSteps(this.getSteps() + 1);
            }
            case 1 -> {
                System.out.println(name + "'s action: Move down");
                this.decrementScore();
                this.setSteps(this.getSteps() + 1);
            }
            case 2 -> {
                System.out.println(name + "'s action: Move left");
                this.decrementScore();
                this.setSteps(this.getSteps() + 1);
            }
            case 3 -> {
                System.out.println(name + "'s action: Move right");
                this.decrementScore();
                this.setSteps(this.getSteps() + 1);
            }
        }

        return elementChosen;
    }
}