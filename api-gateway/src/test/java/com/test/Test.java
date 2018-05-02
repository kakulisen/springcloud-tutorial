package com.test;

import junit.framework.TestCase;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

public class Test extends TestCase {

    @org.junit.Test
    public void test(){


        System.out.println("Test");

        ClassLoader loader = Test.class.getClassLoader();

        try {
            Enumeration<URL> resources = loader.getResources("com/netflix/zuul/ZuulFilter.class");



            while (resources.hasMoreElements()){

                System.out.println(resources.nextElement());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
