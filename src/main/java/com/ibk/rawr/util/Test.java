//package com.ibk.rawr.util;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Test {
//
//	public static void main(String[] args) throws IOException {
//		List<String> listComan=new ArrayList<>();
//		listComan.add("D:\\test.bat");
//		listComan.add("Alfredo");
//		ProcessBuilder processBuilder = new ProcessBuilder(listComan);						
//	        try {
//
//	            Process process = processBuilder.start();
//
//	            StringBuilder output = new StringBuilder();
//
//	            BufferedReader reader = new BufferedReader(
//	                    new InputStreamReader(process.getInputStream()));
//
//	            String line;
//	            while ((line = reader.readLine()) != null) {
//	                output.append(line + "\n");
//	            }
//
//	            int exitVal = process.waitFor();
//	            if (exitVal == 0) {
//	                System.out.println(output);
//	                System.exit(0);
//	            } else {
//	                //abnormal...
//	            }
//
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//
//	}
//
//}
