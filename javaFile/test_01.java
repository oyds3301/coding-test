package test;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class test_01 {

	/* 문제 1. 주어진 텍스트 파일의 경로를 읽어서 길이가 짧은 단어부터(길이가 같으면 사전 순서) 정렬하여 
	   알파벳 소문자로만 출력해주세요.(텍스트 파일은 알파벳으로만 작성, 텍스트 파일은 1메가 이하) */
    public static void main(String[] args) throws IOException {
        
        // file 세팅
        File file = new File("C:\\Users\\GP62\\coding-test\\File\\in.txt");
        
        String temp;
 
        try {
            // BufferedReader 변수에 file을 넣는다
            BufferedReader reader = new BufferedReader(new FileReader(file));
 
            // 파일을 한줄씩 읽어 넣기 위한 변수 line
            String line = null;
 
            // 하나의 line을 split 하여 넣을 배열 생성
            String[] splitedStr = null;
 
            // 한 줄씩 읽어서 line에 넣은 후 null이 아니면 실행
            while( (line = reader.readLine()) != null ) {
 
                // 초기화
                splitedStr = null;
 
                // 스페이스를 기준으로 잘라서 splitedStr 에 넣는다
                splitedStr = line.split(" ");
 
                // 배열에 들어간 길이 만큼 반복한다
                for (int i = 0; i < splitedStr.length; i++) {
                    // 양쪽의 공백을 제거
                    splitedStr[i] = splitedStr[i].trim();
                                   
                }
                // 단어길이 별로 정렬 하기
                for (int i = splitedStr.length; i>0; i--) {
                	
                	for (int j = 0; j<i-1; j++) {
                		// 단어별 길이 비교
                		if( splitedStr[j].length() > splitedStr[j+1].length() ) {
                			temp = splitedStr[j];
                			splitedStr[j] = splitedStr[j+1];
                			splitedStr[j+1] = temp;
                		}               		
                	}
                	
                }
                
                int sort = 0;

                // 단어길이가 같을 시, 단어별로 정렬하기
                for (int i = splitedStr.length; i>0; i--) {
                	
                	for (int j = 0; j<i-1; j++) {

                		// 단어별 길이 비교
                		if( splitedStr[j].length() == splitedStr[j+1].length() ) {
                			// 단어별 sorting
                			sort = splitedStr[j].compareTo(splitedStr[j+1]);
                			
                			if (sort > 0 ) {
                				temp = splitedStr[j];
                    			splitedStr[j] = splitedStr[j+1];
                    			splitedStr[j+1] = temp;                				
                			} 
                			
                		}
                	}
                } 
                
                // 파일 출력
                for (int i = 0; i<splitedStr.length; i++) {
                	splitedStr[i] = splitedStr[i].toLowerCase(); // 모두 소문자로 바꾸기
                	System.out.println(splitedStr[i]);
                }
                
                
            }
            reader.close();
	
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch( IOException e) {
            e.printStackTrace();
        }

	}

}
