package hotelBooking;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class UpdateCheck extends JFrame implements ActionListener{
    Choice ccustomer ;
    JTextField tfroom,tfname, tfchecking,tfpaid,tfpending;
    JButton check, update,back;
    
UpdateCheck(){
    
getContentPane().setBackground(Color.WHITE);
setLayout(null);

JLabel text = new JLabel("Update Status");
text.setFont(new Font ("tahoma", Font.PLAIN,20));
text.setBounds(90,20,200,30);
text.setForeground(Color.BLUE);
add(text);

JLabel Iblid = new JLabel("Customer Id");
Iblid.setBounds(30,80,100,30);
add(Iblid);

ccustomer = new Choice();
ccustomer.setBounds(200,80,150,25);
add(ccustomer);

try{
    
    Conn c=new Conn();
    ResultSet rs =c.s.executeQuery("select * from Customer");
    while(rs.next()){
        ccustomer.add(rs.getString("number"));
    }
}catch(Exception e){
    e.printStackTrace();
}
JLabel Iblroom= new JLabel("Room Number");
Iblroom.setBounds(30,120,100,30);
add(Iblroom);

tfroom = new JTextField();
tfroom.setBounds(200,120,150,25);
add(tfroom);

JLabel Iblname= new JLabel("Name");
Iblname.setBounds(30,160,100,20);
add(Iblname);

tfname = new JTextField();
tfname.setBounds(200,160,150,25);
add(tfname);

JLabel Iblchecking= new JLabel("Checking Time");
Iblchecking.setBounds(30,200,150,25);
add(Iblchecking);

tfchecking = new JTextField();
tfchecking.setBounds(200,200,150,25);
add(tfchecking);


JLabel Iblpaid= new JLabel("Amount Paid");
Iblpaid.setBounds(30,240,100,20);
add(Iblpaid);

tfpaid = new JTextField();
tfpaid.setBounds(200,240,150,25);
add(tfpaid);

JLabel Iblpending= new JLabel("Pending Amount");
Iblpending.setBounds(30,280,100,20);
add(Iblpending);

tfpending = new JTextField();
tfpending .setBounds(200,280,150,25);
add(tfpending );


check =  new JButton ("check");
check.setBackground(Color.BLACK);
check.setForeground(Color.WHITE);
check.setBounds(30,340,100,30);
check.addActionListener(this);
add(check);


update =  new JButton ("update");
update.setBackground(Color.BLACK);
update.setForeground(Color.WHITE);
update.setBounds(150,340,100,30);
update.addActionListener(this);
add(update);

back =  new JButton ("back");
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.setBounds(270,340,100,30);
back.addActionListener(this);
add(back);

ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Icons/nine.jpg"));
JLabel image = new JLabel(i1);
image.setBounds(400,50,500,300);
add(image);
setBounds(300,200,980,500);
setVisible(true);

}

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==check){
        String id =ccustomer.getSelectedItem();
        String query = "select * from customer where number  = '"+id+"'";
        try{
            Conn c = new Conn();
            ResultSet rs = c.s .executeQuery(query);
            while(rs.next()){
                tfroom.setText(rs.getString("room"));
                tfname.setText(rs.getString("name"));
                tfchecking.setText(rs.getString("checkingtime"));
                tfpaid.setText(rs.getString("deposite"));      
            } 
            ResultSet rs2=c.s.executeQuery("select * from room where roomnumber ='"+tfroom.getText()+"'");
            while(rs2.next()){
                String price = rs2.getString("price");
                int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfpaid.getText());
                tfpending.setText(""+amountPaid);
            }
        }
    
    
        catch(Exception e){
            e.printStackTrace();
        }
    }
    else if(ae.getSource() == update){
        String number=ccustomer.getSelectedItem();
        String room=tfroom.getText();
        String name=tfname.getText();
        String checking=tfchecking.getText();
        String deposite=tfpaid.getText();
        
        
        try{
            Conn c=new Conn();
            c.s.executeUpdate("update customer set room ='"+room+"', name = '"+name+"',checkingtime ='"+checking+"',deposite ='"+deposite+"' where number = '"+number+"'");
            
            JOptionPane.showMessageDialog(null," Data Updated Successfully");
            setVisible(false);
            new Reception();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    else{
        setVisible(false);
        new Reception();
        
    }
}


public static void main(String[]args){
    new UpdateCheck();
}
}
