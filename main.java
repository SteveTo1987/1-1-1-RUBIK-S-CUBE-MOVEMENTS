import java.util.*;
import java.util.Map.Entry;

public class main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String rotations = in.nextLine();
        String face1 = in.nextLine();
        String face2 = in.nextLine();

        String[] rotationData = rotations.split(" ");
    	if(rotationData.length >= 1 && rotationData.length <= 100) {
    		int count = 0;
    		Cube cube = new Cube();
    		while(count < rotationData.length){
    			cube.rotation(rotationData[count]);
    			count++;
    		}
    		System.out.println(cube.getData(face1));
            System.out.println(cube.getData(face2)); 
    	}
    }
    
    static class Cube{    	
    	HashMap<String, String> cubeData = new HashMap<String, String>();
    	String[] moveLineX = new String[] {"F", "U", "B", "D"};
    	String[] moveLineY = new String[] {"F", "L", "B", "R"};
    	String[] moveLineZ = new String[] {"L", "U", "R", "D"};
     	
    	public Cube() {
    		cubeData.put("F", "F");
    		cubeData.put("B", "B");
    		cubeData.put("L", "L");
    		cubeData.put("R", "R");
    		cubeData.put("U", "U");
    		cubeData.put("D", "D");
    	}
    	
    	public String getData(String face) {
    		for (Entry<String, String> entry :  this.cubeData.entrySet()) {
                if (entry.getValue().equals(face)) {
                    return entry.getKey();
                }
            }
    		return "";
    	}
    	
    	public void rotation(String rotationWay) {
    		String[] moveMap;
    		if(rotationWay.indexOf("x") > -1) {
    			moveMap = moveLineX;
    		}
    		else if(rotationWay.indexOf("y") > -1) {
    			moveMap = moveLineY;
    		}
    		else {
    			moveMap = moveLineZ;
    		}
    		
    		if(rotationWay.indexOf("'") <= -1) {
    			clockwise(moveMap);
    		}
    		else{
    			counterClockwise(moveMap);
    		}
    	}
    	
    	private void clockwise(String[] moveMap) {
    		String tmp = this.cubeData.get(moveMap[3]);
    		String tmp2 = "";
    		for(int i = 0; i < moveMap.length; i++) { 
    			if( i == 0 ) {
    				tmp2 =  this.cubeData.get(moveMap[i]);
    				this.cubeData.put(moveMap[i], tmp);
    			}
    			else {
    				tmp =  this.cubeData.get(moveMap[i]);
    				this.cubeData.put(moveMap[i], tmp2);
    				tmp2 = tmp;
    			}
    		}
    	}
    	
    	private void counterClockwise(String[] moveMap) {
    		String tmp =  this.cubeData.get(moveMap[0]);
    		for(int i = 0; i < moveMap.length; i++) { 
    			if( i + 1 < moveMap.length) {
    				 this.cubeData.put(moveMap[i], cubeData.get(moveMap[i+1]));
    			}
    			else {
    				 this.cubeData.put(moveMap[i], tmp);
    			}
    		}
    	}	
    }
}