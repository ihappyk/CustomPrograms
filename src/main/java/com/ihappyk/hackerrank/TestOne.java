package com.ihappyk.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url;

		try {
			// get URL content
			System.out.println("coming");
			url = new URL("https://cdn.hackerrank.com/hackerrank/static/contests/capture-the-flag/infinite/qds.html");
			URLConnection conn = url.openConnection();

			// open the stream and put it into BufferedReader
			BufferedReader br = new BufferedReader(
                               new InputStreamReader(conn.getInputStream()));

			//use FileWriter to write file
			String inputline;
			while ( (inputline=br.readLine()) != null) {
				System.out.println(inputline);
			}

			br.close();

			System.out.println("Done");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
