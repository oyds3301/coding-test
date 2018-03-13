package test;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test_02 {
	/* 
	5���� ��ǥ�� ������ǥ�� ������ �Է� �޾Ƽ� 
	���� ��ǥ���� �Ÿ��� ª�� ������� �����Ͽ� ����ϼ���.(��ǥ ���� ����, ��ǥ�� ()�� ǥ���ϰ� ���ڿ��� ����)
    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �迭����
		String[] location = null;
		Scanner input = new Scanner(System.in);
		int standardLocation = 0;

	    // Ű����κ��� ���ڿ� �Է¹ޱ�
	    System.out.print("��ǥ 5���� ������ǥ�� ������ �Է��Ͻÿ�: ");
	    // System.out.println(input.nextLine());
	    
	    // �Է¹��� ���� ����
	    String txt = input.nextLine();
  	    // StringTokenizer�� �̿��� ���ڿ� �и�
        StringTokenizer tokens = new StringTokenizer(txt);
        
        location = txt.split(" ");
    	// �迭�� �� ���� ��ŭ �ݺ��Ѵ�
        for (int i = 0; i < location.length; i++) {
            // ������ ������ ������, location[i] �� �� �� setting
        	location[i] = location[i].trim();
        	
        	// ������ǥ  location[standardLocation]  ����
        	if ( location[i].length() == 1) {
        		if (standardLocation == 0)
        		    standardLocation = Integer.parseInt(location[i])-1 ;
        		else {
        			System.out.println("���� ��ǥ�� �ѹ��� �Է����ּ���.");
        			return;
        		}
        	}
        	
        	for ( int j = 0 ; j < location[i].length(); j++) {
        		if ( location[i].charAt(j) == '.' ) {
            		System.out.println("��ǥ���� ������ �Է��Ͻð�, ��ǥ���� ������ ',' ���ڸ� ����Ͽ� �ּ���.");
            		return;
            	}	
        	}
        	
        }       
        
        System.out.println("������ǥ�� " + location[standardLocation] + " �Դϴ�.");
        // ��ǥ �� �Ÿ� ���ϱ� 
        // System.out.println(getDistance(2,2,2,2)); getDistance ( ������ǥ x, ������ǥ y, ����ǥ x, ����ǥ y)
        // location[standardLocation] = (x,y);
                 
        String[][] result = new String[5][5];
        // ���ڿ� �� ���� ���ϱ�
        for (int i = 0; i < location.length-1; i++) {
        	for ( int j = 0 ; j < location[i].length(); j++) {
        		if ( location[i].charAt(j) >= 47 && location[i].charAt(j) <= 58 ) {
            		result[i][j] =  String.valueOf( location[i].charAt(j) ) ;
            	}	
        	}        	
        }
        
        // ������ǥ 
        // location[standardLocation]
        
        int x = 0; // ���� x��
        int y = 0; // ���� y��
        boolean  checkX = false; // ���� x�� ���� �ִ���
        boolean  checkY = false; // ���� y�� ���� �ִ���
                
        int x1 = Character.getNumericValue( location[standardLocation].charAt(1) ); // ������ x��
        int y1 = Character.getNumericValue( location[standardLocation].charAt(3) ) ; // ������ y��
        
        double[] chkMeter = new double[5];
        double temp;
        String strTemp = null;
        
		// �ڸ��� Ȯ�ο�
		for (int i = 0; i < location.length - 1; i++) {
			for (int j = 0; j < location[i].length(); j++) {
				if (result[i][j] != null) {

					// System.out.println(i + "," + j + " / " + result[i][j]);
					if (checkX == false) {
						checkX = true;
						x = Integer.parseInt(result[i][j]);
					} else if (checkY == false) {
						checkY = true;
						y = Integer.parseInt(result[i][j]);
					}

				}
			}
			chkMeter[i] = getDistance (x , y , x1 , y1);			
			
			// Ȯ�ο� ���� �ʱ�ȭ
			checkX = false;
			checkY = false;
		}
		
		System.out.print("������ : ");
		for (int i = 0; i < chkMeter.length; i ++) {
			System.out.print(location[i] + " ");
		}
		
        // �Ÿ������� ���� �ϱ�
        for (int i = chkMeter.length; i>0; i--) {
        	
        	for (int j = 0; j<i-1; j++) {
        		// �ܾ ���� ��
        		if( chkMeter[j] > chkMeter[j+1] ) {
        			temp = chkMeter[j];
        			chkMeter[j] = chkMeter[j+1];
        			chkMeter[j+1] = temp;
        			
        			strTemp = location[j];
        			location[j] = location[j+1];
        			location[j+1] = strTemp;
        		}               		
        	}
        	
        }

		System.out.print("\n������ : ");
		for (int i = 0; i < chkMeter.length; i ++) {
			System.out.print(location[i] + " ");
		}        
		
	}
	
	// �� ������ �Ÿ� ���ϱ�
	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt(Math.pow(Math.abs(x1-x), 2) + Math.pow(Math.abs(y1-y), 2));
	}

}


