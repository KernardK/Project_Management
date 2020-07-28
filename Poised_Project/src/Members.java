public class Members {

    private String type;
    private String name;
    private String surname;
    private String phoneNum;
    private String emailAddress;
    private String physicalAddress;


    /**
     *  This creates an object of the Member
     * @param type the occupation of the Member (Architect, Contractor or Customer).
     * @param name the name of the Member.
     * @param surname the surname of the Member.
     * @param phoneNum the phone number of the Member
     * @param emailAddress the email address of the Member.
     * @param physicalAddress the physical address of the Member.
     */
    public Members(String type, String name, String surname, String phoneNum, String emailAddress, String physicalAddress)
    {
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.phoneNum = phoneNum;
        this.emailAddress = emailAddress;
        this.physicalAddress = physicalAddress;
    }


    /**
     * This gets the title of the Member
     * @return the title
     */
    public String getType()
    {
        return type;
    }

    /**
     * This gets the name of the Member
     * @return the Name
     */
    public String getName()
    {
        return name;
    }

    /**
     *  This gets the Surname of the Member
     * @return the Surname
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * This gets the phone number of the Member
     * @return the Phone Number.
     */
    public String getPhoneNum()
    {
        return phoneNum;
    }

    /**
     * This gets the email address of the Member.
     * @return the Email Address
     */
    public String getEmailAddress()
    {
        return emailAddress;
    }

    /**
     * This gets the physical address of the Member.
     * @return the Physical Address.
     */
    public String getPhysicalAddress()
    {
        return physicalAddress;
    }


    /**
     * This updates the members name
     * @param newName new name for the member
     */
    public void updateName(String newName)
    {
        name = newName;
    }

    /**
     * This updates the members surname
     * @param newSurname new surname of the member
     */
    public void updateSurname(String newSurname)
    {
        surname = newSurname;
    }


    /**
     *  This updates the members phone number.
     * @param newPhoneNum the phone number entered
     */
    public void updatePhoneNumber(String newPhoneNum)
    {
        phoneNum = newPhoneNum;
    }


    /**
     * This updates the members email address.
     * @param newEmailAddress
     */
    public void updateEmail(String newEmailAddress)
    {
        emailAddress = newEmailAddress;
    }

    /**
     * This updates the members physical address
     * @param newPhysicalAddress
     */
    public void updatePhysicalAddress(String newPhysicalAddress)
    {
        physicalAddress = newPhysicalAddress;
    }

    /**
     *  This overrides the toString() methods.
     * @return the output of the member classes
     */
    public String toString()
    {
        String display = "Title: " + this.getType();
        display += "\nName: " + this.getName();
        display += "\nSurname: " + this.getSurname();
        display += "\nTelephone Number: " + this.getPhoneNum();
        display += "\nEmail Address: " + this.getEmailAddress();
        display += "\nPhysical Address: " + this.getPhysicalAddress() + "\n";

        return display;
    }
}
