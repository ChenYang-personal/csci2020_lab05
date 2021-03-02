package sample;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.FXMLLoader;
import javafx.beans.property.SimpleStringProperty;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent origin = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle(" Lab05 ");
        DataSource data = new DataSource();
        ObservableList dat = data.getAllMarks();
        TableView TV = new TableView();
        TV.setItems(dat);
        TableColumn column1 = new TableColumn("SID");
        column1.setCellValueFactory(new PropertyValueFactory("studentID"));
        TableColumn column2 = new TableColumn("Assignments");
        column2.setCellValueFactory(new PropertyValueFactory("assignments"));
        TableColumn column3 = new TableColumn("Midterm");
        column3.setCellValueFactory(new PropertyValueFactory("midterm"));
        TableColumn column4 = new TableColumn("Final Exam");
        column4.setCellValueFactory(new PropertyValueFactory("finalExam"));
        TableColumn column5 = new TableColumn("Final Mark");
        column5.setCellValueFactory(new PropertyValueFactory("finalMark"));
        TableColumn column6 = new TableColumn("Letter Grade");
        column6.setCellValueFactory(new PropertyValueFactory("letterGrade"));
        TV.getColumns().setAll(column1, column2,column3,column4,column5,column6);
        TV.setPrefHeight(800);
        TV.setPrefWidth(1000);
        TV.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox vb = new VBox(30);
        vb.getChildren().addAll(TV);
        vb.setPadding(new Insets(35, 35, 35, 35));;
        Scene table = new Scene(vb, 550, 657);
        primaryStage.setScene(table);
        primaryStage.show();
    }

    public class DataSource {
        public  ObservableList<StudentRecord> getAllMarks()
        {
            ObservableList<StudentRecord> marks =
                    FXCollections.observableArrayList();
// Student ID, Assignments, Midterm, Final exam
            marks.add(new StudentRecord("100100100", 75.0f, 68.0f,
                    54.25f)); marks.add(new StudentRecord("100100101", 70.0f,
                69.25f, 51.5f)); marks.add(new StudentRecord("100100102",
                100.0f, 97.0f, 92.5f)); marks.add(new
                StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
            marks.add(new StudentRecord("100100104", 72.25f, 74.75f,
                    58.25f));
            marks.add(new StudentRecord("100100105", 85.0f, 56.0f,
                    62.5f)); marks.add(new StudentRecord("100100106", 70.0f,
                66.5f, 61.75f)); marks.add(new StudentRecord("100100107",
                55.0f, 47.0f, 50.5f)); marks.add(new
                StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
            marks.add(new StudentRecord("100100109", 82.5f, 77.0f,
                    74.25f));
            return marks;
        }
    }

    public class StudentRecord{

        private SimpleStringProperty studentID;
        private SimpleStringProperty letterGrade;
        private SimpleDoubleProperty midterm;
        private SimpleDoubleProperty assignments;
        private SimpleDoubleProperty finalExam;
        private SimpleDoubleProperty finalMark;
        StudentRecord(String id, double assig, double midt , double fina){
            studentID = new SimpleStringProperty(id);
            midterm   = new SimpleDoubleProperty(midt);
            assignments=new SimpleDoubleProperty(assig);
            finalExam =new SimpleDoubleProperty(fina);
            double total = 2/100*assig+3/100*midt+5/100*fina;
            finalMark =new SimpleDoubleProperty(total);
            if(total>=80){
                letterGrade=new SimpleStringProperty("A");
            }
            else if(total>=70){
                letterGrade=new SimpleStringProperty("B");
            }
            else if(total>=60){
                letterGrade=new SimpleStringProperty("C");
            }
            else if(total>=50){
                letterGrade=new SimpleStringProperty("D");
            }
            else{
                letterGrade=new SimpleStringProperty("F");
            }

        }
        public String getStudentID() {
            return studentID.get();
        }
        public String getLetterGrade() {
            return letterGrade.get();
        }
        public double getMidterm() {
            return midterm.get();
        }
        public double getAssignments() {
            return assignments.get();
        }
        public double getFinalExam() {
            return finalExam.get();
        }
        public double getFinalMark() {
            return finalMark.get();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

