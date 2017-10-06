package hw;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();
        //System.out.println("ok1"+"|"+lineList.size());
        // wirte your code here
        List<String> result = calculateUnilateral(lineList);
        //System.out.println(result.size());
        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();
        
        checkRule1(result,lineList);
        merge(lineList);
        checkRule1(result,lineList);
        return result;
    }
    public static void merge(List<UnilateralLine> lineList){
    	for(UnilateralLine lineItem : lineList){
    		String tempsCen = lineItem.getSCen();
    		String tempeCen = lineItem.getECen();
    		String tempType = lineItem.getTType();
    		if(tempType.equals("9.6m")){
    			UnilateralLine tempLine = searchExist(tempsCen,tempeCen,tempType,lineItem.getId(),lineList);
    			if(tempLine!=null){
    				tempLine.setId(lineItem.getId()+"+"+tempLine.getId());
    				tempLine.setTType("17.5m");
    				lineList.remove(getIndex(lineItem.getId(),lineList));
    			}
    		}
    	}
    }
    public static UnilateralLine searchExist(String tempsCen,String tempeCen,String tempType,String id,List<UnilateralLine> lineList){
    	for(UnilateralLine lineItem : lineList){
    		String sCen = lineItem.getSCen();
    		String eCen = lineItem.getECen();
    		String tid = lineItem.getId();
    		String type = lineItem.getTType();
    		if((!tid.equals(id))&&(sCen.equals(tempsCen))&&(eCen.equals(tempeCen))&&(type.equals(tempType))){
    			return lineItem;
    		}
    	}
    	return null;
    }
    public static void checkRule1(List<String> result,List<UnilateralLine> lineList){
    	for(UnilateralLine lineItem : lineList){
    		String tempsCen = lineItem.getSCen();
    		String tempeCen = lineItem.getECen();
    		String tempType = lineItem.getTType();
    		//System.out.println(lineItem.id+"|"+lineList.size());
    		UnilateralLine tempLine = searchCenExist(tempeCen,tempsCen,tempType,lineList);
    		if(tempLine!=null){
    			//System.out.println("try");
    			result.add("rule1:"+lineItem.id+"+"+tempLine.id);
    			List<UnilateralLine> linetempList = lineList;
    			linetempList.remove(getIndex(lineItem.getId(),lineList));
    			linetempList.remove(getIndex(tempLine.getId(),lineList));
    			checkRule1(result,linetempList);
    			lineList = linetempList;
    			return;
    		}
    	}
    	checkRule2(result,lineList);
    }
    public static void checkRule2(List<String> result,List<UnilateralLine> lineList){
    	for(UnilateralLine lineItem : lineList){
    		String tempsCen = lineItem.getSCen();
    		String tempeCen = lineItem.getECen();
    		String tempType = lineItem.getTType();
    		List<UnilateralLine> tempList = searchCenListExist(tempeCen,tempType,lineList);
    		for(UnilateralLine line2Item : tempList){
    			String temp2sCen = line2Item.getSCen();
        		String temp2eCen = line2Item.getECen();
        		String temp2Type = line2Item.getTType();
        		UnilateralLine tempLine = searchCenExist(temp2eCen,tempsCen,temp2Type,lineList);
        		if(tempLine!=null){
        			result.add("rule2:"+lineItem.id+"+"+line2Item.id+"+"+tempLine.id);
        			List<UnilateralLine> linetempList = lineList;
        			linetempList.remove(getIndex(lineItem.getId(),lineList));
        			linetempList.remove(getIndex(tempLine.getId(),lineList));
        			linetempList.remove(getIndex(line2Item.getId(),lineList));
        			checkRule2(result,linetempList);
        			lineList = linetempList;
        			return;
        		}
    		}
    	}
        checkRule3(result,lineList);
    }
    public static List<UnilateralLine> searchCenListExist(String tempsCen,String tempType,List<UnilateralLine> lineList){
    	List<UnilateralLine> tempList = new ArrayList<UnilateralLine>();
    	for(UnilateralLine lineItem : lineList){
    		String sCen = lineItem.getSCen();
    		String type = lineItem.getTType();
    		if((sCen.equals(tempsCen))&&(type.equals(tempType))){
    			tempList.add(lineItem);
    		}
    	}
    	return tempList;
    }
    public static List<UnilateralLine> searcheCenListExist(String tempsCen,String tempType,List<UnilateralLine> lineList){
    	List<UnilateralLine> tempList = new ArrayList<UnilateralLine>();
    	for(UnilateralLine lineItem : lineList){
    		String sCen = lineItem.getECen();
    		String type = lineItem.getTType();
    		if((sCen.equals(tempsCen))&&(type.equals(tempType))){
    			tempList.add(lineItem);
    		}
    	}
    	return tempList;
    }
    public static void checkRule3(List<String> result,List<UnilateralLine> lineList){
    	for(UnilateralLine lineItem : lineList){
    		String tempsCen = lineItem.getSCen();//A
    		String tempeCen = lineItem.getECen();//B
    		String tempPro = lineItem.ePro;//B
    		String tempType = lineItem.getTType();
    		List<UnilateralLine> tempList = searcheCenListExist(tempsCen,tempType,lineList);
    		for(UnilateralLine line2Item : tempList){
    			String temp2sCen = line2Item.getSCen();
    			String temp2Pro = line2Item.getSPro();
        		if(temp2sCen.equals(tempeCen)&&temp2Pro.equals(tempPro)){
        			result.add("rule3:"+lineItem.id+"+"+line2Item.id);
        			List<UnilateralLine> linetempList = lineList;
        			linetempList.remove(getIndex(lineItem.getId(),lineList));
        			linetempList.remove(getIndex(line2Item.getId(),lineList));
        			checkRule3(result,linetempList);
        			lineList = linetempList;
        			return;
        		}
    		}
    	}
    }
    public static int getIndex(String id,List<UnilateralLine> lineList){
    	UnilateralLine lineItem = null;
    	for(int i=0;i<lineList.size();i++){
    		lineItem = lineList.get(i);
    		String tempId = lineItem.getId();
    		if(tempId.equals(id))
    			return i;
    	}
    	return -1;
    }
    public static UnilateralLine searchCenExist(String tempsCen,String tempeCen,String tempType,List<UnilateralLine> lineList){
    	for(UnilateralLine lineItem : lineList){
    		//System.out.println("===");
    		String sCen = lineItem.getSCen();
    		String eCen = lineItem.getECen();
    		String type = lineItem.getTType();
    		if((sCen.equals(tempsCen))&&(eCen.equals(tempeCen))&&(type.equals(tempType))){
    			//System.out.println("==="+lineItem.id+"|"+lineList.size());
    			return lineItem;
    		}
    	}
    	return null;
    }
public static class UnilateralLine {
private String id;
private String sCen;//出发分拨
private String sPro;//出发省
private String eCen;//到达分拨
private String ePro;//到达省
//9.6m/17.5m
private String tType;//车型
public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
            this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
public String getId() {return id;}
public void setId(String id) {this.id = id;}
public String getSCen() {return sCen;}
public void setSCen(String ePro) {this.ePro = ePro;}
public String getSPro() {return sPro;}
public void setSPro(String sPro) {this.sPro = sPro;}
public String getECen() {return eCen;}
public void setECen(String eCen) {this.eCen = eCen;}
public String getEPro() {return ePro;}
public void setEPro(String ePro) {this.ePro = ePro;}
public String getTType() {return tType;}
public void setTType(String tType) {this.tType = tType;}
}
}