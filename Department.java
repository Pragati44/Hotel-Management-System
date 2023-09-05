package hotelBooking;


import javax.swing.*;
import java .awt.*;
import java .awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel i1 =new JLabel("Department");
        i1.setBounds(180,10,100,20);
        add(i1);
        
        JLabel i2 =new JLabel("Budget");
        i2.setBounds(420,10,100,20);
        add(i2);
        
       table = new JTable();
       table.setBounds(0,50,700,350);
       add(table);
       
       try{
           Conn c= new Conn();
          ResultSet rs =  c.s.executeQuery("select * from department");
         table.setModel(DbUtils.resultSetToTableModel(rs));  
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       back = new JButton ("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       back.setBounds(280,400,120,30);
       add(back);
       
       
       
       
        
      setBounds(400,200,700,480);
      setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    
    
    public static void main (String[] args){
        
        new Department(); 
    }
    
}

