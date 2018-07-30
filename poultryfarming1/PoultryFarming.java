package poultryfarming1;
import java.awt.Panel;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.DatePicker;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.DateCell;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.WindowEvent;
import javafx.util.Callback;


public class PoultryFarming extends Application {
    private static final String username="root";
    private static final String password="actmq%#DOact";
    private static final String conn_string="jdbc:mysql://localhost:3306/polutryfarm";
    String businesstype;
    String country1;
    String valuofview="no",valuofview1="no",valuofview2="no",valuofview3="no";
    int lineflag;
    Button btnscene1, btnscene2;
    Label lblscene1, lblscene2;
    FlowPane pane1, pane2;
    Scene scene1, scene2;
    Stage thestage,thestage1;
    int flag=0,connect=0;
    
    private DatePicker checkInDatePicker,checkInDatePicker1,checkInDatePicker2,checkInDatePicker3;
    private DatePicker checkOutDatePicker,checkOutDatePicker1,checkOutDatePicker2,checkOutDatePicker3;
    private final TableView<Person> table = new TableView<>();
    private final ObservableList<Person> data =
        FXCollections.observableArrayList(
            /*new Person("1", "100", "vetsatile","1000","10"),
            new Person("2", "200", "celestial","2000","20"),
            new Person("3", "300", "universal","3000","30"),
            new Person("4", "400", "amblin","4000","40"),
            new Person("5", "500", "lucas","5000","40")*/
        );
    private final TableView<Person1> table1 = new TableView<>();
    private final ObservableList<Person1> data1 =
        FXCollections.observableArrayList(
           /* new Person("1", "100", "vetsatile","1000","10")
            /*new Person("2", "200", "celestial","2000","20"),
            new Person("3", "300", "universal","3000","30"),
            new Person("4", "400", "amblin","4000","40"),
            new Person("5", "500", "lucas","5000","40")*/
        );
    private final TableView<Person2> table2 = new TableView<>();
    private final ObservableList<Person2> data2 =
        FXCollections.observableArrayList(
           /* new Person("1", "100", "vetsatile","1000","10")
            /*new Person("2", "200", "celestial","2000","20"),
            new Person("3", "300", "universal","3000","30"),
            new Person("4", "400", "amblin","4000","40"),
            new Person("5", "500", "lucas","5000","40")*/
        );
    private final TableView<Person3> table3 = new TableView<>();
    private final ObservableList<Person3> data3 =
        FXCollections.observableArrayList(
            /*new Person("1", "100", "vetsatile","1000","10"),
            new Person("2", "200", "celestial","2000","20"),
            new Person("3", "300", "universal","3000","30"),
            new Person("4", "400", "amblin","4000","40"),
            new Person("5", "500", "lucas","5000","40")*/
        );
    
    
    //private TableView table = new TableView();
    @Override
    
    public void start(Stage primaryStage)  {
        
        try{thestage=primaryStage;
        thestage1=primaryStage;
        thestage.setTitle("PFM");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 1020, 600);
        thestage.setScene(scene);
        double a=thestage.getMaxHeight();
        double b=thestage.getMaxWidth();
        //System.out.println("height:"+a+"width:"+b);
        thestage.setMinWidth(1020);
        thestage.setMinHeight(600.00);
        Image i=new Image(PoultryFarming.class.getResourceAsStream("titlebar.png"));
       
        thestage.getIcons().add(i);
        
        loginpage();
        
        
        thestage.show();
        }catch(Exception ex){
            Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText(ex.toString());

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
        }
    }

    public static Connection conn = null;
    public void connection()
    {
        
       try{
          
      Class.forName("com.mysql.jdbc.Driver");
      conn=DriverManager.getConnection(conn_string, username, password);
      System.out.println("connected");
      
      }catch(SQLException e){
          System.out.println("Exception"+e);
      }catch(ClassNotFoundException e){
          System.out.println("Exception"+e);
      } 
    }
    
    public static void main(String[] args) {
        launch(args);
         
      
        
}
    
    
    public void ButtonClicked(ActionEvent e)
    {
                thestage.setTitle("PFM");
                GridPane grid = new GridPane();
                grid.setAlignment(Pos.TOP_LEFT);
                grid.setHgap(10);
                grid.setVgap(10);
                grid.setPadding(new Insets(25, 25, 25, 25));
                //grid.setGridLinesVisible(true);
                Scene scene = new Scene(grid, 1000, 750);
                thestage.setScene(scene);
                thestage.setMaxWidth(1000);
                thestage.setMaxHeight(750);
                thestage.setMinWidth(1000);
                thestage.setMinHeight(750);
                thestage.setOnCloseRequest(b-> closeregister(b));
                
                
                Text scenetitle = new Text("REGISTER");
                scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
                grid.add(scenetitle, 10, 5, 2, 1);
                Label userName = new Label("User Name:");
                grid.add(userName, 10,6);
                TextField userTextField = new TextField();
                userTextField.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                userTextField.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
                
                grid.add(userTextField, 11,6,2,1);
                
                
                Label fname = new Label("First Name:");
                grid.add(fname, 10,8);
                TextField userTextField1 = new TextField();
                userTextField1.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                userTextField1.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
                grid.add(userTextField1, 11,8,2,1);
                Label lname = new Label("Last Name:");
                grid.add(lname, 10,10);
                TextField userTextField2 = new TextField();
                userTextField2.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                userTextField2.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
                
                grid.add(userTextField2, 11,10,2,1);
                Label enterprise = new Label("Enterprise:");
                grid.add(enterprise, 10,12);
                TextField userTextField3 = new TextField();
                userTextField3.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                userTextField3.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
                
                userTextField3.setEditable(true);
                userTextField3.setPromptText("eg.healthy farm pvt.ltd.");
                grid.add(userTextField3, 11,12,2,1);
                Label business = new Label("Business Type:");
                grid.add(business, 10,14);
    
                ObservableList<String> options = 
                FXCollections.observableArrayList(
                    "Poultry Farm",
                    "Poultry retailer"
        
                );
    
                final ComboBox comboBox = new ComboBox(options);
                comboBox.setEditable(false);
                comboBox.setValue("Select Business type");
                comboBox.valueProperty().addListener(new ChangeListener<String>() {
                        @Override 
                        public void changed(ObservableValue ov, String t, String t1) {                
                            businesstype = t1;                
                        }    


                    });
                    
                    grid.add(comboBox, 11,14);
                    Label phonenumber = new Label("Phone number");
                    grid.add(phonenumber, 10,16);
                    TextField userTextField4 = new TextField();
                    
                    
                    userTextField4.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                userTextField4.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                            
                        }
                    });
                    

                    grid.add(userTextField4, 11,16,2,1);
                    Label address = new Label("address");
                    grid.add(address, 10,18);
                    TextField userTextField5 = new TextField();
                    userTextField5.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                userTextField5.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
                    
                    grid.add(userTextField5, 11,18,2,1);
                    Label country = new Label("country");
                grid.add(country, 10,20);
    
                ObservableList<String> options1 = 
                FXCollections.observableArrayList(
                    "India",
                    "Nepal",
                    "Sri Lanka",
                    "Bhutan"
        
                );
    
                final ComboBox comboBox1 = new ComboBox(options1);
                comboBox1.setEditable(false);
                comboBox1.setValue("Select country");
                comboBox1.valueProperty().addListener(new ChangeListener<String>() {
                        @Override 
                        public void changed(ObservableValue ov, String t, String t1) {                
                            country1= t1;                
                        }    


                    });
                    grid.add(comboBox1, 11,20);
                    Label pincode = new Label("pincode");
                    grid.add(pincode, 10,22);
                    TextField userTextField8 = new TextField();
                    
                    String pincodetext=userTextField8.getText();
                    grid.add(userTextField8, 11,22,2,1);
                    userTextField8.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                userTextField8.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                        }
                    });
                    
                    Label passwd1 = new Label("password");
                    grid.add(passwd1, 10,24);
                    PasswordField userTextField6 = new PasswordField();
                    userTextField6.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                userTextField6.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
                    
                    grid.add(userTextField6, 11,24,2,1);
                    Label passwd2 = new Label("confirm password");
                    grid.add(passwd2, 10,26);
                    PasswordField userTextField7 = new PasswordField();
                    userTextField7.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                userTextField7.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
                    
                    String passedcon=userTextField7.getText();
                    
                            
                    grid.add(userTextField7, 11,26,2,1);
                    btnscene2 = new Button("register");
                    HBox hbBtn1 = new HBox(10);
                    hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
                    hbBtn1.getChildren().add(btnscene2);
                    grid.add(hbBtn1, 11, 28, 1, 1);
                    final Text actiontarget1 = new Text();
                            
                    btnscene2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String use="rand";
                 use=String.valueOf(userTextField.getText());
                use.trim();
                use.toLowerCase();
                String fn="rand";
                 fn=String.valueOf(userTextField1.getText());
                fn.trim();
                fn.toLowerCase();
                String ln="rand";
                 ln=String.valueOf(userTextField2.getText());
                ln.trim();
                fn.toLowerCase();
                String ent="rand";
                 ent=String.valueOf(userTextField3.getText());
                 String passc="rand";
                 passc=String.valueOf(userTextField7.getText());
                 String phn="rand";
                 phn=String.valueOf(userTextField4.getText());
                 if(phn.length()>10)
                 {
                     phn=phn.trim().substring(0,10);
                 }
                 String pin="rand";
                 pin=String.valueOf(userTextField8.getText());
                 if(pin.length()>6)
                 {
                     pin=pin.trim().substring(0,6);
                 }
                 String pass="rand";
                 pass=String.valueOf(userTextField6.getText());
                pass.trim();
                pass.toLowerCase();
                String addr="rand";
                 addr=String.valueOf(userTextField5.getText());
                addr.trim();
                addr.toLowerCase();
                boolean a1=use.isEmpty();
                boolean a2=fn.isEmpty();
                boolean a3=ln.isEmpty();
                boolean a4=ent.isEmpty();
                boolean a5=phn.isEmpty();
                boolean a6=pin.isEmpty();
                boolean a7=pass.isEmpty();
                boolean a8=addr.isEmpty();
                System.out.println("1 "+a1+"2 "+a2+"3 "+a3+"4 "+a4+"5 "+a5+"6 "+a6+"7 "+a7+"8 "+a8);
                if(a1 || a2 || a3 || a4 || a5 || a6 || a7 || a8)
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Registration Form");
                        
                        alert.setContentText("Enter all the details");

                        alert.showAndWait();
                        
                        System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }
                else{
                    if(!pass.equals(passc)){
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Registration Form");
                        
                        alert.setContentText("enter the same conformation password");

                        alert.showAndWait();
                        
                        System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }
                    else{
                
                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
      
                    String sql = "INSERT INTO register1(username,password,firstname,lastname, enterprise,businessType,phone,address,country,pincode) " +"VALUES ('"+use.trim().toLowerCase()+"','"+pass.trim().toLowerCase()+"','"+fn.trim().toLowerCase()+"','"+ln.trim().toLowerCase()+"','"+ent.trim().toLowerCase()+"','"+businesstype+"','"+phn.trim()+"','"+addr+"','"+country1+"','"+pin.trim()+"')";
                    stmt.executeUpdate(sql);
                    

                }catch(SQLException se){
                    
                    Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("");
                        
                        alert.setContentText("enter a different username");

                        alert.showAndWait();
                        
                        System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        connect=1;
                    
                }catch(Exception ae){
                    
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            if(connect==0){    
             RegisteredClicked();
            }
            }
            }
                
        }    
    });
                      
                    Button back=new Button("back");
                    back.setId("back");
                    grid.add(actiontarget1,10,29,4,1);
                    back.setOnAction(f-> logouttologinpage(f));
                    
                    grid.add(back, 10, 28, 1, 1);
                    
                    
                    scene.getStylesheets().add(PoultryFarming.class.getResource("register.css").toExternalForm());
                    thestage.show();
    }
    public void RegisteredClicked()
    {
        thestage.setTitle("PFM");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 1020, 600);
        thestage.setScene(scene);
        thestage.setScene(scene);
        thestage.setMaxWidth(1020);
        thestage.setMaxHeight(600.00);
        
        thestage.setMinWidth(1020);
        thestage.setMinHeight(600.00);
        
        thestage.setOnCloseRequest(b-> close(b));
        thestage.setOnCloseRequest(new EventHandler<WindowEvent>(){;
                    public void handle(WindowEvent event) {

                    //File Menu Trees Exit
                    Label secondLabel = new Label("Are you sure you want to logout?");
                    Button buttonNo = new Button();

                    buttonNo.setStyle("-fx-font: 10 arial; -fx-base: #d3d3d3;");
                    buttonNo.setTranslateX(+55);
                    buttonNo.setTranslateY(30);

                    Button buttonYes = new Button();

                    buttonYes.setStyle("-fx-font: 10 arial; -fx-base: #d3d3d3;");
                    buttonYes.setTranslateX(-55);
                    buttonYes.setTranslateY(30);

                    buttonNo.setText("No");
                    buttonNo.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            System.out.println("No");
                            Stage secondStage = (Stage) buttonNo.getScene().getWindow();
                            secondStage.close();
                        }

                    });
                    buttonYes.setText("Yes");
                    buttonYes.setOnAction(f->logouttologinpage(f));
                    StackPane secondaryLayout = new StackPane();
                    secondaryLayout.getChildren().add(secondLabel);
                    secondaryLayout.getChildren().add(buttonNo);
                    secondaryLayout.getChildren().add(buttonYes);

                    Scene secondScene = new Scene(secondaryLayout, 350, 150);

                    Stage secondStage = new Stage();
                    secondStage.setTitle("Exit");
                    secondStage.setScene(secondScene);
                    secondStage.setX(thestage.getX() + 250);
                    secondStage.setY(thestage.getY() + 100);
                    secondStage.centerOnScreen();

                    secondStage.show();
                }
            });
        Text scenetitle = new Text("LOGIN");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(scenetitle, 57, 16, 2, 1);
        Label userName = new Label("User Name:");
        grid.add(userName, 57, 17);
        TextField userTextField = new TextField();
        grid.add(userTextField, 58, 17,2,1);
        String un=userTextField.getText();
        Label pw = new Label("Password:");
        grid.add(pw,57,18);
        CheckBox checkBox = new CheckBox("Show password");
        grid.add(checkBox, 59, 19);
        
        PasswordField pwBox = new PasswordField();
        String pass=pwBox.getText();
        TextField pwbox1 = new TextField();
        pwbox1.setManaged(false);
        pwbox1.setVisible(false);
        pwbox1.managedProperty().bind(checkBox.selectedProperty());
        pwbox1.visibleProperty().bind(checkBox.selectedProperty());
        pwBox.visibleProperty().bind(checkBox.selectedProperty().not());
        pwBox.managedProperty().bind(checkBox.selectedProperty().not());
        
        pwbox1.textProperty().bindBidirectional(pwBox.textProperty());
        grid.add(pwbox1, 58, 18,2,1);
        
        
        grid.add(pwBox, 58, 18,2,1);
        
        
        Button btn1 = new Button("Sign in");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 58, 20);
        final Text actiontarget1 = new Text();
        grid.add(actiontarget1, 56, 21, 5, 1);
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Connection conn = null;
                Statement stmt = null;
                String username1 = "random";
                String password1 = "random";
                String user = "notrandom";
                String passwd = "notrandom";
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    user=String.valueOf(userTextField.getText());
                    passwd=String.valueOf(pwBox.getText());
                    String sql = "SELECT username,password FROM register1 WHERE username='"+user+"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    //STEP 5: Extract data from result set
      
                    while(rs.next()){
                        //Retrieve by column name
         
                        username1 = rs.getString("username");
                        password1 = rs.getString("password");

                        //Display values
         
                        System.out.print("First: " + username1);
                        System.out.println("Last: " + password1);
                        if(user.equals(username1) && passwd.equals(password1)){flag=1;}
                    }
                    rs.close();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ke){
                    //Handle errors for Class.forName
                    ke.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                    if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
                
            if(username1.equalsIgnoreCase(user) && password1.equalsIgnoreCase(passwd))
            {
                    
                    
                    mainmenu();
                    
                    
                    
            }  
            else
            {
                    actiontarget1.setFill(Color.FIREBRICK);
                    actiontarget1.setText("either username or password is wrong");   
            }
        }
        
        });
       
        final Text actiontarget2 = new Text();
        grid.add(actiontarget2, 59, 20);
        actiontarget2.setText("or");
        Button btn = new Button("register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,59,20);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 58, 18);
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                ButtonClicked(e);
                     
                }
            });
        
        scene.getStylesheets().add(PoultryFarming.class.getResource("loginregistered.css").toExternalForm());
        
        thestage.show();
    }
    public void mainmenu()
    {
                    
        thestage.setTitle("PFM");
                    thestage.setResizable(true);
                    thestage.setMinHeight(800);
                    thestage.setMinWidth(1024);
                    
                    thestage.setOnCloseRequest(z-> closemainmenu(z));
        thestage.setTitle("PFM");
        double a=thestage.getMaxHeight();
        double b=thestage.getMaxWidth();
        System.out.println("height:"+a+"width:"+b);
        Screen screen = Screen.getPrimary();
Rectangle2D bounds = screen.getVisualBounds();

thestage.setX(bounds.getMinX());
thestage.setY(bounds.getMinY());
thestage.setWidth(bounds.getWidth());
thestage.setHeight(bounds.getHeight());
        BorderPane borderPane = new BorderPane();
        Group root = new Group();
        Scene scene = new Scene(root, 1024, 600,Color.WHITE);
        //Scene scene = new Scene(root, 400, 250, Color.WHITE);
        MenuBar menuBar = new MenuBar();
                    menuBar.prefWidthProperty().bind(thestage.widthProperty());
                    menuBar.prefHeight(50);
                    borderPane.setTop(menuBar);
                    

                    // File Menu

                    Menu fileMenu = new Menu("File");
                    MenuItem newMenuItem = new MenuItem("New");
                    MenuItem saveMenuItem = new MenuItem("Save");
                    MenuItem exitMenuItem = new MenuItem("logout");

                    fileMenu.getItems().addAll(newMenuItem, saveMenuItem,
                    new SeparatorMenuItem(), exitMenuItem);
                    newMenuItem.setOnAction(new EventHandler<ActionEvent>()
                    {
                        @Override
                        public void handle(ActionEvent event) {
                            mainmenu();
                            System.out.println("new");
                        }
                        
                            });
                    exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {

                    //File Menu Trees Exit
                    Label secondLabel = new Label("Are you sure you want to logout?");
                    Button buttonNo = new Button();

                    buttonNo.setStyle("-fx-font: 10 arial; -fx-base: #d3d3d3;");
                    buttonNo.setTranslateX(+55);
                    buttonNo.setTranslateY(30);

                    Button buttonYes = new Button();

                    buttonYes.setStyle("-fx-font: 10 arial; -fx-base: #d3d3d3;");
                    buttonYes.setTranslateX(-55);
                    buttonYes.setTranslateY(30);

                    buttonNo.setText("No");
                    buttonNo.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            System.out.println("No");
                            Stage secondStage = (Stage) buttonNo.getScene().getWindow();
                            secondStage.close();
                        }

                    });
                    buttonYes.setText("Yes");
                    buttonYes.setOnAction(f->logouttologinpage(f));
                    StackPane secondaryLayout = new StackPane();
                    secondaryLayout.getChildren().add(secondLabel);
                    secondaryLayout.getChildren().add(buttonNo);
                    secondaryLayout.getChildren().add(buttonYes);

                    Scene secondScene = new Scene(secondaryLayout, 350, 150);

                    Stage secondStage = new Stage();
                    secondStage.setTitle("Exit");
                    secondStage.setScene(secondScene);
                    secondStage.setX(thestage.getX() + 250);
                    secondStage.setY(thestage.getY() + 100);
                    secondStage.centerOnScreen();

                    secondStage.show();
                }
            });
                   
            menuBar.getMenus().addAll(fileMenu);
            
        
        TabPane tabPane = new TabPane();

        
        
            Tab tab0 = new Tab();
            Tab tab1 = new Tab();
            Tab tab2 = new Tab();
            Tab tab3 = new Tab();
            tab0.setClosable(false);
            tab1.setClosable(false);
            tab2.setClosable(false);
            tab3.setClosable(false);
            
                
                tab0.setId("tab0");
                      
               
               tab1.setId("tab1");
                        
                tab2.setId("tab2");
                tab3.setId("tab3");        
                
                        
                
            
            VBox hbox0 = new VBox();
            hbox0.setId("hbox0");
            VBox hbox1 = new VBox();
            hbox1.setId("hbox1");
            VBox hbox2 = new VBox();
            hbox2.setId("hbox2");
            VBox hbox3 = new VBox();
            hbox3.setId("hbox3");
            Scene scene1 = new Scene(new Group());
            
            
            //feed table
                    
            GridPane grid0 = new GridPane();
        grid0.setAlignment(Pos.TOP_LEFT);
        grid0.setHgap(50);
        grid0.setVgap(10);
        grid0.setPadding(new Insets(25, 25, 25, 25));
        //grid0.setGridLinesVisible(true);
        Label feedlabel0=new Label();
        feedlabel0.setText("Feed details");
        feedlabel0.setId("feedlabel");
        grid0.add(feedlabel0,0,0,2,1);
        table.setEditable(true);
        
        TableColumn firstNameCol = new TableColumn("Code");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
 
        TableColumn lastNameCol = new TableColumn("Date");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
 
        TableColumn emailCol = new TableColumn("Type");
        emailCol.setMinWidth(100);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        TableColumn newNameCol = new TableColumn("Quantity");
        newNameCol.setMinWidth(100);
        newNameCol.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
        TableColumn new1NameCol = new TableColumn("Price");
        new1NameCol.setMinWidth(100);
        new1NameCol.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        
 
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,newNameCol,new1NameCol); 
        
               
        Label feedtypelabel0=new Label();
        feedtypelabel0.setText("Feed Type");
        feedtypelabel0.setId("feedtypelabel");
        grid0.add(feedtypelabel0,1, 3);
        TextField feedtypetextbox0=new TextField();
        feedtypetextbox0.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                feedtypetextbox0.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
        Label feedquantitylabel0=new Label();
        feedquantitylabel0.setText("Quantity");
        feedquantitylabel0.setId("feedquantitylabel");
        grid0.add(feedquantitylabel0,1, 5);
        TextField feedquantitytextbox0=new TextField();
        feedquantitytextbox0.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                feedquantitytextbox0.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                            
                        }
                    });
        Label feeddatelabel0=new Label();
        feeddatelabel0.setText("Date");
        feeddatelabel0.setId("feedDatelabel");
        grid0.add(feeddatelabel0,1, 7);
        /*TextField feeddatetextbox0=new TextField();
        feeddatetextbox0.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                feeddatetextbox0.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });*/
        checkInDatePicker = new DatePicker();
        checkOutDatePicker = new DatePicker();
        checkInDatePicker.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                    checkInDatePicker.getValue().plusDays(1))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
        Label feedshedlabel0=new Label();
        feedshedlabel0.setText("price");
        feedshedlabel0.setId("feedShedlabel");
        grid0.add(feedshedlabel0,1, 9);
        TextField feedshedtextbox0=new TextField();
        feedshedtextbox0.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                feedshedtextbox0.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                        }
                    });

        Label feedviewlabel0=new Label();
        feedviewlabel0.setText("View");
        feedviewlabel0.setId("feedtypelabel");
        grid0.add(feedviewlabel0,1, 11);
        
        
        grid0.add(feedtypetextbox0,2, 3);
        String feeddata=feedtypetextbox0.getText();
        grid0.add(feedquantitytextbox0,2,5);
        String quantitydata=feedquantitytextbox0.getText();
        grid0.add(checkInDatePicker,2,7);
        String datedata=checkInDatePicker.getValue().toString();
        grid0.add(feedshedtextbox0,2,9);
        String sheddata=feedshedtextbox0.getText();
        
        
        //table.getColumns().addAll(CodeCol0,firstNameCol0, lastNameCol0,thirdCol0,ShedCol0);
        grid0.add(table,3, 0,7,22);
        ObservableList<String> options = 
                FXCollections.observableArrayList(
                    "Feed Purchase",
                    "Feed Stock",
                    "Feed Consumption"
        
                );
       
        final ComboBox comboBox = new ComboBox(options);
                comboBox.setEditable(true);
                comboBox.setPromptText("Feed Purchase");
                comboBox.valueProperty().addListener(new ChangeListener<String>() {
                        @Override 
                        public void changed(ObservableValue ov, String t, String t1) {                
                            valuofview = t1;                
                        }    


                    });
    
                    grid0.add(comboBox, 2,11);
        ObservableList<String> optionsinsert = 
                FXCollections.observableArrayList(
                    "Insert",
                    
                    "Update"
        
                );
        final ComboBox comboBoxinsert = new ComboBox(optionsinsert);
                comboBoxinsert.setEditable(false);
                comboBoxinsert.setPromptText("Feed Purchase");
                comboBoxinsert.valueProperty().addListener(new ChangeListener<String>() {
                        @Override 
                        public void changed(ObservableValue ov, String t, String t1) {                
                            valuofview = t1;                
                        }    


                    });
                
        Button insertbtn=new Button();
        insertbtn.setText("Insert");
        insertbtn.setId("insert");
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             if(valuofview.equals("Feed Purchase"))
             {
                feedtypetextbox0.setDisable(false);
                feedquantitytextbox0.setDisable(false);
                checkInDatePicker.setDisable(false);
                feedshedtextbox0.setDisable(false);
                insertbtn.setDisable(false);
             }
             if(valuofview.equals("Feed Stock"))
             {
                feedtypetextbox0.setDisable(true);
                feedquantitytextbox0.setDisable(true);
                checkInDatePicker.setDisable(true);
                feedshedtextbox0.setDisable(true);
                insertbtn.setDisable(true);
                
             }
             if(valuofview.equals("Feed Consumption"))
             {
                feedtypetextbox0.setDisable(false);
                feedquantitytextbox0.setDisable(false);
                checkInDatePicker.setDisable(false);
                feedshedtextbox0.setDisable(true);
                insertbtn.setDisable(false);
                
             }
            }
        });
        insertbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox0.getText());
                String quantity=String.valueOf(feedquantitytextbox0.getText());
                String date=String.valueOf(checkInDatePicker.getValue().toString());
                String price=String.valueOf(feedshedtextbox0.getText());
                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    if(valuofview.equals("Feed Purchase")){
                    String sql = "INSERT INTO feedpurchase2(date,feedtype,quantity,amount) " +"VALUES ('"+date+"','"+feed+"','"+quantity+"','"+price+"')";
                    stmt.executeUpdate(sql);
                    
                    String sql1 = "SELECT ftype FROM feedstock1 WHERE ftype='"+feed+"'";
                    ResultSet rs = stmt.executeQuery(sql1);
                    if (!rs.next() ) {    
                        String sql2 = "INSERT INTO feedstock1(ftype,feedquantity) " +"VALUES ('"+feed+"','"+quantity+"')";
                        stmt.executeUpdate(sql2);
                    }
                    else
                    {
                        String sql4 = "SELECT feedquantity FROM feedstock1 WHERE ftype='"+feed+"'";
                    
                        ResultSet rs1 = stmt.executeQuery(sql4);
                        String feedquantity = null;
                        while(rs1.next()){
                             feedquantity = rs1.getString("feedquantity");
                        }    
                    
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            q=q+nq;
                            System.out.println(q);
                            feedquantity=Integer.toString(q);
                            String sql2 = "UPDATE feedstock1 SET feedquantity='"+feedquantity+"' WHERE ftype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                    
                    }    
                    
                    }
                    
                    else if(valuofview.equals("Feed Consumption"))
                    {
                        String sql1 = "SELECT ftype FROM feedstock1 WHERE ftype='"+feed+"'";
                        ResultSet rs = stmt.executeQuery(sql1);
                        if (!rs.next() ) {    
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("");
                        
                            alert.setContentText("Feed Not Available in Stock");

                            alert.showAndWait();
                        
                            System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                        else{
                            String sql4 = "SELECT feedquantity FROM feedstock1 WHERE ftype='"+feed+"'";
                    
                            ResultSet rs1 = stmt.executeQuery(sql4);
                            String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("feedquantity");
                            }
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            if(nq>q){
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("Feed Quantity Requested More Than available");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");    
                            }
                            else{
                                String sql = "INSERT INTO feedconsumption1(date,feedtype,quantity) " +"VALUES ('"+date+"','"+feed+"','"+quantity+"')";
                                stmt.executeUpdate(sql);
                                q=q-nq;
                                feedquantity=Integer.toString(q);
                                String sql2 = "UPDATE feedstock1 SET feedquantity='"+feedquantity+"' WHERE ftype='"+feed+"'";
                                stmt.executeUpdate(sql2);
                            }
                        }
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        
        System.out.println(feeddata+" "+quantitydata+" "+datedata+" "+sheddata+" ");
        Button deletebtn=new Button();
        deletebtn.setText("Delete");
        deletebtn.setId("insert");
        deletebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox0.getText());
                String quantity=String.valueOf(feedquantitytextbox0.getText());
                String date=String.valueOf(checkInDatePicker.getValue().toString());
                String price=String.valueOf(feedshedtextbox0.getText());
                Connection conn = null;
                Statement stmt = null;
                
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    TextInputDialog dialog = new TextInputDialog("walter");
                    dialog.setTitle("Text Input Dialog");
                    dialog.setHeaderText("Select the Code for Deletion");
                    dialog.setContentText("Code:");
                    
                    // Traditional way to get the response value.
                    Optional<String> result = dialog.showAndWait();
                    String code="0";
                    if (result.isPresent()){
                        code=result.get();
                    }

                    // The Java 8 way to get the response value (with lambda expression).
                    result.ifPresent(name -> System.out.println("Your name: " + name));
                    if(valuofview.equals("Feed Purchase")){
                        
                        try{
                            
                            String sq5="SELECT feedtype,quantity FROM feedpurchase2 WHERE code='"+code+"'";
                            
                            ResultSet rs2 = stmt.executeQuery(sq5);
                            
                            String feedquantity1 = null;
                            while(rs2.next()){
                                feedquantity1 = rs2.getString("quantity");
                                feed=rs2.getString("feedtype");
                            }
                            String sql4 = "SELECT feedquantity FROM feedstock1 WHERE ftype='"+feed+"'";
                            ResultSet rs1 = stmt.executeQuery(sql4);
                           String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("feedquantity");
                            }
                            System.out.println(feedquantity1);
                            System.out.println(feedquantity);
                            System.out.println(code);
                            int q=Integer.parseInt(feedquantity);
                            int p=Integer.parseInt(feedquantity1);
                            q=q-p;
                            if(q<0)
                            {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("feed already consumed");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                            }
                            else{
                            String sql2 = "UPDATE feedstock1 SET feedquantity= '"+q+"' WHERE ftype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                            String sql1 = "DELETE FROM feedpurchase2 WHERE code='"+code+"'";
                            stmt.executeUpdate(sql1);
                            }
                            
                        }catch(Exception sqe)
                        {
                            Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText(sqe.toString());

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                   // ResultSet rs = stmt.executeQuery(sql1);
                    /*while (rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("feedtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        //System.out.println(sqlcode1);
                        //System.out.println(sqldate);
                        
                        data.add(new Person(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table.setItems(data);
                        //table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,newNameCol,new1NameCol);
                    }*/
                                      
                    }
                    
                    else if(valuofview.equals("Feed Consumption"))
                    {
                        try{
                            String sq5="SELECT feedtype,quantity FROM feedconsumption1 WHERE code='"+code+"'";
                            
                            ResultSet rs2 = stmt.executeQuery(sq5);
                            
                            String feedquantity1 = null;
                            while(rs2.next()){
                                feedquantity1 = rs2.getString("quantity");
                                feed=rs2.getString("feedtype");
                            }
                            String sql4 = "SELECT feedquantity FROM feedstock1 WHERE ftype='"+feed+"'";
                            ResultSet rs1 = stmt.executeQuery(sql4);
                           String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("feedquantity");
                            }
                            System.out.println(feedquantity1);
                            System.out.println(feedquantity);
                            System.out.println(code);
                            int q=Integer.parseInt(feedquantity);
                            int p=Integer.parseInt(feedquantity1);
                            q=q+p;
                            if(q<0)
                            {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("feed already consumed");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                            }
                            else{
                            String sql2 = "UPDATE feedstock1 SET feedquantity= '"+q+"' WHERE ftype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                            String sql1 = "DELETE FROM feedconsumption1 WHERE code='"+code+"'";
                            stmt.executeUpdate(sql1);
                        }
                        }catch(Exception sqe)
                        {
                            Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("Code not available");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                        
                    /*ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("feedtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        data.add(new Person(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table.setItems(data);
                        }*/
                    }
                    else if(valuofview.equals("Feed Stock"))
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("Stock cannot be deleted");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        Button updatebtn=new Button();
        //updatebtn.setText("Update");
        //updatebtn.setId("insert");
        Button clearbtn=new Button();
        clearbtn.setText("View");
        clearbtn.setId("insert");
        clearbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox0.getText());
                String quantity=String.valueOf(feedquantitytextbox0.getText());
                String date=String.valueOf(checkInDatePicker.getValue().toString());
                String price=String.valueOf(feedshedtextbox0.getText());
                Connection conn = null;
                Statement stmt = null;
                for ( int i = 0; i<table.getItems().size(); i++) {
                            table.getItems().clear();
                    }
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    if(valuofview.equals("Feed Purchase")){
                        
                    
                        String sql1 = "SELECT * FROM feedpurchase2";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while (rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("feedtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        //System.out.println(sqlcode1);
                        //System.out.println(sqldate);
                        
                        data.add(new Person(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table.setItems(data);
                        //table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,newNameCol,new1NameCol);
                    }
                                      
                    }
                    
                    else if(valuofview.equals("Feed Consumption"))
                    {
                        String sql1 = "SELECT * FROM feedconsumption1";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("feedtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        data.add(new Person(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table.setItems(data);
                        }
                    }
                    else if(valuofview.equals("Feed Stock"))
                    {
                        String sql1 = "SELECT * FROM feedstock1";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        //String sqlcode1=rs.getString("code");
                        //String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("ftype");
                        String sqlquantity=rs.getString("feedquantity");
                        //String sqlamount=rs.getString("amount");
                        data.add(new Person("","",sqlfeedtype,sqlquantity,""));
                        table.setItems(data);
                        }
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        grid0.add(insertbtn,1,13,2,1);
        grid0.add(deletebtn,2,13,2,1);
        //grid0.add(updatebtn,1,14,2,1);
        grid0.add(clearbtn,2,14,2,1);
        
        
        //table0.setItems(data);
        hbox0.getChildren().add(grid0);    
            
        
            //medicine table
            GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.TOP_LEFT);
        grid1.setHgap(50);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));
        //grid1.setGridLinesVisible(true);
        Label feedlabel1=new Label();
        feedlabel1.setText("Medicine details");
        feedlabel1.setId("medicinelabel");
        grid1.add(feedlabel1,0,0,4,1);
           
        //table1.setEditable(true);
        //table1.setPrefHeight(500);
       /* TableColumn CodeCol1 = new TableColumn("Code");
        CodeCol1.setMinWidth(100);
        CodeCol1.setCellValueFactory(new PropertyValueFactory<Person,String>("Code"));
        TableColumn firstNameCol1 = new TableColumn("Medicine type");
        firstNameCol1.setMinWidth(100);
        firstNameCol1.setCellValueFactory(new PropertyValueFactory<Person,String>("Medicine type"));
        TableColumn lastNameCol1 = new TableColumn("Quantity");
        lastNameCol1.setMinWidth(100);
        lastNameCol1.setCellValueFactory(
            new PropertyValueFactory<Person,String>("Quantity")
        );
        TableColumn thirdCol1 = new TableColumn("date");
        thirdCol1.setMinWidth(10);
        thirdCol1.setCellValueFactory(
            new PropertyValueFactory<Person,String>("date")
        );
        TableColumn ShedCol1 = new TableColumn("Price");
        ShedCol1.setMinWidth(100);
        ShedCol1.setCellValueFactory(
            new PropertyValueFactory<Person,String>("Shed")
        );*/
        //table1.getColumns().addAll(CodeCol1,firstNameCol1, lastNameCol1,thirdCol1,ShedCol1);
        //grid1.add(table1,3, 0,7,22);
        table1.setEditable(true);
        TableColumn firstNameCol1 = new TableColumn("Code");
        firstNameCol1.setMinWidth(100);
        firstNameCol1.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
 
        TableColumn lastNameCol1 = new TableColumn("Date");
        lastNameCol1.setMinWidth(100);
        lastNameCol1.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
 
        TableColumn emailCol1 = new TableColumn("Type");
        emailCol1.setMinWidth(100);
        emailCol1.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        TableColumn newNameCol1 = new TableColumn("Quantity");
        newNameCol1.setMinWidth(100);
        newNameCol1.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
        TableColumn new1NameCol1 = new TableColumn("Price");
        new1NameCol1.setMinWidth(100);
        new1NameCol1.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        /*TableColumn firstNameCol1 = new TableColumn("Code");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
 
        TableColumn lastNameCol1 = new TableColumn("Date");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
 
        TableColumn emailCol1 = new TableColumn("Type");
        emailCol.setMinWidth(100);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        TableColumn newNameCol1 = new TableColumn("Quantity");
        newNameCol.setMinWidth(100);
        newNameCol.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
        TableColumn new1NameCol1 = new TableColumn("Price");
        new1NameCol.setMinWidth(100);
        new1NameCol.setCellValueFactory(
                new PropertyValueFactory<>("price"));*/
        
 
        table1.setItems(data1);
        table1.getColumns().addAll(firstNameCol1, lastNameCol1, emailCol1,newNameCol1,new1NameCol1);
         
        Label feedtypelabel1=new Label();
        feedtypelabel1.setText("Medicine Type");
        feedtypelabel1.setId("feedtypelabel");
        grid1.add(feedtypelabel1,1, 3);
        TextField feedtypetextbox1=new TextField();
        String medicinetype=feedtypelabel1.getText();
        feedtypetextbox1.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                feedtypetextbox1.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
        Label feedquantitylabel1=new Label();
        feedquantitylabel1.setText("Quantity");
        feedquantitylabel1.setId("feedquantitylabel");
        grid1.add(feedquantitylabel1,1, 5);
        TextField feedquantitytextbox1=new TextField();
        feedquantitytextbox1.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                feedquantitytextbox1.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                        }
                    });
        String medicinequantity=feedquantitylabel1.getText();
        Label feeddatelabel1=new Label();
        feeddatelabel1.setText("Date");
        feeddatelabel1.setId("feedDatelabel");
        grid1.add(feeddatelabel1,1, 7);
        checkInDatePicker1 = new DatePicker();
        checkOutDatePicker1 = new DatePicker();
        checkInDatePicker1.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory1 = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                    checkInDatePicker1.getValue().plusDays(1))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
        /*TextField feeddatetextbox1=new TextField();
        feeddatetextbox1.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                feeddatetextbox1.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });*/
        //String medicinedate=feeddatetextbox1.getText();
        Label feedshedlabel1=new Label();
        feedshedlabel1.setText("price");
        feedshedlabel1.setId("feedShedlabel");
        grid1.add(feedshedlabel1,1, 9);
        TextField feedshedtextbox1=new TextField();
        feedshedtextbox1.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                feedshedtextbox1.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                        }
                    });
        String medicineShed=feedshedtextbox1.getText();
        grid1.add(feedtypetextbox1,2, 3);
        
        grid1.add(feedquantitytextbox1,2,5);
        
        grid1.add(checkOutDatePicker1,2,7);
        
        grid1.add(feedshedtextbox1,2,9);
        Label feedviewlabel1=new Label();
        feedviewlabel1.setText("View");
        feedviewlabel1.setId("feedtypelabel");
        grid1.add(feedviewlabel1,1, 11);
        ObservableList<String> options1 = 
                FXCollections.observableArrayList(
                    "Medicine Purchase",
                    "Medicine Stock",
                    "Medicine Consumption"
        
                );
        final ComboBox comboBox1 = new ComboBox(options1);
                comboBox1.setEditable(true);
                comboBox1.setPromptText("Medicine Purchase");
                comboBox1.valueProperty().addListener(new ChangeListener<String>() {
                        @Override 
                        public void changed(ObservableValue ov, String t, String t1) {                
                            valuofview1= t1;                
                        }    


                    });
    
                    grid1.add(comboBox1, 2,11);
        Button insertbtn1=new Button();
        insertbtn1.setText("Insert");
        insertbtn1.setId("insert");
        comboBox1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             if(valuofview1.equals("Medicine Purchase"))
             {
                feedtypetextbox1.setDisable(false);
                feedquantitytextbox1.setDisable(false);
                checkOutDatePicker1.setDisable(false);
                feedshedtextbox1.setDisable(false);
                insertbtn1.setDisable(false);
             }
             if(valuofview1.equals("Medicine Stock"))
             {
                feedtypetextbox1.setDisable(true);
                feedquantitytextbox1.setDisable(true);
                checkOutDatePicker1.setDisable(true);
                feedshedtextbox1.setDisable(true);
                insertbtn1.setDisable(true);
                
             }
             if(valuofview1.equals("Medicine Consumption"))
             {
                feedtypetextbox1.setDisable(false);
                feedquantitytextbox1.setDisable(false);
                checkOutDatePicker1.setDisable(false);
                feedshedtextbox1.setDisable(true);
                insertbtn1.setDisable(false);
                
             }
            }
        });
        Button deletebtn1=new Button();
        deletebtn1.setText("Delete");
        deletebtn1.setId("insert");
        Button updatebtn1=new Button();
        updatebtn1.setText("Update");
        updatebtn1.setId("insert");
        Button clearbtn1=new Button();
        clearbtn1.setText("View");
        clearbtn1.setId("insert");
        clearbtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox0.getText());
                String quantity=String.valueOf(feedquantitytextbox0.getText());
                String date=String.valueOf(checkInDatePicker.getValue().toString());
                String price=String.valueOf(feedshedtextbox0.getText());
                Connection conn = null;
                Statement stmt = null;
                for ( int i = 0; i<table1.getItems().size(); i++) {
                            table1.getItems().clear();
                    }
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    if(valuofview1.equals("Medicine Purchase")){
                        
                    
                        String sql1 = "SELECT * FROM medicinepurchase";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while (rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("medicinetype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        System.out.println(sqlcode1);
                        //System.out.println(sqldate);
                        
                        data1.add(new Person1(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table1.setItems(data1);
                        //table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,newNameCol,new1NameCol);
                    }
                                      
                    }
                    
                    else if(valuofview1.equals("Medicine Consumption"))
                    {
                        String sql1 = "SELECT * FROM medicineconsumption";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("medicinetype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        data1.add(new Person1(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table1.setItems(data1);
                        }
                    }
                    else if(valuofview1.equals("Medicine Stock"))
                    {
                        String sql1 = "SELECT * FROM medicinestock";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        //String sqlcode1=rs.getString("code");
                        //String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("medicinetype");
                        String sqlquantity=rs.getString("quantity");
                        //String sqlamount=rs.getString("amount");
                        data1.add(new Person1("","",sqlfeedtype,sqlquantity,""));
                        table1.setItems(data1);
                        }
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        grid1.add(insertbtn1,1,13,2,1);
        grid1.add(deletebtn1,2,13,2,1);
        deletebtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox0.getText());
                String quantity=String.valueOf(feedquantitytextbox0.getText());
                String date=String.valueOf(checkInDatePicker.getValue().toString());
                String price=String.valueOf(feedshedtextbox0.getText());
                Connection conn = null;
                Statement stmt = null;
                
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    TextInputDialog dialog = new TextInputDialog("");
                    dialog.setTitle("Text Input Dialog");
                    dialog.setHeaderText("Select the Code for Deletion");
                    dialog.setContentText("Code:");
                    
                    // Traditional way to get the response value.
                    Optional<String> result = dialog.showAndWait();
                    String code="0";
                    if (result.isPresent()){
                        code=result.get();
                    }

                    // The Java 8 way to get the response value (with lambda expression).
                    result.ifPresent(name -> System.out.println("Your name: " + name));
                    if(valuofview1.equals("Medicine Purchase")){
                        
                        try{
                            
                            String sq5="SELECT medicinetype,quantity FROM medicinepurchase WHERE code='"+code+"'";
                            
                            ResultSet rs2 = stmt.executeQuery(sq5);
                            
                            String feedquantity1 = null;
                            while(rs2.next()){
                                feedquantity1 = rs2.getString("quantity");
                                feed=rs2.getString("medicinetype");
                            }
                            String sql4 = "SELECT quantity FROM medicinestock WHERE medicinetype='"+feed+"'";
                            ResultSet rs1 = stmt.executeQuery(sql4);
                           String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            System.out.println(feedquantity1);
                            System.out.println(feedquantity);
                            System.out.println(code);
                            int q=Integer.parseInt(feedquantity);
                            int p=Integer.parseInt(feedquantity1);
                            q=q-p;
                            if(q<0)
                            {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("feed already consumed");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                            }
                            else{
                            String sql2 = "UPDATE medicinestock SET quantity= '"+q+"' WHERE medicinetype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                            String sql1 = "DELETE FROM medicinepurchase WHERE code='"+code+"'";
                            stmt.executeUpdate(sql1);
                            }
                            
                        }catch(Exception sqe)
                        {
                            Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText(sqe.toString());

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                   // ResultSet rs = stmt.executeQuery(sql1);
                    /*while (rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("feedtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        //System.out.println(sqlcode1);
                        //System.out.println(sqldate);
                        
                        data.add(new Person(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table.setItems(data);
                        //table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,newNameCol,new1NameCol);
                    }*/
                                      
                    }
                    
                    else if(valuofview1.equals("Medicine Consumption"))
                    {
                        try{
                            String sq5="SELECT medicinetype,quantity FROM medicineconsumption WHERE code='"+code+"'";
                            
                            ResultSet rs2 = stmt.executeQuery(sq5);
                            
                            String feedquantity1 = null;
                            while(rs2.next()){
                                feedquantity1 = rs2.getString("quantity");
                                feed=rs2.getString("medicinetype");
                            }
                            String sql4 = "SELECT quantity FROM medicinestock WHERE medicinetype='"+feed+"'";
                            ResultSet rs1 = stmt.executeQuery(sql4);
                           String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            System.out.println(feedquantity1);
                            System.out.println(feedquantity);
                            System.out.println(code);
                            int q=Integer.parseInt(feedquantity);
                            int p=Integer.parseInt(feedquantity1);
                            q=q+p;
                            if(q<0)
                            {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("medicine already consumed");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                            }
                            else{
                            String sql2 = "UPDATE medicinestock SET quantity= '"+q+"' WHERE medicinetype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                            String sql1 = "DELETE FROM medicineconsumption WHERE code='"+code+"'";
                            stmt.executeUpdate(sql1);
                        }
                        }catch(Exception sqe)
                        {
                            Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText(sqe.toString());

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                        
                    /*ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("feedtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        data.add(new Person(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table.setItems(data);
                        }*/
                    }
                    else if(valuofview1.equals("Medicine Stock"))
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("Stock cannot be deleted");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        grid1.add(table1,3, 0,7,22);
        //grid1.add(updatebtn1,1,14,2,1);
        grid1.add(clearbtn1,2,14,2,1);
        insertbtn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox1.getText());
                String quantity=String.valueOf(feedquantitytextbox1.getText());
                String date=String.valueOf(checkOutDatePicker1.getValue().toString());
                String price=String.valueOf(feedshedtextbox1.getText());
                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    if(valuofview1.equals("Medicine Purchase")){
                    String sql = "INSERT INTO medicinepurchase(date,medicinetype,quantity,amount) " +"VALUES ('"+date+"','"+feed+"','"+quantity+"','"+price+"')";
                    stmt.executeUpdate(sql);
                    
                    String sql1 = "SELECT medicinetype FROM medicinestock WHERE medicinetype='"+feed+"'";
                    ResultSet rs = stmt.executeQuery(sql1);
                    if (!rs.next() ) {    
                        String sql2 = "INSERT INTO medicinestock(medicinetype,quantity) " +"VALUES ('"+feed+"','"+quantity+"')";
                        stmt.executeUpdate(sql2);
                    }
                    else
                    {
                        String sql4 = "SELECT quantity FROM medicinestock WHERE medicinetype='"+feed+"'";
                    
                        ResultSet rs1 = stmt.executeQuery(sql4);
                        String feedquantity = null;
                        while(rs1.next()){
                             feedquantity = rs1.getString("quantity");
                        }    
                    
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            q=q+nq;
                            System.out.println(q);
                            feedquantity=Integer.toString(q);
                            String sql2 = "UPDATE medicinestock SET quantity='"+feedquantity+"' WHERE medicinetype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                    
                    }    
                    
                    }
                    
                    else if(valuofview1.equals("Medicine Consumption"))
                    {
                        String sql1 = "SELECT medicinetype FROM medicinestock WHERE medicinetype='"+feed+"'";
                        ResultSet rs = stmt.executeQuery(sql1);
                        if (!rs.next() ) {    
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("");
                        
                            alert.setContentText("medicine Not Available in Stock");

                            alert.showAndWait();
                        
                            System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                        else{
                            String sql4 = "SELECT quantity FROM medicinestock WHERE medicinetype='"+feed+"'";
                    
                            ResultSet rs1 = stmt.executeQuery(sql4);
                            String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            if(nq>q){
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("medicine Quantity Requested More Than available");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");    
                            }
                            else{
                                String sql = "INSERT INTO medicineconsumption(date,medicinetype,quantity) " +"VALUES ('"+date+"','"+feed+"','"+quantity+"')";
                                stmt.executeUpdate(sql);
                                q=q-nq;
                                feedquantity=Integer.toString(q);
                                String sql2 = "UPDATE medicinestock SET quantity='"+feedquantity+"' WHERE medicinetype='"+feed+"'";
                                stmt.executeUpdate(sql2);
                            }
                        }
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        
        hbox1.getChildren().add(grid1); 
        
             //bird table
                GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.TOP_LEFT);
        grid2.setHgap(50);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));
        //grid2.setGridLinesVisible(true);
        Label feedlabel2=new Label();
        feedlabel2.setText("Bird details");
        feedlabel2.setId("medicinelabel");
        grid2.add(feedlabel2,0,0,4,1);
           
        table2.setEditable(true);
        
        TableColumn firstNameCol2 = new TableColumn("Code");
        firstNameCol2.setMinWidth(100);
        firstNameCol2.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
 
        TableColumn lastNameCol2 = new TableColumn("Date");
        lastNameCol2.setMinWidth(100);
        lastNameCol2.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
 
        TableColumn emailCol2 = new TableColumn("Type");
        emailCol2.setMinWidth(100);
        emailCol2.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        TableColumn newNameCol2 = new TableColumn("Quantity");
        newNameCol2.setMinWidth(100);
        newNameCol2.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
        TableColumn new1NameCol2 = new TableColumn("Price");
        new1NameCol2.setMinWidth(100);
        new1NameCol2.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        
 
        table2.setItems(data2);
        table2.getColumns().addAll(firstNameCol2, lastNameCol2, emailCol2,newNameCol2,new1NameCol2); 
        grid2.add(table2,3, 0,7,22);
        Label feedtypelabel2=new Label();
        feedtypelabel2.setText("Bird Type");
        feedtypelabel2.setId("feedtypelabel");
        grid2.add(feedtypelabel2,1, 3);
        TextField feedtypetextbox2=new TextField();
        feedtypetextbox2.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                feedtypetextbox2.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
        String bird=feedtypetextbox2.getText();
        Label feedquantitylabel2=new Label();
        feedquantitylabel2.setText("Quantity");
        feedquantitylabel2.setId("feedquantitylabel");
        grid2.add(feedquantitylabel2,1, 5);
        TextField feedquantitytextbox2=new TextField();
        feedquantitytextbox2.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                feedquantitytextbox2.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                        }
                    });
        String birdquantity=feedquantitytextbox2.getText();
        
        Label feeddatelabel2=new Label();
        feeddatelabel2.setText("Date");
        feeddatelabel2.setId("feedDatelabel");
        grid2.add(feeddatelabel2,1, 7);
        checkInDatePicker2 = new DatePicker();
        checkOutDatePicker2 = new DatePicker();
        checkInDatePicker2.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory2 = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                    checkInDatePicker2.getValue().plusDays(1))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
        /*TextField feeddatetextbox2=new TextField();
        feeddatetextbox2.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                feeddatetextbox2.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });*/
        String birddate=checkInDatePicker2.getValue().toString();
        Label feedshedlabel2=new Label();
        feedshedlabel2.setText("Price");
        feedshedlabel2.setId("feedShedlabel");
        grid2.add(feedshedlabel2,1, 9);
        TextField feedshedtextbox2=new TextField();
        feedshedtextbox2.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                feedshedtextbox2.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                        }
                    });
        String birdshed=feedshedtextbox2.getText();
        grid2.add(feedtypetextbox2,2, 3);
        
        grid2.add(feedquantitytextbox2,2,5);
        
        grid2.add(checkInDatePicker2,2,7);
        
        grid2.add(feedshedtextbox2,2,9);
        Label feedviewlabel2=new Label();
        feedviewlabel2.setText("View");
        feedviewlabel2.setId("feedtypelabel");
        grid2.add(feedviewlabel2,1, 11);
        ObservableList<String> options2 = 
                FXCollections.observableArrayList(
                    "Bird Purchase",
                    "Bird Stock",
                    
                    "Bird Sales"
        
                );
        final ComboBox comboBox2 = new ComboBox(options2);
                comboBox2.setEditable(true);
                comboBox2.setPromptText("Bird Purchase");
                comboBox2.valueProperty().addListener(new ChangeListener<String>() {
                        @Override 
                        public void changed(ObservableValue ov, String t, String t1) {                
                            valuofview2 = t1;                
                        }    


                    });
        System.out.println(valuofview2);
                    grid2.add(comboBox2, 2,11);
        Button insertbtn2=new Button();
        insertbtn2.setText("Insert");
        insertbtn2.setId("insert");
        
        comboBox2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             if(valuofview2.equals("Bird Purchase"))
             {
                feedtypetextbox2.setDisable(false);
                feedquantitytextbox2.setDisable(false);
                checkInDatePicker2.setDisable(false);
                feedshedtextbox2.setDisable(false);
                insertbtn2.setDisable(false);
             }
             if(valuofview2.equals("Bird Stock"))
             {
                feedtypetextbox2.setDisable(true);
                feedquantitytextbox2.setDisable(true);
                checkInDatePicker2.setDisable(true);
                feedshedtextbox2.setDisable(true);
                insertbtn2.setDisable(true);
                
             }
             if(valuofview2.equals("Bird Sales"))
             {
                feedtypetextbox2.setDisable(false);
                feedquantitytextbox2.setDisable(false);
                checkInDatePicker2.setDisable(false);
                feedshedtextbox2.setDisable(false);
                insertbtn2.setDisable(false);
                
             }
            }
        });
        insertbtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox2.getText());
                String quantity=String.valueOf(feedquantitytextbox2.getText());
                String date=String.valueOf(checkInDatePicker2.getValue().toString());
                String price=String.valueOf(feedshedtextbox2.getText());
                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    if(valuofview2.equals("Bird Purchase")){
                    String sql = "INSERT INTO birdpurchase(date,birdtype,quantity,amount) " +"VALUES ('"+date+"','"+feed+"','"+quantity+"','"+price+"')";
                    stmt.executeUpdate(sql);
                    
                    String sql1 = "SELECT birdtype FROM birdstock WHERE birdtype='"+feed+"'";
                    ResultSet rs = stmt.executeQuery(sql1);
                    if (!rs.next() ) {    
                        String sql2 = "INSERT INTO birdstock(birdtype,quantity) " +"VALUES ('"+feed+"','"+quantity+"')";
                        stmt.executeUpdate(sql2);
                    }
                    else
                    {
                        String sql4 = "SELECT quantity FROM birdstock WHERE birdtype='"+feed+"'";
                    
                        ResultSet rs1 = stmt.executeQuery(sql4);
                        String feedquantity = null;
                        while(rs1.next()){
                             feedquantity = rs1.getString("quantity");
                        }    
                    
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            q=q+nq;
                            System.out.println(q);
                            feedquantity=Integer.toString(q);
                            String sql2 = "UPDATE birdstock SET quantity='"+feedquantity+"' WHERE birdtype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                    
                    }    
                    
                    }
                    
                    else if(valuofview2.equals("Bird Sales"))
                    {
                        String sql1 = "SELECT birdtype FROM birdstock WHERE birdtype='"+feed+"'";
                        ResultSet rs = stmt.executeQuery(sql1);
                        if (!rs.next() ) {    
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("");
                        
                            alert.setContentText("bird Not Available in Stock");

                            alert.showAndWait();
                        
                            System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                        else{
                            String sql4 = "SELECT quantity FROM birdstock WHERE birdtype='"+feed+"'";
                    
                            ResultSet rs1 = stmt.executeQuery(sql4);
                            String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            if(nq>q){
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("bird Quantity Requested More Than available");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");    
                            }
                            else{
                                String sql = "INSERT INTO birdsales(date,birdtype,quantity,amount) " +"VALUES ('"+date+"','"+feed+"','"+quantity+"','"+price+"')";
                                stmt.executeUpdate(sql);
                                q=q-nq;
                                feedquantity=Integer.toString(q);
                                String sql2 = "UPDATE birdstock SET quantity='"+feedquantity+"' WHERE birdtype='"+feed+"'";
                                stmt.executeUpdate(sql2);
                            }
                        }
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        Button deletebtn2=new Button();
        deletebtn2.setText("Delete");
        deletebtn2.setId("insert");
        deletebtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox0.getText());
                String quantity=String.valueOf(feedquantitytextbox0.getText());
                String date=String.valueOf(checkInDatePicker.getValue().toString());
                String price=String.valueOf(feedshedtextbox0.getText());
                Connection conn = null;
                Statement stmt = null;
                
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    TextInputDialog dialog = new TextInputDialog("");
                    dialog.setTitle("Text Input Dialog");
                    dialog.setHeaderText("Select the Code for Deletion");
                    dialog.setContentText("Code:");
                    
                    // Traditional way to get the response value.
                    Optional<String> result = dialog.showAndWait();
                    String code="0";
                    if (result.isPresent()){
                        code=result.get();
                    }

                    // The Java 8 way to get the response value (with lambda expression).
                    result.ifPresent(name -> System.out.println("Your name: " + name));
                    if(valuofview2.equals("Bird Purchase")){
                        
                        try{
                            
                            String sq5="SELECT birdtype,quantity FROM birdpurchase WHERE code='"+code+"'";
                            
                            ResultSet rs2 = stmt.executeQuery(sq5);
                            
                            String feedquantity1 = null;
                            while(rs2.next()){
                                feedquantity1 = rs2.getString("quantity");
                                feed=rs2.getString("birdtype");
                            }
                            String sql4 = "SELECT quantity FROM birdstock WHERE birdtype='"+feed+"'";
                            ResultSet rs1 = stmt.executeQuery(sql4);
                           String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            System.out.println(feedquantity1);
                            System.out.println(feedquantity);
                            System.out.println(code);
                            int q=Integer.parseInt(feedquantity);
                            int p=Integer.parseInt(feedquantity1);
                            q=q-p;
                            if(q<0)
                            {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("bird already sold");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                            }
                            else{
                            String sql2 = "UPDATE birdstock SET quantity= '"+q+"' WHERE birdtype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                            String sql1 = "DELETE FROM birdpurchase WHERE code='"+code+"'";
                            stmt.executeUpdate(sql1);
                            }
                            
                        }catch(Exception sqe)
                        {
                            Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText(sqe.toString());

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                   // ResultSet rs = stmt.executeQuery(sql1);
                    /*while (rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("feedtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        //System.out.println(sqlcode1);
                        //System.out.println(sqldate);
                        
                        data.add(new Person(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table.setItems(data);
                        //table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,newNameCol,new1NameCol);
                    }*/
                                      
                    }
                    
                    else if(valuofview2.equals("Bird Sales"))
                    {
                        try{
                            String sq5="SELECT birdtype,quantity FROM birdsales WHERE code='"+code+"'";
                            
                            ResultSet rs2 = stmt.executeQuery(sq5);
                            
                            String feedquantity1 = null;
                            while(rs2.next()){
                                feedquantity1 = rs2.getString("quantity");
                                feed=rs2.getString("birdtype");
                            }
                            String sql4 = "SELECT quantity FROM birdstock WHERE birdtype='"+feed+"'";
                            ResultSet rs1 = stmt.executeQuery(sql4);
                           String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            System.out.println(feedquantity1);
                            System.out.println(feedquantity);
                            System.out.println(code);
                            int q=Integer.parseInt(feedquantity);
                            int p=Integer.parseInt(feedquantity1);
                            q=q+p;
                            if(q<0)
                            {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("birds already sold");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                            }
                            else{
                            String sql2 = "UPDATE birdstock SET quantity= '"+q+"' WHERE birdtype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                            String sql1 = "DELETE FROM birdsales WHERE code='"+code+"'";
                            stmt.executeUpdate(sql1);
                        }
                        }catch(Exception sqe)
                        {
                            Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText(sqe.toString());

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                        
                    /*ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("feedtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        data.add(new Person(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table.setItems(data);
                        }*/
                    }
                    else if(valuofview2.equals("Bird Stock"))
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("Stock cannot be deleted");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        //Button updatebtn2=new Button();
        //updatebtn2.setText("Update");
        //updatebtn2.setId("insert");
        Button clearbtn2=new Button();
        clearbtn2.setText("View");
        clearbtn2.setId("insert");
        clearbtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox0.getText());
                String quantity=String.valueOf(feedquantitytextbox0.getText());
                String date=String.valueOf(checkInDatePicker.getValue().toString());
                String price=String.valueOf(feedshedtextbox0.getText());
                Connection conn = null;
                Statement stmt = null;
                for ( int i = 0; i<table2.getItems().size(); i++) {
                            table2.getItems().clear();
                    }
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    if(valuofview2.equals("Bird Purchase")){
                        
                    
                        String sql1 = "SELECT * FROM birdpurchase";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while (rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("birdtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        System.out.println(sqlcode1);
                        //System.out.println(sqldate);
                        
                        data2.add(new Person2(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table2.setItems(data2);
                        //table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,newNameCol,new1NameCol);
                    }
                                      
                    }
                    
                    else if(valuofview2.equals("Bird Sales"))
                    {
                        String sql1 = "SELECT * FROM birdsales";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("Birdtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        data2.add(new Person2(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table2.setItems(data2);
                        }
                    }
                    else if(valuofview2.equals("Bird Stock"))
                    {
                        String sql1 = "SELECT * FROM birdstock";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        //String sqlcode1=rs.getString("code");
                        //String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("birdtype");
                        String sqlquantity=rs.getString("quantity");
                        //String sqlamount=rs.getString("amount");
                        data2.add(new Person2("","",sqlfeedtype,sqlquantity,""));
                        table2.setItems(data2);
                        }
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        grid2.add(insertbtn2,1,13,2,1);
        grid2.add(deletebtn2,2,13,2,1);
        //grid2.add(updatebtn2,1,14,2,1);
        grid2.add(clearbtn2,2,14,2,1);
        /*insertbtn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //data.add(new Person("1",feeddata,quantitydata,datedata,sheddata));
                String feed=String.valueOf(feedtypetextbox2.getText());
                String quantity=String.valueOf(feedquantitytextbox2.getText());
                String date=String.valueOf(feeddatetextbox2.getText());
                String price=String.valueOf(feedshedtextbox2.getText());
                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    
                    
                    if(valuofview2.equals("Bird Purchase")){
                    String sql = "INSERT INTO birdpurchase(date,birdtype,quantity,amount) " +"VALUES ('"+date+"','"+feed+"','"+quantity+"','"+price+"')";
                    stmt.executeUpdate(sql);
                    
                    String sql1 = "SELECT birdtype FROM birdstock WHERE birdtype='"+feed+"'";
                    ResultSet rs = stmt.executeQuery(sql1);
                    if (!rs.next() ) {    
                        String sql2 = "INSERT INTO birdstock(birdtype,quantity) " +"VALUES ('"+feed+"','"+quantity+"')";
                        stmt.executeUpdate(sql2);
                    }
                    else
                    {
                        String sql4 = "SELECT quantity FROM birdstock WHERE birdtype='"+feed+"'";
                    
                        ResultSet rs1 = stmt.executeQuery(sql4);
                        String feedquantity = null;
                        while(rs1.next()){
                             feedquantity = rs1.getString("quantity");
                        }    
                    
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            q=q+nq;
                            System.out.println(q);
                            feedquantity=Integer.toString(q);
                            String sql2 = "UPDATE birdstock SET quantity='"+feedquantity+"' WHERE birdtype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                    
                    }    
                    
                    }
                    
                    else if(valuofview2.equals("Bird Sales"))
                    {
                        String sql1 = "SELECT birdtype FROM birdstock WHERE birdtype='"+feed+"'";
                        ResultSet rs = stmt.executeQuery(sql1);
                        if (!rs.next() ) {    
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("");
                        
                            alert.setContentText("Bird Not Available in Stock");

                            alert.showAndWait();
                        
                            System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                        else{
                            String sql4 = "SELECT quantity FROM birdstock WHERE birdtype='"+feed+"'";
                    
                            ResultSet rs1 = stmt.executeQuery(sql4);
                            String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            if(nq>q){
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("Bird Quantity Requested More Than available");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");    
                            }
                            else{
                                String sql = "INSERT INTO birdsales(date,birdtype,quantity,amount) " +"VALUES ('"+date+"','"+feed+"','"+quantity+"','"+price+"')";
                                stmt.executeUpdate(sql);
                                q=q-nq;
                                feedquantity=Integer.toString(q);
                                String sql2 = "UPDATE birdstock SET quantity='"+feedquantity+"' WHERE birdtype='"+feed+"'";
                                stmt.executeUpdate(sql2);
                            }
                        }
                    }
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try
            }
        });*/
        //table2.setItems(data);
        hbox2.getChildren().add(grid2);
              
            
        
            //egg table
            GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.TOP_LEFT);
        grid3.setHgap(50);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));
        //grid3.setGridLinesVisible(true);
        Label feedlabel3=new Label();
        feedlabel3.setText("Egg details");
        feedlabel3.setId("medicinelabel");
        grid3.add(feedlabel3,0,0,4,1);
           
        //table3.setEditable(true);
        //table3.setPrefHeight(500);
        TableColumn firstNameCol3 = new TableColumn("Code");
        firstNameCol3.setMinWidth(100);
        firstNameCol3.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));
 
        TableColumn lastNameCol3 = new TableColumn("Date");
        lastNameCol3.setMinWidth(100);
        lastNameCol3.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));
 
        TableColumn emailCol3 = new TableColumn("Type");
        emailCol3.setMinWidth(100);
        emailCol3.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        TableColumn newNameCol3 = new TableColumn("Quantity");
        newNameCol3.setMinWidth(100);
        newNameCol3.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
        TableColumn new1NameCol3 = new TableColumn("Price");
        new1NameCol3.setMinWidth(100);
        new1NameCol3.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        table3.getColumns().addAll(firstNameCol3,lastNameCol3,emailCol3,newNameCol3,new1NameCol3);
        //grid3.add(table3,3, 0,7,22);
        Label feedtypelabel3=new Label();
        feedtypelabel3.setText("Egg Type");
        feedtypelabel3.setId("feedtypelabel");
        grid3.add(feedtypelabel3,1, 3);
        TextField feedtypetextbox3=new TextField();
        feedtypetextbox3.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                feedtypetextbox3.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });
        
        String egg=feedtypetextbox3.getText();
        Label feedquantitylabel3=new Label();
        feedquantitylabel3.setText("Quantity");
        feedquantitylabel3.setId("feedquantitylabel");
        grid3.add(feedquantitylabel3,1, 5);
        TextField feedquantitytextbox3=new TextField();
        
        feedquantitytextbox3.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                feedquantitytextbox3.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                        }
                    });
        String eggquantity=feedquantitytextbox3.getText();
        Label feeddatelabel3=new Label();
        feeddatelabel3.setText("Date");
        feeddatelabel3.setId("feedDatelabel");
        grid3.add(feeddatelabel3,1, 7);
        checkInDatePicker3 = new DatePicker();
        checkOutDatePicker3 = new DatePicker();
        checkInDatePicker3.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory3 = 
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                           
                            if (item.isBefore(
                                    checkInDatePicker3.getValue().plusDays(1))
                                ) {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                            }   
                    }
                };
            }
        };
        /*TextField feeddatetextbox3=new TextField();
        feeddatetextbox3.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (newValue.matches("[a-zA-Z0-9 ]+")) {
                                feeddatetextbox3.setText(newValue.replaceAll(" ", ""));
                            }
                        }
                    });*/
        String eggdate=checkInDatePicker3.getValue().toString();
        Label feedshedlabel3=new Label();
        feedshedlabel3.setText("Price");
        feedshedlabel3.setId("feedShedlabel");
        grid3.add(feedshedlabel3,1, 9);
        TextField feedshedtextbox3=new TextField();
        feedshedtextbox3.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            if (!newValue.matches("\\d*")) {
                                feedshedtextbox3.setText(newValue.replaceAll("[^\\d]", ""));
                            }
                        }
                    });
        String eggshed=feedshedtextbox3.getText();
        grid3.add(feedtypetextbox3,2, 3);
        
        grid3.add(feedquantitytextbox3,2,5);
        
        grid3.add(checkInDatePicker3,2,7);
        
        grid3.add(feedshedtextbox3,2,9);
        Label feedviewlabel3=new Label();
        feedviewlabel3.setText("View");
        feedviewlabel3.setId("feedtypelabel");
        grid3.add(feedviewlabel3,1, 11);
        ObservableList<String> options3 = 
                FXCollections.observableArrayList(
                    "Egg Lays",
                    "Egg Stock",
                    
                    "Egg Sales"
        
                );
        final ComboBox comboBox3 = new ComboBox(options3);
                comboBox3.setEditable(true);
                comboBox3.setPromptText("Egg lays");
                comboBox3.valueProperty().addListener(new ChangeListener<String>() {
                        @Override 
                        public void changed(ObservableValue ov, String t, String t1) {                
                            valuofview3 = t1;                
                        }    


                    });
    
                    grid3.add(comboBox3, 2,11);
        
        Button insertbtn3=new Button();
         
        insertbtn3.setText("Insert");
        insertbtn3.setId("insert");
        comboBox3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             if(valuofview3.equals("Egg Lays"))
             {
                feedtypetextbox3.setDisable(false);
                feedquantitytextbox3.setDisable(false);
                checkInDatePicker3.setDisable(false);
                feedshedtextbox3.setDisable(true);
                insertbtn3.setDisable(false);
             }
             if(valuofview3.equals("Egg Stock"))
             {
                feedtypetextbox3.setDisable(true);
                feedquantitytextbox3.setDisable(true);
                checkInDatePicker3.setDisable(true);
                feedshedtextbox3.setDisable(true);
                insertbtn3.setDisable(true);
                
             }
             if(valuofview3.equals("Egg Sales"))
             {
                feedtypetextbox3.setDisable(false);
                feedquantitytextbox3.setDisable(false);
                checkInDatePicker3.setDisable(false);
                feedshedtextbox3.setDisable(false);
                insertbtn3.setDisable(false);
                
             }
            }
        });
        insertbtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox3.getText());
                String quantity=String.valueOf(feedquantitytextbox3.getText());
                //String date=String.valueOf(feeddatetextbox3.getText());
                String price=String.valueOf(feedshedtextbox3.getText());
                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    if(valuofview3.equals("Egg Lays")){
                    String sql = "INSERT INTO egglays(date,eggtype,quantity) " +"VALUES ('"+checkInDatePicker3.getValue()+"','"+feed+"','"+quantity+"')";
                    stmt.executeUpdate(sql);
                    
                    String sql1 = "SELECT eggtype FROM eggstock WHERE eggtype='"+feed+"'";
                    ResultSet rs = stmt.executeQuery(sql1);
                    if (!rs.next() ) {    
                        String sql2 = "INSERT INTO eggstock(eggtype,quantity) " +"VALUES ('"+feed+"','"+quantity+"')";
                        stmt.executeUpdate(sql2);
                    }
                    else
                    {
                        String sql4 = "SELECT quantity FROM eggstock WHERE eggtype='"+feed+"'";
                    
                        ResultSet rs1 = stmt.executeQuery(sql4);
                        String feedquantity = null;
                        while(rs1.next()){
                             feedquantity = rs1.getString("quantity");
                        }    
                    
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            q=q+nq;
                            System.out.println(q);
                            feedquantity=Integer.toString(q);
                            String sql2 = "UPDATE eggstock SET quantity='"+feedquantity+"' WHERE eggtype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                    
                    }    
                    
                    }
                    
                    else if(valuofview3.equals("Egg Sales"))
                    {
                        String sql1 = "SELECT eggtype FROM eggstock WHERE eggtype='"+feed+"'";
                        ResultSet rs = stmt.executeQuery(sql1);
                        if (!rs.next() ) {    
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("");
                        
                            alert.setContentText("egg Not Available in Stock");

                            alert.showAndWait();
                        
                            System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                        else{
                            String sql4 = "SELECT quantity FROM eggstock WHERE eggtype='"+feed+"'";
                    
                            ResultSet rs1 = stmt.executeQuery(sql4);
                            String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            if(nq>q){
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("egg Quantity Requested More Than available");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");    
                            }
                            else{
                                String sql = "INSERT INTO eggsales(date,eggtype,quantity,amount) " +"VALUES ('"+checkInDatePicker3.getValue()+"','"+feed+"','"+quantity+"','"+price+"')";
                                stmt.executeUpdate(sql);
                                q=q-nq;
                                feedquantity=Integer.toString(q);
                                String sql2 = "UPDATE eggstock SET quantity='"+feedquantity+"' WHERE eggtype='"+feed+"'";
                                stmt.executeUpdate(sql2);
                            }
                        }
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        Button deletebtn3=new Button();
        deletebtn3.setText("Delete");
        deletebtn3.setId("insert");
        deletebtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox0.getText());
                String quantity=String.valueOf(feedquantitytextbox0.getText());
                String date=String.valueOf(checkInDatePicker.getValue().toString());
                String price=String.valueOf(feedshedtextbox0.getText());
                Connection conn = null;
                Statement stmt = null;
                
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    TextInputDialog dialog = new TextInputDialog("");
                    dialog.setTitle("Text Input Dialog");
                    dialog.setHeaderText("Select the Code for Deletion");
                    dialog.setContentText("Code:");
                    
                    // Traditional way to get the response value.
                    Optional<String> result = dialog.showAndWait();
                    String code="0";
                    if (result.isPresent()){
                        code=result.get();
                    }

                    // The Java 8 way to get the response value (with lambda expression).
                    result.ifPresent(name -> System.out.println("Your name: " + name));
                    if(valuofview3.equals("Egg Lays")){
                        
                        try{
                            
                            String sq5="SELECT eggtype,quantity FROM egglays WHERE code='"+code+"'";
                            
                            ResultSet rs2 = stmt.executeQuery(sq5);
                            
                            String feedquantity1 = null;
                            while(rs2.next()){
                                feedquantity1 = rs2.getString("quantity");
                                feed=rs2.getString("eggtype");
                            }
                            String sql4 = "SELECT quantity FROM eggstock WHERE eggtype='"+feed+"'";
                            ResultSet rs1 = stmt.executeQuery(sql4);
                           String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            System.out.println(feedquantity1);
                            System.out.println(feedquantity);
                            System.out.println(code);
                            int q=Integer.parseInt(feedquantity);
                            int p=Integer.parseInt(feedquantity1);
                            q=q-p;
                            if(q<0)
                            {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("egg already sold");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                            }
                            else{
                            String sql2 = "UPDATE eggstock SET quantity= '"+q+"' WHERE eggtype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                            String sql1 = "DELETE FROM egglays WHERE code='"+code+"'";
                            stmt.executeUpdate(sql1);
                            }
                            
                        }catch(Exception sqe)
                        {
                            Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText(sqe.toString());

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                   // ResultSet rs = stmt.executeQuery(sql1);
                    /*while (rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("feedtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        //System.out.println(sqlcode1);
                        //System.out.println(sqldate);
                        
                        data.add(new Person(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table.setItems(data);
                        //table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,newNameCol,new1NameCol);
                    }*/
                                      
                    }
                    
                    else if(valuofview3.equals("Egg Sales"))
                    {
                        try{
                            String sq5="SELECT eggtype,quantity FROM eggsales WHERE code='"+code+"'";
                            
                            ResultSet rs2 = stmt.executeQuery(sq5);
                            
                            String feedquantity1 = null;
                            while(rs2.next()){
                                feedquantity1 = rs2.getString("quantity");
                                feed=rs2.getString("eggtype");
                            }
                            String sql4 = "SELECT quantity FROM eggstock WHERE eggtype='"+feed+"'";
                            ResultSet rs1 = stmt.executeQuery(sql4);
                           String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            System.out.println(feedquantity1);
                            System.out.println(feedquantity);
                            System.out.println(code);
                            int q=Integer.parseInt(feedquantity);
                            int p=Integer.parseInt(feedquantity1);
                            q=q+p;
                            if(q<0)
                            {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("egg already sold");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                            }
                            else{
                            String sql2 = "UPDATE eggstock SET quantity= '"+q+"' WHERE eggtype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                            String sql1 = "DELETE FROM eggsales WHERE code='"+code+"'";
                            stmt.executeUpdate(sql1);
                        }
                        }catch(Exception sqe)
                        {
                            Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText(sqe.toString());

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                        
                    /*ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("feedtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        data.add(new Person(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table.setItems(data);
                        }*/
                    }
                    else if(valuofview3.equals("Egg Stock"))
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("Stock cannot be deleted");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        //Button updatebtn3=new Button();
        //updatebtn3.setText("Update");
        //updatebtn3.setId("insert");
        Button clearbtn3=new Button();
        clearbtn3.setText("View");
        clearbtn3.setId("insert");
        clearbtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                
                String feed=String.valueOf(feedtypetextbox0.getText());
                String quantity=String.valueOf(feedquantitytextbox0.getText());
                String date=String.valueOf(checkInDatePicker.getValue().toString());
                String price=String.valueOf(feedshedtextbox0.getText());
                Connection conn = null;
                Statement stmt = null;
                for ( int i = 0; i<table3.getItems().size(); i++) {
                            table3.getItems().clear();
                    }
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    if(valuofview3.equals("Egg Lays")){
                        
                    
                        String sql1 = "SELECT * FROM egglays";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while (rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("eggtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        System.out.println(sqlcode1);
                        //System.out.println(sqldate);
                        
                        data3.add(new Person3(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table3.setItems(data3);
                        //table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,newNameCol,new1NameCol);
                    }
                                      
                    }
                    
                    else if(valuofview3.equals("Egg Sales"))
                    {
                        String sql1 = "SELECT * FROM eggsales";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        String sqlcode1=rs.getString("code");
                        String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("eggtype");
                        String sqlquantity=rs.getString("quantity");
                        String sqlamount=rs.getString("amount");
                        data3.add(new Person3(sqlcode1,sqldate,sqlfeedtype,sqlquantity,sqlamount));
                        table3.setItems(data3);
                        }
                    }
                    else if(valuofview3.equals("Egg Stock"))
                    {
                        String sql1 = "SELECT * FROM eggstock";
                        
                    ResultSet rs = stmt.executeQuery(sql1);
                    while(rs.next() ) {    
                        //String sqlcode1=rs.getString("code");
                        //String sqldate=rs.getString("date");
                        String sqlfeedtype=rs.getString("eggtype");
                        String sqlquantity=rs.getString("quantity");
                        //String sqlamount=rs.getString("amount");
                        data3.add(new Person3("","",sqlfeedtype,sqlquantity,""));
                        table3.setItems(data3);
                        }
                    }
                    else
                    {
                        Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("select view");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");
                    }    
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try*/
            }
        });
        grid3.add(table3,3, 0,7,22);
        grid3.add(insertbtn3,1,13,2,1);
        grid3.add(deletebtn3,2,13,2,1);
        //grid3.add(updatebtn3,1,14,2,1);
        grid3.add(clearbtn3,2,14,2,1);
        /*insertbtn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                //data.add(new Person("1",feeddata,quantitydata,datedata,sheddata));
                String feed=String.valueOf(feedtypetextbox3.getText());
                String quantity=String.valueOf(feedquantitytextbox3.getText());
                String date=String.valueOf(feeddatetextbox3.getText());
                String price=String.valueOf(feedshedtextbox3.getText());
                Connection conn = null;
                Statement stmt = null;
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Inserting records into the table...");
                    stmt = conn.createStatement();
                    
                    if(valuofview3.equals("Egg Lays")){
                    String sql = "INSERT INTO egglays(date,eggtype,quantity) " +"VALUES ('"+date+"','"+feed+"','"+quantity+"')";
                    stmt.executeUpdate(sql);
                    
                    String sql1 = "SELECT eggtype FROM eggstock WHERE eggtype='"+feed+"'";
                    ResultSet rs = stmt.executeQuery(sql1);
                    if (!rs.next() ) {    
                        String sql2 = "INSERT INTO eggstock(eggtype,quantity) " +"VALUES ('"+feed+"','"+quantity+"')";
                        stmt.executeUpdate(sql2);
                    }
                    else
                    {
                        String sql4 = "SELECT quantity FROM eggstock WHERE eggtype='"+feed+"'";
                    
                        ResultSet rs1 = stmt.executeQuery(sql4);
                        String feedquantity = null;
                        while(rs1.next()){
                             feedquantity = rs1.getString("quantity");
                        }    
                    
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            q=q+nq;
                            System.out.println(q);
                            feedquantity=Integer.toString(q);
                            String sql2 = "UPDATE eggstock SET quantity='"+feedquantity+"' WHERE eggtype='"+feed+"'";
                            stmt.executeUpdate(sql2);
                    
                    }    
                    
                    }
                    
                    else if(valuofview3.equals("Egg Sales"))
                    {
                        String sql1 = "SELECT eggtype FROM eggstock WHERE eggtype='"+feed+"'";
                        ResultSet rs = stmt.executeQuery(sql1);
                        if (!rs.next() ) {    
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setTitle("");
                        
                            alert.setContentText("Egg Not Available in Stock");

                            alert.showAndWait();
                        
                            System.out.println("Submit Button Clicked Without Filling All Parameters..");
                        }
                        else{
                            String sql4 = "SELECT quantity FROM eggstock WHERE eggtype='"+feed+"'";
                    
                            ResultSet rs1 = stmt.executeQuery(sql4);
                            String feedquantity = null;
                            while(rs1.next()){
                                feedquantity = rs1.getString("quantity");
                            }
                            int q=Integer.parseInt(feedquantity);
                            System.out.println(q);
                            int nq=Integer.parseInt(quantity);
                            System.out.println(nq);
                            if(nq>q){
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.setTitle("");
                        
                                alert.setContentText("Egg Quantity Requested More Than available");

                                alert.showAndWait();
                        
                                System.out.println("Submit Button Clicked Without Filling All Parameters..");    
                            }
                            else{
                                String sql = "INSERT INTO eggsales(date,eggtype,quantity,amount) " +"VALUES ('"+date+"','"+feed+"','"+quantity+"','"+price+"')";
                                stmt.executeUpdate(sql);
                                q=q-nq;
                                feedquantity=Integer.toString(q);
                                String sql2 = "UPDATE eggstock SET quantity='"+feedquantity+"' WHERE eggtype='"+feed+"'";
                                stmt.executeUpdate(sql2);
                            }
                        }
                    }
                    System.out.println("Inserted records into the table...");

                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ae){
                    //Handle errors for Class.forName
                    ae.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                     if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                    }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
            }//end finally try
         }//end try
            }
        });*/
        //table3.setItems(data);
        hbox3.getChildren().add(grid3);    
            
        
            hbox0.setAlignment(Pos.TOP_LEFT);
            hbox1.setAlignment(Pos.TOP_LEFT);
            hbox2.setAlignment(Pos.TOP_LEFT);
            hbox3.setAlignment(Pos.TOP_LEFT);
            tab0.setContent(hbox0);
            tab1.setContent(hbox1);
            tab2.setContent(hbox2);
            tab3.setContent(hbox3);
            tabPane.getTabs().add(tab0);
            tabPane.getTabs().add(tab1);
            tabPane.getTabs().add(tab2);
            tabPane.getTabs().add(tab3);
        
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        scene.getStylesheets().add(PoultryFarming.class.getResource("mainmenu.css").toExternalForm());
        thestage.setScene(scene);
        thestage.show();
                    
    }
    public void loginpage()
    {
        
        thestage.setTitle("PFM");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 600, 1020);
        thestage.setScene(scene);
        thestage.setScene(scene);
        thestage.setMaxWidth(1020);
        thestage.setMaxHeight(600.00);
        double a=thestage.getMaxHeight();
        double c=thestage.getMaxWidth();
        
        
        
        
        
        thestage.setOnCloseRequest(b-> close(b));
        Text scenetitle = new Text("LOGIN");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(scenetitle, 57, 16, 2, 1);
        Label userName = new Label("User Name:");
        grid.add(userName, 57, 17);
        TextField userTextField = new TextField();
        String sn="null";
        grid.add(userTextField, 58, 17,2,1);
        String un=userTextField.getText();
        
            
        Label pw = new Label("Password:");
        grid.add(pw,57,18);
        CheckBox checkBox = new CheckBox("Show password");
        grid.add(checkBox, 59, 19);
        
        PasswordField pwBox = new PasswordField();
        String pass=pwBox.getText();
        
        TextField pwbox1 = new TextField();
        pwbox1.setManaged(false);
        pwbox1.setVisible(false);
        pwbox1.managedProperty().bind(checkBox.selectedProperty());
        pwbox1.visibleProperty().bind(checkBox.selectedProperty());
        pwBox.visibleProperty().bind(checkBox.selectedProperty().not());
        pwBox.managedProperty().bind(checkBox.selectedProperty().not());
        
        pwbox1.textProperty().bindBidirectional(pwBox.textProperty());
        grid.add(pwbox1, 58, 18,2,1);
        
        
        grid.add(pwBox, 58, 18,2,1);
        
        
        Button btn1 = new Button("Sign in");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 58, 20);
        final Text actiontarget1 = new Text();
        grid.add(actiontarget1, 56, 21, 5, 1);
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Connection conn = null;
                Statement stmt = null;
                String username1 = "random";
                String password1 = "random";
                String user = "notrandom";
                String passwd = "notrandom";
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    user=String.valueOf(userTextField.getText());
                    passwd=String.valueOf(pwBox.getText());
                    String sql = "SELECT username,password FROM register1 WHERE username='"+user+"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    //STEP 5: Extract data from result set
      
                    while(rs.next()){
                        //Retrieve by column name
         
                        username1 = rs.getString("username");
                        password1 = rs.getString("password");

                        //Display values
         
                        System.out.print("First: " + username1);
                        System.out.println("Last: " + password1);
                        if(user.equals(username1) && passwd.equals(password1)){flag=1;}
                    }
                    rs.close();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ke){
                    //Handle errors for Class.forName
                    ke.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                    if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
                
            if(username1.equalsIgnoreCase(user) && password1.equalsIgnoreCase(passwd))
            {
                    
                    
                    mainmenu();
                    
                    
                    
            }  
            else
            {
                    actiontarget1.setFill(Color.FIREBRICK);
                    actiontarget1.setText("either username or password is wrong");   
            }
        }
        
        });
       
        final Text actiontarget2 = new Text();
        grid.add(actiontarget2, 59, 20);
        actiontarget2.setText("or");
        Button btn = new Button("register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,59,20);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 58, 18);
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                ButtonClicked(e);
                     
                }
            });
        scene.getStylesheets().add(PoultryFarming.class.getResource("login2.css").toExternalForm());
        
        thestage.show();
    }
    public void logouttologinpage(ActionEvent f)
    {
      thestage.setTitle("PFM");
      thestage.centerOnScreen();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Screen screen = Screen.getPrimary();
Rectangle2D bounds = screen.getVisualBounds();

thestage.setX(bounds.getMinX());
thestage.setY(bounds.getMinY());
thestage.setWidth(bounds.getWidth());
thestage.setHeight(bounds.getHeight());
        //grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 1020, 600);
        thestage.setScene(scene);
        thestage.setScene(scene);
        thestage.setMaxWidth(1020);
        thestage.setMaxHeight(600.00);
        
        thestage.setMinWidth(1020);
        thestage.setMinHeight(600.00);
        
        thestage.setOnCloseRequest(b-> close(b));
        Text scenetitle = new Text("LOGIN");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(scenetitle, 57, 16, 2, 1);
        Label userName = new Label("User Name:");
        grid.add(userName, 57, 17);
        TextField userTextField = new TextField();
        grid.add(userTextField, 58, 17,2,1);
        String un=userTextField.getText();
        Label pw = new Label("Password:");
        grid.add(pw,57,18);
        CheckBox checkBox = new CheckBox("Show password");
        grid.add(checkBox, 59, 19);
        
        PasswordField pwBox = new PasswordField();
        String pass=pwBox.getText();
        TextField pwbox1 = new TextField();
        pwbox1.setManaged(false);
        pwbox1.setVisible(false);
        pwbox1.managedProperty().bind(checkBox.selectedProperty());
        pwbox1.visibleProperty().bind(checkBox.selectedProperty());
        pwBox.visibleProperty().bind(checkBox.selectedProperty().not());
        pwBox.managedProperty().bind(checkBox.selectedProperty().not());
        
        pwbox1.textProperty().bindBidirectional(pwBox.textProperty());
        grid.add(pwbox1, 58, 18,2,1);
        
        
        grid.add(pwBox, 58, 18,2,1);
        
        
        Button btn1 = new Button("Sign in");
        HBox hbBtn1 = new HBox(10);
        hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn1.getChildren().add(btn1);
        grid.add(hbBtn1, 58, 20);
        final Text actiontarget1 = new Text();
        grid.add(actiontarget1, 56, 21, 5, 1);
        
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Connection conn = null;
                Statement stmt = null;
                String username1 = "random";
                String password1 = "random";
                String user = "notrandom";
                String passwd = "notrandom";
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    System.out.println("Connecting to a selected database...");
                    conn = DriverManager.getConnection(conn_string, username, password);
                    System.out.println("Connected database successfully...");
      
                    //STEP 4: Execute a query
                    System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    user=String.valueOf(userTextField.getText());
                    passwd=String.valueOf(pwBox.getText());
                    String sql = "SELECT username,password FROM register1 WHERE username='"+user+"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    //STEP 5: Extract data from result set
      
                    while(rs.next()){
                        //Retrieve by column name
         
                        username1 = rs.getString("username");
                        password1 = rs.getString("password");

                        //Display values
         
                        System.out.print("First: " + username1);
                        System.out.println("Last: " + password1);
                        if(user.equals(username1) && passwd.equals(password1)){flag=1;}
                    }
                    rs.close();
                }catch(SQLException se){
                    //Handle errors for JDBC
                    se.printStackTrace();
                }catch(Exception ke){
                    //Handle errors for Class.forName
                    ke.printStackTrace();
                }finally{
                    //finally block used to close resources
                try{
                    if(stmt!=null)
                    conn.close();
                }catch(SQLException se){
                }// do nothing
                try{
                    if(conn!=null)
                    conn.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }//end try
                
            if(username1.equalsIgnoreCase(user) && password1.equalsIgnoreCase(passwd))
            {
                    
                    
                    mainmenu();
                    
                    
                    
            }  
            else
            {
                    actiontarget1.setFill(Color.FIREBRICK);
                    actiontarget1.setText("either username or password is wrong");   
            }
        }
        
        });
       
        final Text actiontarget2 = new Text();
        grid.add(actiontarget2, 59, 20);
        actiontarget2.setText("or");
        Button btn = new Button("register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn,59,20);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 58, 18);
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent e) {
                ButtonClicked(e);
                     
                }
            });
        
        scene.getStylesheets().add(PoultryFarming.class.getResource("login2.css").toExternalForm());
        
        
        thestage.show();  
    }
    private void closemainmenu(WindowEvent z)
    {
        
        Label secondLabel = new Label("Are you sure you want to exit?");
                Button buttonNo = new Button();

                buttonNo.setStyle("-fx-font: 10 arial; -fx-base: #d3d3d3;");
                buttonNo.setTranslateX(-55);
                buttonNo.setTranslateY(30);

                Button buttonYes = new Button();

                buttonYes.setStyle("-fx-font: 10 arial; -fx-base: #d3d3d3;");
                buttonYes.setTranslateX(+55);
                buttonYes.setTranslateY(30);

                buttonNo.setText("Exit, No");
                buttonNo.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        System.out.println("No");
                        Stage secondStage = (Stage) buttonNo.getScene().getWindow();
                        mainmenu();
                        secondStage.close();
                    }

                });

                buttonYes.setText("Exit, Yes");
                buttonYes.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        System.out.println("Yes");
                        Platform.exit();
                    }
                });
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
                secondaryLayout.getChildren().add(buttonNo);
                secondaryLayout.getChildren().add(buttonYes);

                Scene secondScene = new Scene(secondaryLayout, 350, 150);
                Stage secondStage = new Stage();
                secondStage.setTitle("Exit");
                secondStage.setScene(secondScene);
                secondStage.setX(thestage.getX() + 250);
                secondStage.setY(thestage.getY() + 100);
                secondStage.centerOnScreen();

                secondStage.show();
    }
    
    private void close(WindowEvent b) {
      Label secondLabel = new Label("Are you sure you want to exit?");
                Button buttonNo = new Button();

                buttonNo.setStyle("-fx-font: 10 arial; -fx-base: #d3d3d3;");
                buttonNo.setTranslateX(-55);
                buttonNo.setTranslateY(30);

                Button buttonYes = new Button();

                buttonYes.setStyle("-fx-font: 10 arial; -fx-base: #d3d3d3;");
                buttonYes.setTranslateX(+55);
                buttonYes.setTranslateY(30);

                buttonNo.setText("Exit, No");
                buttonNo.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        System.out.println("No");
                        Stage secondStage = (Stage) buttonNo.getScene().getWindow();
                        //try {
                            loginpage();
                        //} catch (SQLException ex) {
                        //    Logger.getLogger(PoultryFarming.class.getName()).log(Level.SEVERE, null, ex);
                       // }
                        secondStage.close();
                    }

                });

                buttonYes.setText("Exit, Yes");
                buttonYes.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        System.out.println("Yes");
                        Platform.exit();
                    }
                });
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
                secondaryLayout.getChildren().add(buttonNo);
                secondaryLayout.getChildren().add(buttonYes);

                Scene secondScene = new Scene(secondaryLayout, 350, 150);
                Stage secondStage = new Stage();
                secondStage.setTitle("Exit");
                secondStage.setScene(secondScene);
                secondStage.setX(thestage.getX() + 250);
                secondStage.setY(thestage.getY() + 100);
                secondStage.centerOnScreen();

                secondStage.show();  
    }
    private void closeregister(WindowEvent b) {
      Label secondLabel = new Label("Are you sure you want to exit?");
                Button buttonNo = new Button();

                buttonNo.setStyle("-fx-font: 10 arial; -fx-base: #d3d3d3;");
                buttonNo.setTranslateX(-55);
                buttonNo.setTranslateY(30);

                Button buttonYes = new Button();

                buttonYes.setStyle("-fx-font: 10 arial; -fx-base: #d3d3d3;");
                buttonYes.setTranslateX(+55);
                buttonYes.setTranslateY(30);

                buttonNo.setText("Exit, No");
                buttonNo.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        ButtonClicked(event);
                        System.out.println("No");
                        Stage secondStage = (Stage) buttonNo.getScene().getWindow();
                        
                        secondStage.close();
                    }

                });

                buttonYes.setText("Exit, Yes");
                buttonYes.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        System.out.println("Yes");
                        Platform.exit();
                    }
                });
                StackPane secondaryLayout = new StackPane();
                secondaryLayout.getChildren().add(secondLabel);
                secondaryLayout.getChildren().add(buttonNo);
                secondaryLayout.getChildren().add(buttonYes);

                Scene secondScene = new Scene(secondaryLayout, 350, 150);
                Stage secondStage = new Stage();
                secondStage.setTitle("Exit");
                secondStage.setScene(secondScene);
                secondStage.setX(thestage.getX() + 250);
                secondStage.setY(thestage.getY() + 100);
                secondStage.centerOnScreen();

                secondStage.show();  
    }
    public static class Person {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty quantity;
        private final SimpleStringProperty price;
 
        private Person(String fName, String lName, String email,String q,String p) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.quantity=new SimpleStringProperty(q);
            this.price=new SimpleStringProperty(p);
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String fName) {
            email.set(fName);
        }
        public String getQuantity() {
            return quantity.get();
        }
 
        public void setQuantity(String fName) {
            quantity.set(fName);
        }
        public String getPrice() {
            return price.get();
        }
 
        public void setPrice(String fName) {
            price.set(fName);
        }
    }
    public static class Person1 {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty quantity;
        private final SimpleStringProperty price;

        
 
        private Person1(String fName, String lName, String email,String q,String p) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.quantity=new SimpleStringProperty(q);
            this.price=new SimpleStringProperty(p);
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String fName) {
            email.set(fName);
        }
        public String getQuantity() {
            return quantity.get();
        }
 
        public void setQuantity(String fName) {
            quantity.set(fName);
        }
        public String getPrice() {
            return price.get();
        }
 
        public void setPrice(String fName) {
            price.set(fName);
        }
    }
    public static class Person2 {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty quantity;
        private final SimpleStringProperty price;

        
 
        private Person2(String fName, String lName, String email,String q,String p) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.quantity=new SimpleStringProperty(q);
            this.price=new SimpleStringProperty(p);
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String fName) {
            email.set(fName);
        }
        public String getQuantity() {
            return quantity.get();
        }
 
        public void setQuantity(String fName) {
            quantity.set(fName);
        }
        public String getPrice() {
            return price.get();
        }
 
        public void setPrice(String fName) {
            price.set(fName);
        }
    }
    public static class Person3 {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty quantity;
        private final SimpleStringProperty price;

        
 
        private Person3(String fName, String lName, String email,String q,String p) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.quantity=new SimpleStringProperty(q);
            this.price=new SimpleStringProperty(p);
        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String fName) {
            email.set(fName);
        }
        public String getQuantity() {
            return quantity.get();
        }
 
        public void setQuantity(String fName) {
            quantity.set(fName);
        }
        public String getPrice() {
            return price.get();
        }
 
        public void setPrice(String fName) {
            price.set(fName);
        }
    }
 }



