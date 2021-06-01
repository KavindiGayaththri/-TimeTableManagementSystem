/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.studentpackage.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import timetablemanagementsystem.studentpackage.models.ParallelSession;
import timetablemanagementsystem.studentpackage.models.academicdetails;

/**
 * FXML Controller class
 *
 * @author Kavindi Gayaththri
 */
public class Parallel_SessionController implements Initializable {
    
    ObservableList<String> subjectnamelist  = FXCollections.observableArrayList();
    ObservableList<String> lecturelist  = FXCollections.observableArrayList();
    ObservableList<String> yearsemlist  = FXCollections.observableArrayList();
    ObservableList<String> grouplist  = FXCollections.observableArrayList();
    ObservableList<String> subgrouplist  = FXCollections.observableArrayList();

    @FXML
    private TextField searchbar;
    @FXML
    private Label lb1;
    @FXML
    private Label lb5;
    @FXML
    private Label lb51112;
    @FXML
    private Label lb5111;
    @FXML
    private Label lb51111;
    @FXML
    private ComboBox<String> combo1;
    @FXML
    private ComboBox<String> combo2;
    @FXML
    private ComboBox<String> combo3;
    @FXML
    private ComboBox<String> combo4;
    @FXML
    private ComboBox<String> combo5;
    @FXML
    private Button insert1;
    @FXML
    private Button update6;
    @FXML
    private Button delete6;
    @FXML
    private Button cancel6;
    @FXML
    private Button search;
    @FXML
    private TableView<ParallelSession> table;
    @FXML
    private TableColumn<ParallelSession, String> tb0;
    @FXML
    private TableColumn<ParallelSession, String> tb1;
    @FXML
    private TableColumn<ParallelSession, String> tb2;
    @FXML
    private TableColumn<ParallelSession, String> tb3;
    @FXML
    private TableColumn<ParallelSession, String> tb4;
    @FXML
    private TableColumn<ParallelSession, String> tb5;
    @FXML
    private TableColumn<ParallelSession, String> tb6;
    @FXML
    private TableColumn<ParallelSession, String> tb7;
    @FXML
    private TableColumn<ParallelSession, String> tb8;
    @FXML
    private TableColumn<ParallelSession, String> tb9;
    @FXML
    private Label lb11;
    @FXML
    private Label lb21;
    @FXML
    private Label lb51;
    @FXML
    private Label lb511;
    @FXML
    private TextField startingtime1;
    @FXML
    private TextField endtime1;
    @FXML
    private TextField day;
    @FXML
    private TextField duration;
    @FXML
    private Label bar4;
    @FXML
    private Label label4;
    
    private String searchid = null;
    @FXML
    private Label lb12;
    @FXML
    private ComboBox<String> combo11;
    @FXML
    private TableColumn<ParallelSession, String> tb11;
    @FXML
    private Button Home;
    @FXML
    private MenuButton sm;
    @FXML
    private MenuItem sm1;
    @FXML
    private MenuItem sm2;
    @FXML
    private MenuItem sm3;
    @FXML
    private MenuItem sm4;
    @FXML
    private MenuItem sm5;
    @FXML
    private MenuItem sm6;
    @FXML
    private MenuItem sm7;
    @FXML
    private MenuItem sm8;
    @FXML
    private MenuButton sl;
    @FXML
    private MenuItem sl1;
    @FXML
    private MenuItem sl2;
    @FXML
    private MenuItem sl3;
    @FXML
    private MenuItem sl4;
    @FXML
    private MenuItem sl5;
    @FXML
    private MenuItem sl6;
    @FXML
    private MenuItem sl7;
    @FXML
    private MenuItem sl8;
    @FXML
    private MenuItem sl9;
    @FXML
    private MenuButton slo;
    @FXML
    private MenuItem slo1;
    @FXML
    private MenuItem slo2;
    @FXML
    private MenuItem slo3;
    @FXML
    private MenuItem slo4;
    @FXML
    private MenuItem slo5;
    @FXML
    private MenuItem slo6;
    @FXML
    private MenuItem slo7;
    @FXML
    private MenuButton sdm;
    @FXML
    private MenuItem sdm1;
    @FXML
    private MenuItem sdm2;
    @FXML
    private MenuItem sdm3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getSubjectDetails();
        getLuctureDetails();
        getyearsem();
        showparallelsession();
    }  
     public Connection getconnection(){
         Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable","root","");
            return conn;
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
}
      private void executeQuery(String query) {
        Connection conn = getconnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

    @FXML
    private void getSubName(ActionEvent event) {
        String selectvalue = combo1.getValue();
        System.out.println(selectvalue);
        
        Connection conn = getconnection();
        String query = "Select * From subject where subjectName='"+selectvalue+"'";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                
//                subid.setText(rs.getString("subjectCode"));
//                lecturetime.setText(rs.getString("noOfLecHours"));
//                tutorialtime.setText(rs.getString("noOfTutHours"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
    if(event.getSource() == insert1){
        InsertRecord();
        CancelRecord();
    }else if(event.getSource() == update6){
        if(searchid == null){
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }else{
            UpdateRecord();
            CancelRecord();
        }
    }else if (event.getSource() == delete6){
        if(searchid == null){
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }else{
            deleteButton();
            CancelRecord();
        }
    }else if (event.getSource() == cancel6){
        CancelRecord();
    }else if (event.getSource() == search){
        if (!(searchbar.getText().isEmpty())){
            SearchRecord();
        }
        else{
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }
    }
    }

   public void getSubjectDetails(){
        subjectnamelist.clear();
        Connection conn = getconnection();
        String query = "Select * From subject";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                
                subjectnamelist.add(rs.getString("subjectName"));
            }
            combo1.setItems(subjectnamelist);
            combo11.setItems(subjectnamelist);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    
    }
    
    public void getLuctureDetails(){
        lecturelist.clear();
        Connection conn = getconnection();
        String query = "Select * From lecturer";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                
                lecturelist.add(rs.getString("name"));
            }
            combo2.setItems(lecturelist);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    
    }
    
    public void getyearsem(){
        yearsemlist.clear();
        Connection conn = getconnection();
        String query = "Select * From groupdetails";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                
                yearsemlist.add(rs.getString("year_sem"));
            }
            combo3.setItems(yearsemlist);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    
    }

    @FXML
    private void getYearsem(ActionEvent event) {
        String selectvalue = combo3.getValue();
        System.out.println(selectvalue);
        
        Connection conn = getconnection();
        String query = "Select * From groupdetails where year_sem='"+selectvalue+"'";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                
                grouplist.add(rs.getString("group_id"));
                subgrouplist.add(rs.getString("sgroup_id"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        combo4.setItems(grouplist);
        combo5.setItems(subgrouplist);
    }
    
    private void InsertRecord(){
        String query = "INSERT INTO parallelsession(subjectname1,subjectname2,lecturename,yearsem,groupid,sgroupid,startingtime,endtime,day,duration) VALUES('"+combo1.getValue()+"','"+combo11.getValue()+"','"+combo2.getValue()+"','"+combo3.getValue()+"','"+combo4.getValue()+"','"+combo5.getValue()+"','"+startingtime1.getText()+"','"+endtime1.getText()+"','"+day.getText()+"','"+duration.getText()+"')";
        executeQuery(query);
        showparallelsession();
        searchid = null;
    }
    private void UpdateRecord(){
        String query = "UPDATE parallelsession SET subjectname1 = '" + combo1.getValue() + "' ,subjectname2 = '" + combo11.getValue() + "', lecturename = '" + combo2.getValue() + "', yearsem = '" + combo3.getValue() + "',groupid = '" + combo4.getValue() + "', sgroupid = '" + combo5.getValue() + "', startingtime = '" + startingtime1.getText()+ "',endtime = '"+ endtime1.getText() +"',day = '" + day.getText()+ "', duration = '" + duration.getText()+ "' where id ="+searchid+"";
        executeQuery(query);
        showparallelsession();
        searchid = null;
    }
    private void deleteButton(){
        String query = "DELETE FROM parallelsession where id ="+searchid+"";
        executeQuery(query);
        showparallelsession();
        searchid = null;
    }
    private void CancelRecord(){
        
        combo1.setValue("");
        combo11.setValue("");
        combo2.setValue("");
        combo3.setValue("");
        combo4.setValue("");
        combo5.setValue("");
        startingtime1.setText("");
        endtime1.setText("");
        day.setText("");
        duration.setText("");
        searchbar.setText("");
        
        getSubjectDetails();
        getLuctureDetails();
        getyearsem();
        showparallelsession();
        
        showparallelsession();
    }
    
    public ObservableList<ParallelSession> getParallelSessionlist(){
        ObservableList<ParallelSession> parallelsessionlist = FXCollections.observableArrayList();
        Connection conn = getconnection();
        String query = "SELECT * FROM parallelsession";
        Statement st;
        ResultSet rs;
          
        try {
            
        st = conn.createStatement();
        rs = st.executeQuery(query);
        ParallelSession parallel_obj;
        while(rs.next()){
            parallel_obj = new ParallelSession(String.valueOf(rs.getInt("id")), rs.getString("subjectname1"), rs.getString("subjectname2"), rs.getString("lecturename"), rs.getString("yearsem"), rs.getString("groupid"), rs.getString("sgroupid") , rs.getString("startingtime") , rs.getString("endtime") ,rs.getString("day"), rs.getString("duration"));
            parallelsessionlist.add(parallel_obj);
            
        }
    }catch (Exception ex){
        ex.printStackTrace();
    }
        return parallelsessionlist;
   }
    public void showparallelsession(){
        ObservableList<ParallelSession> list = getParallelSessionlist();
        
        tb0.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("id"));
        tb1.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("subjectname1"));
        tb11.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("subjectname2"));
        tb2.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("lecturename"));
        tb3.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("yearsem"));
        tb4.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("groupid"));
        tb5.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("sgroupid"));
        tb6.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("startingtime"));  
        tb7.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("endtime"));
        tb8.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("day"));
        tb9.setCellValueFactory(new PropertyValueFactory<ParallelSession, String>("duration"));
        table.setItems(list);
        
    }
    
    private void SearchRecord() throws SQLException {
        
        searchid = searchbar.getText();
        
        ObservableList<academicdetails> Academicdetailslist = FXCollections.observableArrayList();
        Connection conn = getconnection();
        String query = "SELECT * FROM parallelsession where id="+searchid+"";
        Statement st;
        ResultSet rs;
            
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
           
        while(rs.next()){
            combo1.setValue(rs.getString("subjectname1"));
            combo11.setValue(rs.getString("subjectname2"));
            combo2.setValue(rs.getString("lecturename"));
            combo3.setValue(rs.getString("yearsem"));
            combo4.setValue(rs.getString("groupid"));
            combo5.setValue(rs.getString("sgroupid"));
            startingtime1.setText(rs.getString("startingtime"));
            endtime1.setText(rs.getString("endtime"));
            day.setText(rs.getString("day"));
            duration.setText(rs.getString("duration"));
            
        }
        
        }catch (Exception ex){
        ex.printStackTrace();
    }
        
    
    
}

    @FXML
    private void handleMenuStudent(ActionEvent event) throws IOException {
        
        if(event.getSource() == Home){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/Home.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm1){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/academicdetails.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm2){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/program_details.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm3){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/group_details.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm4){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/managetags.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm5){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/generate_group_id.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm6){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/consecutive_session.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm7){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/Parallel_Session.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm8){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/overlapping.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        
    }

    @FXML
    private void handleMenuLecture(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystemfx/views/dashboard.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) sdm).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleMenuLocation(ActionEvent event) throws IOException {
        if(event.getSource() == slo1){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/StudentStatistic.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo2){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/StaticforLectureSubject.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo3){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/RoomforSubTagLecSes.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo4){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/RoomForgroup.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo5){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/concesession.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo6){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/timecannotreserved.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo7){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/buildingandroom.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        
    }

    @FXML
    private void handleMenuDay(ActionEvent event) throws IOException {
        if(event.getSource() == sdm1){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/workingDaysAndHours/views/WorkingDaysAndHours.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sdm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sdm2){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/workingDaysAndHours/views/SessionAndNotAvailableTimeAllocation.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sdm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sdm3){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/workingDaysAndHours/views/SessionRoom.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sdm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
    }

}
