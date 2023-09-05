package hotelBooking;
import javax.swing.*;
import java .awt.*;
import java .awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class pickup extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice TypeOfCar;
    JCheckBox available; 
    pickup(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text= new JLabel ("Pickup Service");
        text.setFont(new Font("tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        
        JLabel iblbed= new JLabel ("Type Of Car");
        iblbed.setBounds(50,100,100,20);
        add(iblbed);
        
        TypeOfCar= new Choice();
        TypeOfCar.setBounds(150,100,200,25);
        add(TypeOfCar);
        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from driver");
            while (rs.next()){
                TypeOfCar.add(rs.getString("brand"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
      
        JLabel i5 =new JLabel("Name");
        i5.setBounds(50,160,100,20);
        add(i5);
        
        JLabel i6 =new JLabel("Age");
        i6.setBounds(200,160,100,20);
        add(i6);
        
        
        JLabel i7 =new JLabel("Gender");
        i7.setBounds(330,160,100,20);
        add(i7);
        
        JLabel i8 =new JLabel("Company");
        i8.setBounds(460,160,100,20);
        add(i8);
        
        
        JLabel i9 =new JLabel("Brand");
        i9.setBounds(630,160,100,20);
        add(i9);
        
        
        
        JLabel i10 =new JLabel("Availability");
        i10.setBounds(740,160,100,20);
        add(i10);
        
        JLabel i11 =new JLabel("Location");
        i11.setBounds(890,160,100,20);
        add(i11);
 
        
       table = new JTable();
       table.setBounds(0,200,1000,300);
       add(table);
       
       try{
           Conn c= new Conn();
          ResultSet rs =  c.s.executeQuery("select * from driver");
         table.setModel(DbUtils.resultSetToTableModel(rs));  
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       
        
       submit = new JButton ("Submit");
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.addActionListener(this);
       submit.setBounds(300,520,120,30);
       add(submit);
       
       
       
       back = new JButton ("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       back.setBounds(500,520,120,30);
       add(back);
       
       
       
       
        
      setBounds(300,200,1000,600);
      setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            try{
        String query = "select * from driver where brand = '"+TypeOfCar.getSelectedItem()+"'";
        
        Conn conn =  new Conn();
        ResultSet rs;
             rs=conn.s.executeQuery(query);
         
         table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
       else{
        setVisible(false);
        new Reception();
    }
    
    }
    
    public static void main (String[] args){
        
        new pickup(); 
    }
    
}
