package com.ciscodiz.carrito.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtCantidad;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAgregarOnClick(MouseEvent event) {
    }
}
