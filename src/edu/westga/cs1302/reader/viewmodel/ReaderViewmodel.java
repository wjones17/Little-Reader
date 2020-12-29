package edu.westga.cs1302.reader.viewmodel;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReaderViewmodel {
	private final StringProperty bookProperty;
	
	/**
	 * 
	 */
	
	public ReaderViewmodel() {
		this.bookProperty = new SimpleStringProperty();
	}
	
	public StringProperty bookProperty() {
		return this.bookProperty;
	}
	
	/**
	 * Opens the Selected file and reads it
	 * 
	 * @precondition file != null
	 * @postcondition none
	 * @param file is the file to be read
	 * 
	 */
	public void loadFile(File file) throws FileNotFoundException {
		String book = "";
		try (Scanner input = new Scanner(file)) {
			String delimiter = "\r\n";
			input.useDelimiter(delimiter);
			while (input.hasNext()) {
				book += input.next() + System.lineSeparator();
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		this.bookProperty.setValue(book);
	}
}

