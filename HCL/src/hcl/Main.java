/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author NGSI
 */
public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HatfieldLeisureCentre hcl = new HatfieldLeisureCentre();

                /*
                Frames
                 */
                MainFrame app = new MainFrame(500, 500);
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setVisible(true);
                //Administration               
                MainFrame adminFrame = new MainFrame(500, 500);
                MainFrame reportsFrame = new MainFrame(1000, 500);
                MainFrame addLessonFrame = new MainFrame(600, 600);
                //Coach 
                MainFrame coachFrame = new MainFrame(500, 500);
                MainFrame registerCoachFrame = new MainFrame(600, 500);
                MainFrame addExpAreaFrame = new MainFrame(500, 250);
                MainFrame coachReportFrame = new MainFrame(1000, 200);
                //Student
                MainFrame studentFrame = new MainFrame(500, 500);
                MainFrame registerStudentFrame = new MainFrame(500, 250);
                MainFrame lookupLessonFrame = new MainFrame(1000, 250);
                MainFrame bookLessonFrame = new MainFrame(400, 200);
                MainFrame cancelChangeFrame = new MainFrame(600, 280);
                MainFrame attendFrame = new MainFrame(400, 150);
                MainFrame studentReportFrame = new MainFrame(1000, 200);
                MainFrame lookupTimeSlotFrame = new MainFrame(1000, 250);
                MainFrame bookAppointmentFrame = new MainFrame(600, 200);
                
                /*
                app frame componenets
                 */

                JPanel mainPanelCenter = createPanelCenter(3, 1);
                JLabel title1 = createTitle("Main Menu");
                
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
                
                mainPanelCenter.add(buttonCoach);
                mainPanelCenter.add(buttonStudent);
                mainPanelCenter.add(buttonAdmin);
                
                app.add(title1, BorderLayout.NORTH);
                app.add(mainPanelCenter, BorderLayout.CENTER);

                /*
                Coach frame componenets
                 */
                
                JPanel coachPanelCenter = createPanelCenter(3, 1);
                JLabel title2 = createTitle("Coach Menu");

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
                JButton buttonReportCoach = new JButton("Reports");
                buttonReportCoach.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        coachReportFrame.setVisible(true);
                    }
                });
                
                coachPanelCenter.add(buttonNewCoach);
                coachPanelCenter.add(buttonAddArea);
                coachPanelCenter.add(buttonReportCoach);
                
                coachFrame.add(coachPanelCenter, BorderLayout.CENTER);
                coachFrame.add(title2, BorderLayout.NORTH);
                
                /*
                Register Coach frame componenets
                 */
                
                JPanel registerCoachPanel = createPanelCenter(6, 2);
                JLabel title5 = createTitle("Register a New Coach");

                JLabel fName = new JLabel("Enter your first name:");
                JTextField FNameT = new JTextField(25);
                JLabel lName = new JLabel("Enter your last name:");
                JTextField lNameT = new JTextField(25);
                JLabel tel = new JLabel("Enter your telephone number:");
                JTextField telT = new JTextField(25);
                JLabel officeDay = new JLabel("Select your office day:");
                JRadioButton radioDayButton1 = new JRadioButton("Monday");
                JRadioButton radioDayButton2 = new JRadioButton("Tuesday");
                JRadioButton radioDayButton3 = new JRadioButton("Wednesday");
                JRadioButton radioDayButton4 = new JRadioButton("Thursday");
                JRadioButton radioDayButton5 = new JRadioButton("Friday");
//                JTextField officeDayT = new JTextField(25);
                JLabel startOfficeTime = new JLabel("Enter your start office hour (format hh:mm):");
                JTextField startOfficeTimeT = new JTextField(5);
                JLabel endOfficeTime = new JLabel("Enter your end office hour (format hh:mm):");
                JTextField endOfficeTimeT = new JTextField(5);
                
                JPanel daysRadioPanel = new JPanel();
                daysRadioPanel.setLayout(new GridLayout(3, 2, 5, 5));
                             
                ButtonGroup daysGroup = new ButtonGroup();
                daysGroup.add(radioDayButton1);
                daysGroup.add(radioDayButton2);
                daysGroup.add(radioDayButton3);
                daysGroup.add(radioDayButton4);
                daysGroup.add(radioDayButton5);

                daysRadioPanel.add(radioDayButton1);
                daysRadioPanel.add(radioDayButton2);
                daysRadioPanel.add(radioDayButton3);
                daysRadioPanel.add(radioDayButton4);
                daysRadioPanel.add(radioDayButton5);
                
                registerCoachPanel.add(fName);
                registerCoachPanel.add(FNameT);
                registerCoachPanel.add(lName);
                registerCoachPanel.add(lNameT);
                registerCoachPanel.add(tel);
                registerCoachPanel.add(telT);
                registerCoachPanel.add(officeDay);
                registerCoachPanel.add(daysRadioPanel);
//                registerCoachPanel.add(officeDayT);
                registerCoachPanel.add(startOfficeTime);
                registerCoachPanel.add(startOfficeTimeT);
                registerCoachPanel.add(endOfficeTime);
                registerCoachPanel.add(endOfficeTimeT);

                JButton registerCoachButton = new JButton("Register Coach");
                registerCoachButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String day = "";
                        if (radioDayButton1.isSelected()) {
                            day = "Monday";
                        }
                        if (radioDayButton2.isSelected()) {
                            day = "Tuesday";
                        }
                        if (radioDayButton3.isSelected()) {
                            day = "Wednesday";
                        }
                        if (radioDayButton4.isSelected()) {
                            day = "Thursday";
                        }
                        if (radioDayButton5.isSelected()) {
                            day = "Friday";
                        }
                        String id = hcl.registerCoach(FNameT.getText(), lNameT.getText(), telT.getText(), day, startOfficeTimeT.getText()+" - "+endOfficeTimeT.getText());
                        if (id.equals("Error")) {
                            JOptionPane.showMessageDialog(null,
                                    "Empty Fileds",
                                    "Coach Registration",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (id == "") {
                            JOptionPane.showMessageDialog(null,
                                    "The Coach: " + FNameT.getText() + " " + lNameT.getText() + " is already registered",
                                    "Coach Registration",
                                    JOptionPane.ERROR_MESSAGE);
                            FNameT.setText("");
                            lNameT.setText("");
                            telT.setText("");
                            startOfficeTimeT.setText("");
                            endOfficeTimeT.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "The Coach: " + FNameT.getText() + " " + lNameT.getText() + " is succefully created with Id: " + id,
                                    "Coach Registration",
                                    JOptionPane.ERROR_MESSAGE);
                            registerCoachFrame.setVisible(false);
                            FNameT.setText("");
                            lNameT.setText("");
                            telT.setText("");
                            startOfficeTimeT.setText("");
                            endOfficeTimeT.setText("");
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
                        startOfficeTimeT.setText("");
                        endOfficeTimeT.setText("");
                        registerCoachFrame.setVisible(false);
                    }
                });
                
                JPanel groupPanel = new JPanel();
                groupPanel.setLayout(new GridLayout(1, 2, 5, 5));
                groupPanel.add(registerCoachButton);
                groupPanel.add(CancelCoachButton);
                
                registerCoachFrame.add(registerCoachPanel, BorderLayout.CENTER);
                registerCoachFrame.add(groupPanel, BorderLayout.SOUTH);
                registerCoachFrame.add(title5, BorderLayout.NORTH);
                
                /*
                addExpAreaFrame components
                 */
                
                JPanel areaPanel = new JPanel();
                areaPanel.setLayout(new BoxLayout(areaPanel, BoxLayout.Y_AXIS));
                JLabel title6 = createTitle("Add an expertise area:");

                JLabel fCaochId = new JLabel("Enter the coach ID:");
                JTextField fCaochIdT = new JTextField(25);
                JLabel areaLabel = new JLabel("Select the Expertise Areas:");
                JCheckBox area1 = new JCheckBox("swimming");
                JCheckBox area2 = new JCheckBox("badminton");
                JCheckBox area3 = new JCheckBox("gymnastics");

                JButton addAreaButton = new JButton("Add");
                addAreaButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!(area1.isSelected() || area2.isSelected() || area3.isSelected())) {
                            JOptionPane.showMessageDialog(null,
                                    "Empty Fileds",
                                    "Add Expertise Area",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            String successMessage = "";
                            Coach coach = hcl.coaches.get(fCaochIdT.getText());
                            if (area1.isSelected()) {
                                coach.addArea("swimming");
                                successMessage += ", swimming";
                            }
                            if (area2.isSelected()) {
                                coach.addArea("badminton");
                                successMessage += ", badminton";
                            }
                            if (area3.isSelected()) {
                                coach.addArea("gymnastics");
                                successMessage += ", gymnastics";
                            }
                            JOptionPane.showMessageDialog(null,
                                    "The expertise areas: " + successMessage + " succesfully added to the coach: " + coach.getFullName(),
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
                areaPanel.add(areaLabel);
                areaPanel.add(area1);
                areaPanel.add(area2);
                areaPanel.add(area3);
                
                JPanel groupPanel2 = new JPanel();
                groupPanel2.setLayout(new GridLayout(1, 2, 5, 5));
                groupPanel2.add(addAreaButton);
                groupPanel2.add(cancelAreaButton);

                addExpAreaFrame.add(groupPanel2, BorderLayout.SOUTH);
                addExpAreaFrame.add(areaPanel, BorderLayout.CENTER);
                addExpAreaFrame.add(title6, BorderLayout.NORTH);

                /*
                coachReportFrame
                 */
                
                JLabel title17 = createTitle("Coach Reports");
                JTextPane coachReport = new JTextPane();
                coachReport.setEditable(false);
                coachReportFrame.add(new JScrollPane(coachReport), BorderLayout.CENTER);

                JLabel cId3 = new JLabel("Enter your Coach Id:");
                JTextField cIdT3 = new JTextField(25);

                JButton buttonDisplayCReport = new JButton("Display Report");
                buttonDisplayCReport.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        coachReport.setText(hcl.coachReport(cIdT3.getText()));
                    }
                });

                JPanel cReportPanel = new JPanel();
                cReportPanel.setBorder(new LineBorder(Color.BLACK, 3));
                cReportPanel.setBackground(Color.LIGHT_GRAY);
                cReportPanel.setLayout(new GridLayout(3, 1, 5, 5));
                
                coachReportFrame.add(cReportPanel, BorderLayout.EAST);
                coachReportFrame.add(title17, BorderLayout.NORTH);

                cReportPanel.add(cId3);
                cReportPanel.add(cIdT3);
                cReportPanel.add(buttonDisplayCReport);

                /*
                Admin frame componenets
                 */
                
                JPanel adminPanelCenter = createPanelCenter(2, 1);
                JLabel title3 = createTitle("Administration Menu");

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
                
                adminPanelCenter.add(buttonNewLesson);
                adminPanelCenter.add(buttonReporting);
                adminFrame.add(adminPanelCenter, BorderLayout.CENTER);
                adminFrame.add(title3, BorderLayout.NORTH);

                /*
                Reports frame componenets
                 */
                
                JLabel title7 = createTitle("Reports");
                JTextPane report = new JTextPane();
                report.setEditable(false);
                reportsFrame.add(new JScrollPane(report), BorderLayout.CENTER);

                JButton buttonReport1 = new JButton("Report 1");
                buttonReport1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        report.setText(hcl.report1());
                    }
                });
                JButton buttonReport2 = new JButton("Report 2");
                buttonReport2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        report.setText(hcl.report2());
                    }
                });
                JButton buttonDisplayCoaches = new JButton("Display Coaches");
                buttonDisplayCoaches.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        report.setText(hcl.displayCoaches());
                    }
                });
                JButton buttonDisplayStudents = new JButton("Display Students");
                buttonDisplayStudents.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        report.setText(hcl.displayStudents());
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
                reportPanel.setBorder(new LineBorder(Color.BLACK, 3));
                reportPanel.setBackground(Color.GRAY);
                reportPanel.setLayout(new GridLayout(5, 1, 5, 5));
                
                reportsFrame.add(reportPanel, BorderLayout.EAST);
                reportsFrame.add(title7, BorderLayout.NORTH);

                reportPanel.add(buttonReport1);
                reportPanel.add(buttonReport2);
                reportPanel.add(buttonDisplayCoaches);
                reportPanel.add(buttonDisplayStudents);
                reportPanel.add(buttonDisplayBookings);

                /*
                addLessonFrame componenets
                 */
                
                JPanel addLessonPanel = createPanelCenter(8, 2);
//                addLessonPanel.setLayout(new BoxLayout(addLessonPanel, BoxLayout.Y_AXIS));
                JLabel title8 = createTitle("Add a New Lesson");

                JLabel lessonName = new JLabel("Enter Lesson name:");
                JTextField lessonNameT = new JTextField(25);
                JLabel location = new JLabel("Enter Location");
                JRadioButton radioPlaceButton1 = new JRadioButton("Badminton court A");
                JRadioButton radioPlaceButton2 = new JRadioButton("Badminton court B");
                JRadioButton radioPlaceButton3 = new JRadioButton("Gym");
                JRadioButton radioPlaceButton4 = new JRadioButton("Swimming pool A");
                JRadioButton radioPlaceButton5 = new JRadioButton("Swimming pool B");
//                JTextField locationT = new JTextField(25);
                JLabel coachId = new JLabel("Enter Coach Id");
                JTextField coachIdT = new JTextField(25);
                JLabel day = new JLabel("Select a day:");
                JRadioButton radioDayButton6 = new JRadioButton("Monday");
                JRadioButton radioDayButton7 = new JRadioButton("Tuesday");
                JRadioButton radioDayButton8 = new JRadioButton("Wednesday");
                JRadioButton radioDayButton9 = new JRadioButton("Thursday");
                JRadioButton radioDayButton10 = new JRadioButton("Friday");
//                JTextField dayT = new JTextField(25);
                JLabel startTime = new JLabel("Enter start time(format hh:mm):");
                JTextField startTimeT = new JTextField(5);
                JLabel endTime = new JLabel("Enter end time(format hh:mm):");
                JTextField endTimeT = new JTextField(5);
                JLabel arealabel2 = new JLabel("Select an Area");
                JRadioButton radioButton1 = new JRadioButton("swimming");
                JRadioButton radioButton2 = new JRadioButton("badminton");
                JRadioButton radioButton3 = new JRadioButton("gymnastics");

                JPanel placesRadioPanel = new JPanel();
                placesRadioPanel.setLayout(new GridLayout(3, 2, 5, 5));
                
                ButtonGroup placesGroup = new ButtonGroup();
                placesGroup.add(radioPlaceButton1);
                placesGroup.add(radioPlaceButton2);
                placesGroup.add(radioPlaceButton3);
                placesGroup.add(radioPlaceButton4);
                placesGroup.add(radioPlaceButton5);

                placesRadioPanel.add(radioPlaceButton1);
                placesRadioPanel.add(radioPlaceButton2);
                placesRadioPanel.add(radioPlaceButton3);
                placesRadioPanel.add(radioPlaceButton4);
                placesRadioPanel.add(radioPlaceButton5);
                
                JPanel daysRadioPanel2 = new JPanel();
                daysRadioPanel2.setLayout(new GridLayout(3, 2, 5, 5));
                             
                ButtonGroup daysGroup2 = new ButtonGroup();
                daysGroup2.add(radioDayButton6);
                daysGroup2.add(radioDayButton7);
                daysGroup2.add(radioDayButton8);
                daysGroup2.add(radioDayButton9);
                daysGroup2.add(radioDayButton10);

                daysRadioPanel2.add(radioDayButton6);
                daysRadioPanel2.add(radioDayButton7);
                daysRadioPanel2.add(radioDayButton8);
                daysRadioPanel2.add(radioDayButton9);
                daysRadioPanel2.add(radioDayButton10);
                
                ButtonGroup group2 = new ButtonGroup();
                group2.add(radioButton1);
                group2.add(radioButton2);
                group2.add(radioButton3);

                JPanel radioPanel = new JPanel();
                radioPanel.setLayout(new GridLayout(0, 1));
                radioPanel.add(radioButton1);
                radioPanel.add(radioButton2);
                radioPanel.add(radioButton3);

                JLabel capacity = new JLabel("Enter Lesson Capacity:");
                JTextField capacityT = new JTextField(25);
                capacityT.setText("0");

                addLessonPanel.add(lessonName);
                addLessonPanel.add(lessonNameT);
                addLessonPanel.add(location);
                addLessonPanel.add(placesRadioPanel);
//                addLessonPanel.add(locationT);
                addLessonPanel.add(coachId);
                addLessonPanel.add(coachIdT);
                addLessonPanel.add(day);
                addLessonPanel.add(daysRadioPanel2);
//                addLessonPanel.add(dayT);
                addLessonPanel.add(startTime);
                addLessonPanel.add(startTimeT);
                addLessonPanel.add(endTime);
                addLessonPanel.add(endTimeT);
                addLessonPanel.add(arealabel2);
                addLessonPanel.add(radioPanel);
                addLessonPanel.add(capacity);
                addLessonPanel.add(capacityT);

                JButton addLessonButton = new JButton("Add");
                addLessonButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String coachId = coachIdT.getText();
                        Coach coach = hcl.coaches.get(coachId);
                        String day = "";
                        if (radioDayButton6.isSelected()) {
                            day = "Monday";
                        }
                        if (radioDayButton7.isSelected()) {
                            day = "Tuesday";
                        }
                        if (radioDayButton8.isSelected()) {
                            day = "Wednesday";
                        }
                        if (radioDayButton9.isSelected()) {
                            day = "Thursday";
                        }
                        if (radioDayButton10.isSelected()) {
                            day = "Friday";
                        }
                        String area = "";
                        if (radioButton1.isSelected()) {
                            area = "swimming";
                        }
                        if (radioButton2.isSelected()) {
                            area = "badminton";
                        }
                        if (radioButton3.isSelected()) {
                            area = "gymnastics";
                        }
                        String place = "";
                        if (radioDayButton6.isSelected()) {
                            day = "Badminton court A";
                        }
                        if (radioDayButton7.isSelected()) {
                            day = "Badminton court B";
                        }
                        if (radioDayButton8.isSelected()) {
                            day = "Gym";
                        }
                        if (radioDayButton9.isSelected()) {
                            day = "Swimming pool B";
                        }
                        if (radioDayButton10.isSelected()) {
                            day = "Swimming pool B";
                        }
                        String result = hcl.addLesson(lessonNameT.getText(), place, coachId, day, startTimeT.getText()+" - "+endTimeT.getText(), area, Integer.parseInt(capacityT.getText()));
                        if (result.equals("Empty Fields")) {
                            JOptionPane.showMessageDialog(null,
                                    "Empty Fileds",
                                    "New Lesson",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (result.equals("Coach not registered")) {
                            JOptionPane.showMessageDialog(null,
                                    "The CoachId is incorrect",
                                    "New Lesson",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (result.equals("Expertise area not teached by the coach")) {
                            JOptionPane.showMessageDialog(null,
                                    "The Coach: " + coach.getFullName() + " does not teach " + area,
                                    "New Lesson",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (coach.getLessonsNumber() >= 3) {
                            JOptionPane.showMessageDialog(null,
                                    "The Coach: " + coach.getFullName() + " is already teaching 3 lessons per week",
                                    "New Lesson",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (result.equals("Time conflict")) {
                            JOptionPane.showMessageDialog(null,
                                    "The lesson time is conflicting with the coach " + coach.getFullName() + "'s office hour",
                                    "New Lesson",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "The Lesson: " + lessonNameT.getText() + " is succefully added with Id: " + hcl.lessons.get(result),
                                    "New Lesson",
                                    JOptionPane.ERROR_MESSAGE);
                            addLessonFrame.setVisible(false);
                            lessonNameT.setText("");
//                            locationT.setText("");
                            coachIdT.setText("");
                            startTimeT.setText("");
                            endTimeT.setText("");
                            capacityT.setText("");
                        }
                    }
                });
                JButton cancelLessButton = new JButton("Cancel");
                cancelLessButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addLessonFrame.setVisible(false);
                        lessonNameT.setText("");
//                        locationT.setText("");
                        coachIdT.setText("");
                        startTimeT.setText("");
                        endTimeT.setText("");
                        capacityT.setText("");
                    }
                });
                
                JPanel groupPanel4 = new JPanel();
                groupPanel4.setLayout(new GridLayout(1, 2, 5, 5));
                groupPanel4.add(addLessonButton);
                groupPanel4.add(cancelLessButton);

                addLessonFrame.add(addLessonPanel, BorderLayout.CENTER);
                addLessonFrame.add(groupPanel4, BorderLayout.SOUTH);
                addLessonFrame.add(title8, BorderLayout.NORTH);
                
                /*
                Student frame components
                 */

                JPanel studentPanelCenter = createPanelCenter(8, 1);
                JLabel title4 = createTitle("Student Menu");

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
                JButton ButtonLookupTimeSlot = new JButton("Lookup Appointment Slots");
                ButtonLookupTimeSlot.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        lookupTimeSlotFrame.setVisible(true);
                    }
                });
                JButton ButtonBookAppointment = new JButton("Book a Visitor Appointment");
                ButtonBookAppointment.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bookAppointmentFrame.setVisible(true);
                    }
                });
                JButton buttonSReport = new JButton("Report");
                buttonSReport.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        studentReportFrame.setVisible(true);
                    }
                });

                studentPanelCenter.add(buttonNewStudent);
                studentPanelCenter.add(buttonLookupLesson);
                studentPanelCenter.add(buttonBookLesson);
                studentPanelCenter.add(buttonCancelChange);
                studentPanelCenter.add(buttonAttend);
                studentPanelCenter.add(ButtonLookupTimeSlot);
                studentPanelCenter.add(ButtonBookAppointment);
                studentPanelCenter.add(buttonSReport);
                studentFrame.add(studentPanelCenter, BorderLayout.CENTER);
                studentFrame.add(title4, BorderLayout.NORTH);

                /*
                registerStudentFrame componenets
                 */
                
                JPanel registerStudentPanel = createPanelCenter(5, 2);
                JLabel title9 = createTitle("Student Registration");

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
                        if (id.equals("Empty Fields")) {
                            JOptionPane.showMessageDialog(null,
                                    "Empty Fileds",
                                    "Student Registration",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (id == "") {
                            JOptionPane.showMessageDialog(null,
                                    "The Student: " + sFirstNameT.getText() + " " + sLastNameT.getText() + " is already registered",
                                    "Student Registration",
                                    JOptionPane.ERROR_MESSAGE);
                            sFirstNameT.setText("");
                            sLastNameT.setText("");
                            sAddressT.setText("");
                            sTelT.setText("");
                            parentNameT.setText("");
                        } else {
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
                groupPanel3.setLayout(new GridLayout(1, 2, 5, 5));
                groupPanel3.add(registerStudentButton);
                groupPanel3.add(cancelSRegButton);

                registerStudentFrame.add(registerStudentPanel, BorderLayout.CENTER);
                registerStudentFrame.add(groupPanel3, BorderLayout.SOUTH);
                registerStudentFrame.add(title9, BorderLayout.NORTH);

                /*
                lookupLessonFrame
                 */
                
                JPanel lookupLessonPanel = new JPanel();
                JTextPane lookupLessonResult = new JTextPane();
                lookupLessonResult.setEditable(false);
                lookupLessonFrame.add(new JScrollPane(lookupLessonResult), BorderLayout.CENTER);
                JLabel title10 = createTitle("Lookup Lessons:");
                lookupLessonFrame.add(title10, BorderLayout.NORTH);

                JLabel lookupCoach = new JLabel("Enter a coach full name:");
                JTextField lookupCoachT = new JTextField(25);
                
                JButton lookupByCoach = new JButton("Lookup by Coach");
                lookupByCoach.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String result = hcl.lookupLessonByCoach(lookupCoachT.getText());
                        if (result.equals("")) {
                            JOptionPane.showMessageDialog(null,
                                    "Coach name is incorrect",
                                    "Lookup lessons",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            lookupLessonResult.setText(result);
                        }

                    }
                });
                
                lookupLessonPanel.setLayout(new BoxLayout(lookupLessonPanel, BoxLayout.Y_AXIS));
                lookupLessonFrame.add(lookupLessonPanel, BorderLayout.EAST);

                JRadioButton radioButton4 = new JRadioButton("swimming");
                JRadioButton radioButton5 = new JRadioButton("badminton");
                JRadioButton radioButton6 = new JRadioButton("gymnastics");

                JButton lookupByArea = new JButton("Lookup by Area");
                lookupByArea.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String area = "";
                        if (radioButton4.isSelected()) {
                            area = "swimming";
                        }
                        if (radioButton5.isSelected()) {
                            area = "badminton";
                        }
                        if (radioButton6.isSelected()) {
                            area = "gymnastics";
                        }
                        lookupLessonResult.setText(hcl.lookupLessonByArea(area));
                    }
                });

                ButtonGroup group3 = new ButtonGroup();
                group3.add(radioButton4);
                group3.add(radioButton5);
                group3.add(radioButton6);
                JPanel radioPanel2 = new JPanel();
                radioPanel2.setLayout(new GridLayout(0, 1));
                radioPanel2.add(radioButton4);
                radioPanel2.add(radioButton5);
                radioPanel2.add(radioButton6);

                lookupLessonPanel.add(lookupCoach);
                lookupLessonPanel.add(lookupCoachT);
                lookupLessonPanel.add(lookupByCoach);
                lookupLessonPanel.add(radioPanel2);
                lookupLessonPanel.add(lookupByArea);

                /*
                bookLessonFrame
                 */
                
                JPanel bookLessonPanel = new JPanel();
                bookLessonPanel.setLayout(new BoxLayout(bookLessonPanel, BoxLayout.Y_AXIS));
                JLabel title11 = createTitle("Book a Lesson:");
                bookLessonFrame.add(title11, BorderLayout.NORTH);

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
                        String id = hcl.book(sIdT.getText(), lessonIdT.getText());
                        if (id.equals("Empty Fields")) {
                            JOptionPane.showMessageDialog(null,
                                    "Empty Fileds",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (id.equals("Error studentId")) {
                            JOptionPane.showMessageDialog(null,
                                    "The student with id: " + sIdT.getText() + " does not exist",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (id.equals("Error lessonId")) {
                            JOptionPane.showMessageDialog(null,
                                    "The lesson with id: " + lessonIdT.getText() + " does not exist",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (id.equals("Already enrolled into a class running at the same time")) {
                            JOptionPane.showMessageDialog(null,
                                    "You are already registered in a class running at the same time",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (id.equals("Lesson full")) {
                            JOptionPane.showMessageDialog(null,
                                    "This class is fully booked",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Successful sign on to the lesson, Booking number: " + id,
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                            bookLessonFrame.setVisible(false);
                            sIdT.setText("");
                            lessonIdT.setText("");
                        }
                    }
                });
                JButton cancelBookButton = new JButton("Cancel");
                cancelBookButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bookLessonFrame.setVisible(false);
                        sIdT.setText("");
                        lessonIdT.setText("");
                    }
                });
                
                JPanel groupPanel5 = new JPanel();
                groupPanel5.setLayout(new GridLayout(0, 2));
                groupPanel5.add(bookLessonButton);
                groupPanel5.add(cancelBookButton);

                bookLessonFrame.add(bookLessonPanel, BorderLayout.CENTER);
                bookLessonFrame.add(groupPanel5, BorderLayout.SOUTH);
                
                /*
                cancelChangeFrame
                 */

                JPanel cancelChangePanel = new JPanel();
                cancelChangePanel.setLayout(new BoxLayout(cancelChangePanel, BoxLayout.Y_AXIS));
                JLabel title12 = createTitle("Cancel / Change a Booking:");
                cancelChangeFrame.add(title12, BorderLayout.NORTH);

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
                        String result = hcl.cancelBooking(bNumT.getText());
                        if (result.equals("Empty Fields")) {
                            JOptionPane.showMessageDialog(null,
                                    "Empty Fileds",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (result.equals("Error")) {
                            JOptionPane.showMessageDialog(null,
                                    "This Booking does not exist",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "The booking: " + bNumT.getText() + "is succesfully canceled",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                            bookLessonFrame.setVisible(false);
                            bNumT.setText("");
                        }
                    }
                });
                JButton ChangeButton = new JButton("Change Booking");
                ChangeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String result = hcl.changeBooking(bNumT2.getText(), lessonIdT2.getText());
                        if (result.equals("Empty Fields")) {
                            JOptionPane.showMessageDialog(null,
                                    "Empty Fileds",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (result.equals("Error")) {
                            JOptionPane.showMessageDialog(null,
                                    "This Booking does not exist",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "The booking: " + bNumT.getText() + "is succesfully Changed",
                                    "Lesson Booking",
                                    JOptionPane.ERROR_MESSAGE);
                            bookLessonFrame.setVisible(false);
                            bNumT.setText("");
                            lessonIdT2.setText("");
                        }
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
                JLabel title13 = createTitle("Attend a Lesson:");
                attendFrame.add(title13, BorderLayout.NORTH);

                JLabel bNum3 = new JLabel("Enter your booking number:");
                JTextField bNumT3 = new JTextField(25);
                
                JButton attendButton = new JButton("Attend");
                attendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String result = hcl.attendLesson(bNumT3.getText());
                        if (result.equals("Empty Fields")) {
                            JOptionPane.showMessageDialog(null,
                                    "Empty Fileds",
                                    "Lesson Attendance",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (result.equals("Error")) {
                            JOptionPane.showMessageDialog(null,
                                    "This Booking does not exist",
                                    "Lesson Attendance",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "The booking: " + bNumT.getText() + "is succesfully Attended",
                                    "Lesson Attendance",
                                    JOptionPane.ERROR_MESSAGE);
                            attendFrame.setVisible(false);
                            bNumT3.setText("");
                        }
                    }
                });
                JButton cancelAttendButton = new JButton("Cancel");
                cancelAttendButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        attendFrame.setVisible(false);
                        bNumT3.setText("");
                    }
                });

                attendPanel.add(bNum3);
                attendPanel.add(bNumT3);
                attendPanel.add(attendButton);
                attendFrame.add(attendPanel, BorderLayout.CENTER);

                /*
                lookupTimeSlotFrame
                 */
                
                JPanel lookupSlotsPanel = new JPanel();
                JTextPane lookupSlotsResult = new JTextPane();
                lookupSlotsResult.setEditable(false);
                lookupTimeSlotFrame.add(new JScrollPane(lookupSlotsResult), BorderLayout.CENTER);
                JLabel title14 = createTitle("Lookup Appointment Slots:");
                lookupTimeSlotFrame.add(title14, BorderLayout.NORTH);

                JLabel lookupSCoach = new JLabel("Enter a coach full name:");
                JTextField lookupSCoachT = new JTextField(25);

                JButton lookupSByCoach = new JButton("Lookup by Coach");
                lookupSByCoach.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String result = hcl.lookupTimeslotsByCoach(lookupSCoachT.getText());
                        if (result.equals("")) {
                            JOptionPane.showMessageDialog(null,
                                    "Coach name is incorrect",
                                    "Lookup Appointment Slots",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            lookupSlotsResult.setText(result);
                        }

                    }
                });

                lookupSlotsPanel.setLayout(new BoxLayout(lookupSlotsPanel, BoxLayout.Y_AXIS));
                lookupTimeSlotFrame.add(lookupSlotsPanel, BorderLayout.EAST);

                JRadioButton radioButton7 = new JRadioButton("swimming");
                JRadioButton radioButton8 = new JRadioButton("badminton");
                JRadioButton radioButton9 = new JRadioButton("gymnastics");

                JButton lookupSByArea = new JButton("Lookup by Area");
                lookupSByArea.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String area = "";
                        if (radioButton7.isSelected()) {
                            area = "swimming";
                        }
                        if (radioButton8.isSelected()) {
                            area = "badminton";
                        }
                        if (radioButton9.isSelected()) {
                            area = "gymnastics";
                        }
                        lookupSlotsResult.setText(hcl.lookupTimeslotsByArea(area));
                    }
                });

                ButtonGroup group4 = new ButtonGroup();
                group4.add(radioButton7);
                group4.add(radioButton8);
                group4.add(radioButton9);
                
                JPanel radioPanel3 = new JPanel();
                radioPanel3.setLayout(new GridLayout(0, 1));
                radioPanel3.add(radioButton7);
                radioPanel3.add(radioButton8);
                radioPanel3.add(radioButton9);

                lookupSlotsPanel.add(lookupSCoach);
                lookupSlotsPanel.add(lookupSCoachT);
                lookupSlotsPanel.add(lookupSByCoach);
                lookupSlotsPanel.add(radioPanel3);
                lookupSlotsPanel.add(lookupSByArea);

                /*
                bookAppointmentFrame
                 */
                
                JPanel bookAppointPanel = new JPanel();
                bookAppointPanel.setLayout(new BoxLayout(bookAppointPanel, BoxLayout.Y_AXIS));
                JLabel title15 = createTitle("Book a Visitor Appointment");
                bookAppointmentFrame.add(title15, BorderLayout.NORTH);

                JLabel sId2 = new JLabel("Enter your Student Id:");
                JTextField sIdT2 = new JTextField(25);
                JLabel appointId = new JLabel("Enter the appointment Id:");
                JTextField appointIdT = new JTextField(25);

                bookAppointPanel.add(sId2);
                bookAppointPanel.add(sIdT2);
                bookAppointPanel.add(appointId);
                bookAppointPanel.add(appointIdT);

                JButton bookAppointButton = new JButton("Book");
                bookAppointButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = hcl.bookApointment(appointIdT.getText(), sIdT2.getText());
                        if (id.equals("Empty Fields")) {
                            JOptionPane.showMessageDialog(null,
                                    "Empty Fileds",
                                    "Appointment Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (id.equals("Error appointmentId")) {
                            JOptionPane.showMessageDialog(null,
                                    "The appointment slot with id: " + appointIdT.getText() + " does not exist",
                                    "Appointment Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (id.equals("Error studentId")) {
                            JOptionPane.showMessageDialog(null,
                                    "This student Id is incorrect",
                                    "Appointment Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (id.equals("This apointment slot is already booked")) {
                            JOptionPane.showMessageDialog(null,
                                    "This apointment slot is already booked",
                                    "Appointment Booking",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Appointment succesfully booked, Booking number: " + appointIdT.getText(),
                                    "Appointment Booking",
                                    JOptionPane.ERROR_MESSAGE);
                            bookAppointmentFrame.setVisible(false);
                            sIdT2.setText("");
                            appointIdT.setText("");
                        }
                    }
                });
                JButton cancelAppointButton = new JButton("Cancel");
                cancelAppointButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bookAppointmentFrame.setVisible(false);
                        sIdT2.setText("");
                        appointIdT.setText("");
                    }
                });
                
                JPanel groupPanel6 = new JPanel();
                groupPanel6.setLayout(new GridLayout(0, 2));
                groupPanel6.add(bookAppointButton);
                groupPanel6.add(cancelAppointButton);

                bookAppointmentFrame.add(bookAppointPanel, BorderLayout.CENTER);
                bookAppointmentFrame.add(groupPanel6, BorderLayout.SOUTH);

                /*
                studentReportFrame
                 */
                
                JLabel title16 = createTitle("Student Reports");
                JTextPane studentReport = new JTextPane();
                studentReport.setEditable(false);
                studentReportFrame.add(new JScrollPane(studentReport), BorderLayout.CENTER);

                JLabel sId3 = new JLabel("Enter your Student Id:");
                JTextField sIdT3 = new JTextField(25);

                JButton buttonDisplaySReport = new JButton("Display Report");
                buttonDisplaySReport.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        studentReport.setText(hcl.studentReport(sIdT3.getText()));
                    }
                });

                JPanel sReportPanel = new JPanel();
                sReportPanel.setBorder(new LineBorder(Color.BLACK, 3));
                sReportPanel.setBackground(Color.LIGHT_GRAY);
                sReportPanel.setLayout(new GridLayout(3, 1, 5, 5));
                
                studentReportFrame.add(sReportPanel, BorderLayout.EAST);
                studentReportFrame.add(title16, BorderLayout.NORTH);

                sReportPanel.add(sId3);
                sReportPanel.add(sIdT3);
                sReportPanel.add(buttonDisplaySReport);

                /*
                Data
                */
               
                

                
                Coach coach1 = new Coach("Serita", "Tuck", "tel", "16:00 - 17:00", "Mon");
                Coach coach2 = new Coach("Cyndy", "Cerrato", "tel", "16:00 - 17:00", "Tue");
                Coach coach3 = new Coach("Annamae", "Koski", "tel", "16:00 - 17:00", "Wed");
                Coach coach4 = new Coach("Sari", "Stlaurent", "tel", "16:00 - 17:00", "Thu");
                Coach coach5 = new Coach("Desire", "Royalty", "tel", "16:00 - 17:00", "Fri");
                Coach coach6 = new Coach("Ronny", "Eriksen", "tel", "15:00 - 16:00", "Tue");
                Coach coach7 = new Coach("Steward", "Denver", "tel", "15:00 - 16:00", "Wed");

                hcl.addCoach(coach1);
                hcl.addCoach(coach2);
                hcl.addCoach(coach3);
                hcl.addCoach(coach4);
                hcl.addCoach(coach5);
                hcl.addCoach(coach6);
                hcl.addCoach(coach7);

                coach1.addArea("swimming");
                coach1.addArea("badminton");
                coach1.addArea("gymnastics");
                coach2.addArea("swimming");
                coach2.addArea("badminton");
                coach3.addArea("gymnastics");
                coach4.addArea("swimming");
                coach4.addArea("badminton");
                coach4.addArea("gymnastics");
                coach5.addArea("badminton");
                coach5.addArea("gymnastics");
                coach6.addArea("swimming");
                coach7.addArea("swimming");
                coach7.addArea("badminton");
                coach7.addArea("gymnastics");

                hcl.registerStudent("Loida", "Poon", "Add", "tel", "Brad");
                hcl.registerStudent("Ewa", "Porto", "Add", "tel", "Linkon");
                hcl.registerStudent("Dylan ", "Bucher", "Add", "tel", "Jimmy");
                hcl.registerStudent("Reggie ", "Malan", "Add", "tel", "Smith");
                hcl.registerStudent("Landon ", "Buel", "Add", "tel", "Henderson");
                hcl.registerStudent("Enid ", "Lepine", "Add", "tel", "Eriksen");
                hcl.registerStudent("Aiko ", "Redmon", "Add", "tel", "Marco");
                hcl.registerStudent("Earl ", "Evatt", "Add", "tel", "Lucas");
                hcl.registerStudent("Annita ", "Bruckner", "Add", "tel", "Sergio");
                hcl.registerStudent("Emilee ", "Lubin", "Add", "tel", "Dani");
                hcl.registerStudent("Estell ", "Dillenbeck", "Add", "tel", "Ferland");
                hcl.registerStudent("Charleen ", "Boss", "Add", "tel", "Toni");
                hcl.registerStudent("Chadwick ", "Fiscus", "Add", "tel", "Fede");
                hcl.registerStudent("Steven", "Pullman", "Add", "tel", "Nacho");
                hcl.registerStudent("Elizabeth", "Simpson", "Add", "tel", "Fernandez");

                hcl.addLesson("Swimming 1", "swimming pool A", "C01", "Mon", "16:00 - 17:00", "swimming", 5);
                hcl.addLesson("Badminton 1", "badminton court A", "C01", "Tue", "14:00 - 15:00", "badminton", 5);
                hcl.addLesson("Gymnastics 1", "Gym", "C01", "Wed", "14:00 - 15:00", "gymnastics", 5);
                hcl.addLesson("Swimming 1", "swimming pool A", "C02", "Fri", "14:00 - 15:00", "swimming", 5);
                hcl.addLesson("Badminton 1", "badminton court A", "C02", "Mon", "14:00 - 15:00", "badminton", 5);
                hcl.addLesson("Gymnastics 1", "Gym", "C03", "Mon", "17:00 - 18:00", "gymnastics", 5);
                hcl.addLesson("Gymnastics 1", "Gym", "C03", "Tue", "17:00 - 18:00", "gymnastics", 5);
                hcl.addLesson("Gymnastics 2", "Gym", "C03", "Wed", "17:00 - 18:00", "gymnastics", 5);
                hcl.addLesson("Swimming 1", "swimming pool A", "C04", "Thu", "17:00 - 18:00", "swimming", 5);
                hcl.addLesson("Gymnastics 2", "Gym", "C04", "Fri", "17:00 - 18:00", "gymnastics", 5);
                hcl.addLesson("Gymnastics 2", "Gym", "C04", "Wed", "17:00 - 18:00", "gymnastics", 5);
                hcl.addLesson("Badminton 2", "badminton court B", "C05", "Mon", "19:00 - 20:00", "badminton", 5);
                hcl.addLesson("Badminton 2", "badminton court B", "C05", "Tue", "19:00 - 20:00", "badminton", 5);

                hcl.book("S01", "less11");
                hcl.book("S01", "less16");
                hcl.book("S02", "less11");
                hcl.book("S03", "less11");
                hcl.book("S04", "less11");
                hcl.book("S05", "less11");
                hcl.book("S06", "less11");
                hcl.book("S07", "less11");
                hcl.book("S07", "less12");
                hcl.book("S08", "less13");
                hcl.book("S09", "less14");
                hcl.book("S010", "less15");
                hcl.book("S011", "less16");
                hcl.book("S012", "less17");

                hcl.bookApointment("Appoint016", "S01");
                hcl.bookApointment("Appoint014", "S02");
                hcl.bookApointment("Appoint015", "S03");
                hcl.bookApointment("Appoint013", "S04");
                hcl.bookApointment("Appoint016", "S05");
                hcl.bookApointment("Appoint03", "S06");
            }
        });
    }
    
    public static JPanel createPanelCenter(Integer x, Integer y) {
        JPanel panelCenter = new JPanel();
        panelCenter.setBorder(new LineBorder(Color.BLACK, 3));
        panelCenter.setBackground(Color.LIGHT_GRAY);
        panelCenter.setLayout(new GridLayout(x, y, 5, 5));
        return panelCenter;
    }
    public static JLabel createTitle(String title){
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 42));
        return titleLabel;
    }

        

        
        

}
