package lists4;

import java.util.ArrayList;
import java.util.List;

import static input.InputUtils.stringInput;

public class userInputs {
    public static void main(String[] args) {
        List<String> todoList = new ArrayList<>();

        while (true){
            String data = stringInput("Please type a task you need to do, or press Enter to quit.");

            if (todoList.contains(data)){
                System.out.println("This task already exists");
                // if the task already exists, don't add it to the list
                continue;
            }

            if (data.isEmpty()) {
                // If the user presses enter, the length will be 0:  data.length() == 0
                break;
            }

            todoList.add(data);
        }

        // print the data
        System.out.println("You created " + todoList.size() + " tasks, they are:");
        for (String data : todoList){
            System.out.println(data);
        }
    }
}
