import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ProjectList {

    Scanner input = new Scanner(System.in);

    /**
     * Instance of the project ArrayList
     */
    private ArrayList<Projects> projectsList;

    /**
     * Create the object of the current class
     */
    private static ProjectList onlyInstance = new ProjectList();

    /**
     * Private constructor creates the ArrayList ProjectsList
     */
    private ProjectList()
    {
        projectsList = new ArrayList();
    }


    /**
     * Returns the instance of the class
     * @return the only instance object
     */
    public static ProjectList getInstance()
    {
        return onlyInstance;
    }


    /**
     * Method to add projects to the ArrayList
     * @param pr the project object created
     */
    public void addProject(Projects pr)
    {
        projectsList.add(pr);
    }


    /**
     * This method writes to the file
     * @param fileName the file to be writen to.
     */
    public void writesToFile(String fileName)
    {
        int size = projectsList.size();
        try
        {
            Formatter outputFile = new Formatter(fileName);

            String fileData = "";
            for(int i = 0; i < size; i++)
            {
                fileData += projectsList.get(i).formatProject() + "\n"
                        + projectsList.get(i).formatCustomer() + "\n"
                        + projectsList.get(i).formatArchitect() + "\n"
                        + projectsList.get(i).formatContractor() + "\n";
            }
            outputFile.format("%s", fileData);

            outputFile.close();



        }catch (Exception e)
        {
            System.out.println("Error in writing to the file. Please try again");
        }
    }

    /**
     * Reads the file data and creates the object.
     * @param inputFile takes in the file for reading data
     */
    public void readsFile(String inputFile)
    {
        // Project Variables.
        String projectNum, projectName, buildingType, projectAddress,
                erfNum, projectDeadline, finalized, completedDate, blankLine;
        int totalProjectFee, amountPaid;

        try
        {
            // File Object.
            File readefile = new File(inputFile);
            // Scanner Object
            Scanner reader = new Scanner(readefile);

            while(reader.hasNext())
            {
                // Project details read and stored.
                projectNum = reader.nextLine();
                projectName = reader.nextLine();
                buildingType = reader.nextLine();
                projectAddress = reader.nextLine();
                erfNum = reader.nextLine();
                totalProjectFee = Integer.parseInt(reader.nextLine());
                amountPaid = Integer.parseInt(reader.nextLine());
                projectDeadline = reader.nextLine();
                finalized = reader.nextLine();
                completedDate = reader.nextLine();

                Projects project = new Projects(projectNum, projectName, buildingType,
                        projectAddress, erfNum, totalProjectFee,
                        amountPaid, projectDeadline, finalized, completedDate);

                // Customer Variables
                String type, name, surname, phoneNum, email, address;

                // Reads the lines to collect the customer details
                type = reader.nextLine();
                name = reader.nextLine();
                surname = reader.nextLine();
                phoneNum = reader.nextLine();
                email = reader.nextLine();
                address = reader.nextLine();

                // Creates the customer object
                project.createCustomer(type, name, surname, phoneNum, email, address);

                // Reads the lines to collect the architect details
                type = reader.nextLine();
                name = reader.nextLine();
                surname = reader.nextLine();
                phoneNum = reader.nextLine();
                email = reader.nextLine();
                address = reader.nextLine();

                // Creates the architect object
                project.createArchitect(type, name, surname, phoneNum, email, address);

                // Reads the lines to collect the customer details
                type = reader.nextLine();
                name = reader.nextLine();
                surname = reader.nextLine();
                phoneNum = reader.nextLine();
                email = reader.nextLine();
                address = reader.nextLine();

                // Creates the contractor object
                project.createContractor(type, name, surname, phoneNum, email, address);

                // Adds the project to the array list.
                projectsList.add(project);
            }

        }catch (Exception e)
        {
            System.out.println("Error in Reading the file");
        }
    }


    /**
     * This method updates the project details
     * @param projectId The id of the project
     */
    public void updateProject(String projectId)
    {
        Scanner input = new Scanner(System.in);
        // Initializes the size of the Arraylist
        int size = projectsList.size();

        for(int i = 0; i < size; i++)
        {
            if(projectId.equals(projectsList.get(i).getProjectNum()))
            {
                // Prompt user for an option
                System.out.println("Please select an option:\n1 - Update the project\n2 - Finalize the project");
                int choice = input.nextInt();

                switch (choice)
                {
                    case 1:
                        System.out.println("What information would you like to update?\n1 - Project Details " +
                                "2 - Customer Details   3 - Architect Details   4 - Contractor Details");
                        int projectChoice = input.nextInt();
                        if(projectChoice == 1)
                        {
                            System.out.println("What detail would you like to edit?\n1 - Project Number " +
                                    "2 - Project Name   3 - Building Type   4 - Project Address\n5 - ERF Number    " +
                                    "6 - Total Project Fee   7 - Amount Paid    8 - Project Deadline");
                            int projectUpdate = input.nextInt();
                            if(projectUpdate == 1)
                            {
                                System.out.println("Please enter new project number");
                                String newNum = input.nextLine();
                                input.nextLine();
                                // Gets the object and updates the project number.
                                projectsList.get(i).updateProjectNum(newNum);
                            }
                            else if(projectUpdate == 2)
                            {
                                System.out.println("Please enter new project name:");
                                String newName = input.nextLine();
                                newName = input.nextLine();
                                // Get the object and updates the Project Name.
                                projectsList.get(i).updateProjectName(newName);
                            }
                            else if(projectUpdate == 3)
                            {
                                System.out.println("Please enter new building type:");
                                String newBuildingType = input.nextLine();
                                input.nextLine();
                                // Get the object and updates the Project Name.
                                projectsList.get(i).updateBuildingType(newBuildingType);
                            }
                            else if(projectUpdate == 4)
                            {
                                System.out.println("Please enter new project address:");
                                String newProjectAddress = input.nextLine();
                                input.nextLine();
                                // Get the object and updates the Project Name.
                                projectsList.get(i).updateBuildingAddress(newProjectAddress);
                            }
                            else if(projectUpdate == 5)
                            {
                                System.out.println("Please enter new ERF Number:");
                                String newERFNumber = input.nextLine();
                                input.nextLine();
                                // Get the object and updates the Project Name.
                                projectsList.get(i).updatERFNum(newERFNumber);
                            }
                            else if(projectUpdate == 6)
                            {
                                System.out.println("Please enter new total project fee:");
                                int newProjectFee = input.nextInt();
                                input.nextLine();
                                // Get the object and updates the Project Name.
                                projectsList.get(i).updateProjectFee(newProjectFee);
                                // Updates the new fee plus the amount paid by the client
                                projectsList.get(i).updateTotalFee();
                            }
                            else if(projectUpdate == 7)
                            {
                                System.out.println("Please enter new amount paid by the client:");
                                int newAmountPaid = input.nextInt();
                                input.nextLine();
                                // Get the object and updates the Project Name.
                                projectsList.get(i).updateAmountPaid(newAmountPaid);
                                // Updates the new fee plus the amount paid by the client
                                projectsList.get(i).updateTotalFee();
                            }
                            else if(projectUpdate == 8)
                            {
                                System.out.println("Please enter a new project deadline:");
                                String newProjectDeadline = input.nextLine();
                                input.nextLine();
                                // Updates the project deadline
                                projectsList.get(i).updateDeadline(newProjectDeadline);
                            }
                        }
                        break;
                    case 2:
                        if(choice == 2)
                        {
                            projectsList.get(i).finalizeProject();
                            System.out.println("Project has been finalized");
                        }
                }
            }
        }
    }

    /**
     * Method to display the information of all the projects in the ArrayList
     */
    public void displayProject()
    {
        // Initializes the size of the Arraylist
        int size = projectsList.size();
        // Loops through each iteration of the Arraylist.
        for(int i = 0; i < size; i++)
        {
            // Project Data
            System.out.println(projectsList.get(i).toString());

            // Customer Data
            System.out.println(projectsList.get(i).getCustomer().toString());

            // Architect Data
            System.out.println(projectsList.get(i).getArchitect().toString());

            // Contractor Data
            System.out.println(projectsList.get(i).getContractor().toString());
        }
    }

    /**
     *  Displays all the incomplete projects from the file
     * @param incomplete takes in the parameter to get the data
     */
    public void diplayIncompleted(String incomplete)
    {
        int size = projectsList.size();

        for(int i = 0; i < size; i++)
        {
            if(incomplete.equals(projectsList.get(i).getFinalized()))
            {
                System.out.println(projectsList.get(i).toString());
            }
            else if(incomplete.equals(projectsList.get(i).getCompletedDate()))
            {
                System.out.println(projectsList.get(i).toString());
            }
        }
    }

    /**
     * This method removes an entry from the ArrayList.
     * @param projectId entered by the user.
     */
    public void removeProject(String projectId)
    {
        // Initializes the size of the Arraylist
        int size = projectsList.size();
        // Loops through each iteration of the Arraylist.
        for(int i = 0; i < size; i++)
        {
            // Removes the project at the index of the id entered by the user.
            if(projectId.equals(projectsList.get(i).getProjectNum()))
            {
                projectsList.remove(i);
                // Displays back to the user
                System.out.println("The entry has been deleted from the records.");
            }
            else
                {
                    System.out.println("Error...Entry not found, Please try again.");
                }
        }
    }
}
