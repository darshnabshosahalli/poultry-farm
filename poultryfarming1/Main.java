import javafx.application.Application;
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

public class Main extends Application {

    private TableView<Person> table = new TableView<Person>();
    private final ObservableList<Person> data =
        FXCollections.observableArrayList(
            new Person("A", "Z", "a@example.com", "Z", "a@example.com"),
            new Person("B", "X", "b@example.com", "Z", "a@example.com"),
            new Person("C", "W", "c@example.com", "Z", "a@example.com"),
            new Person("D", "Y", "d@example.com", "Z", "a@example.com"),
            new Person("E", "V", "e@example.com", "Z", "a@example.com")
        );   

    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setWidth(900);
        stage.setHeight(550);

        table.setEditable(true);
       
        TableColumn codeNameCol = new TableColumn("Code");
        codeNameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("code"));

        TableColumn feedNameCol = new TableColumn("Feed Type");
        codeNameCol.setCellValueFactory(
            new PropertyValueFactory<Person,String>("feedtype")
        );

        TableColumn quantityNameCol = new TableColumn("Quantity");
        quantityNameCol.setMinWidth(200);
        quantityNameCol.setCellValueFactory(
            new PropertyValueFactory<Person,String>("quantity")
        );
        TableColumn dateNameCol = new TableColumn("Date");
        dateNameCol.setMinWidth(200);
        dateNameCol.setCellValueFactory(
            new PropertyValueFactory<Person,String>("date")
        );
        TableColumn priceNameCol = new TableColumn("Price");
        priceNameCol.setMinWidth(200);
        priceNameCol.setCellValueFactory(
            new PropertyValueFactory<Person,String>("price")
        );
                                     
        table.setItems(data);
        table.getColumns().addAll(codeNameCol,feedNameCol,quantityNameCol,dateNameCol,priceNameCol);
     
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                data.add(new Person("new","new","new","new","new"));
            }
        });
        
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table,addButton);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
   
    public static class Person {
        private final SimpleStringProperty Feedtype;
        private final SimpleStringProperty Code;
        private final SimpleStringProperty Quantity;
        private final SimpleStringProperty Date;
        private final SimpleStringProperty Price;

        private Person(String code, String feedtype, String quantity, String date, String price) {
            this.Feedtype = new SimpleStringProperty(feedtype);
            this.Code = new SimpleStringProperty(code);
            this.Quantity = new SimpleStringProperty(quantity);
            this.Date = new SimpleStringProperty(date);
            this.Price = new SimpleStringProperty(price);
        }

        public String getCodeName() {
            return Code.get();
        }
        public void setCodeName(String code) {
            Code.set(code);
        }
       
        public String getFeedtypeName() {
            return Feedtype.get();
        }
        public void setFeedtypeName(String feedtype) {
            Feedtype.set(feedtype);
        }
       
        public String getQuantity() {
            return Quantity.get();
        }
        public void setQuantity(String quantity) {
            Quantity.set(quantity);
        }
        public String getDate() {
            return Date.get();
        }
        public void setDate(String feedtype) {
            Date.set(feedtype);
        }
       
        public String getPrice() {
            return Price.get();
        }
        public void setEmail(String quantity) {
            Price.set(quantity);
        }
       
    }
   
}