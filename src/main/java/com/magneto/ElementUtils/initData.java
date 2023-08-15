package com.magneto.ElementUtils;

import com.magneto.constants.FileLocations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class initData {
    
   static Properties dataProp;
    public static Properties initDataProp(){
        dataProp = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(FileLocations.TEST_DATA_PATH);
            dataProp.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         return dataProp;
    }
}
