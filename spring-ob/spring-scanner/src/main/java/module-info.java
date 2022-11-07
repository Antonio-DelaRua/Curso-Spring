module com.ruxx.springscanner {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;


    opens com.ruxx to javafx.fxml;
    exports com.ruxx;
}