/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.inventory_management_system;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mega
 */
public class ValidDate extends InputVerifier{

    @Override
    public boolean verify(JComponent input) {
        JTextField field = (JTextField) input;
        if (!Validation.isValidDate(field.getText())) {
            JOptionPane.showMessageDialog(input, "Data not valid", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
}
