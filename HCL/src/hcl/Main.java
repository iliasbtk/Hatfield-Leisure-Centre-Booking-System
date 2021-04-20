/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author NGSI
 */
public class Main{

    public static void main(String[] args) { 
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
                
                /*
                Frames
                */
                
                MainFrame app = new MainFrame("Hatfield Leisure Centre");
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setVisible(true);
                
                //Administration
                
                MainFrame adminFrame = new MainFrame("Hatfield Leisure Centre");
                MainFrame reportsFrame = new MainFrame("Hatfield Leisure Centre");
                reportsFrame.setLayout(new BorderLayout());
                MainFrame addLessonFrame = new MainFrame("Hatfield Leisure Centre");
                //Coach 
                
                MainFrame coachFrame = new MainFrame("Hatfield Leisure Centre");
                MainFrame registerCoachFrame = new MainFrame("Hatfield Leisure Centre");
                MainFrame addExpAreaFrame = new MainFrame("Hatfield Leisure Centre");

                //Student
                MainFrame studentFrame = new MainFrame("Hatfield Leisure Centre"); 
                MainFrame registerStudentFrame = new MainFrame("Hatfield Leisure Centre"); 
                MainFrame lookupLessonFrame = new MainFrame("Hatfield Leisure Centre"); 
                MainFrame bookLessonFrame = new MainFrame("Hatfield Leisure Centre"); 
                MainFrame cancelChangeFrame = new MainFrame("Hatfield Leisure Centre"); 
                MainFrame attendFrame = new MainFrame("Hatfield Leisure Centre"); 

                /*
                app frame componenets
                */
                JPanel mainPanel = new JPanel ();                               
                mainPanel.setLayout (new BoxLayout (mainPanel, BoxLayout.X_AXIS));
                
                JButton buttonCoach = new JButton("I am a Coach"); 
                buttonCoach.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        coachFrame.setVisible(true);
                    }
                });
                JButton buttonStudent = new JButton("I am a Student");
                buttonStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        studentFrame.setVisible(true);
                    }
                });
                JButton buttonAdmin = new JButton("HCL Administration");
                buttonAdmin.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        adminFrame.setVisible(true);
                    }
                });
                mainPanel.add (buttonCoach);                        
                mainPanel.add (buttonStudent);
                mainPanel.add (buttonAdmin);
                app.add(mainPanel, BorderLayout.CENTER);
                
                /*
                Coach frame componenets
                */
                JPanel coachPanel = new JPanel();
                coachPanel.setLayout(new BoxLayout(coachPanel, BoxLayout.Y_AXIS));
                
                JButton buttonNewCoach = new JButton("Register a New Coach"); 
                buttonNewCoach.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registerCoachFrame.setVisible(true);
                    }
                });
                JButton buttonAddArea = new JButton("Add an expertise area");
                buttonAddArea.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addExpAreaFrame.setVisible(true);
                    }
                });
                coachPanel.add (buttonNewCoach);                        
                coachPanel.add (buttonAddArea);                
                coachFrame.add(coachPanel, BorderLayout.CENTER);
                
                /*
                Register Coach frame componenets
                */
                JPanel registerCoachPanel = new JPanel();
                registerCoachPanel.setLayout(new BoxLayout(registerCoachPanel, BoxLayout.Y_AXIS));

                JLabel fName = new JLabel("Enter your first name:");
                JTextField FNameT = new JTextField(25);
                JLabel lName = new JLabel("Enter your last name:");
                JTextField lNameT = new JTextField(25);
                JLabel tel = new JLabel("Enter your telephone number:");
                JTextField telT = new JTextField(25);
                JLabel officeDay = new JLabel("Enter your office day:");
                JTextField officeDayT = new JTextField(25);
                JLabel officeTime = new JLabel("Enter your office hour:");
                JTextField officeTimeT = new JTextField(25);
                registerCoachPanel.add(fName);
                registerCoachPanel.add(FNameT);
                registerCoachPanel.add(lName);
                registerCoachPanel.add(lNameT);
                registerCoachPanel.add(tel);
                registerCoachPanel.add(telT);
                registerCoachPanel.add(officeDay);
                registerCoachPanel.add(officeDayT);
                registerCoachPanel.add(officeTime);
                registerCoachPanel.add(officeTimeT);

                JButton registerCoachButton = new JButton("Register Coach");
                registerCoachButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = hcl.registerCoach(FNameT.getText(), lNameT.getText(), telT.getText(), officeDayT.getText(), officeTimeT.getText());
                        if(id.equals("Error")){
                            JOptionPane.showMessageDialog(null,
                                "Empty Fileds",
                                "Coach Registration",
                                JOptionPane.ERROR_MESSAGE);
                        }else if(id==""){
                            JOptionPane.showMessageDialog(null,
                                    "The Coach: " + FNameT.getText() + " " + lNameT.getText() + " is already registered",
                                    "Coach Registration",
                                    JOptionPane.ERROR_MESSAGE);
                            FNameT.setText("");
                            lNameT.setText("");
                            telT.setText("");
                            officeDayT.setText("");
                            officeTimeT.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "The Coach: " + FNameT.getText() + " " + lNameT.getText() + " is succefully created with Id: " + id,
                                    "Coach Registration",
                                    JOptionPane.ERROR_MESSAGE);
                            registerCoachFrame.setVisible(false);
                            FNameT.setText("");
                            lNameT.setText("");
                            telT.setText("");
                            officeDayT.setText("");
                            officeTimeT.setText("");
                        }
                    }
                });
                JButton CancelCoachButton = new JButton("Cancel");
                CancelCoachButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FNameT.setText("");
                        lNameT.setText("");
                        telT.setText("");
                        officeDayT.setText("");
                        officeTimeT.setText("");
                        registerCoachFrame.setVisible(false); 
                    }
                });
                JPanel groupPanel = new JPanel();
                groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
                groupPanel.add(registerCoachButton);
                groupPanel.add(CancelCoachButton);
                registerCoachFrame.add(registerCoachPanel, BorderLayout.CENTER);
                registerCoachFrame.add(groupPanel, BorderLayout.SOUTH);
                /*
                addExpAreaFrame components
                */
                JPanel areaPanel = new JPanel();
                areaPanel.setLayout(new BoxLayout(areaPanel, BoxLayout.Y_AXIS));
                
                JLabel label2 = new JLabel("Add an expertise area:");
                reportsFrame.add(label2, BorderLayout.NORTH);
                
                JLabel fCaochId = new JLabel("Enter the coach ID:");
                JTextField fCaochIdT = new JTextField(25);
                
                JCheckBox area1 = new JCheckBox("swimming");
                JCheckBox area2 = new JCheckBox("badminton");
                JCheckBox area3 = new JCheckBox("gymnastics");

                JButton addAreaButton = new JButton("Add");
                addAreaButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!(area1.isSelected() || area2.isSelected() || area3.isSelected())){
                            JOptionPane.showMessageDialog(null,
                                "Empty Fileds",
                                "Add Expertise Area",
                                JOptionPane.ERROR_MESSAGE);
                        }else{
                            String successMessage ="";
                            Coach coach = hcl.coaches.get(fCaochIdT.getText());
                            if(area1.isSelected()){
                                coach.addArea("swimming");
                                successMessage += ", swimming";
                            }
                            if(area2.isSelected()){
                                coach.addArea("badminton");
                                successMessage += ", badminton";
                            }
                            if(area3.isSelected()){
                                coach.addArea("gymnastics");
                                successMessage += ", gymnastics";
                            }
                            JOptionPane.showMessageDialog(null,
                                "The expertise areas: "+successMessage+" succesfully added to the coach: "+coach.getFullName(),
                                "Add Expertise Area",
                                JOptionPane.ERROR_MESSAGE);
                            addExpAreaFrame.setVisible(false);
                            fCaochIdT.setText("");
                        }
                    }
                });
                JButton cancelAreaButton = new JButton("Cancel");
                cancelAreaButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addExpAreaFrame.setVisible(false);
                        fCaochIdT.setText(""); 
                    }
                });
                
                
                areaPanel.add(fCaochId);
                areaPanel.add(fCaochIdT);
                areaPanel.add(area1);
                areaPanel.add(area2);
                areaPanel.add(area3);
                JPanel groupPanel2 = new JPanel();
                groupPanel2.setLayout(new BoxLayout(groupPanel2, BoxLayout.Y_AXIS));
                groupPanel2.add(addAreaButton);
                groupPanel2.add(cancelAreaButton);
                
                addExpAreaFrame.add(groupPanel2, BorderLayout.SOUTH);
                addExpAreaFrame.add(areaPanel, BorderLayout.CENTER);
                
                
                
                
                 /*
                Admin frame componenets
                */
                JPanel adminPanel = new JPanel();
                adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));
                
                JButton buttonNewLesson = new JButton("Add a New Lesson"); 
                buttonNewLesson.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addLessonFrame.setVisible(true);
                        
                    }
                });
                JButton buttonReporting = new JButton("Reports");
                buttonReporting.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        reportsFrame.setVisible(true);
                        
                    }
                });
                adminPanel.add (buttonNewLesson);                        
                adminPanel.add (buttonReporting);                
                adminFrame.add(adminPanel, BorderLayout.CENTER);
                
                /*
                Reports frame componenets
                */
                JTextPane report = new JTextPane();
                report.setEditable(false);
                reportsFrame.add(new JScrollPane(report), BorderLayout.CENTER);

                JLabel label1 = new JLabel("Report Name");
                reportsFrame.add(label1, BorderLayout.NORTH);
                
                JButton buttonReport1 = new JButton("Report 1");
                JButton buttonReport2 = new JButton("Report 2");
                JButton buttonDisplayCoaches = new JButton("Display Coaches");
                buttonDisplayCoaches.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       report.setText(hcl.displayCoaches()); 
                    }
                });
                JButton buttonDisplayLessons = new JButton("Display Lessons");
                buttonDisplayLessons.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       report.setText(hcl.displayLessons());     
                    }
                });
                JButton buttonDisplayBookings = new JButton("Display Bookings");
                buttonDisplayBookings.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       report.setText(hcl.displayBookings()); 
                    }
                });
                
                JPanel reportPanel = new JPanel();                            
                reportPanel.setLayout(new BoxLayout(reportPanel, BoxLayout.Y_AXIS));  
                reportsFrame.add(reportPanel, BorderLayout.EAST);

                reportPanel.add(buttonReport1);
                reportPanel.add(buttonReport2);
                reportPanel.add(buttonDisplayCoaches);   
                reportPanel.add(buttonDisplayLessons);   
                reportPanel.add(buttonDisplayBookings);   
                
                /*
                addLessonFrame componenets
                */
                JPanel addLessonPanel = new JPanel();
                addLessonPanel.setLayout(new BoxLayout(addLessonPanel, BoxLayout.Y_AXIS));
//                String name, String place, Coach coach, String day, String hour, String area, Integer capacity
                JLabel lessonName = new JLabel("Enter Lesson name:");
                JTextField lessonNameT = new JTextField(25);
                JLabel location = new JLabel("Enter Location");
                JTextField locationT = new JTextField(25);
                JLabel coachId = new JLabel("Enter Coach Id");
                JTextField coachIdT = new JTextField(25);
                JLabel day = new JLabel("Enter day:");
                JTextField dayT = new JTextField(25);
                JLabel time = new JLabel("Enter time:");
                JTextField timeT = new JTextField(25);
                
                JLabel area = new JLabel("Enter Area");
                JRadioButton radioButton1 = new JRadioButton("Area1");
                JRadioButton radioButton2 = new JRadioButton("Area2");
                JRadioButton radioButton3 = new JRadioButton("Area3");
                JRadioButton radioButton4 = new JRadioButton("Area4");
                JRadioButton radioButton5 = new JRadioButton("Area5");
                ButtonGroup group = new ButtonGroup();
                group.add(radioButton1);
                group.add(radioButton2);
                group.add(radioButton3);
                group.add(radioButton4);
                group.add(radioButton5);
                
                JPanel radioPanel = new JPanel();
                radioPanel.setLayout(new GridLayout(0, 1));
                radioPanel.add(radioButton1);
                radioPanel.add(radioButton2);
                radioPanel.add(radioButton3);
                radioPanel.add(radioButton4);
                radioPanel.add(radioButton5);
                
                JLabel capacity = new JLabel("Enter Lesson Capacity:");
                JTextField capacityT = new JTextField(25);
                
                addLessonPanel.add(lessonName);
                addLessonPanel.add(lessonNameT);
                addLessonPanel.add(location);
                addLessonPanel.add(locationT);
                addLessonPanel.add(coachId);
                addLessonPanel.add(coachIdT);
                addLessonPanel.add(day);
                addLessonPanel.add(dayT);
                addLessonPanel.add(time);
                addLessonPanel.add(timeT);
                addLessonPanel.add(area);
                addLessonPanel.add(radioPanel);
                addLessonPanel.add(capacity);
                addLessonPanel.add(capacityT);
                
                JButton addLessonButton = new JButton("Add");
                
                addLessonFrame.add(addLessonPanel, BorderLayout.CENTER);
                addLessonFrame.add(addLessonButton, BorderLayout.SOUTH);
               
                /*
                Student frame components
                */
                JPanel studentPanel = new JPanel();
                studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
                JButton buttonNewStudent = new JButton("Register a New Student"); 
                buttonNewStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registerStudentFrame.setVisible(true);
                    }
                });
                JButton buttonLookupLesson = new JButton("Lookup Lesson");
                buttonLookupLesson.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        lookupLessonFrame.setVisible(true);
                    }
                });
                JButton buttonBookLesson = new JButton("Book a Lesson");
                buttonBookLesson.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bookLessonFrame.setVisible(true);
                    }
                });
                JButton buttonCancelChange = new JButton("Cancel/Change");
                buttonCancelChange.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cancelChangeFrame.setVisible(true);
                    }
                });
                JButton buttonAttend = new JButton("Attend a Lesson");
                buttonAttend.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        attendFrame.setVisible(true);
                    }
                });
                
                studentPanel.add(buttonNewStudent);
                studentPanel.add(buttonLookupLesson);
                studentPanel.add(buttonBookLesson);   
                studentPanel.add(buttonCancelChange);   
                studentPanel.add(buttonAttend);  
                studentFrame.add(studentPanel, BorderLayout.CENTER);
                

                /*
                registerStudentFrame componenets
                */
                JPanel registerStudentPanel = new JPanel();
                registerStudentPanel.setLayout(new BoxLayout(registerStudentPanel, BoxLayout.Y_AXIS));

                JLabel sFirstName = new JLabel("Enter your first name:");
                JTextField sFirstNameT = new JTextField(25);
                JLabel sLastName = new JLabel("Enter your last name:");
                JTextField sLastNameT = new JTextField(25);
                JLabel sAddress = new JLabel("Enter your address:");
                JTextField sAddressT = new JTextField(25);
                JLabel sTel = new JLabel("Enter your telephone number:");
                JTextField sTelT = new JTextField(25);
                JLabel parentName = new JLabel("Enter your parent name");
                JTextField parentNameT = new JTextField(25);
                
                registerStudentPanel.add(sFirstName);
                registerStudentPanel.add(sFirstNameT);
                registerStudentPanel.add(sLastName);
                registerStudentPanel.add(sLastNameT);
                registerStudentPanel.add(sAddress);
                registerStudentPanel.add(sAddressT);
                registerStudentPanel.add(sTel);
                registerStudentPanel.add(sTelT);
                registerStudentPanel.add(parentName);
                registerStudentPanel.add(parentNameT);
                        
                JButton registerStudentButton = new JButton("Register Student");
                registerStudentButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = hcl.registerStudent(sFirstNameT.getText(), sLastNameT.getText(), sAddressT.getText(), sTelT.getText(), parentNameT.getText());
                        if(id.equals("Error")){
                            JOptionPane.showMessageDialog(null,
                                "Empty Fileds",
                                "Student Registration",
                                JOptionPane.ERROR_MESSAGE);
                        }else if(id==""){
                            JOptionPane.showMessageDialog(null,
                                    "The Student: " + sFirstNameT.getText() + " " + sLastNameT.getText() + " is already registered",
                                    "Student Registration",
                                    JOptionPane.ERROR_MESSAGE);
                            sFirstNameT.setText("");
                            sLastNameT.setText("");
                            sAddressT.setText("");
                            sTelT.setText("");
                            parentNameT.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null,
                                    "The Student: " + sFirstNameT.getText() + " " + sLastNameT.getText() + " is succefully created with Id: " + id,
                                    "Student Registration",
                                    JOptionPane.ERROR_MESSAGE);
                            registerStudentFrame.setVisible(false);
                            sFirstNameT.setText("");
                            sLastNameT.setText("");
                            sAddressT.setText("");
                            sTelT.setText("");
                            parentNameT.setText("");
                        }
                    }
                });
                JButton cancelSRegButton = new JButton("Cancel");
                cancelSRegButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registerStudentFrame.setVisible(false);
                        sFirstNameT.setText("");
                        sLastNameT.setText("");
                        sAddressT.setText("");
                        sTelT.setText("");
                        parentNameT.setText(""); 
                    }
                });
                JPanel groupPanel3 = new JPanel();
                groupPanel3.setLayout(new BoxLayout(groupPanel3, BoxLayout.Y_AXIS));
                groupPanel3.add(registerStudentButton);
                groupPanel3.add(cancelSRegButton);
                
                registerStudentFrame.add(registerStudentPanel, BorderLayout.CENTER);
                registerStudentFrame.add(groupPanel3, BorderLayout.SOUTH);
                
                /*
                lookupLessonFrame
                */  
                JPanel lookupLessonPanel = new JPanel();
                JTextPane lookupLessonResult = new JTextPane();
                lookupLessonResult.setEditable(false);
                lookupLessonFrame.add(new JScrollPane(lookupLessonResult), BorderLayout.CENTER);

                JLabel label3 = new JLabel("Lookup Lessons:");
                lookupLessonFrame.add(label1, BorderLayout.NORTH);
                
                JLabel lookupCoach = new JLabel("Enter a coach Id:");
                JTextField lookupCoachT = new JTextField(25);
                
                JButton lookupByArea = new JButton("Lookup by Area");
                JButton lookupByCoach = new JButton("Lookup by Coach");
                                         
                lookupLessonPanel.setLayout(new BoxLayout(lookupLessonPanel, BoxLayout.Y_AXIS));  
                lookupLessonFrame.add(lookupLessonPanel, BorderLayout.EAST);

                lookupLessonPanel.add(lookupCoach);
                lookupLessonPanel.add(lookupCoachT);
                lookupLessonPanel.add(lookupByCoach);   
                lookupLessonPanel.add(radioPanel);   
                lookupLessonPanel.add(lookupByArea);  
                
                /*
                bookLessonFrame
                */
                JPanel bookLessonPanel = new JPanel();
                bookLessonPanel.setLayout(new BoxLayout(bookLessonPanel, BoxLayout.Y_AXIS));

                JLabel sId = new JLabel("Enter your Student Id:");
                JTextField sIdT = new JTextField(25);
                JLabel lessonId = new JLabel("Enter the lesson Id:");
                JTextField lessonIdT = new JTextField(25);

                
                bookLessonPanel.add(sId);
                bookLessonPanel.add(sIdT);
                bookLessonPanel.add(lessonId);
                bookLessonPanel.add(lessonIdT);
                        
                JButton bookLessonButton = new JButton("Book");
                bookLessonButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hcl.book(sIdT.getText(), lessonIdT.getText());
                        bookLessonFrame.setVisible(false);                        
                    }
                });
                bookLessonFrame.add(bookLessonPanel, BorderLayout.CENTER);
                bookLessonFrame.add(bookLessonButton, BorderLayout.SOUTH);
                /*
                cancelChangeFrame
                */
                JPanel cancelChangePanel = new JPanel();
                cancelChangePanel.setLayout(new BoxLayout(cancelChangePanel, BoxLayout.Y_AXIS));
                JLabel bNum = new JLabel("Enter your booking number:");
                JTextField bNumT = new JTextField(25);
                JLabel bNum2 = new JLabel("Enter your booking number:");
                JTextField bNumT2 = new JTextField(25);
                JLabel lessonId2 = new JLabel("Enter the new lesson Id:");
                JTextField lessonIdT2 = new JTextField(25);
                
                JButton CancelButton = new JButton("Cancel Booking");
                CancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hcl.cancelBooking(bNumT.getText());
                        bookLessonFrame.setVisible(false);                        
                    }
                });
                JButton ChangeButton = new JButton("Change Booking");
                ChangeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hcl.changeBooking(bNumT2.getText(), lessonIdT2.getText());
                        bookLessonFrame.setVisible(false);                        
                    }
                });
                
                cancelChangePanel.add(bNum);
                cancelChangePanel.add(bNumT);
                cancelChangePanel.add(CancelButton);
                cancelChangePanel.add(bNum2);
                cancelChangePanel.add(bNumT2);
                cancelChangePanel.add(lessonId2);
                cancelChangePanel.add(lessonIdT2);
                cancelChangePanel.add(ChangeButton);
                
                cancelChangeFrame.add(cancelChangePanel, BorderLayout.CENTER);
                /*
                attendFrame
                */
                JPanel attendPanel = new JPanel();
                attendPanel.setLayout(new BoxLayout(attendPanel, BoxLayout.Y_AXIS));
                JLabel bNum3 = new JLabel("Enter your booking number:");
                JTextField bNumT3 = new JTextField(25);
                JButton attendButton = new JButton("Attend");
                attendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hcl.attendLesson(bNumT3.getText());
                        attendFrame.setVisible(false);                        
                    }
                });
                attendPanel.add(bNum3);
                attendPanel.add(bNumT3);
                attendPanel.add(attendButton);
                attendFrame.add(attendPanel, BorderLayout.CENTER);
                
                
            }

            
        });
        
        
//        Main frame1 = new Main();
//        
//        
//        JFrame jFrame = new JFrame("Hatfield Leisure Centre");
//        jFrame.setSize(800, 800);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jFrame.setLayout (new BorderLayout ());
//        
//        JLabel label = new JLabel ("Select");
//        jFrame.add (label, BorderLayout.NORTH);
//        
//        JPanel panel = new JPanel ();                               
//        panel.setLayout (new BoxLayout (panel, BoxLayout.X_AXIS));  
//        JButton buttonCoach = new JButton("I am a Coach"); 
//        JButton buttonStudent = new JButton("I am a Student");
//        panel.add (buttonCoach);                        
//        panel.add (buttonStudent);
//        
//        jFrame.add(panel, BorderLayout.CENTER);
//
//
//       
//        
//        jFrame.setVisible(true);
//        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
////        hatfieldLeisureCentre.setVisible(true);
//        JFrame jFrameCoach = new JFrame("Hatfield Leisure Centre");
//
//        jFrameCoach.setSize(400, 400);
//        jFrameCoach.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        jFrameCoach.setLayout (new BorderLayout ());
//        jFrameCoach.add(coachRegisterForm(), BorderLayout.CENTER);
            
//        HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();
//        
//        // Coach class instances
//    
//        Coach coach1 = new Coach("Serita",  "Tuck",  "tel", "16:00 - 17:00", "Mon");
//        Coach coach2 = new Coach("Cyndy" ,  "Cerrato",  "tel", "16:00 - 17:00", "Tue");
//        Coach coach3 = new Coach("Annamae" ,  "Koski",  "tel", "16:00 - 17:00", "Wed");
//        Coach coach4 = new Coach("Sari" ,  "Stlaurent",  "tel", "16:00 - 17:00", "Thu");
//        Coach coach5 = new Coach("Desire" ,  "Royalty",  "tel", "16:00 - 17:00", "Fri");
//        Coach coach6 = new Coach("Ronny" ,  "Eriksen",  "tel", "15:00 - 16:00", "Tue");
//        Coach coach7 = new Coach("Steward" ,  "Denver",  "tel", "15:00 - 16:00", "Wed");
//        
//        // Register new coaches
//       
//        hcl.addCoach(coach1);
//        hcl.addCoach(coach2);
//        hcl.addCoach(coach3);
//        hcl.addCoach(coach4);
//        hcl.addCoach(coach5);
//        hcl.addCoach(coach6);
//        hcl.addCoach(coach7);
//        
//        hcl.displayCoaches();
//        
//      
//        // Adding expertise area to the coaches
//        
//        coach1.addArea("swimming");
//        coach1.addArea("badminton");
//        coach1.addArea("gymnastics");
//        coach2.addArea("swimming");
//        coach2.addArea("badminton");
//        coach3.addArea("gymnastics");
//        coach4.addArea("swimming");
//        coach4.addArea("badminton");
//        coach4.addArea("gymnastics");
//        coach5.addArea("badminton");
//        coach5.addArea("gymnastics");
//        coach6.addArea("swimming");
//        coach7.addArea("swimming");
//        coach7.addArea("badminton");
//        coach7.addArea("gymnastics");
//        
//        // Student class instances
//        
//        Student student1 = new Student ("Loida", "Poon", "", "Brad");
//        Student student2 = new Student ("Ewa", "Porto", "", "Linkon");
//        Student student3 = new Student ("Dylan ", "Bucher", "", "Jimmy");
//        Student student4 = new Student ("Reggie ", "Malan", "", "Smith");
//        Student student5 = new Student ("Landon ", "Buel", "", "Henderson");
//        Student student6 = new Student ("Enid ", "Lepine", "", "Eriksen");
//        Student student7 = new Student ("Aiko ", "Redmon", "", "Marco");
//        Student student8 = new Student ("Earl ", "Evatt", "", "Lucas");
//        Student student9 = new Student ("Annita ", "Bruckner", "", "Sergio");
//        Student student10 = new Student ("Emilee ", "Lubin", "", "Dani");
//        Student student11 = new Student ("Estell ", "Dillenbeck", "", "Ferland");
//        Student student12 = new Student ("Charleen ", "Boss", "", "Toni");
//        Student student13 = new Student ("Chadwick ", "Fiscus", "", "Fede");
//        Student student14 = new Student ("Steven", "Pullman", "", "Nacho");
//        Student student15 = new Student ("Elizabeth", "Simpson", "", "Fernandez");
//       
//        // Register new students
//        
//        hcl.registerStudent(student1);
//        hcl.registerStudent(student2);
//        hcl.registerStudent(student3);
//        hcl.registerStudent(student4);
//        hcl.registerStudent(student5);
//        hcl.registerStudent(student6);
//        hcl.registerStudent(student7);
//        hcl.registerStudent(student8);
//        hcl.registerStudent(student9);
//        hcl.registerStudent(student10);
//        hcl.registerStudent(student11);
//        hcl.registerStudent(student12);
//        hcl.registerStudent(student13);
//        hcl.registerStudent(student14);
//        hcl.registerStudent(student15);
//        
//        
//    
//   
//        
//       hcl.addLesson(new Lesson("Swimming 1", "swimming pool A",coach1, "Mon", "16:00 - 17:00", "swimming", 5));
//       hcl.addLesson(new Lesson("Badminton 1","badminton court A",coach1, "Tue", "14:00 - 15:00", "badminton", 5));
//       hcl.addLesson(new Lesson("Gymnastics 1","Gym",coach1, "Wed", "14:00 - 15:00", "gymnastics", 5));
//       hcl.addLesson(new Lesson("Swimming 1","swimming pool A",coach1, "Thu", "14:00 - 15:00", "swimming", 5));
//       hcl.addLesson(new Lesson("Swimming 1","swimming pool A",coach2, "Fri", "14:00 - 15:00", "swimming", 5));
//       hcl.addLesson(new Lesson("Badminton 1","badminton court A",coach2, "Mon", "14:00 - 15:00", "badminton", 5));
//       hcl.addLesson(new Lesson("Gymnastics 1","Gym",coach3, "Mon", "17:00 - 18:00", "gymnastics", 5));
//       hcl.addLesson(new Lesson("Gymnastics 1","Gym",coach3, "Tue", "17:00 - 18:00", "gymnastics", 5));
//       hcl.addLesson(new Lesson("Gymnastics 2","Gym",coach3, "Wed", "17:00 - 18:00", "gymnastics", 5));
//       hcl.addLesson(new Lesson("Swimming 1","swimming pool A",coach4, "Thu", "17:00 - 18:00", "swimming", 5));
//       hcl.addLesson(new Lesson("Gymnastics 2","Gym",coach4, "Fri", "17:00 - 18:00", "gymnastics", 5));
//       hcl.addLesson(new Lesson("Gymnastics 2","Gym",coach4, "Wed", "17:00 - 18:00", "gymnastics", 5));
//       hcl.addLesson(new Lesson("Badminton 2","badminton court B",coach5, "Mon", "19:00 - 20:00", "badminton", 5));
//       hcl.addLesson(new Lesson("Badminton 2","badminton court B",coach5, "Tue", "19:00 - 20:00", "badminton", 5));
//       hcl.addLesson(new Lesson("Gymnastics 3","Gym",coach5, "Wed", "19:00 - 20:00", "gymnastics", 5));
//       hcl.addLesson(new Lesson("Swimming 1","swimming pool B",coach6, "Thu", "19:00 - 20:00", "swimming", 5));
//       hcl.addLesson(new Lesson("Swimming 2","swimming pool B",coach7, "Fri", "19:00 - 20:00", "swimming", 5));
//       hcl.addLesson(new Lesson("Swimming 2","swimming pool B",coach6, "Tue", "19:00 - 20:00", "swimming", 5));
//       hcl.addLesson(new Lesson("Swimming 2","swimming pool B",coach6, "Wed", "19:00 - 20:00", "swimming", 5));
//       hcl.addLesson(new Lesson("Gymnastics 3","Gym",coach7, "Thu", "19:00 - 20:00", "gymnastics", 5));
//       
//      
//       
//       hcl.book("S01", "less11");
//       hcl.book("S01", "less16");
//       hcl.book("S02", "less11");
//       hcl.book("S03", "less11");
//       hcl.book("S04", "less11");
//       hcl.book("S05", "less11");
//       hcl.book("S06", "less11");
//       hcl.book("S07", "less11");
//       hcl.book("S07", "less12");
//       hcl.book("S08", "less13");
//       hcl.book("S09", "less14");
//       hcl.book("S010", "less15");
//       hcl.book("S011", "less16");
//       hcl.book("S012", "less17");
//     
//      
//       
//       
//       hcl.bookApointment("Appoint016", "S01");
//       hcl.bookApointment("Appoint014", "S02");
//       hcl.bookApointment("Appoint015", "S03");
//       hcl.bookApointment("Appoint013", "S04");
//       hcl.bookApointment("Appoint016", "S05");
//       hcl.bookApointment("Appoint03", "S06");
//       
//       
//       hcl.report1();
//       hcl.report2();
       
       
        
    }
    

//    class DescribeAction implements ActionListener {
//        private final JEditorPane pane;
//        public DescribeAction (JEditorPane pane) {
//            this.pane = pane;                                           
//        }
//        public void actionPerformed (ActionEvent e) {
//            System.out.println("Coaches Registered:");
//            displayCoaches();
//                                          
//        }
//    }
//    class ClickListener implements ActionListener {
//
//        private String FNameT;
//        private String lNameT;
//        private String telT;
//        private String officeDayT;
//        private String officeTimeT;
//
//        public ClickListener(String FNameT, String lNameT, String telT, String officeTimeT, String officeDayT) {
//            this.FNameT = FNameT;
//            this.lNameT = lNameT;
//            this.officeDayT = officeDayT;
//            this.officeTimeT = officeTimeT;
//            this.telT = telT;
//        }
//
//        public void actionPerformed(ActionEvent e) {
//            hcl.registerCoach(FNameT, lNameT, telT, officeTimeT, officeDayT);
//        }
//    }
//
//    public JPanel coachRegisterForm() {
//        JPanel panel = new JPanel();                               // (2)
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  // (3)
//
//        JLabel fName = new JLabel("Enter your first name:");
//        JTextField FNameT = new JTextField(25);
//        JLabel lName = new JLabel("Enter your last name:");
//        JTextField lNameT = new JTextField(25);
//        JLabel tel = new JLabel("Enter your telephone number:");
//        JTextField telT = new JTextField(25);
//        JLabel officeDay = new JLabel("Enter your office day:");
//        JTextField officeDayT = new JTextField(25);
//        JLabel officeTime = new JLabel("Enter your office hour:");
//        JTextField officeTimeT = new JTextField(25);
//
//        panel.add(fName);
//        panel.add(FNameT);
//        panel.add(lName);
//        panel.add(lNameT);
//        panel.add(tel);
//        panel.add(telT);
//        panel.add(officeDay);
//        panel.add(officeDayT);
//        panel.add(officeTime);
//        panel.add(officeTimeT);
//        JButton button = new JButton("Register Coach");
//        button.addActionListener(new ClickListener(FNameT.getText(), lNameT.getText(), telT.getText(), officeTimeT.getText(), officeDayT.getText()));
//        panel.add(button, BorderLayout.SOUTH);
//
//        return panel;
//    }
//    
//    class ClickListenerCoachMenu implements ActionListener {  
//            
//            public void actionPerformed(ActionEvent e) {       
//                
//            }
//        }
    
    //            class ClickListener implements ActionListener {
//
//            private String FNameT;
//            private String lNameT;
//            private String telT;
//            private String officeDayT;
//            private String officeTimeT;
//
//            public ClickListener(String FNameT, String lNameT, String telT, String officeTimeT, String officeDayT) {
//                this.FNameT = FNameT;
//                this.lNameT = lNameT;
//                this.officeDayT = officeDayT;
//                this.officeTimeT = officeTimeT;
//                this.telT = telT;
//            }
//
//            public void actionPerformed(ActionEvent e) {
//                hcl.registerCoach(FNameT, lNameT, telT, officeTimeT, officeDayT);
//                
//            }
//        }
    
    
}
