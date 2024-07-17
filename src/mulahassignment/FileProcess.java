/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mulahassignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class FileProcess {
    private final String Testcsv = "src\\mulahassignment\\File\\Table_Input.csv";
    DefaultTableModel model;
    private Map<String, String> Index;
    
    public FileProcess(DefaultTableModel model) {
        this.model = model;
        Index = new HashMap<>();
    }

     public void createTestTable (){
        try (BufferedReader br = new BufferedReader(new FileReader(Testcsv))) {
            String line;
            boolean FirstRow = true;
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                if (FirstRow) {
                    model.setColumnIdentifiers(data);
                    FirstRow = false;
                    
                } else {
                    model.addRow(data);
                    Index.put(data[0], data[1]);
                }
            }
        } catch (IOException e) {
           System.out.println("Failed to load file");
        }
    }

    
    public void createCustomTable (File Upload){

        try (BufferedReader br = new BufferedReader(new FileReader(Upload))) {
            String line;
            boolean FirstRow = true;
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                if (FirstRow) {
                    model.setColumnIdentifiers(data);
                    FirstRow = false;
                    
                } else {
                    model.addRow(data);
                }
            }
        } catch (IOException e) {
           System.out.println("Failed to load file");
        }
    }
    
        public int getValue(String key) {
        return Integer.parseInt(Index.get(key));
       
    }
}

