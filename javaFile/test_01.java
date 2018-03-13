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

	/* ���� 1. �־��� �ؽ�Ʈ ������ ��θ� �о ���̰� ª�� �ܾ����(���̰� ������ ���� ����) �����Ͽ� 
	   ���ĺ� �ҹ��ڷθ� ������ּ���.(�ؽ�Ʈ ������ ���ĺ����θ� �ۼ�, �ؽ�Ʈ ������ 1�ް� ����) */
    public static void main(String[] args) throws IOException {
        
        // file ����
        File file = new File("C:\\Users\\GP62\\coding-test\\File\\in.txt");
        
        String temp;
 
        try {
            // BufferedReader ������ file�� �ִ´�
            BufferedReader reader = new BufferedReader(new FileReader(file));
 
            // ������ ���پ� �о� �ֱ� ���� ���� line
            String line = null;
 
            // �ϳ��� line�� split �Ͽ� ���� �迭 ����
            String[] splitedStr = null;
 
            // �� �پ� �о line�� ���� �� null�� �ƴϸ� ����
            while( (line = reader.readLine()) != null ) {
 
                // �ʱ�ȭ
                splitedStr = null;
 
                // �����̽��� �������� �߶� splitedStr �� �ִ´�
                splitedStr = line.split(" ");
 
                // �迭�� �� ���� ��ŭ �ݺ��Ѵ�
                for (int i = 0; i < splitedStr.length; i++) {
                    // ������ ������ ����
                    splitedStr[i] = splitedStr[i].trim();
                                   
                }
                // �ܾ���� ���� ���� �ϱ�
                for (int i = splitedStr.length; i>0; i--) {
                	
                	for (int j = 0; j<i-1; j++) {
                		// �ܾ ���� ��
                		if( splitedStr[j].length() > splitedStr[j+1].length() ) {
                			temp = splitedStr[j];
                			splitedStr[j] = splitedStr[j+1];
                			splitedStr[j+1] = temp;
                		}               		
                	}
                	
                }
                
                int sort = 0;

                // �ܾ���̰� ���� ��, �ܾ�� �����ϱ�
                for (int i = splitedStr.length; i>0; i--) {
                	
                	for (int j = 0; j<i-1; j++) {

                		// �ܾ ���� ��
                		if( splitedStr[j].length() == splitedStr[j+1].length() ) {
                			// �ܾ sorting
                			sort = splitedStr[j].compareTo(splitedStr[j+1]);
                			
                			if (sort > 0 ) {
                				temp = splitedStr[j];
                    			splitedStr[j] = splitedStr[j+1];
                    			splitedStr[j+1] = temp;                				
                			} 
                			
                		}
                	}
                } 
                
                // ���� ���
                for (int i = 0; i<splitedStr.length; i++) {
                	splitedStr[i] = splitedStr[i].toLowerCase(); // ��� �ҹ��ڷ� �ٲٱ�
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
