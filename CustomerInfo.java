package hotelBooking;
import javax.swing.*;
import java .awt.*;
import java .awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel i5 =new JLabel("Document Type");
        i5.setBounds(10,10,100,20);
        add(i5);
        
        JLabel i6 =new JLabel("Number");
        i6.setBounds(160,10,100,20);
        add(i6);
        
        
        JLabel i7 =new JLabel("Name");
        i7.setBounds(290,10,100,20);
        add(i7);
        
        JLabel i8 =new JLabel("Gender");
        i8.setBounds(410,10,100,20);
        add(i8);
        
        
        JLabel i9 =new JLabel("Country");
        i9.setBounds(540,10,100,20);
        add(i9);
        
        
        
        JLabel i10 =new JLabel("Room Number ");
        i10.setBounds(640,10,100,20);
        add(i10);
        
        
        JLabel i11=new JLabel("Checking time");
        i11.setBounds(760,10,100,20);
        add(i11);
        
        JLabel i12=new JLabel("Deposite");
        i12.setBounds(900,10,100,20);
        add(i12);
        
        
        
        
       table = new JTable();
       table.setBounds(0,40,1000,400);
       add(table);
       
       try{
           Conn c= new Conn();
          ResultSet rs =  c.s.executeQuery("select * from customer");
         table.setModel(DbUtils.resultSetToTableModel(rs));  
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       back = new JButton ("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       back.setBounds(200,500,160,30);
       add(back);
       
       
       
       
        
      setBounds(300,200,1050,600);
      setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    
    
    public static void main (String[] args){
        
        new CustomerInfo(); 
    }
    
}
