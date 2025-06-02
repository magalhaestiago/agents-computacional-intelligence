import java.util.Scanner;

public class Enviroment {

    public void Simulate(VacuumWorld world, ReactiveAgent agent) {
        // Simulate the environment with the given world and agent

        
        world.printWorld();
        
        
        world.addAgent(agent);

        world.printWorld();
        

        int operation = -1;

        while(agent.getSteps() < 100) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press Enter to continue...");
            scanner.nextLine();

            operation = agent.operation();

            switch (operation) {
                case 0 -> {
                    if(agent.getPosition().getX() - 1 < 0){
                        System.out.println("Hit the wall!");
                    } else {
                        int aux = world.getDirtyCount();
                        world.moveAgent(agent, new Position(agent.getPosition().getX() - 1, agent.getPosition().getY()));
                        
                        if (world.getDirtyCount() < aux) {
                            agent.incrementScore();
                        } 

                    }
                }

                case 1 -> {
                    if(agent.getPosition().getX() + 1 >= world.getRows()){
                        System.out.println("Hit the wall!");
                    } else {
                        int aux = world.getDirtyCount();
                        world.moveAgent(agent, new Position(agent.getPosition().getX() +1, agent.getPosition().getY() ));
                        if (world.getDirtyCount() < aux) {
                            agent.incrementScore();
                        }
                    }
                }
                
                case 2 -> {
                    if(agent.getPosition().getY() - 1 < 0){
                        System.out.println("Hit the wall!");
                    } else {
                        int aux = world.getDirtyCount();
                        world.moveAgent(agent, new Position(agent.getPosition().getX(), agent.getPosition().getY() - 1));
                        
                        if (world.getDirtyCount() < aux) {
                            agent.incrementScore();
                        }
                    }
                }
                
                case 3 -> {
                    if(agent.getPosition().getY() + 1 >= world.getCols()){ 
                        System.out.println("Hit the wall!");
                    } else {
                        int aux = world.getDirtyCount();
                        world.moveAgent(agent, new Position(agent.getPosition().getX(), agent.getPosition().getY()+1));
                        
                        if (world.getDirtyCount() < aux) {
                            agent.incrementScore();
                        }
                    }
                }
            }
            System.out.println("Agent score: " + agent.getScore());
            world.printWorld();
    
        }
    
}
    
    public void Simulate(VacuumWorld world, ModelAgent agent) {
        // Simulate the environment with the given world and agent
        world.printWorld();
        
        
        world.addAgent(agent);

        world.printWorld();

        

        int operation = -1;

        while(agent.getSteps() < 100) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press Enter to continue...");
            scanner.nextLine();

            operation = agent.operation();

            switch (operation) {
                case 0 -> {
                    if(agent.getPosition().getX() - 1 < 0){
                        System.out.println("Hit the wall!");
                    } else {
                        int aux = world.getDirtyCount();
                        world.moveAgent(agent, new Position(agent.getPosition().getX() - 1, agent.getPosition().getY()));
                        if (world.getDirtyCount() < aux) {
                            agent.incrementScore();
                        }
                    }
                }

                case 1 -> {
                    if(agent.getPosition().getX() + 1 >= world.getRows()){
                        System.out.println("Hit the wall!");
                    } else {
                        int aux = world.getDirtyCount();
                        world.moveAgent(agent, new Position(agent.getPosition().getX() +1, agent.getPosition().getY() ));
                        if (world.getDirtyCount() < aux) {
                            agent.incrementScore();
                        }
                    }
                }
                
                case 2 -> {
                    if(agent.getPosition().getY() - 1 < 0){
                        System.out.println("Hit the wall!");
                    } else {
                        int aux = world.getDirtyCount();
                        world.moveAgent(agent, new Position(agent.getPosition().getX(), agent.getPosition().getY() - 1));
                        if (world.getDirtyCount() < aux) {
                            agent.incrementScore();
                        }
                    }
                }
                
                case 3 -> {
                    if(agent.getPosition().getY() + 1 >= world.getCols()){ 
                        System.out.println("Hit the wall!");
                    } else {
                        int aux = world.getDirtyCount();
                        world.moveAgent(agent, new Position(agent.getPosition().getX(), agent.getPosition().getY()+1));
                        if (world.getDirtyCount() < aux) {
                            agent.incrementScore();
                        }
                    }
                }
            }
            System.out.println("Agent score: " + agent.getScore());
            world.printWorld();
    
        }
    
}

public static void main(String[] args) {
    VacuumWorld world = new VacuumWorld("enviroments/enviroment1.txt");
    //ReactiveAgent agent = new ReactiveAgent("[A]");
    ModelAgent agent = new ModelAgent("[A]");
    // ReactiveAgent reactiveAgent = new ReactiveAgent("[R]");
    //Enviroment environment_one = new Enviroment();
    Enviroment environment_two = new Enviroment();

    //environment_one.Simulate(world, reactiveAgent);
    environment_two.Simulate(world, agent);

}
}
