/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author NGSI
 */
public class MainFrame extends JFrame {
    public MainFrame(String title){
        super(title);
        
        setSize(800, 800);
        setLayout (new BorderLayout ());
    }
    
        

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
}
//class ClickListener implements ActionListener {
//
//        private String FNameT;
//        private String lNameT;
//        private String telT;
//        private String officeDayT;
//        private String officeTimeT;
//        private HatfieldLeisureCentre hcl;
//
//        public ClickListener(String FNameT, String lNameT, String telT, String officeTimeT, String officeDayT, HatfieldLeisureCentre hcl) {
//            this.FNameT = FNameT;
//            this.lNameT = lNameT;
//            this.officeDayT = officeDayT;
//            this.officeTimeT = officeTimeT;
//            this.telT = telT;
//            this.hcl = hcl;
//        }
//
//        public void actionPerformed(ActionEvent e) {
//            hcl.registerCoach(FNameT, lNameT, telT, officeTimeT, officeDayT);
//        }
//        
//    }

