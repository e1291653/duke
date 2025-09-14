import java.util.Scanner;

public class Kev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tasks = new String[100];
        int taskCount = 0;

        String input;

        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Kev");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");

        //to loop until exit condition is satisfied
        while (true) {
            input = sc.nextLine().trim();  //to read user input

            if (input.equalsIgnoreCase("bye")) {  //exit condition
                System.out.println("____________________________________________________________");
                System.out.println(" Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            }

            else if (input.equalsIgnoreCase("list")) {
                //to display stored tasks
                System.out.println("____________________________________________________________");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println(" " + (i + 1) + ". " + tasks[i]);
                }
                System.out.println("____________________________________________________________");
            }

            else {
                //to store tasks
                if (taskCount < tasks.length) {
                    tasks[taskCount] = input;
                    taskCount++;
                    System.out.println("____________________________________________________________");
                    System.out.println(" added: " + input);
                    System.out.println("____________________________________________________________");
                } else {
                    System.out.println("____________________________________________________________");
                    System.out.println(" Cannot add more tasks, storage full!");
                    System.out.println("____________________________________________________________");
                }
            }
        }
        sc.close();
    }
}

