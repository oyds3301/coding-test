package test;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test_02 {
	/* 
	5개의 좌표와 기준좌표의 순번을 입력 받아서 
	기준 좌표에서 거리가 짧은 순서대로 정렬하여 출력하세요.(좌표 값은 정수, 좌표는 ()로 표현하고 빈문자열로 구분)
    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 배열생성
		String[] location = null;
		Scanner input = new Scanner(System.in);
		int standardLocation = 0;

	    // 키보드로부터 문자열 입력받기
	    System.out.print("좌표 5개와 기준좌표의 순번을 입력하시오: ");
	    // System.out.println(input.nextLine());
	    
	    // 입력받은 문자 저장
	    String txt = input.nextLine();
  	    // StringTokenizer를 이용한 문자열 분리
        StringTokenizer tokens = new StringTokenizer(txt);
        
        location = txt.split(" ");
    	// 배열에 들어간 길이 만큼 반복한다
        for (int i = 0; i < location.length; i++) {
            // 양쪽의 공백을 제거후, location[i] 에 각 값 setting
        	location[i] = location[i].trim();
        	
        	// 기준좌표  location[standardLocation]  설정
        	if ( location[i].length() == 1) {
        		if (standardLocation == 0)
        		    standardLocation = Integer.parseInt(location[i])-1 ;
        		else {
        			System.out.println("기준 좌표는 한번만 입력해주세요.");
        			return;
        		}
        	}
        	
        	for ( int j = 0 ; j < location[i].length(); j++) {
        		if ( location[i].charAt(j) == '.' ) {
            		System.out.println("좌표값은 정수로 입력하시고, 좌표값의 구분은 ',' 문자를 사용하여 주세요.");
            		return;
            	}	
        	}
        	
        }       
        
        System.out.println("기준좌표는 " + location[standardLocation] + " 입니다.");
        // 좌표 간 거리 구하기 
        // System.out.println(getDistance(2,2,2,2)); getDistance ( 기준좌표 x, 기준좌표 y, 비교좌표 x, 비교좌표 y)
        // location[standardLocation] = (x,y);
                 
        String[][] result = new String[5][5];
        // 문자열 중 정수 구하기
        for (int i = 0; i < location.length-1; i++) {
        	for ( int j = 0 ; j < location[i].length(); j++) {
        		if ( location[i].charAt(j) >= 47 && location[i].charAt(j) <= 58 ) {
            		result[i][j] =  String.valueOf( location[i].charAt(j) ) ;
            	}	
        	}        	
        }
        
        // 기준좌표 
        // location[standardLocation]
        
        int x = 0; // 비교점 x값
        int y = 0; // 비교점 y값
        boolean  checkX = false; // 비교점 x에 값이 있는지
        boolean  checkY = false; // 비교점 y에 값이 있는지
                
        int x1 = Character.getNumericValue( location[standardLocation].charAt(1) ); // 기준점 x값
        int y1 = Character.getNumericValue( location[standardLocation].charAt(3) ) ; // 기준점 y값
        
        double[] chkMeter = new double[5];
        double temp;
        String strTemp = null;
        
		// 자리수 확인용
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
			
			// 확인용 변수 초기화
			checkX = false;
			checkY = false;
		}
		
		System.out.print("정렬전 : ");
		for (int i = 0; i < chkMeter.length; i ++) {
			System.out.print(location[i] + " ");
		}
		
        // 거리순으로 정렬 하기
        for (int i = chkMeter.length; i>0; i--) {
        	
        	for (int j = 0; j<i-1; j++) {
        		// 단어별 길이 비교
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

		System.out.print("\n정렬후 : ");
		for (int i = 0; i < chkMeter.length; i ++) {
			System.out.print(location[i] + " ");
		}        
		
	}
	
	// 두 지점간 거리 구하기
	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt(Math.pow(Math.abs(x1-x), 2) + Math.pow(Math.abs(y1-y), 2));
	}

}


