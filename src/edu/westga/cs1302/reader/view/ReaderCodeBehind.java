package edu.westga.cs1302.reader.view;

import java.io.File;
import java.io.FileNotFoundException;

import edu.westga.cs1302.reader.viewmodel.ReaderViewmodel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

	public class ReaderCodeBehind {

	    @FXML
	    private TextArea readTextArea;

	    @FXML
	    private MenuItem openMenuItem;

	    @FXML
	    void handleOpenMenuItem(ActionEvent event) throws FileNotFoundException {
	    	FileChooser fileChooser = new FileChooser();
	    	File selectedFile = fileChooser.showOpenDialog(null);
			try {
				if (selectedFile != null) {
					this.viewModel.loadFile(selectedFile);

				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	    private ReaderViewmodel viewModel;
	    @FXML 
	    void initialize() {
	    	this.viewModel = new ReaderViewmodel();
	    	this.readTextArea.textProperty().bind(this.viewModel.bookProperty());
	    }

	}

