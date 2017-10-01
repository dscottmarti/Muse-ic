import java.awt.*;
import java.awt.List;

import javax.swing.*;
import java.util.ArrayList;
import java.util.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
public class MindReader{
	StringTokenizer tok;
	double secStart = 0.0;
	int j = 0;
	String PATH;
	double sampleLength;
	//Need the averege eeg for each section
	public MindReader(String filePath, double sampleLength){
		PATH = filePath;
		this.sampleLength = sampleLength;
	}

	public ArrayList<ArrayList<Note>> engine(){
		EasyReader read = new EasyReader(PATH);
		System.out.println(read.readLine());
		ArrayList array = new ArrayList();
		String s = read.readLine();
		s = s.replace(',', ' ');
		System.out.println(read.readLine());
		double[] values = new double[4];
		while(s != null){
			if(s.contains("/eeg,")){
				s = s.replace(',', ' ');
				tok = new StringTokenizer(s," ");
				double i = Double.parseDouble(tok.nextToken());
				if(i-secStart>=sampleLength){
					j = 0;
					array.add(""+values[0]+" "+values[1]+" "+values[2]+" "+values[3]);
					values[0] = 0.0;
					values[1] = 0.0;
					values[2] = 0.0;
					values[3] = 0.0;
					secStart = i;
				}else{
					j++;
					tok.nextToken();
					double temp = values[0];
					i = Double.parseDouble(tok.nextToken());
					values[0] = ((temp*j)+i)/(j+1);
					temp = values[1];
					i = Double.parseDouble(tok.nextToken());
					values[1] = ((temp*j)+i)/(j+1);
					temp = values[2];
					i = Double.parseDouble(tok.nextToken());
					values[2] = ((temp*j)+i)/(j+1);
					temp = values[3];
					i = Double.parseDouble(tok.nextToken());
					values[3] = ((temp*j)+i)/(j+1);
				}
	        }
		s = read.readLine();
		}
		
		array.add(""+values[0]+" "+values[1]+" "+values[2]+" "+values[3]);
		System.out.println(""+values[0]);
		for(int i = 0; i < array.size();i++) System.out.println(""+array.get(i));
		double[] egg0 = new double[array.size()];
		double[] egg1 = new double[array.size()];
		double[] egg2 = new double[array.size()];
		double[] egg3 = new double[array.size()];
		for(int i = 0; i < array.size();i++){
			tok = new StringTokenizer(""+array.get(i)," ");
			egg0[i] = Double.parseDouble(tok.nextToken());
			egg1[i] = Double.parseDouble(tok.nextToken());
			egg2[i] = Double.parseDouble(tok.nextToken());
			egg3[i] = Double.parseDouble(tok.nextToken());
		}
		double[][] d = new double[4][array.size()];
		d[0] = egg0;
		d[1] = egg1;
		d[2] = egg2;
		d[3] = egg3;
		int[] scale0 = {36,38,40,41,43,45,47,48};
		int[] scale1 = {48,50,52,53,55,57,59,60};
		int[] scale2 = {60,62,64,65,67,69,71,72};
		int[] scale3 = {72,74,76,77,79,81,83,84};
		String[] sA = {"c1","d1","e1","f1","g1","a1","b1","c2"};
		int[] raw = {0,600,625,700,750,800,900, 10000};
		ArrayList<ArrayList<Note>> ret = new ArrayList<ArrayList<Note>>();
		ret.add(new ArrayList<Note>());
		ret.add(new ArrayList<Note>());
		ret.add(new ArrayList<Note>());
		ret.add(new ArrayList<Note>());
//		ArrayList A0 = new ArrayList();
//		ArrayList A1 = new ArrayList();
//		ArrayList A2 = new ArrayList();
//		ArrayList A3 = new ArrayList();
		for(int i = 0; i<4; i++) {
			for(int j = 1; j<d[i].length; j++) {
				int k = 0;
				while(d[i][j] > raw[k] && k<raw.length)
					k++;
				ret.get(i).add(new Note(sA[k]));
			}
		}
//		for(int i = 0; i < egg0.length;i++){
//				int j = 0;
//				while(raw[j]<egg0[i])j+=1;
//				A0.add(new Note(sA[j]+"1"));
//		}
//		for(int i = 0; i < egg1.length;i++){
//			int j = 0;
//			while(raw[j]<egg1[i])j++;
//			A0.add(new Note(sA[j]+"2"));
//		}
//		for(int i = 0; i < egg2.length;i++){
//			int j = 0;
//			while(raw[j]<egg2[i])j++;
//			A0.add(new Note(sA[j]+"3");
//		}
//		for(int i = 0; i < egg3.length;i++){
//			int j = 0;
//			while(raw[j]<egg3[i])j++;
//			A0.add(new Note(sA[j]+"4");
//		}
//		ret[0] = A0;
//		ret[1] = A1;
//		ret[2] = A2;
//		ret[3] = A3;
//		for(int i = 0; i < array.size();i++){
//			System.out.println(d[0][i]);
//		}
//		for(int i = 0; i <4;i++){
//			for(int j = 0; j < ret[i].size();j++) System.out.println(ret[i].get(j));
//		}
		return ret;
	}
}