import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Projects {


    private String projectNum;
    private String projectName;
    private String buildingType;
    private String projectAddress;
    private String erfNum;
    private int totalProjectFee;
    private int amountPaid;
    private String projectDeadline;
    private String finalized;
    private String completedDate;

    private Members architect;
    private Members customer;
    private Members contractor;



    /**
     * Creates the Project objects with the information with project details.
     */
    public Projects(String projectNum, String projectName, String buildingType, String projectAddress,
                    String erfNum, int totalProjectFee, int amountPaid, String projectDeadline, String finalized, String completedDate)
    {
        this.projectNum = projectNum;
        this.projectName = projectName;
        this.buildingType = buildingType;
        this.projectAddress = projectAddress;
        this.erfNum = erfNum;
        this.totalProjectFee = totalProjectFee;
        this.amountPaid = amountPaid;
        this.projectDeadline = projectDeadline;
        this.finalized = "Not Finalized";
        this.completedDate = "In Progress";

    }


    /**
     *  Gets the projects number.
     * @return the project number
     */
    public String getProjectNum()
    {
        return projectNum;
    }


    /**
     * Gets the projects name
     * @return the project name
     */
    public String getProjectName() {
        return projectName;
    }


    /**
     * Gets the projects building type
     * @return the type of building
     */
    public String getBuildingType() {
        return buildingType;
    }

    /**
     * Gets the projects buildings address
     * @return the buildings address
     */
    public String getProjectAddress() {
        return projectAddress;
    }

    /**
     * Gets the erf number of the project
     * @return the buildings erf number
     */
    public String getErfNum() {
        return erfNum;
    }

    /**
     * Gets the total cost of the project
     * @return the cost of the project
     */
    public int getTotalProjectFee() {
        return totalProjectFee;
    }

    /**
     * Gets the amount paid for the project to date
     * @return the fees paid for the project to date
     */
    public int getAmountPaid() {
        return amountPaid;
    }

    /**
     * Gets the deadline for the project
     * @return the projects deadline
     */
    public String getProjectDeadline() {
        return projectDeadline;
    }


    /**
     * returns the project status, if the project is finalized or not.
     * @return
     */
    public String getFinalized()
    {
        return finalized;
    }

    public String getCompletedDate()
    {
        return completedDate;
    }


    /**
     * Gets the Architects object
     * @return the architect
     */
    public Members getArchitect() {
        return architect;
    }


    /**
     * Gets the Customer object
     * @return the customer object
     */
    public Members getCustomer() {
        return customer;
    }


    /**
     * Gets the Contractor object
     * @return the contractor objects
     */
    public Members getContractor() {
        return contractor;
    }


    /**
     * Creates the architect for the project by utilizing an object
     * @param type the type of user that was created
     * @param name the name of the user
     * @param surname the surname of the user
     * @param phoneNum the contact number of the user
     * @param emailAddress the email address of the user
     * @param physicalAddress the physical address of the user.
     */
    public void createArchitect(String type, String name, String surname, String phoneNum, String emailAddress,
                                String physicalAddress)
    {
        type = "Architect";
        architect = new Members(type, name, surname, phoneNum, emailAddress, physicalAddress);
    }


    /**
     * Creates the Customer for the project
     * @param type customer type
     * @param name name of the customer
     * @param surname surname of the customer
     * @param phoneNum phone number of customer
     * @param emailAddress email address of the customer
     * @param physicalAddress physical address of the customer
     */
    public void createCustomer(String type, String name, String surname, String phoneNum, String emailAddress,
                               String physicalAddress)
    {
        type = "Customer";
        customer = new Members(type, name, surname, phoneNum, emailAddress, physicalAddress);
    }

    /**
     * Creates the Contractor object
     * @param type contractor type
     * @param name name of the contractor
     * @param surname surname of the contractor
     * @param phoneNum phone number of the contractor
     * @param emailAddress email address of the contractor
     * @param physicalAddress physical address of the contractor
     */
    public void createContractor(String type, String name, String surname, String phoneNum, String emailAddress,
                                 String physicalAddress)
    {
        type = "Contractor";
        contractor = new Members(type, name, surname, phoneNum, emailAddress, physicalAddress);
    }

    /**
     * Updates the project number.
     * @param newProjectNum changes the number of project
     */
    public void updateProjectNum(String newProjectNum)
    {
        projectNum = newProjectNum;
    }


    /**
     * Updates the project name.
     * @param newProjectName changes name of project
     */
    public void updateProjectName(String newProjectName)
    {
        projectName = newProjectName;
    }

    /**
     * Updates the project name.
     * @param newBuildingType changes name of project
     */
    public void updateBuildingType(String newBuildingType)
    {
        buildingType = newBuildingType;
    }

    /**
     * Updates the project name.
     * @param newProjectAddress changes name of project
     */
    public void updateBuildingAddress(String newProjectAddress)
    {
        projectAddress = newProjectAddress;
    }

    /**
     * Updates the project name.
     * @param newErfNumber changes name of project
     */
    public void updatERFNum(String newErfNumber)
    {
        erfNum = newErfNumber;
    }

    /**
     * Updates the project fee
     * @param newProjectFee changes the project fee
     */
    public void updateProjectFee(int newProjectFee)
    {
        totalProjectFee = newProjectFee;
    }

    /**
     * Updates the project name.
     * @param newPayment changes name of project
     */
    public void updateAmountPaid(int newPayment)
    {
        amountPaid += newPayment;
    }

    /**
     * Updates the project name.
     * @return
     */
    public void updateTotalFee()
    {
        totalProjectFee -= amountPaid;
    }

    /**
     * Updates the project name.
     * @param newProjectDeadline changes name of project
     */
    public void updateDeadline(String newProjectDeadline)
    {
        projectName = newProjectDeadline;
    }


    /**
     * Finalizes the project
     */
    public void finalizeProject()
    {
        // Marks task as completed
        finalized = "Finalized";
        // All information about the project should be added to text file. (CompletedProject.txt)
    }

    /**
     * updates the completion date
     * @param updatedCompletionDate
     */
    public void updateCompletedDate(String updatedCompletionDate)
    {
        completedDate = updatedCompletionDate;
    }

    /**
     * Formats the project details to be written to the file
     * @return returns the formatted data
     */
    public String formatProject()
    {
        String data = "";
        data += getProjectNum() + "\n" + getProjectName() + "\n" + getBuildingType() + "\n" + getProjectAddress()
        + "\n" + getErfNum() + "\n" + getTotalProjectFee() + "\n" + getAmountPaid() + "\n" + getProjectDeadline()
        + "\n" + getFinalized() + "\n" + getCompletedDate();

        return data;
    }

    /**
     * Formats the customer details to be written to the file
     * @return returns the formatted data
     */
    public String formatCustomer()
    {
        String data = "";
        data += getCustomer().getType() + "\n" + getCustomer().getName() + "\n" + getCustomer().getSurname()
                + "\n" + getCustomer().getPhoneNum()
                + "\n" + getCustomer().getEmailAddress() + "\n" + getCustomer().getPhysicalAddress();

        return data;
    }

    /**
     * Formats the architect details to be written to the file
     * @return returns the formatted data
     */
    public String formatArchitect()
    {
        String data = "";
        data += getArchitect().getType() + "\n" + getArchitect().getName() + "\n" + getArchitect().getSurname() + "\n"
                + getArchitect().getPhoneNum() + "\n" + getArchitect().getEmailAddress() + "\n"
                + getArchitect().getPhysicalAddress();

        return data;
    }

    /**
     * Formats the contractor details to be written to the file
     * @return return the formatted data
     */
    public String formatContractor()
    {
        String data = "";
        data += getContractor().getType() + "\n" + getContractor().getName() + "\n" + getContractor().getSurname()
                + "\n" + getContractor().getPhoneNum() + "\n" + getContractor().getEmailAddress()
                + "\n" + getContractor().getPhysicalAddress();

        return data;
    }

    /**
     *  This overrides the toString() methods.
     * @return the output of the member classes
     */
    public String toString()
    {
        String output = "Project Number: " + this.getProjectNum();
        output += "\nProject Name: " + this.getProjectName();
        output += "\nBuilding Type: " + this.getBuildingType() ;
        output += "\nBuilding Project Address: " + getProjectAddress() ;
        output += "\nERF Number: " + getErfNum();
        output += "\nTotal Project Cost: " + getTotalProjectFee();
        output += "\nTotal Amount Paid to Date: " + getAmountPaid();
        output += "\nProject Deadline: " + getProjectDeadline();
        output += "\nProject Finalized Status: " + getFinalized();
        output += "\nProject Completion Date: " + getCompletedDate() + "\n";

        return output;
    }

    /**
     * This method checks whether the phone number entered is valid or not.
     * @param Phonenum the number entered by the user
     * @return True or False
     */
    public static  boolean validPhoneNum(String Phonenum)
    {
        // First Try Catch Block utilized
        boolean valid = false;
        try
        {
            if (Phonenum.length() != 10)
            {
                return valid;
            }
            else if (Phonenum.length() == 10)
            {
                valid = true;

            }
        }catch(Exception e)
        {
            System.out.println("Invalid Phone Number Entry");
        }
        return valid;
    }


    /**
     * This method checks i the email address entered is a valid email address with all characters needed for an email
     * @param emailAddress entered by the users
     * @return True or False.
     */
    public static boolean validEmailAddress(String emailAddress)
    {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        boolean validEmail = false;

        // Second try catch block utilized.
        try
        {
            Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
            Matcher match = emailPattern.matcher(emailAddress);
            if (match.find() == true)
            {
                validEmail = true;
                return validEmail;
            }else
            {
                System.out.println("Invalid Email Address Entry");
            }
        }catch (Exception e)
        {
            System.out.println("Please enter a valid email address");
        }
        return validEmail;
    }

}
