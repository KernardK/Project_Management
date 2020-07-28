import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;

public class Functions {
    private ProjectList datalist;

    public Functions()
    {
        datalist.getInstance();
    }

    /**
     * This method collects the user information for the the project
     * @return the project object
     */
    public static Projects userInput()
    {

        // Project Object

        // User Type Initializing.
        String type = "";
        String finalized = "";
        String completedDate = "";

        // Scanner Object
        Scanner input = new Scanner(System.in);

        // Prompts the user for the projects information.
        System.out.println("Please enter the project number:");
        String projectNum = input.nextLine();

        System.out.println("Please enter the project name:");
        String projectName = input.nextLine();

        System.out.println("Please enter the type of building for the project:");
        String buildingType = input.nextLine();

        System.out.println("Please enter the address where the project will be constructed:");
        String projectAddress = input.nextLine();

        System.out.println("Please enter the ERF number of the project:");
        String erfNum = input.nextLine();

        System.out.println("Please enter the total fee for the project:");
        int totalProjectfee = input.nextInt();

        System.out.println("Please enter the amount paid by the customer for the project:");
        int amountPaid = input.nextInt();

        System.out.println("Please enter the deadline for the project:");
        input.nextLine();
        String projectDeadline = input.nextLine();

        // Creates the project object.
        Projects project = new Projects(projectNum, projectName, buildingType, projectAddress,
                erfNum, totalProjectfee, amountPaid, projectDeadline, finalized, completedDate);

        while(true)
        {

            System.out.println("Please enter the user you'd like to enter:\n1 - Customer\n2 - Architect\n3 - Contractor\n4 - Exit");
            int choice = input.nextInt();
            if (choice != 4) {
                System.out.println("Please enter a name:");
                input.nextLine();
                String name = input.nextLine();

                System.out.println("Please enter surname:");
                String surname = input.nextLine();

                System.out.println("Please enter phone number:");
                String phoneNum = input.nextLine();

                while (!Projects.validPhoneNum(phoneNum)) {
                    System.out.println("Please enter a valid phone number:");
                    phoneNum = input.nextLine();
                }

                System.out.println("Please enter email address:");
                String emailAddress = input.nextLine();
                while (!Projects.validEmailAddress(emailAddress)) {
                    System.out.println("Please enter a valid email address");
                    emailAddress = input.nextLine();
                }

                System.out.println("Please enter physical address:\nPlease use the following format:\n12 new road, fairland, 2101 ");
                String physicalAddress = input.nextLine();

                switch (choice) {
                    case 1:
                        project.createCustomer(type, name, surname, phoneNum, emailAddress, physicalAddress);
                        break;
                    case 2:
                        project.createArchitect(type, name, surname, phoneNum, emailAddress, physicalAddress);
                        break;
                    case 3:
                        project.createContractor(type, name, surname, phoneNum, emailAddress, physicalAddress);

                    default:
                        System.out.println("Error... Please try again");

                }


            } else if (choice == 4) {
                System.out.println("All information has been entered successfully.");
                break;
            }
        }
        return project;
    }
}
