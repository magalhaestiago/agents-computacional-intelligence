import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VacuumWorld {
    private int cols, rows;
    String[][] world;
    private int dirtyCount;




    public VacuumWorld(String pathFile) {
        initializeWorld(pathFile);
    }

    
    public int getDirtyCount() {

        dirtyCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (world[i][j].equals("[D]")) {
                    dirtyCount++;
                }
            }
        }
        return dirtyCount;
    }
    

    public Boolean moveAgent(ModelAgent agent, Position position) {
        
        world[agent.getPosition().getX()][agent.getPosition().getY()] = "[X]";
        world[position.getX()][position.getY()] = agent.getName();

        agent.addWalkedSpace(agent.getPosition());
        agent.setPosition(position);

        return true;
    }

    public Boolean moveAgent(ReactiveAgent agent, Position position) {
        
        world[agent.getPosition().getX()][agent.getPosition().getY()] = "[ ]";
        world[position.getX()][position.getY()] = agent.getName();

        
        agent.setPosition(position);

        return true;
    }


    public void printWorld() {
        System.out.println("======================");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(world[i][j]);
            }
            System.out.println();
        }
        System.out.println("======================");
    }

    public void addAgent(ModelAgent agent) {
        world[0][0] = agent.getName();
    }

    public void addAgent(ReactiveAgent agent) {
        world[0][0] = agent.getName();
    }


    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }
    public void setCols(int cols) {
        this.cols = cols;
    }

     public void initializeWorld(String pathFile) {
        String input = readEnviroment(pathFile);
        String[][] matrix = convertToMatrix(input);


        this.setRows(matrix.length);
        this.setCols(matrix[0].length);
        this.world = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                world[i][j] = matrix[i][j];
            }
        }
    }


    private String readEnviroment(String pathFile) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            
        }

        return content.toString();
    }

    private String[][] convertToMatrix(String input) {
        String[] lines = input.strip().split("\n");
        int rows = lines.length;
        int cols = lines[0].split("\\[").length - 1;

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = lines[i].trim();
            String[] cells = line.split("\\]");

            for (int j = 0; j < cols; j++) {
                String content = cells[j].replace("[", "").trim();
                matrix[i][j] = content.equals("D") ? "[D]" : "[ ]";
            }
        }

        return matrix;
    }
}
