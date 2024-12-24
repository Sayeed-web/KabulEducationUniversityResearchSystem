package test_u_m_s;

import java.rmi.server.Operation;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Update_delete_Research {
    
  //  public void insertion(char operation,Integer id,String name1,String lname2,String salary1,String pos ,String ph ,String address1,String gender ){
            void insertion(char operation, int id, String name1, String lname2, String writer, String workName, String WorkType, String yearPub, String magazinName, String page, String sn, String pubName, String modifier) {

                            //name1,lname2,salary1, pos,ph, address1, gender
        Connection con=MyconnectionDemo.getConnection();
       PreparedStatement ps; 
        if(operation=='j'){//j is for insert
            try{
            ps=con.prepareStatement("INSERT INTO `research`(`id`, `name`, `lname`, `writer`, `workName`, `workType`, `yearPub`, `magazine`, `page`, `issn`, `pubName`, `modifier`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ");
          
            //  ps.setInt(8, id);
            ps.setString(1, name1);
             ps.setString(2, lname2);
              ps.setString(3, writer);
                ps.setString(4, workName);
                  ps.setString(5, WorkType);
                    ps.setString(6, yearPub);
                     ps.setString(7, magazinName);
               ps.setString(8, page);
               ps.setString(9, sn);
               ps.setString(10, pubName);
               ps.setString(11, modifier);
               
           
               if (ps.executeUpdate()>0) {
                   
                   JOptionPane.showMessageDialog(null, "Record inserted Successfully!!");
                   
                
            }else{
   JOptionPane.showMessageDialog(null, "Record not inserted Successfully!!");
 
                   
                   
               } }catch(Exception e){}
            
    }
        
        
        
 
     if(operation=='u'){//j is for Update
            try{
            ps=con.prepareStatement("UPDATE research SET name=?,lname=?,writer=?,workName=?,workType=?,yearPub=?,magazine=?,page=?,issn=?,pubName=?,modifier=? where id=?");
          
                  
                ps.setString(1, name1);
                ps.setString(2, lname2);
                ps.setString(3, writer);
                ps.setString(4, workName);
                ps.setString(5, WorkType);
                ps.setString(6, yearPub);
                ps.setString(7, magazinName);
                ps.setString(8, page);
                ps.setString(9, sn);
                ps.setString(10, pubName);
                ps.setString(11, modifier);
                ps.setInt(12, id);
           
               if (ps.executeUpdate()>0) {
                   
                   JOptionPane.showMessageDialog(null, "Record Updated Successfully!!");
                   
                
            }else{
   JOptionPane.showMessageDialog(null, "Record not updated Successfully!!");
 
                   
                   
               } }catch(Exception e){}
            
    }    
       
      if(operation=='d'){//d for delete
            try{
            ps=con.prepareStatement("delete from research where id=? ");
            
             ps.setInt(1, id);
         // ps.setString(2, name1);
            
           
               if (ps.executeUpdate()>0) {
                   
                   JOptionPane.showMessageDialog(null, "Record Deleted Successfully!!");
                   
                
            }else{
   JOptionPane.showMessageDialog(null, "Record not Delete Successfully!!");
 
                   
                   
               } }catch(Exception e){}
            
    }
      
      
      
      
      
      
      
}
    public void fillEmployee(JTable table,String valuesearch){
        
        Connection con=MyconnectionDemo.getConnection();
        PreparedStatement ps;
        
        try {
            ps=con.prepareStatement("select * from research where CONCAT(id,name,lname,writer,workName,workType,yearPub,magazine,page,issn, pubName, modifier)like ? ");
            ps.setString(1,"%"+valuesearch+"%");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model=(DefaultTableModel)table.getModel();
       Object [] row;
            while (rs.next()) {                
                
                row=new Object[12];
                row [0]=rs.getInt(1);
                row [1]=rs.getString(2);
                row [2]=rs.getString(3);
                row [3]=rs.getString(4);
                row [4]=rs.getString(5);
                row [5]=rs.getString(6);
                row [6]=rs.getString(7);
                row [7]=rs.getString(8);
                row [8]=rs.getString(9);
                row [9]=rs.getString(10);
                row [10]=rs.getString(11);
                row [11]=rs.getString(12);
                model.addRow(row);
                 
            }
            
        } catch (Exception e) {
        }
    }
    
      
      
      
      
      
      
      
      
    
}


    

    

