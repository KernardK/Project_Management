import java.util.ArrayList;
import java.util.Scanner;

public class Poised extends Functions {
    public static void main(String[] args)
    {
        Projects pr;
        // Instantiate projectList.
        ProjectList prList = ProjectList.getInstance();
        // Scanner object
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        // Variables
        String filename = "ProjectsFile.txt";
        String add;
        String notFinalized = "Not Finalized";
        String inProgress = "In Progress";
        boolean status = true;
        boolean continueLoop = true;

        // Reading The file.
        prList.readsFile(filename);

        // Displays the information in the file
        prList.displayProject();

        do
        {
            // Display menu for information
            System.out.println("Please select a choice from the options below:" +
                    "\nAdd - Add a project\nView - View projects\nUpdate - Update projects\nDelete - Delete Project" +
                    "\nExit - Exit");

            // Menu Choice
            String menuInput = input.nextLine();

            // adding a new project.
            if(menuInput.equals("Add") || menuInput.equals("add"))
            {
                while(continueLoop)
                {
                    // Project object with user information
                    pr = userInput();

                    // Adding the project
                    prList.addProject(pr);

                    // Writes to the file
                    prList.writesToFile(filename);

                    // Ask the user to continue.
                    System.out.println("Would you like to add another project?\nY - Yes or N - No");
                    add = input.nextLine();

                    // Continues looping through adding a project.
                    if(add.equals("Y") || add.equals("y"))
                    {
                        continue;
                    }
                    // Ends the loop and goes back to the main menu.
                    else
                        {
                            continueLoop = false;
                        }
                }
            }

            // Viewing all projects
            else if(menuInput.equals("View") || menuInput.equals("view"))
            {
                // Displays all the projects
                prList.displayProject();

                // View Incomplete Projects
                System.out.println("Would you like to view Incomplete Projects? Y - Yes N - No");
                String incompletedChoice = input.nextLine();

                if (incompletedChoice.equals("Y") || incompletedChoice.equals("y"))
                {
                    while(continueLoop)
                    {
                        System.out.println("Please select what projects you would like to view:" +
                                "\n1 - Not Finalized   2 - In Progress");

                        String choice = input.nextLine();
                        if(choice.equals("1"))
                        {
                            choice = notFinalized;
                        }
                        else
                        {
                            choice = inProgress;
                        }
                        prList.diplayIncompleted(choice);

                        // Prompts users to continue
                        System.out.println("Would you like to continue viewing more incomplete project? Y - Yes or N - No");
                        String viewing = input.nextLine();
                        if(viewing.equals("Y") || viewing.equals("y"))
                        {
                            continue;
                        }
                        else
                        {
                            continueLoop = false;
                        }
                    }
                }
            }

            // Updating projects
            else if(menuInput.equals("Update") || menuInput.equals("update"))
            {
                while(continueLoop)
                {
                    // Displays the projects
                    prList.displayProject();

                    // Prompts the user for a choice
                    System.out.println("Please enter the ID od the project you would like to edit");
                    String updateProject = input.nextLine();

                    // Updates the project.
                    prList.updateProject(updateProject);

                    // Update the file
                    prList.writesToFile(filename);

                    // Prompts users to continue
                    System.out.println("Would you like update another project? Y - Yes or N - No");
                    add = input.nextLine();
                    if(add.equals("Y") || add.equals("y"))
                    {
                        continue;
                    }
                    else
                        {
                            continueLoop = false;
                        }
                }
            }

            else if(menuInput.equals("Delete") || menuInput.equals("delete"))
            {
                while(continueLoop)
                {
                    // Displays projects
                    prList.displayProject();
                    System.out.println("-------------------------------------------------------------\n");
                    // Prompts the user for the choice
                    System.out.println("Please enter the ID of the project you would like to delete:");
                    String projectId = input.nextLine();
                    // Removes the project from the file
                    prList.removeProject(projectId);
                    // Updates the file
                    prList.writesToFile(filename);

                    // Prompts users to continue
                    System.out.println("Would you like to remove another project? Y - Yes or N - No");
                    String remove = input.nextLine();
                    if(remove.equals("Y") || remove.equals("y"))
                    {
                        continue;
                    }
                    else
                    {
                        continueLoop = false;
                    }
                }
            }

            // Exit Program
            else if(menuInput.equals("Exit") || menuInput.equals("exit"))
            {
                status = false;
                //break;
            }
        }while(status);
    }
}
