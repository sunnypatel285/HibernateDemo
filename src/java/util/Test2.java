/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.ecw.dao.AddressDaoImpl;
import com.ecw.dao.StaffDaoImpl;
import com.ecw.dao.StoreDaoImpl;
import com.ecw.pojo.Address;
import com.ecw.pojo.Language;
import com.ecw.pojo.Staff;
import com.ecw.pojo.Store;
import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sunnyp
 */
public class Test2 {

    public static void main(String[] ar) throws IOException {
        Language l = new Language("Gujarati", new Date());
        Address a = new AddressDaoImpl().getLanguage(1);
        String filePath = "E:\\Sunny docs\\Id proof & photo\\Passport Photo.jpg";
        Staff st = new Staff("Dash", "Panchal", a, null, "s.a@s.com", 1, 1, "dash", "secret", new Date());
        byte[] photoBytes = readBytesFromFile(filePath);
        st.setPicture(photoBytes);
        //new StaffDaoImpl().addStStaff(st);
        Store store = new Store(st, a, new Date());
        new StoreDaoImpl().addStore(store);
    }

    private static byte[] readBytesFromFile(String filePath) throws IOException {
        File inputFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(inputFile);

        byte[] fileBytes = new byte[(int) inputFile.length()];
        inputStream.read(fileBytes);
        inputStream.close();

        return fileBytes;
    }
}
