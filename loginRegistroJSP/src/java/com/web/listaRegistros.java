/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class listaRegistros {
    //public static ArrayList<String> list=new ArrayList<String>();
   

        private static listaRegistros mInstance;
        private ArrayList<String> list = null;

        public static listaRegistros getInstance() {
            if(mInstance == null)
                mInstance = new listaRegistros();

            return mInstance;
        }

        private listaRegistros() {
          list = new ArrayList<String>();
        }
        // retrieve array from anywhere
        public ArrayList<String> getArray() {
         return this.list;
        }
        //Add element to array
        public void addToArray(String value) {
         list.add(value);
        }
}

