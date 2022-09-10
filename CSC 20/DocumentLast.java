/*
Name: First Last
Self-Grade: 100
Date Program Created: 02/14/22
*/

// import date object
import java.util.*;

public class DocumentLast {
    
}


class Document {
    private String content;

    // constructor
    public Document(String text) {
        this.content = text;
    }

    // method to return content variable
    public String getContent() {
        return this.content;
    }

    // method to set the content variable
    public void setContent(String newContent) {
        this.content = newContent;
    }

    // object representation
    public String toString() {
        return String.format("Content: %s\n", this.getContent());
    }

    // this method returns the length of the String content and returns it.
    public int getContentLength() {
        return this.content.length();
    }

    // this method returns true if the instance variable content contains the keyword. 
    public boolean contains(String keyword) {
        return this.content.contains(keyword);
    }

    // this method compares two objects of type Document.returns true if the two Document objects are the same
    // returns false otherwise
    public boolean equals(Document other) {
        return this.content.equalsIgnoreCase(other.getContent());
    }
}


class Email extends Document{
    private String sender, recipient;
    private Date date; //date of the email
    private String subject; // email subject
    private String cc; //list of the people to be copied
    private boolean isSent; //specifies if the email has been sent

    public Email(String text, String sender, String recipient, String subject, String cc) {
        super(text);
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.cc = cc;
        this.date = new Date();
    }

    // this method sets the instance variable isSent to true
    public void send() {
        this.isSent = true;
    }
    
    // public void forward(String recipient, String cc) {
    // }
    

    /*
        GETTER METHODS TO RETURN INSTANCE VARIABLES
    */
    // returns the instance variable isSent
    public boolean getSent() {
        return this.isSent;
    }

    // returns the instance variable sender
    public String getSender() {
        return this.sender;
    }

    // returns the instance variable recipient
    public String getRecipient() {
        return this.recipient;
    }

    // returns the instance variable subject
    public String getSubject() {
        return this.subject;
    }

    // returns the instance variable cc
    public String getCC() {
        return this.cc;
    }

    // returns the Date instance variable
    public Date getDate() {
        return this.date;
    }

    // extra method that returns the instance parent instance variable content
    public String getText() {
        return super.getContent();
    }
    // extra method that returns the document length
    public int getDocumentLength() {
        return super.getContentLength();
    }


    /*
        SETTER METHODS TO SET INSTANCE VARIABLES
    */
    // this method  must check the instance variable isSent if false, then we set sender if true then we dont. 
    public void setSender(String s) {
        if (this.isSent) {
            System.out.println("This email has been sent and the sender cannot be modified.");
        } else {
            this.sender = s;
        }
    }
    // this method  must check the instance variable isSent if false, then we set sender if true then we dont. 
    public void setRecipient(String r) {
        if (this.isSent) {
            System.out.println("This email has been sent and the recipient cannot be modified.");
        } else {
            this.recipient = r;
        }
    }
    // this method  must check the instance variable isSent if false, then we set sender if true then we dont. 
    public void setSubject(String s) {
        if (this.isSent) {
            System.out.println("This email has been sent and the subject cannot be modified.");
        } else {
            this.subject = s;
        }
    }
    // this method  must check the instance variable isSent if false, then we set sender if true then we dont. 
    public void setCC(String cc) {
        if (this.isSent) {
            System.out.println("This email has been sent and the CC's cannot be modified.");
        } else {
            this.cc = cc;
        }
    }
    /* 
    this method must check the instance variable isSent. 
    if it is false that means the email has not been sent yet and the content can be modified.
    */ 
    public void modifyContent(String newText) {
        if (this.isSent) {
            System.out.println("This email has been sent and the content cannot be modified.");
        } else {
            super.setContent(newText);
        }
    }


    /*
        OBJECT REPRESENTATION
    */
    // this method creates a String representing the Email object.
    public String toString() {
        return String.format("Sender: %s\nRecipient: %s\nCC: %s\nSubject: %s\nDate: %s\n%s", this.getSender(), this.getRecipient(), this.getCC(), this.getSubject(), this.getDate(), super.toString());
    }

    
    // this method is going to forward an email that was previously sent to the new recipients and cc
    public Email forward(String rec, String sender, String cc) {
        // create email object to send
        Email f = new Email(this.getText(), sender, rec, this.subject, cc);
        f.date = new Date();
        f.isSent = true;
        return f;

    }
}


class EmailDriver {
    // public Email(String text, String sender,String recipiant, String subject, String cc)
    public static void main(String[] args) {
        //creating an Email object
        Email e1 = new Email("Hello everyone, we will have a meeting tomorrow at 10", "Gita Faroughi","Alex","Meeting","");
        
        // sending the email
        // 1. send the email e1
        e1.send();
        
        // display the details about the email
        System.out.println(e1);
        System.out.println("\n\n");
        
        // searching the email for the email for the word tomorrow
        boolean b = e1.contains("tomorrow");
        if (b) {
           System.out.println("The word tomorrow was found in the email");

        }
        else {
           System.out.println("The word tomorrow was not found in the email"); 
        }
           
      
        // displaying just the content(text) of the email
        System.out.println("\nThe content of this email is: " + e1.getText());
        System.out.println();
        //modifying the content of the email
        e1.modifyContent("bye");
        
        // changing the recipient of the e1 email
        // 3. all the setter methods on the email e1
        e1.setRecipient("Jose@yahoo.com,Mary@gmail.com");
        System.out.println();
        
        // forwarding the email
        // 4. forward the email e1
        Email forward = e1.forward("Alex", "Gita" ,"Maria");
        System.out.println();
        
        // printing the forwarded email
        // 5. display the email e1 or forward object showing it was sent
        System.out.println("forwarded message\n"+ forward);
        System.out.println();
        
        // display the length of the text in the email
        System.out.println("The number of the letters in the email is: " + e1.getDocumentLength());
        
        // ***********************************************************************
        // your turn, refer to the provided documnet on the codes you need to write

        // create object 2
        System.out.println("\n\n\n");
        Email e2 = new Email("Hello everyone welcome to CSC 20 for this semester", "Junior Mendoza", "Herky TheHornet", "Schedule", "");

        // 6. forward the email e1
        e2.forward("Professor Richter", "Jon Jones", "Gita");
        // 7. call the setter methods on the email e2
        e2.setSubject("Important Topic! Open Immediately");
        e2.setContent("Here is the assignment you were needing for today!");
        // 8. modify the content on the email e2
        e2.modifyContent("Whoops! I sent the wrong file. The correct one is attached. ");
        // 9. call the method getDocumentLength on the email e2
        System.out.printf("The number of letters in email 2 is: %d\n", e2.getDocumentLength());
        // 10. call the method contains on the email e2 with the word of your choice. 
        boolean wordCheck = e2.contains("hello");
        // 11. send the email e2
        e2.send();
        // 12. display the email e2
        System.out.println(e2);
    }
}