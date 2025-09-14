import java.util.Scanner;

public class Kev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task[] tasks = new Task[100];
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
            else if (input.startsWith("mark ")) {
                int idx = Integer.parseInt(input.split(" ")[1]) - 1;
                if (idx >= 0 && idx < taskCount) {
                    tasks[idx].markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println("   " + tasks[idx]);
                    System.out.println("____________________________________________________________");
                }
            } else if (input.startsWith("unmark ")) {
                int idx = Integer.parseInt(input.split(" ")[1]) - 1;
                if (idx >= 0 && idx < taskCount) {
                    tasks[idx].markAsNotDone();
                    System.out.println("____________________________________________________________");
                    System.out.println(" OK, I've marked this task as not done yet:");
                    System.out.println("   " + tasks[idx]);
                    System.out.println("____________________________________________________________");
                }
            }
            else if (input.startsWith("todo ")) {
                String desc = input.substring(5).trim();
                tasks[taskCount++] = new Todo(desc);
                System.out.println(" Got it. I've added this task:");
                System.out.println("   " + tasks[taskCount - 1]);
                System.out.println(" Now you have " + taskCount + " tasks in the list.");
            }
            else if (input.startsWith("deadline ")) {
                String[] parts = input.substring(9).split("/by", 2);
                String desc = parts[0].trim();
                String by = parts[1].trim();
                tasks[taskCount++] = new Deadline(desc, by);
                System.out.println(" Got it. I've added this task:");
                System.out.println("   " + tasks[taskCount - 1]);
                System.out.println(" Now you have " + taskCount + " tasks in the list.");
            }
            else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split("/from|/to");
                String desc = parts[0].trim();
                String from = parts[1].trim();
                String to = parts[2].trim();
                tasks[taskCount++] = new Event(desc, from, to);
                System.out.println(" Got it. I've added this task:");
                System.out.println("   " + tasks[taskCount - 1]);
                System.out.println(" Now you have " + taskCount + " tasks in the list.");
            }

            else {
                //to store tasks
                if (taskCount < tasks.length) {
                    tasks[taskCount] = new Task(input);
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

