package hotelBooking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,rooms,department,allEmployee,ManagerInfo,Customer,searchRoom,pickup,checkout,logout,Update,Roomstatus;
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
        newCustomer =  new JButton("New Customer Form ");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        
       
         rooms =  new JButton("Rooms ");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        department =  new JButton("Department ");
        department .setBounds(10,110,200,30);
        department .setBackground(Color.BLACK);
       department .setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department );
        
        allEmployee =  new JButton("All Employee");
         allEmployee .setBounds(10,150,200,30);
         allEmployee .setBackground(Color.BLACK);
        allEmployee .setForeground(Color.WHITE);
        allEmployee.addActionListener(this);
        add( allEmployee );
        
        
        Customer =  new JButton ("Customer");
         Customer.setBounds(10,190,200,30);
        Customer .setBackground(Color.BLACK);
        Customer .setForeground(Color.WHITE);
        Customer.addActionListener(this);
        add( Customer );
       
        
        ManagerInfo =  new JButton(" Manager Info");
        ManagerInfo .setBounds(10,230,200,30);
        ManagerInfo.setBackground(Color.BLACK);
        ManagerInfo .setForeground(Color.WHITE);
       ManagerInfo.addActionListener(this);
        add(  ManagerInfo);
        
        
         checkout =  new JButton("Checkout");
         checkout .setBounds(10,270,200,30);
         checkout.setBackground(Color.BLACK);
        checkout .setForeground(Color.WHITE);
         checkout.addActionListener(this);
        add( checkout);
        
         Update =  new JButton("Update Status");
         Update  .setBounds(10,310,200,30);
         Update .setBackground(Color.BLACK);
       Update  .setForeground(Color.WHITE);
       Update.addActionListener(this);
        add( Update  );
        
        Roomstatus =  new JButton("Update Room Status");
         Roomstatus  .setBounds(10,350,200,30);
         Roomstatus .setBackground(Color.BLACK);
      Roomstatus .setForeground(Color.WHITE);
      Roomstatus.addActionListener(this);
        add( Roomstatus  );
        
        pickup =  new JButton("Pickup Service");
          pickup   .setBounds(10,390,200,30);
         pickup .setBackground(Color.BLACK);
       pickup .setForeground(Color.WHITE);
       pickup.addActionListener(this);
        add(  pickup   );
        
        
        
         searchRoom =  new JButton("Search Room");
          searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(Color.BLACK);
       searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(  searchRoom);
        
        
        logout =  new JButton("Logout");
         logout .setBounds(10,470,200,30);
        logout .setBackground(Color.BLACK);
       logout  .setForeground(Color.WHITE);
       logout.addActionListener(this);
        add(  logout    );
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        setBounds (350,200,800,570);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==department){
            setVisible(false);
            new Department();
        }
        else if (ae.getSource()==allEmployee){
            setVisible(false);
            new Employeeinfo();
        }
        else if(ae.getSource()== ManagerInfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource()== Customer){
            setVisible(false);
            new CustomerInfo();
        }
        else if (ae.getSource()== searchRoom){
            setVisible(false);
            new SearchRoom();
    }
        else if(ae.getSource()== pickup){
            setVisible(false);
            new pickup();
        }
        else if (ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }else if (ae.getSource()== logout){
            setVisible(false);
            System.exit(0);
        }
        else if(ae.getSource()==Update){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource()== Roomstatus){
            setVisible(false);
            new UpdateRoom();
        }
    }
    
    public static void main(String[]args){
        
        new Reception();
    }
}
